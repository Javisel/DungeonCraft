package com.dungeoncraftteam.dungeoncraft.common.entitydata.attributesystem;

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

    }





}
