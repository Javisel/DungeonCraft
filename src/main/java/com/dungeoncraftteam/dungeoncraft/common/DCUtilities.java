package com.dungeoncraftteam.dungeoncraft.common;

import com.dungeoncraftteam.dungeoncraft.DungeonCraft;
import com.dungeoncraftteam.dungeoncraft.common.attributes.attributesystem.DungeoncraftAttributes;
import com.dungeoncraftteam.dungeoncraft.common.attributes.corestats.CoreStat;
import com.dungeoncraftteam.dungeoncraft.common.capabilities.entity.EntityDataProvider;
import com.dungeoncraftteam.dungeoncraft.common.capabilities.entity.IEntityData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import org.apache.commons.lang3.StringUtils;

import java.util.Collection;
import java.util.UUID;

public class DCUtilities {


    public static IEntityData getEntityData(LivingEntity entity) {


        return entity.getCapability(EntityDataProvider.Entity_DATA_CAPABILITY, null).orElseThrow(NullPointerException::new);
    }


    public static CompoundNBT initItemNBT(ItemStack stack) {

        CompoundNBT nbt = stack.hasTag() ? stack.getTag() : new CompoundNBT();


        if (!nbt.hasUniqueId(DungeonCraft.MODID)) {

            CompoundNBT dungeoncraftnbt = new CompoundNBT();
            nbt.put(DungeonCraft.MODID, dungeoncraftnbt);


        }


        stack.setTag(nbt);


        return stack.getTag();

    }


    public static void removeAllModifiers(LivingEntity entity, IAttribute attribute) {

        if (entity.getAttributes().getAttributeInstance(attribute) != null) {

            Collection<AttributeModifier> mods = entity.getAttribute(attribute).getModifiers();


            for (AttributeModifier modifier : mods) {
                entity.getAttribute(attribute).removeModifier(modifier);
            }


        } else if (getEntityData(entity).getStatMap().getAttributeInstance(attribute) != null) {


            Collection<AttributeModifier> mods = getEntityData(entity).getStatMap().getAttributeInstance(attribute).getModifiers();


            for (AttributeModifier modifier : mods) {
                getEntityData(entity).getStatMap().getAttributeInstance(attribute).removeModifier(modifier);
            }

            if (attribute instanceof CoreStat) {

                ((CoreStat) attribute).constructAttribute(entity);


            }

        }


    }


    public static void applyEntityModifier(LivingEntity entity, IAttribute attribute, AttributeModifier modifier) {


        IEntityData entityData = getEntityData(entity);


        if (entityData.getStatMap().getAttributeInstance(attribute) != null) {

            entityData.getStatMap().getAttributeInstance(attribute).applyModifier(modifier);


        }
        if (attribute instanceof CoreStat) {

            ((CoreStat) attribute).constructAttribute(entity);


        }


    }


    public static void recalculateCoreStats(LivingEntity entity) {


        for (CoreStat stat : DungeoncraftAttributes.coreStats) {


            stat.constructAttribute(entity);


        }


    }


    public static AttributeModifier attributeModifierfromString(String mod) {

        double amount = Double.parseDouble(StringUtils.substringBetween(mod, "amount=", ","));

        String name = StringUtils.substringBetween(mod, "name='", "',");
        UUID id = UUID.fromString(StringUtils.substringBetween(mod, "id=", ","));
        boolean seralized = Boolean.parseBoolean(StringUtils.substringBetween(mod, "serialize=", "}"));
        String opstring = StringUtils.substringBetween(mod, "operation=", ",");

        AttributeModifier.Operation operation = null;
        if (opstring.equalsIgnoreCase("addition")) {
            operation = AttributeModifier.Operation.ADDITION;


        } else if (opstring.equalsIgnoreCase("multiply_base")) {

            operation = AttributeModifier.Operation.MULTIPLY_BASE;


        } else if (opstring.equalsIgnoreCase("multiply_total")) {

            operation = AttributeModifier.Operation.MULTIPLY_TOTAL;


        } else {

            System.err.println("UNKOWN OPERATION  " + opstring);
        }


        return new AttributeModifier(id, name, amount, operation).setSaved(seralized);


    }
}