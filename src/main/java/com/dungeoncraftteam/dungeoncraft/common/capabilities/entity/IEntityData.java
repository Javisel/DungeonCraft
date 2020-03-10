package com.dungeoncraftteam.dungeoncraft.common.capabilities.entity;

import com.dungeoncraftteam.dungeoncraft.common.attributes.attributesystem.DCAttributeMap;
import com.dungeoncraftteam.dungeoncraft.common.combatengine.EnumDamageType;
import com.dungeoncraftteam.dungeoncraft.common.attributes.attributesystem.DCAttributeInstance;
import com.dungeoncraftteam.dungeoncraft.common.attributes.attributesystem.DCAttributeModifier;
import net.minecraft.nbt.CompoundNBT;

import java.util.ArrayList;
import java.util.HashMap;

public interface IEntityData {

    DCAttributeMap getStatMap();

    DCAttributeInstance getStrength();

    DCAttributeInstance getDexterity();

    DCAttributeInstance getConstitution();

    DCAttributeInstance getIntelligence();

    DCAttributeInstance getCharisma();

    DCAttributeInstance getWisdom();

    DCAttributeInstance getArmour();

    DCAttributeInstance getMagicResist();

    DCAttributeInstance getCritChance();

    DCAttributeInstance getEnumDamageTypeArmor(EnumDamageType type);

    DCAttributeInstance getEnumDamageTypeDamage(EnumDamageType type);

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

    HashMap<EnumDamageType, ArrayList<DCAttributeModifier>> getSubtypeDefendingModifiers();

    HashMap<EnumDamageType, ArrayList<DCAttributeModifier>> getSubtypeAttackingModifiers();


    void loadNBT(CompoundNBT nbt);

    CompoundNBT writeNBT();


    int getTicks();

    void tick();
}
