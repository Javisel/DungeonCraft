package com.dungeoncraftteam.dungeoncraft.common.entitydata.attributesystem;

import com.dungeoncraftteam.dungeoncraft.DungeonCraft;
import net.minecraft.entity.ai.attributes.AttributeModifier;

import java.util.Objects;
import java.util.UUID;
import java.util.function.Supplier;

public class DCAttributeModifier extends AttributeModifier {


    private final double amount;
    private final DCAttributeModifier.Operation operation;
    private final Supplier<String> name;
    private final UUID id;
    private boolean isSaved = true;

   public  DCAttributeModifier(String nameIn, double amountIn, AttributeModifier.Operation operationIn, double amount, Operation operation, Supplier<String> name, UUID id, boolean isSaved) {
        super(nameIn, amountIn, operationIn);
        this.amount = amount;
        this.operation = operation;
        this.name = name;
        this.id = id;
        this.isSaved = isSaved;
    }

    public   DCAttributeModifier(UUID uuid, String nameIn, double amountIn, AttributeModifier.Operation operationIn, double amount, Operation operation, Supplier<String> name, UUID id, boolean isSaved) {
        super(uuid, nameIn, amountIn, operationIn);
        this.amount = amount;
        this.operation = operation;
        this.name = name;
        this.id = id;
        this.isSaved = isSaved;
    }

    public   DCAttributeModifier(UUID uuid, Supplier<String> nameIn, double amountIn, AttributeModifier.Operation operationIn, double amount, Operation operation, Supplier<String> name, UUID id, boolean isSaved) {
        super(uuid, nameIn, amountIn, operationIn);
        this.amount = amount;
        this.operation = operation;
        this.name = name;
        this.id = id;
        this.isSaved = isSaved;
    }


    public UUID getID() {
        return this.id;
    }

    public String getName() {
        return this.name.get();
    }

    public DCAttributeModifier.Operation getOperation() {
        return this.operation;
    }

    public double getAmount() {
        return this.amount;
    }

    /**
     * @see #isSaved
     */
    public boolean isSaved() {
        return this.isSaved;
    }

    public double apply(double in) {

        if (this.operation == Operation.ADDITION) {

            return in + amount;
        } else if (this.operation == Operation.MULTIPLY_TOTAL) {

            return in * (1+ amount);
        } else {
            DungeonCraft.LOGGER.error("Unknown Operation: " + operation.name());
            return in;
        }

    }




    /**
     * @see #isSaved
     */
    public DCAttributeModifier setSaved(boolean saved) {
        this.isSaved = saved;
        return this;
    }

    public boolean equals(Object p_equals_1_) {
        if (this == p_equals_1_) {
            return true;
        } else if (p_equals_1_ != null && this.getClass() == p_equals_1_.getClass()) {
            DCAttributeModifier attributemodifier = (DCAttributeModifier)p_equals_1_;
            return Objects.equals(this.id, attributemodifier.id);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return this.id != null ? this.id.hashCode() : 0;
    }

    public String toString() {
        return "DCAttributeModifier{amount=" + this.amount + ", operation=" + this.operation + ", name='" + (String)this.name.get() + '\'' + ", id=" + this.id + ", serialize=" + this.isSaved + '}';
    }







}