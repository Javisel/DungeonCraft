package com.dungeoncraftteam.dungeoncraft.common.combatengine;

import com.dungeoncraftteam.dungeoncraft.common.attributes.attributesystem.DCAttributeModifier;

import java.util.UUID;
import java.util.function.Supplier;

public class SubtypeModifier extends DCAttributeModifier {
    public SubtypeModifier(UUID uuid, String nameIn, double amountIn, Operation operationIn, EnumDamageSubType subType) {
        super(uuid, nameIn, amountIn, operationIn);
        this.subType = subType;
    }

    public EnumDamageSubType getSubType() {
        return subType;
    }

    private EnumDamageSubType subType;






}
