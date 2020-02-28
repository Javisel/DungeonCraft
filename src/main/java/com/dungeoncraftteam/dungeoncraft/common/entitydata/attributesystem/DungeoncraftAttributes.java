package com.dungeoncraftteam.dungeoncraft.common.entitydata.attributesystem;

import com.dungeoncraftteam.dungeoncraft.DungeonCraft;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

public class DungeoncraftAttributes {


    //CORE

    public static final IAttribute STRENGTH = new RangedAttribute(null, "dungeoncraft.Strength", 0, -10.0D, 20).setDescription("A entity's Strength Value.").setShouldWatch(true);
    public static final IAttribute CONSTITUTION = new RangedAttribute(null, "dungeoncraft.Constitution", 0, -10.0D, 20).setDescription("A entity's Constitution Value.").setShouldWatch(true);
    public static final IAttribute DEXTERITY = new RangedAttribute(null, "dungeoncraft.Dexterity", 0, -10.0D, 20).setDescription("A entity's Dexterity Value.").setShouldWatch(true);
    public static final IAttribute INTELLIGENCE = new RangedAttribute(null, "dungeoncraft.Intelligence", 0, -10.0D, 20).setDescription("A entity's Intelligence Value.").setShouldWatch(true);
    public static final IAttribute WISDOM = new RangedAttribute(null, "dungeoncraft.Wisdom", 0, -10.0D, 20).setDescription("A entity's Wisdom Value.").setShouldWatch(true);
    public static final IAttribute CHARISMA = new RangedAttribute(null, "dungeoncraft.Charisma", 0, -10.0D, 20).setDescription("A entity's Charisma Value.").setShouldWatch(true);



    //BATTLESTAT
    public static final IAttribute ARMOR = new RangedAttribute(null, "dungeoncraft.Armor", 0, 0.0D, 1000000).setDescription("A entity's Armor Value.").setShouldWatch(true);
    public static final IAttribute MAGIC_RESIST = new RangedAttribute(null, "dungeoncraft.MagicResist", 10, 0.0D, 1000000).setDescription("A entity's Magic Resist Value.").setShouldWatch(true);

    public static final IAttribute SPELL_POWER = new RangedAttribute(null, "dungeoncraft.SpellPower", 0, 0.0D, 10000).setDescription("The Spell Power of an entity.").setShouldWatch(true);
    public static final IAttribute CRITCHANCE = new RangedAttribute(null, "dungeoncraft.CritChance", 0, 0.0D, 10000).setDescription("The Critical Strike Chance of an entity.").setShouldWatch(true);
    public static final IAttribute CRITDAMAGE = new RangedAttribute(null, "dungeoncraft.CritDamage", 2.0D, 0.0D, 10000).setDescription("The Critical Strike Multiplier.").setShouldWatch(true);
    public static final IAttribute LIFESTEAL = new RangedAttribute(null, "dungeoncraft.Lifesteal", 0, 0.0D, 10000).setDescription("The Magical Power of an entity.").setShouldWatch(true);
    public static final IAttribute FLATARMORPEN = new RangedAttribute(null, "dungeoncraft.FlatArmorPen", 0, 0.0D, 10000).setDescription("The Magical Power of an entity.").setShouldWatch(true);
    public static final IAttribute FLATMAGICPEN = new RangedAttribute(null, "dungeoncraft.FlatMagicPen", 0, 0.0D, 10000).setDescription("The Magical Power of an entity.").setShouldWatch(true);
    public static final IAttribute PERCENTARMORPEN = new RangedAttribute(null, "dungeoncraft.PercentArmorPen", 0, 0.0D, 10000).setDescription("The Magical Power of an entity.").setShouldWatch(true);
    public static final IAttribute PERCENTMAGICPEN = new RangedAttribute(null, "dungeoncraft.PercentMagicPen", 0, 0.0D, 10000).setDescription("The Magical Power of an entity.").setShouldWatch(true);

    public static final IAttribute SPELLVAMP = new RangedAttribute(null, "dungeoncraft.SpellVamp", 0, 0.0D, 10000).setDescription("The Magical Power of an entity.").setShouldWatch(true);
    public static final IAttribute HEALTH_REGEN = new RangedAttribute(null, "dungeoncraft.HealthRegen", 0, 0.0D, 10000).setDescription("The Magical Power of an entity.").setShouldWatch(true);
    public static final IAttribute MAX_RESOURCE_AMOUNT = new RangedAttribute(null, "dungeoncraft.MaxResourceAmount", 0, 0.0D, 10000).setDescription("The Magical Power of an entity.").setShouldWatch(true);
    public static final IAttribute RESOURCE_REGEN = new RangedAttribute(null, "dungeoncraft.ResourceRegen", 0, 0.0D, 10000).setDescription("The Magical Power of an entity.").setShouldWatch(true);
    public static final IAttribute COOLDOWN_REDUCTION = new RangedAttribute(null, "dungeoncraft.CooldownReduction", 0.0D, 0.0D, 10000).setDescription("The Magical Power of an entity.").setShouldWatch(true);
    public static final IAttribute EXPERIENCE = new RangedAttribute(null, "dungeoncraft.Experience", 0, 0.0D, 10000).setDescription("The Magical Power of an entity.").setShouldWatch(true);

    public static ArrayList<IAttribute> battleAttributes = new ArrayList<>();

