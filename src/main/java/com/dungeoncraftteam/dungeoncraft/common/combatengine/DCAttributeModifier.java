package com.dungeoncraftteam.dungeoncraft.common.combatengine;

import com.dungeoncraftteam.dungeoncraft.DungeonCraft;
import io.netty.util.internal.ThreadLocalRandom;
import net.minecraft.util.math.MathHelper;

import java.util.Objects;
import java.util.UUID;
import java.util.function.Supplier;

public class DCAttributeModifier {


    private final double amount;
    private final DCAttributeModifier.Operation operation;
    private final Supplier<String> name;
    private final UUID id;
    private boolean isSaved = true;

    public DCAttributeModifier(String nameIn, double amountIn, DCAttributeModifier.Operation operationIn) {
        this(MathHelper.getRandomUUID(ThreadLocalRandom.current()), () -> {
            return nameIn;
        }, amountIn, operationIn);
    }

    public DCAttributeModifier(UUID uuid, String nameIn, double amountIn, DCAttributeModifier.Operation operationIn) {
        this(uuid, () -> {
            return nameIn;
        }, amountIn, operationIn);
    }

    public DCAttributeModifier(UUID uuid, Supplier<String> nameIn, double amountIn, DCAttributeModifier.Operation operationIn) {
        this.id = uuid;
        this.name = nameIn;
        this.amount = amountIn;
        this.operation = operationIn;
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
        } else if (this.operation == Operation.MULTIPLY) {

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

    public static enum Operation {
        ADDITION(0),
        MULTIPLY(1);

        private static final DCAttributeModifier.Operation[] VALUES = new DCAttributeModifier.Operation[]{ADDITION, MULTIPLY};
        private final int id;

        private Operation(int id) {
            this.id = id;
        }

        public int getId() {
            return this.id;
        }

        public static DCAttributeModifier.Operation byId(int id) {
            if (id >= 0 && id < VALUES.length) {
                return VALUES[id];
            } else {
                throw new IllegalArgumentException("No operation with value " + id);
            }
        }
    }
}