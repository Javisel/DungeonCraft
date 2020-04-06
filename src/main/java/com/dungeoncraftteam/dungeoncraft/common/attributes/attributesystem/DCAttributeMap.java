package com.dungeoncraftteam.dungeoncraft.common.attributes.attributesystem;


import com.dungeoncraftteam.dungeoncraft.common.attributes.corestats.CoreStat;
import net.minecraft.entity.ai.attributes.AttributeMap;
import net.minecraft.entity.ai.attributes.IAttributeInstance;

public class DCAttributeMap extends AttributeMap {

    public DCAttributeMap() {

        DungeoncraftAttributes.loadAttributes(this);

    }



}
