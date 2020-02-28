package com.dungeoncraftteam.dungeoncraft.common.capabilities.entity;

import com.dungeoncraftteam.dungeoncraft.common.combatengine.EnumDamageSubType;
import com.dungeoncraftteam.dungeoncraft.common.entitydata.attributesystem.DCAttributeInstance;
import com.dungeoncraftteam.dungeoncraft.common.entitydata.attributesystem.DCAttributeModifier;
import com.dungeoncraftteam.dungeoncraft.common.entitydata.attributesystem.DungeoncraftAttributes;
import com.dungeoncraftteam.dungeoncraft.common.entitydata.attributesystem.DCAttributeMap;
import com.dungeoncraftteam.dungeoncraft.common.entitydata.corestats.*;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.nbt.CompoundNBT;

import java.util.ArrayList;
import java.util.HashMap;

import static com.dungeoncraftteam.dungeoncraft.common.entitydata.attributesystem.DungeoncraftAttributes.*;

public class EntityData implements IEntityData {



    DCAttributeMap statMap = new DCAttributeMap();
    Strength strength = new Strength(statMap);
    Dexterity dexterity = new Dexterity(statMap);
    Constitution constitution = new Constitution(statMap);
    Intelliegence intelliegence = new Intelliegence(statMap);
    HashMap<EnumDamageSubType,ArrayList<DCAttributeModifier>> defensiveSubtypeModifiers = new HashMap<>();
    HashMap<EnumDamageSubType, ArrayList<DCAttributeModifier>> offensiveSubtypeModifiers = new HashMap<>();

    Wisdom wisdom = new Wisdom(statMap);
    Charisma charisma = new Charisma(statMap);

    float resourceamount = 0;



    @Override
    public Strength getStrength() {

        return  strength;
    }

    @Override
    public Dexterity getDexterity() {
        return dexterity;
    }

    @Override
    public Constitution getConstitution() {
        return constitution;
    }

    @Override
    public Intelliegence getIntelligence() {
        return intelliegence;
    }

    @Override
    public Charisma getCharisma() {
        return charisma;
    }

    @Override
    public Wisdom getWisdom() {
        return wisdom;
    }

    @Override
    public DCAttributeInstance getArmour() {
        return statMap.getAttributeInstance(DungeoncraftAttributes.ARMOR);
    }

    @Override
    public DCAttributeInstance getMagicResist() {
        return statMap.getAttributeInstance(DungeoncraftAttributes.MAGIC_RESIST);
    }

    @Override
    public DCAttributeInstance getCritChance() {
        return statMap.getAttributeInstance(DungeoncraftAttributes.CRITCHANCE);
    }

    @Override
    public DCAttributeInstance getCritDamage() {
        return statMap.getAttributeInstance(DungeoncraftAttributes.CRITDAMAGE);
    }

    @Override
    public DCAttributeInstance getLifesteal() {
        return statMap.getAttributeInstance(LIFESTEAL);
    }

    @Override
    public DCAttributeInstance getFlatArmorPenetration() {
        return statMap.getAttributeInstance(FLATARMORPEN);
    }

    @Override
    public DCAttributeInstance getFlatMagicPenetration() {
        return statMap.getAttributeInstance(FLATMAGICPEN);
    }

    @Override
    public DCAttributeInstance getPercentArmorPenetration() {
        return statMap.getAttributeInstance(PERCENTARMORPEN);
    }

    @Override
    public DCAttributeInstance getPercentMagicPenetration() {
        return statMap.getAttributeInstance(PERCENTMAGICPEN);
    }

    @Override
    public DCAttributeInstance getSpellVamp() {
        return statMap.getAttributeInstance(SPELLVAMP);
    }

    @Override
    public DCAttributeInstance getHealthRegen() {
        return statMap.getAttributeInstance(HEALTH_REGEN);
    }

    @Override
    public float getResourceAmount() {
        return resourceamount;
    }

    @Override
    public void setResourceAmount(double amount) {
        resourceamount= (float) amount;
    }

    @Override
    public void addResourceAmount(float amount) {

        resourceamount+=amount;
    }

    @Override
    public DCAttributeInstance getMaxResourceAmount() {
        return statMap.getAttributeInstance(MAX_RESOURCE_AMOUNT);
    }

    @Override
    public DCAttributeInstance getCooldownReduction() {
        return statMap.getAttributeInstance(COOLDOWN_REDUCTION);
    }

    @Override
    public DCAttributeInstance getExperience() {
        return statMap.getAttributeInstance(EXPERIENCE);
    }

    @Override
    public DCAttributeInstance getResourceRegen() {
        return statMap.getAttributeInstance(RESOURCE_REGEN);
    }

    @Override
    public HashMap<EnumDamageSubType, ArrayList<DCAttributeModifier>> getSubtypeDefendingModifiers() {
        return defensiveSubtypeModifiers;
    }

    @Override
    public HashMap<EnumDamageSubType, ArrayList<DCAttributeModifier>> getSubtypeAttackingModifiers() {
        return offensiveSubtypeModifiers;
    }

    @Override
    public void loadNBT(CompoundNBT nbt) {
        statMap  = new DCAttributeMap();
        DungeoncraftAttributes.readAttributes(statMap, nbt.getList("attributemap", 10));

        resourceamount=nbt.getFloat("resourceamount");
    }

    @Override
    public CompoundNBT writeNBT() {



        CompoundNBT nbt = new CompoundNBT();
        nbt.putFloat("resourceamount", getResourceAmount());
        nbt.put("attributemap", DungeoncraftAttributes.writeAttributes(statMap));

        return nbt;
    }
}
