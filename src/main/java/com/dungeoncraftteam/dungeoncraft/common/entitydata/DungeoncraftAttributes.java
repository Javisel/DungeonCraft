package com.dungeoncraftteam.dungeoncraft.common.entitydata;

import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.RangedAttribute;

import java.util.ArrayList;

public class DungeoncraftAttributes {


    public static final IAttribute STRENGTH = new RangedAttribute(null, "dungeoncraft.Strength", 10, 0.0D, 1000000).setDescription("A entity's Strength Value.").setShouldWatch(true);
    public static final IAttribute CONSTITUTION = new RangedAttribute(null, "dungeoncraft.Constitution", 10, 0.0D, 1000000).setDescription("A entity's Constitution Value.").setShouldWatch(true);
    public static final IAttribute DEXTERITY = new RangedAttribute(null, "dungeoncraft.Dexterity", 10, 0.0D, 1000000).setDescription("A entity's Dexterity Value.").setShouldWatch(true);
    public static final IAttribute INTELLIGENCE = new RangedAttribute(null, "dungeoncraft.Intelligence", 10, 0.0D, 1000000).setDescription("A entity's Intelligence Value.").setShouldWatch(true);
    public static final IAttribute WISDOM = new RangedAttribute(null, "dungeoncraft.Wisdom", 10, 0.0D, 1000000).setDescription("A entity's Wisdom Value.").setShouldWatch(true);
    public static final IAttribute CHARISMA = new RangedAttribute(null, "dungeoncraft.Charisma", 10, 0.0D, 1000000).setDescription("A entity's Charisma Value.").setShouldWatch(true);
    public static final IAttribute DEFENCE = new RangedAttribute(null, "dungeoncraft.Defence", 10, 0.0D, 1000000).setDescription("A entity's Defence Value.").setShouldWatch(true);
    public static final IAttribute MAGIC_RESIST = new RangedAttribute(null, "dungeoncraft.MagicResist", 10, 0.0D, 1000000).setDescription("A entity's Magic Resist Value.").setShouldWatch(true);
    public static ArrayList<IAttribute> attributes = new ArrayList<>();

    static  {

        attributes.add(STRENGTH);
        attributes.add(CONSTITUTION);
        attributes.add(CHARISMA);
        attributes.add(DEXTERITY);
        attributes.add(INTELLIGENCE);
        attributes.add(WISDOM);
        attributes.add(DEFENCE);
        attributes.add(MAGIC_RESIST);

    }





}
