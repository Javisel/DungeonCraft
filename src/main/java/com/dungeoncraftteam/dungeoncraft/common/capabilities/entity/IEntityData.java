package com.dungeoncraftteam.dungeoncraft.common.capabilities.entity;

import com.dungeoncraftteam.dungeoncraft.common.attributes.attributesystem.DCAttributeMap;
import com.dungeoncraftteam.dungeoncraft.common.combatengine.EnumDamageType;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.nbt.CompoundNBT;

public interface IEntityData {

    DCAttributeMap getStatMap();



    IAttributeInstance getEnumDamageTypeArmor(EnumDamageType type);

    IAttributeInstance getEnumDamageTypeDamage(EnumDamageType type);




    //DEFENSIVE


    //UTILITY
    float getResourceAmount();

    void setResourceAmount(double amount);

    void addResourceAmount(float amount);


    void loadNBT(CompoundNBT nbt);

    CompoundNBT writeNBT();


    int getTicks();

    void tick();
    int getLevel();
}
