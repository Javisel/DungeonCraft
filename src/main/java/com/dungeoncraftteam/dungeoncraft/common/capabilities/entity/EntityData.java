package com.dungeoncraftteam.dungeoncraft.common.capabilities.entity;

import com.dungeoncraftteam.dungeoncraft.common.combatengine.EnumDamageSubType;
import com.dungeoncraftteam.dungeoncraft.common.attributes.attributesystem.DCAttributeInstance;
import com.dungeoncraftteam.dungeoncraft.common.attributes.attributesystem.DCAttributeModifier;
import com.dungeoncraftteam.dungeoncraft.common.attributes.attributesystem.DungeoncraftAttributes;
import com.dungeoncraftteam.dungeoncraft.common.attributes.attributesystem.DCAttributeMap;
import net.minecraft.nbt.CompoundNBT;

import java.util.ArrayList;
import java.util.HashMap;

import static com.dungeoncraftteam.dungeoncraft.common.attributes.attributesystem.DungeoncraftAttributes.*;

public class EntityData implements IEntityData {



    DCAttributeMap statMap = new DCAttributeMap();

    HashMap<EnumDamageSubType,ArrayList<DCAttributeModifier>> defensiveSubtypeModifiers = new HashMap<>();
    HashMap<EnumDamageSubType, ArrayList<DCAttributeModifier>> offensiveSubtypeModifiers = new HashMap<>();


    int ticks = 0;
    float resourceamount = 0;


    @Override
    public DCAttributeMap getStatMap() {
        return statMap;
    }
    @Override
    public DCAttributeInstance getStrength() {


            return statMap.getAttributeInstance(STRENGTH);
    }

    @Override
    public DCAttributeInstance getDexterity() {
        return statMap.getAttributeInstance(DEXTERITY);
    }

    @Override
    public DCAttributeInstance getConstitution() {
        return statMap.getAttributeInstance(CONSTITUTION);
    }

    @Override
    public DCAttributeInstance getIntelligence() {
        return statMap.getAttributeInstance(INTELLIGENCE);
    }

    @Override
    public DCAttributeInstance getCharisma() {
        return statMap.getAttributeInstance(CHARISMA);
    }

    @Override
    public DCAttributeInstance getWisdom() {
        return statMap.getAttributeInstance(WISDOM);
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

        if (amount>getMaxResourceAmount().getValue()) {
            amount=resourceamount;
        }


        resourceamount = (float) amount;
    }

    @Override
    public void addResourceAmount(float amount) {

        if (amount+resourceamount > getMaxResourceAmount().getValue()) {
            amount= (float) (getMaxResourceAmount().getValue()-resourceamount);

        }

        if (amount+resourceamount<0) {
            amount=resourceamount * -1;
        }

        resourceamount += amount;
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

    @Override
    public int getTicks() {
        return ticks;
    }

    @Override
    public void tick() {

        if (ticks==20) {
            ticks=0;
        } else {
            ticks++;
        }

    }




}