    static  {


        battleAttributes.add(ARMOR);
        battleAttributes.add(MAGIC_RESIST);
        battleAttributes.add(SPELL_POWER);
        battleAttributes.add(CRITCHANCE);
        battleAttributes.add(CRITDAMAGE);
        battleAttributes.add(LIFESTEAL);
        battleAttributes.add(FLATARMORPEN);
        battleAttributes.add(FLATMAGICPEN);
        battleAttributes.add(PERCENTARMORPEN);
        battleAttributes.add(PERCENTMAGICPEN);
        battleAttributes.add(SPELLVAMP);
        battleAttributes.add(HEALTH_REGEN);
        battleAttributes.add(ARMOR);
        battleAttributes.add(MAGIC_RESIST);
        battleAttributes.add(MAX_RESOURCE_AMOUNT);
        battleAttributes.add(COOLDOWN_REDUCTION);
        battleAttributes.add(EXPERIENCE);
        battleAttributes.add(RESOURCE_REGEN);

    }



    public static void loadAttributes(DCAttributeMap attributeMap) {



        attributeMap.registerAttribute(SPELL_POWER);
        attributeMap.registerAttribute(CRITCHANCE);
        attributeMap.registerAttribute(CRITDAMAGE);
        attributeMap.registerAttribute(LIFESTEAL);
        attributeMap.registerAttribute(FLATARMORPEN);
        attributeMap.registerAttribute(FLATMAGICPEN);
        attributeMap.registerAttribute(PERCENTARMORPEN);
        attributeMap.registerAttribute(PERCENTMAGICPEN);
        attributeMap.registerAttribute(SPELLVAMP);
        attributeMap.registerAttribute(HEALTH_REGEN);
        attributeMap.registerAttribute(ARMOR);
        attributeMap.registerAttribute(MAGIC_RESIST);
        attributeMap.registerAttribute(MAX_RESOURCE_AMOUNT);
        attributeMap.registerAttribute(COOLDOWN_REDUCTION);
        attributeMap.registerAttribute(EXPERIENCE);
        attributeMap.registerAttribute(RESOURCE_REGEN);


    }


    public static ListNBT writeAttributes(DCAttributeMap map) {
        ListNBT listnbt = new ListNBT();

        for(DCAttributeInstance iattributeinstance : map.getAllAttributes()) {
            listnbt.add(writeAttribute(iattributeinstance));
        }

        return listnbt;
    }

    private static CompoundNBT writeAttribute(DCAttributeInstance instance) {
        CompoundNBT compoundnbt = new CompoundNBT();
        IAttribute iattribute = instance.getAttribute();
        compoundnbt.putString("Name", iattribute.getName());
        compoundnbt.putDouble("Base", instance.getBaseValue());
        Collection<DCAttributeModifier> collection = instance.getModifiers();
        if (collection != null && !collection.isEmpty()) {
            ListNBT listnbt = new ListNBT();

            for(DCAttributeModifier attributemodifier : collection) {
                if (attributemodifier.isSaved()) {
                    listnbt.add(writeAttributeModifier(attributemodifier));
                }
            }

            compoundnbt.put("Modifiers", listnbt);
        }

        return compoundnbt;
    }

    public static CompoundNBT writeAttributeModifier(DCAttributeModifier modifier) {
        CompoundNBT compoundnbt = new CompoundNBT();
        compoundnbt.putString("Name", modifier.getName());
        compoundnbt.putDouble("Amount", modifier.getAmount());
        compoundnbt.putInt("Operation", modifier.getOperation().getId());
        compoundnbt.putUniqueId("UUID", modifier.getID());
        return compoundnbt;
    }

    public static void readAttributes(DCAttributeMap map, ListNBT list) {
        for(int i = 0; i < list.size(); ++i) {
            CompoundNBT compoundnbt = list.getCompound(i);
            DCAttributeInstance iattributeinstance = map.getAttributeInstanceByName(compoundnbt.getString("Name"));
            if (iattributeinstance == null) {
                DungeonCraft.LOGGER.warn("Ignoring unknown attribute '{}'", (Object)compoundnbt.getString("Name"));
            } else {
                readAttribute(iattributeinstance, compoundnbt);
            }
        }

    }

    private static void readAttribute(DCAttributeInstance instance, CompoundNBT compound) {
        instance.setBaseValue(compound.getDouble("Base"));
        if (compound.contains("Modifiers", 9)) {
            ListNBT listnbt = compound.getList("Modifiers", 10);

            for(int i = 0; i < listnbt.size(); ++i) {
                DCAttributeModifier attributemodifier = readAttributeModifier(listnbt.getCompound(i));
                if (attributemodifier != null) {
                    DCAttributeModifier attributemodifier1 = instance.getModifier(attributemodifier.getID());
                    if (attributemodifier1 != null) {
                        instance.removeModifier(attributemodifier1);
                    }

                    instance.applyModifier(attributemodifier);
                }
            }
        }

    }

    @Nullable
    public static DCAttributeModifier readAttributeModifier(CompoundNBT compound) {
        UUID uuid = compound.getUniqueId("UUID");

        try {
            DCAttributeModifier.Operation attributemodifier$operation = DCAttributeModifier.Operation.byId(compound.getInt("Operation"));
            return new DCAttributeModifier(uuid, compound.getString("Name"), compound.getDouble("Amount"), attributemodifier$operation);
        } catch (Exception exception) {
            DungeonCraft.LOGGER.warn("Unable to create attribute: {}", (Object)exception.getMessage());
            return null;
        }
    }
}
