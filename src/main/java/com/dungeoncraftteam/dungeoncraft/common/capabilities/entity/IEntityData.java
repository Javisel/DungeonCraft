package com.dungeoncraftteam.dungeoncraft.common.capabilities.entity;

import com.dungeoncraftteam.dungeoncraft.common.combatengine.EnumDamageSubType;
import com.dungeoncraftteam.dungeoncraft.common.entitydata.attributesystem.DCAttributeInstance;
import com.dungeoncraftteam.dungeoncraft.common.entitydata.attributesystem.DCAttributeModifier;
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

    DCAttributeInstance getCritChance();

    DCAttributeInstance getCritDamage();

    DCAttributeInstance getLifesteal();

    DCAttributeInstance getFlatArmorPenetration();

    DCAttributeInstance getFlatMagicPenetration();

    DCAttributeInstance getPercentArmorPenetration();

    DCAttributeInstance getPercentMagicPenetration();

    DCAttributeInstance getSpellVamp();


    //DEFENSIVE

    DCAttributeInstance getHealthRegen();


    //UTILITY
    float getResourceAmount();

    void setResourceAmount(double amount);

    void addResourceAmount(float amount);

    DCAttributeInstance getMaxResourceAmount();

    DCAttributeInstance getCooldownReduction();

    DCAttributeInstance getExperience();

    DCAttributeInstance getResourceRegen();

    HashMap<EnumDamageSubType, ArrayList<DCAttributeModifier>> getSubtypeDefendingModifiers();

    HashMap<EnumDamageSubType, ArrayList<DCAttributeModifier>> getSubtypeAttackingModifiers();


    void loadNBT(CompoundNBT nbt);

    CompoundNBT writeNBT();


}
