package com.dungeoncraftteam.dungeoncraft.common.capabilities.entity;

import com.dungeoncraftteam.dungeoncraft.common.attributes.attributesystem.DCAttributeMap;
import com.dungeoncraftteam.dungeoncraft.common.combatengine.EnumDamageType;
import com.dungeoncraftteam.dungeoncraft.common.attributes.attributesystem.DungeoncraftAttributes;
import net.minecraft.entity.ai.attributes.AttributeMap;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.nbt.CompoundNBT;

import static com.dungeoncraftteam.dungeoncraft.common.attributes.attributesystem.DungeoncraftAttributes.*;

public class EntityData implements IEntityData {



    AttributeMap statMap = new DCAttributeMap();




    int ticks = 0;
    float resourceamount = 0;


    @Override
    public AttributeMap getStatMap() {
        return statMap;
    }

    @Override
    public IAttributeInstance getEnumDamageTypeArmor(EnumDamageType type) {



        return  statMap.getAttributeInstanceByName(type.getDefensiveName());
    }

    @Override
    public IAttributeInstance getEnumDamageTypeDamage(EnumDamageType type) {



        return  statMap.getAttributeInstanceByName(type.getOffensiveName());
    }




    @Override
    public float getResourceAmount() {
        return resourceamount;
    }


    @Override
    public void setResourceAmount(double amount) {

        if (amount>statMap.getAttributeInstance(MAX_RESOURCE_AMOUNT).getValue()) {
            amount=resourceamount;
        }


        resourceamount = (float) amount;
    }

    @Override
    public void addResourceAmount(float amount) {

        if (amount+resourceamount > statMap.getAttributeInstance(MAX_RESOURCE_AMOUNT).getValue()) {
            amount= (float) (statMap.getAttributeInstance(MAX_RESOURCE_AMOUNT).getValue()-resourceamount);

        }

        if (amount+resourceamount<0) {
            amount=resourceamount * -1;
        }

        resourceamount += amount;
    }



    @Override
    public void loadNBT(CompoundNBT nbt) {
        statMap  = new AttributeMap();
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
