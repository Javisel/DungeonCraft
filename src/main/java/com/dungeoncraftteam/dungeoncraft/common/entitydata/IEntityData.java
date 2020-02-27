package com.dungeoncraftteam.dungeoncraft.common.entitydata;

import com.dungeoncraftteam.dungeoncraft.common.entitydata.attributesystem.DCAttributeInstance;
import com.dungeoncraftteam.dungeoncraft.common.entitydata.attributesystem.DCAttributeModifier;
import com.dungeoncraftteam.dungeoncraft.common.combatengine.EnumDamageSubType;
import com.dungeoncraftteam.dungeoncraft.common.entitydata.corestats.*;
import net.minecraft.nbt.CompoundNBT;

import java.util.ArrayList;
import java.util.HashMap;

public interface IEntityData {

    Strength getStrength();
    Dexterity getDexterity();
    Constitution getConstitution();
    Intelliegence getIntelligence();
    Charisma getCharisma();
    Wisdom getWisdom();
    DCAttributeInstance getArmour();
    DCAttributeInstance getMagicResist();




    HashMap<EnumDamageSubType, ArrayList<DCAttributeModifier>> getSubtypeModifiers();



    void loadNBT(CompoundNBT nbt);
    CompoundNBT writeNBT();








}
