package com.dungeoncraftteam.dungeoncraft.common.entitydata.attributesystem;

import net.minecraft.entity.ai.attributes.AttributeMap;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.RangedAttribute;

import java.util.ArrayList;

public class DungeoncraftAttributes {


    public static final IAttribute STRENGTH = new RangedAttribute(null, "dungeoncraft.Strength", 0, -10.0D, 20).setDescription("A entity's Strength Value.").setShouldWatch(true);
    public static final IAttribute CONSTITUTION = new RangedAttribute(null, "dungeoncraft.Constitution", 0, -10.0D, 20).setDescription("A entity's Constitution Value.").setShouldWatch(true);
    public static final IAttribute DEXTERITY = new RangedAttribute(null, "dungeoncraft.Dexterity", 0, -10.0D, 20).setDescription("A entity's Dexterity Value.").setShouldWatch(true);
    public static final IAttribute INTELLIGENCE = new RangedAttribute(null, "dungeoncraft.Intelligence", 0, -10.0D, 20).setDescription("A entity's Intelligence Value.").setShouldWatch(true);
    public static final IAttribute WISDOM = new RangedAttribute(null, "dungeoncraft.Wisdom", 0, -10.0D, 20).setDescription("A entity's Wisdom Value.").setShouldWatch(true);
    public static final IAttribute CHARISMA = new RangedAttribute(null, "dungeoncraft.Charisma", 0, -10.0D, 20).setDescription("A entity's Charisma Value.").setShouldWatch(true);
    public static final IAttribute ARMOR = new RangedAttribute(null, "dungeoncraft.Armor", 0, 0.0D, 1000000).setDescription("A entity's Armor Value.").setShouldWatch(true);
    public static final IAttribute MAGIC_RESIST = new RangedAttribute(null, "dungeoncraft.MagicResist", 10, 0.0D, 1000000).setDescription("A entity's Magic Resist Value.").setShouldWatch(true);
    public static final IAttribute MAX_HEALTH = new RangedAttribute(null, "dungeoncraft.MaxHealth", 40, 0.0D, 1000000).setDescription("A entity's health.").setShouldWatch(true);

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

    public static ArrayList<IAttribute> attributes = new ArrayList<>();

    static  {

        attributes.add(STRENGTH);
        attributes.add(CONSTITUTION);
        attributes.add(CHARISMA);
        attributes.add(DEXTERITY);
        attributes.add(INTELLIGENCE);
        attributes.add(WISDOM);
        attributes.add(ARMOR);
        attributes.add(MAGIC_RESIST);
        attributes.add(MAX_HEALTH);
        attributes.add(SPELL_POWER);
        attributes.add(CRITCHANCE);
        attributes.add(CRITDAMAGE);
        attributes.add(LIFESTEAL);
        attributes.add(FLATARMORPEN);
        attributes.add(FLATMAGICPEN);
        attributes.add(PERCENTARMORPEN);
        attributes.add(PERCENTMAGICPEN);
        attributes.add(SPELLVAMP);
        attributes.add(HEALTH_REGEN);
        attributes.add(ARMOR);
        attributes.add(MAGIC_RESIST);
        attributes.add(MAX_RESOURCE_AMOUNT);
        attributes.add(COOLDOWN_REDUCTION);
        attributes.add(EXPERIENCE);
        attributes.add(RESOURCE_REGEN);

    }



    public static void loadAttributes(AttributeMap attributeMap) {

        attributeMap.registerAttribute(STRENGTH);
        attributeMap.registerAttribute(CHARISMA);
        attributeMap.registerAttribute(CONSTITUTION);
        attributeMap.registerAttribute(WISDOM);

        attributeMap.registerAttribute(DEXTERITY);
        attributeMap.registerAttribute(INTELLIGENCE);


        attributeMap.registerAttribute(MAX_HEALTH);
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



}
