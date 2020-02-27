package com.dungeoncraftteam.dungeoncraft.common.combatengine;

import com.dungeoncraftteam.dungeoncraft.common.entitydata.attributesystem.DCAttributeModifier;

import java.util.UUID;
import java.util.function.Supplier;

public class SubtypeModifier extends DCAttributeModifier {
    public EnumDamageSubType getSubType() {
        return subType;
    }

    private EnumDamageSubType subType;



    public SubtypeModifier(String nameIn, double amountIn, Operation operationIn, double amount, Operation operation, Supplier<String> name, UUID id, boolean isSaved, EnumDamageSubType subType) {
        super(nameIn, amountIn, operationIn, amount, operation, name, id, isSaved);
        this.subType = subType;
    }

    public SubtypeModifier(UUID uuid, String nameIn, double amountIn, Operation operationIn, double amount, Operation operation, Supplier<String> name, UUID id, boolean isSaved, EnumDamageSubType subType) {
        super(uuid, nameIn, amountIn, operationIn, amount, operation, name, id, isSaved);
        this.subType = subType;
    }

    public SubtypeModifier(UUID uuid, Supplier<String> nameIn, double amountIn, Operation operationIn, double amount, Operation operation, Supplier<String> name, UUID id, boolean isSaved, EnumDamageSubType subType) {
        super(uuid, nameIn, amountIn, operationIn, amount, operation, name, id, isSaved);
        this.subType = subType;
    }


}
