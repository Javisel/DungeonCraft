package com.dungeoncraftteam.dungeoncraft.common.combatengine;

public enum EnumDamageArchetype {

    TRUE("true",0),
    MAGICAL("magical",1),
    PHYSICAL("physical",2);



    int id;
    String name;

    EnumDamageArchetype(String nameIn, int idIn) {

        name=nameIn;
        id=idIn;
    }
}
