package com.dungeoncraftteam.dungeoncraft.common.attributes.attributesystem;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.util.LowerStringMap;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class DCAttributeMap {
    protected final Map<IAttribute, DCAttributeInstance> attributes = Maps.newHashMap();
    protected final Map<String, DCAttributeInstance> attributesByName = new LowerStringMap<>();
    protected final Multimap<IAttribute, IAttribute> descendantsByParent = HashMultimap.create();
    private final Set<DCAttributeInstance> dirtyInstances = Sets.newHashSet();
    protected final Map<String, DCAttributeInstance> instancesByName = new LowerStringMap<>();

    public DCAttributeMap() {

        DungeoncraftAttributes.loadAttributes(this);
    }


    public DCAttributeInstance getAttributeInstance(IAttribute attribute) {
        return this.attributes.get(attribute);
    }

    public DCAttributeInstance getAttributeInstanceByName(String attributeName) {
        return this.attributesByName.get(attributeName);


    }

    /**
     * Registers an attribute with this AttributeMap, returns a modifiable AttributeInstance associated with this map
     */
    public DCAttributeInstance registerAttribute(IAttribute attribute) {
        if (this.attributesByName.containsKey(attribute.getName())) {
            throw new IllegalArgumentException("Attribute is already registered!");
        } else {
            DCAttributeInstance iattributeinstance = this.createInstance(attribute);
            this.attributesByName.put(attribute.getName(), iattributeinstance);
            this.attributes.put(attribute, iattributeinstance);

            for(IAttribute iattribute = attribute.getParent(); iattribute != null; iattribute = iattribute.getParent()) {
                this.descendantsByParent.put(iattribute, attribute);
            }

            return iattributeinstance;
        }
    }

    
    
    protected DCAttributeInstance createInstance(IAttribute attribute) {
        return new DCAttributeInstance(this, attribute);
    }

    public void onAttributeModified(DCAttributeInstance instance) {
        if (instance.getAttribute().getShouldWatch()) {
            this.dirtyInstances.add(instance);
        }

        for(IAttribute iattribute : this.descendantsByParent.get(instance.getAttribute())) {
            DCAttributeInstance modifiableattributeinstance = this.getAttributeInstance(iattribute);
            if (modifiableattributeinstance != null) {
                modifiableattributeinstance.flagForUpdate();
            }
        }

    }

    public Set<DCAttributeInstance> getDirtyInstances() {
        return this.dirtyInstances;
    }

    public Collection<DCAttributeInstance> getWatchedAttributes() {
        Set<DCAttributeInstance> set = Sets.newHashSet();

        for(DCAttributeInstance iattributeinstance : this.getAllAttributes()) {
            if (iattributeinstance.getAttribute().getShouldWatch()) {
                set.add(iattributeinstance);
            }
        }

        return set;
    }
    public Collection<DCAttributeInstance> getAllAttributes() {
        return this.attributesByName.values();
    }

}
