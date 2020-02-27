package com.dungeoncraftteam.dungeoncraft.common.entitydata;

import com.dungeoncraftteam.dungeoncraft.common.entitydata.attributesystem.DCAttributeInstance;
import com.dungeoncraftteam.dungeoncraft.common.entitydata.attributesystem.DCAttributeModifier;
import com.dungeoncraftteam.dungeoncraft.common.combatengine.EnumDamageSubType;
import com.dungeoncraftteam.dungeoncraft.common.entitydata.corestats.CoreStatInstance;
import com.dungeoncraftteam.dungeoncraft.common.entitydata.corestats.Strength;
import net.minecraft.nbt.CompoundNBT;

import java.util.ArrayList;
import java.util.HashMap;

public interface IEntityData {

    Strength getStrength();
    CoreStatInstance getDexterity();
    CoreStatInstance getConstitution();
    CoreStatInstance getIntelligence();
    CoreStatInstance getCharisma();
    CoreStatInstance getWisdom();
    DCAttributeInstance getArmour();
    DCAttributeInstance getMagicResist();




    HashMap<EnumDamageSubType, ArrayList<DCAttributeModifier>> getSubtypeModifiers();



    void loadNBT(CompoundNBT nbt);
    CompoundNBT writeNBT();








}
