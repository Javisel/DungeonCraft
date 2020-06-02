package com.dungeoncraftteam.dungeoncraft.common.combatengine;

import com.dungeoncraftteam.dungeoncraft.DungeonCraft;
import com.dungeoncraftteam.dungeoncraft.common.effects.Trauma;
import net.minecraft.potion.Effect;

import java.util.Arrays;
import java.util.Comparator;

import static com.dungeoncraftteam.dungeoncraft.common.registration.EffectRegistration.*;

public enum EnumDamageType {

    TRUE("true",0),
    ACID("acid",1),
    BLUDGEONING("bludgeoning",2),
    COLD("cold",3),
    FIRE("fire",4),
    FORCE("force",5),
    LIGHTNING("lightning",6),
    NECROTIC("necrotic",7),
    PIERCING("piercing",8),
    POISON("poison",9),
    PSYCHIC("psychic",10),
    RADIANT("radiant",11),
    SLASHING("slashing",12),
    THUNDER("thunder",13);




    public static final EnumDamageType[] VALUES = Arrays.stream(values()).sorted(Comparator.comparingInt(EnumDamageType::getId)).toArray((p_199795_0_) -> new EnumDamageType[p_199795_0_]);

    int id;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    String name;


    EnumDamageType(String nameIn, int idIn) {

        id=idIn;


        name=nameIn;



    }


    public String getDefensiveName() {


        return DungeonCraft.MODID+"." +name+"Resist";
    }


    public String getOffensiveName() {


        return DungeonCraft.MODID+"." +name+"Damage";
    }


}
