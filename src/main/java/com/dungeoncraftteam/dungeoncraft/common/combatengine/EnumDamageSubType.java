package com.dungeoncraftteam.dungeoncraft.common.combatengine;

import net.minecraft.item.DyeColor;

import java.util.Arrays;
import java.util.Comparator;

public enum EnumDamageSubType {

    TRUE("true",0),
    ACID("acid",1),
    BLUDGEONING("bludgeoning",2),
    COLD("cold",3),
    HEAT("heat",4),
    FORCE("force",5),
    LIGHTNING("lightning",6),
    NECROTIC("necrotic",7),
    PIERCING("piercing",8),
    POISON("poison",9),
    PSYCHIC("psychic",10),
    RADIANT("radiant",11),
    SLASHING("slashing",12),
    THUNDER("thunder",13);




    public static final EnumDamageSubType[] VALUES = Arrays.stream(values()).sorted(Comparator.comparingInt(EnumDamageSubType::getId)).toArray((p_199795_0_) -> {
        return new EnumDamageSubType[p_199795_0_];
    });

    int id;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    String name;

    EnumDamageSubType(String nameIn, int idIn) {

        id=idIn;


        name=nameIn;



    }






}
