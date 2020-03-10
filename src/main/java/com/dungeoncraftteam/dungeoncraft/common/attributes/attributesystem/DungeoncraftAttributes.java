package com.dungeoncraftteam.dungeoncraft.common.attributes.attributesystem;

import com.dungeoncraftteam.dungeoncraft.DungeonCraft;
import com.dungeoncraftteam.dungeoncraft.common.attributes.corestats.CoreStat;
import com.dungeoncraftteam.dungeoncraft.common.attributes.corestats.EnumCoreStats;
import com.dungeoncraftteam.dungeoncraft.common.combatengine.EnumDamageType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;

public class DungeoncraftAttributes {


    //CORE


    //BATTLESTAT
    public static final IAttribute ARMOR = new RangedAttribute(null, "dungeoncraft.Armor", 0, 0.0D, 1000000).setDescription("A entity's Armor Value.").setShouldWatch(true);
    public static final IAttribute ELEMENTRESIST = new RangedAttribute(null, "dungeoncraft.elementResist", 10, 0.0D, 1000000).setDescription("A entity's Magic Resist Value.").setShouldWatch(true);

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
    public static final IAttribute MAX_RESOURCE_AMOUNT = new RangedAttribute(null, "dungeoncraft.MaxResourceAmount", 500, 0.0D, 10000).setDescription("The Magical Power of an entity.").setShouldWatch(true);
    public static final IAttribute RESOURCE_REGEN = new RangedAttribute(null, "dungeoncraft.ResourceRegen", 2.5d, 0.0D, 10000).setDescription("The Magical Power of an entity.").setShouldWatch(true);
    public static final IAttribute COOLDOWN_REDUCTION = new RangedAttribute(null, "dungeoncraft.CooldownReduction", 0.0D, 0.0D, 10000).setDescription("The Magical Power of an entity.").setShouldWatch(true);
    public static final IAttribute EXPERIENCE = new RangedAttribute(null, "dungeoncraft.Experience", 0, 0.0D, 10000).setDescription("The Magical Power of an entity.").setShouldWatch(true);





    public static final IAttribute STRENGTH = new CoreStat(null, "dungeoncraft.Strength" , EnumCoreStats.STRENGTH,new HashMap<IAttribute, CoreStat.modifier>()).setDescription("A entity's Strength Value.").setShouldWatch(true);
    public static final IAttribute DEXTERITY = new CoreStat(null, "dungeoncraft.Dexterity" , EnumCoreStats.DEXTERITY,new HashMap<IAttribute, CoreStat.modifier>()).setDescription("A entity's Dexterity Value.").setShouldWatch(true);
    public static final IAttribute CONSTITUTION = new CoreStat(null, "dungeoncraft.Constitution" , EnumCoreStats.CONSTITUTION,new HashMap<IAttribute, CoreStat.modifier>()).setDescription("A entity's Constitution Value.").setShouldWatch(true);
    public static final IAttribute CHARISMA = new CoreStat(null, "dungeoncraft.Charisma" , EnumCoreStats.CHARISMA,new HashMap<IAttribute, CoreStat.modifier>()).setDescription("A entity's Charisma Value.").setShouldWatch(true);
    public static final IAttribute WISDOM = new CoreStat(null, "dungeoncraft.Wisdom" , EnumCoreStats.WISDOM,new HashMap<IAttribute, CoreStat.modifier>()).setDescription("A entity's Dexterity Value.").setShouldWatch(true);
    public static final IAttribute INTELLIGENCE = new CoreStat(null, "dungeoncraft.Intelliegence" , EnumCoreStats.INTELLIEGENCE,new HashMap<IAttribute, CoreStat.modifier>()).setDescription("A entity's Dexterity Value.").setShouldWatch(true);




    public static ArrayList<IAttribute> attributes = new ArrayList<>();

    static  {
        attributes.add(STRENGTH);


        ((CoreStat) STRENGTH).attributesModified.put(SharedMonsterAttributes.ATTACK_DAMAGE,new CoreStat.modifier(DCAttributeModifier.Operation.ADDITION,4));
        ((CoreStat) STRENGTH).attributesModified.put(ARMOR,new CoreStat.modifier(DCAttributeModifier.Operation.ADDITION,2));





        attributes.add(DEXTERITY);

        ((CoreStat) DEXTERITY).attributesModified.put(SharedMonsterAttributes.ATTACK_SPEED,new CoreStat.modifier(DCAttributeModifier.Operation.MULTIPLY_BASE,0.05));
        ((CoreStat) DEXTERITY).attributesModified.put(SharedMonsterAttributes.MOVEMENT_SPEED,new CoreStat.modifier(DCAttributeModifier.Operation.MULTIPLY_BASE,0.005));
        ((CoreStat) DEXTERITY).attributesModified.put(CRITCHANCE,new CoreStat.modifier(DCAttributeModifier.Operation.ADDITION,2.5));

        attributes.add(CONSTITUTION);
        ((CoreStat) CONSTITUTION).attributesModified.put(SharedMonsterAttributes.MAX_HEALTH,new CoreStat.modifier(DCAttributeModifier.Operation.ADDITION,20));
        ((CoreStat) CONSTITUTION).attributesModified.put(HEALTH_REGEN,new CoreStat.modifier(DCAttributeModifier.Operation.ADDITION,0.5));
        ((CoreStat) CONSTITUTION).attributesModified.put(ELEMENTRESIST,new CoreStat.modifier(DCAttributeModifier.Operation.ADDITION,2));



        attributes.add(INTELLIGENCE);

        ((CoreStat) INTELLIGENCE).attributesModified.put(MAX_RESOURCE_AMOUNT,new CoreStat.modifier(DCAttributeModifier.Operation.ADDITION,10));
        ((CoreStat) INTELLIGENCE).attributesModified.put(RESOURCE_REGEN,new CoreStat.modifier(DCAttributeModifier.Operation.ADDITION,0.5));


        attributes.add(WISDOM);
        ((CoreStat) WISDOM).attributesModified.put(COOLDOWN_REDUCTION,new CoreStat.modifier(DCAttributeModifier.Operation.ADDITION,2.5));

        attributes.add(CHARISMA);

        //I'm not making a new Attribute for every damage type. Fight me.

        for (EnumDamageType type : EnumDamageType.VALUES){
            attributes.add( new RangedAttribute(null,type.getDefensiveName(),0,-10000,10000));
            attributes.add( new RangedAttribute(null,type.getOffensiveName(),0,-10000,10000));



        }





        attributes.add(ARMOR);
        attributes.add(ELEMENTRESIST);
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
        attributes.add(MAX_RESOURCE_AMOUNT);
        attributes.add(COOLDOWN_REDUCTION);
        attributes.add(EXPERIENCE);
        attributes.add(RESOURCE_REGEN);

    }



    public static void loadAttributes(DCAttributeMap attributeMap) {



        for (IAttribute attribute : attributes) {

            attributeMap.registerAttribute(attribute);
        }


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
