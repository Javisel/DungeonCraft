package com.dungeoncraftteam.dungeoncraft.common.combatengine;

import java.util.UUID;
import java.util.function.Supplier;

public class SubtypeModifier extends DCAttributeModifier {

    public EnumDamageSubType getSubType() {
        return subType;
    }

    private EnumDamageSubType subType;





    public SubtypeModifier(String nameIn,  EnumDamageSubType subTypeIn,double amountIn, Operation operationIn) {
        super(nameIn, amountIn, operationIn);
        subType=subTypeIn;
    }

    public SubtypeModifier(UUID uuid, String nameIn, EnumDamageSubType subTypeIn, double amountIn, Operation operationIn) {
        super(uuid, nameIn, amountIn, operationIn);
        subType=subTypeIn;

    }

    public SubtypeModifier(UUID uuid, Supplier<String> nameIn,  EnumDamageSubType subTypeIn, double amountIn, Operation operationIn) {
        super(uuid, nameIn, amountIn, operationIn);
        subType=subTypeIn;

    }
}
