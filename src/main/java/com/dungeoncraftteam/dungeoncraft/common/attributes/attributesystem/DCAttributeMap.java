package com.dungeoncraftteam.dungeoncraft.common.attributes.attributesystem;


import net.minecraft.entity.ai.attributes.AttributeMap;

public class DCAttributeMap extends AttributeMap {

    public DCAttributeMap() {

        DungeoncraftAttributes.loadAttributes(this);

    }



}
