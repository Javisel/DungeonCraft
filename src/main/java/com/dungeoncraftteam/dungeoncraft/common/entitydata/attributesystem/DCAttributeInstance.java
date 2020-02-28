package com.dungeoncraftteam.dungeoncraft.common.entitydata.attributesystem;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import net.minecraft.entity.ai.attributes.*;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class DCAttributeInstance  {

    private final DCAttributeMap attributeMap;
    private final IAttribute genericAttribute;
    private final Map<DCAttributeModifier.Operation, Set<DCAttributeModifier>> mapByOperation = Maps.newEnumMap(DCAttributeModifier.Operation.class);
    private final Map<String, Set<DCAttributeModifier>> mapByName = Maps.newHashMap();
    private final Map<UUID, DCAttributeModifier> mapByUUID = Maps.newHashMap();
    private double baseValue;
    private boolean needsUpdate = true;
    private double cachedValue;

    public DCAttributeInstance(DCAttributeMap attributeMapIn, IAttribute genericAttributeIn) {
        this.attributeMap = attributeMapIn;
        this.genericAttribute = genericAttributeIn;
        this.baseValue = genericAttributeIn.getDefaultValue();

        for(DCAttributeModifier.Operation attributemodifier$operation : DCAttributeModifier.Operation.values()) {
            this.mapByOperation.put(attributemodifier$operation, Sets.newHashSet());
        }

    }

    /**
     * Get the Attribute this is an instance of
     */
    public IAttribute getAttribute() {
        return this.genericAttribute;
    }

    public double getBaseValue() {
        return this.baseValue;
    }

    public void setBaseValue(double baseValue) {
        if (baseValue != this.getBaseValue()) {
            this.baseValue = baseValue;
            this.flagForUpdate();
        }
    }


    //Gets a modifier map by the given Attribute
    public Collection<DCAttributeModifier> func_220368_a(DCAttributeModifier.Operation p_220368_1_) {
        return this.mapByOperation.get(p_220368_1_);
    }

    public Collection<DCAttributeModifier> getModifiers() {
        Set<DCAttributeModifier> set = Sets.newHashSet();

        for(DCAttributeModifier.Operation attributemodifier$operation : DCAttributeModifier.Operation.values()) {
            set.addAll(this.func_220368_a(attributemodifier$operation));
        }

        return set;
    }

    /**
     * Returns attribute modifier, if any, by the given UUID
     */
    @Nullable
    public DCAttributeModifier getModifier(UUID uuid) {
        return this.mapByUUID.get(uuid);
    }

    public boolean hasModifier(DCAttributeModifier modifier) {
        return this.mapByUUID.get(modifier.getID()) != null;
    }

    public void applyModifier(DCAttributeModifier modifier) {
        if (this.getModifier(modifier.getID()) != null) {
            throw new IllegalArgumentException("Modifier is already applied on this attribute!");
        } else {
            Set<DCAttributeModifier> set = this.mapByName.computeIfAbsent(modifier.getName(), (p_220369_0_) -> {
                return Sets.newHashSet();
            });
            this.mapByOperation.get(modifier.getOperation()).add(modifier);
            set.add(modifier);
            this.mapByUUID.put(modifier.getID(), modifier);
            this.flagForUpdate();
        }
    }

    protected void flagForUpdate() {
        this.needsUpdate = true;
        this.attributeMap.onAttributeModified(this);
    }

    public void removeModifier(DCAttributeModifier modifier) {
        for(DCAttributeModifier.Operation attributemodifier$operation : DCAttributeModifier.Operation.values()) {
            this.mapByOperation.get(attributemodifier$operation).remove(modifier);
        }

        Set<DCAttributeModifier> set = this.mapByName.get(modifier.getName());
        if (set != null) {
            set.remove(modifier);
            if (set.isEmpty()) {
                this.mapByName.remove(modifier.getName());
            }
        }

        this.mapByUUID.remove(modifier.getID());
        this.flagForUpdate();
    }

    public void removeModifier(UUID p_188479_1_) {
        DCAttributeModifier attributemodifier = this.getModifier(p_188479_1_);
        if (attributemodifier != null) {
            this.removeModifier(attributemodifier);
        }

    }

    public void removeAllModifiers() {
        Collection<DCAttributeModifier> collection = this.getModifiers();
        if (collection != null) {
            for(DCAttributeModifier attributemodifier : Lists.newArrayList(collection)) {
                this.removeModifier(attributemodifier);
            }

        }
    }


    /**
     * removeAllModifiers is for some reason Client Only. this is functionally the same but will work on server side.
     */
    public void clearAllModifiers() {
        Collection<DCAttributeModifier> collection = this.getModifiers();
        if (collection != null) {
            for(DCAttributeModifier attributemodifier : Lists.newArrayList(collection)) {
                this.removeModifier(attributemodifier);
            }

        }
    }
    public double getValue() {
        if (this.needsUpdate) {
            this.cachedValue = this.computeValue();
            this.needsUpdate = false;
        }

        return this.cachedValue;
    }

    private double computeValue() {
        double d0 = this.getBaseValue();

        for(DCAttributeModifier attributemodifier : this.getModifierbyOperation(DCAttributeModifier.Operation.ADDITION)) {
            d0 += attributemodifier.getAmount();
        }

        double d1 = d0;

        for(DCAttributeModifier attributemodifier1 : this.getModifierbyOperation(DCAttributeModifier.Operation.MULTIPLY_BASE)) {
            d1 += d0 * attributemodifier1.getAmount();
        }

        for(DCAttributeModifier attributemodifier2 : this.getModifierbyOperation(DCAttributeModifier.Operation.MULTIPLY_TOTAL)) {
            d1 *= 1.0D + attributemodifier2.getAmount();
        }

        return this.genericAttribute.clampValue(d1);
    }

    private Collection<DCAttributeModifier> getModifierbyOperation(DCAttributeModifier.Operation operation) {
        Set<DCAttributeModifier> set = Sets.newHashSet(this.func_220368_a(operation));

        for(IAttribute iattribute = this.genericAttribute.getParent(); iattribute != null; iattribute = iattribute.getParent()) {
            DCAttributeInstance iattributeinstance = this.attributeMap.getAttributeInstance(iattribute);
            if (iattributeinstance != null) {
                set.addAll(iattributeinstance.func_220368_a(operation));
            }
        }

        return set;
    }
}