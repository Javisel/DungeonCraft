package com.dungeoncraftteam.dungeoncraft.common.combatengine;

import com.dungeoncraftteam.dungeoncraft.common.attributes.attributesystem.DCAttributeModifier;

import java.util.UUID;

public class SubtypeModifier extends DCAttributeModifier {
    public SubtypeModifier(UUID uuid, String nameIn, double amountIn, Operation operationIn, EnumDamageType subType) {
        super(uuid, nameIn, amountIn, operationIn);
        this.subType = subType;
    }

    public EnumDamageType getSubType() {
        return subType;
    }

    private EnumDamageType subType;






}
