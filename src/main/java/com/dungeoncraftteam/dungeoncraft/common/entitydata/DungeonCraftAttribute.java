package com.dungeoncraftteam.dungeoncraft.common.entitydata;

import net.minecraft.entity.ai.attributes.*;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.UUID;

public class DungeonCraftAttribute extends ModifiableAttributeInstance {


    public DungeonCraftAttribute(AbstractAttributeMap p_i1608_1_, IAttribute p_i1608_2_) {
        super(p_i1608_1_, p_i1608_2_);
    }


    @Override
    public IAttribute getAttribute() {
        return super.getAttribute();
    }

    @Override
    public double getBaseValue() {
        return super.getBaseValue();
    }

    @Override
    public void setBaseValue(double p_111128_1_) {
        super.setBaseValue(p_111128_1_);
    }

    @Override
    public Collection<AttributeModifier> func_220368_a(AttributeModifier.Operation p_220368_1_) {
        return super.func_220368_a(p_220368_1_);
    }

    @Override
    public Collection<AttributeModifier> getModifiers() {
        return super.getModifiers();
    }

    @Nullable
    @Override
    public AttributeModifier getModifier(UUID p_111127_1_) {
        return super.getModifier(p_111127_1_);
    }

    @Override
    public boolean hasModifier(AttributeModifier p_180374_1_) {
        return super.hasModifier(p_180374_1_);
    }

    @Override
    public void applyModifier(AttributeModifier p_111121_1_) {
        super.applyModifier(p_111121_1_);
    }

    @Override
    protected void flagForUpdate() {
        super.flagForUpdate();
    }

    @Override
    public void removeModifier(AttributeModifier p_111124_1_) {
        super.removeModifier(p_111124_1_);
    }

    @Override
    public void removeModifier(UUID p_188479_1_) {
        super.removeModifier(p_188479_1_);
    }

    @Override
    public void removeAllModifiers() {
        super.removeAllModifiers();
    }

    @Override
    public double getValue() {
        return super.getValue();
    }
}
