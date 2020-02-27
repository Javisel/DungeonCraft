package com.dungeoncraftteam.dungeoncraft.common.entitydata;

import net.minecraft.nbt.CompoundNBT;

public interface IEntityData {

    DCAttributeInstance getStrength();
    DCAttributeInstance getDexterity();
    DCAttributeInstance getConstitution();
    DCAttributeInstance getIntelligence();
    DCAttributeInstance getCharisma();
    DCAttributeInstance getWisdom();
    DCAttributeInstance getArmour();
    DCAttributeInstance getMagicResist();
    



    void loadNBT(CompoundNBT nbt);
    CompoundNBT writeNBT();








}
