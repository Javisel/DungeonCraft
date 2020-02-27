package com.dungeoncraftteam.dungeoncraft.common.entitydata.corestats;

import com.dungeoncraftteam.dungeoncraft.common.entitydata.attributesystem.DungeoncraftAttributes;
import net.minecraft.entity.ai.attributes.IAttribute;

import java.util.UUID;

public enum EnumCoreStats {


    STRENGTH(0, DungeoncraftAttributes.STRENGTH, UUID.fromString("ff9eb8ea-ba2d-48da-b516-6afbaea129d9")),
    DEXTERITY(1, DungeoncraftAttributes.DEXTERITY,  UUID.fromString("9219e302-4111-46a5-ba72-fffc7fa26f39")),
    CONSTITUTION(2, DungeoncraftAttributes.CONSTITUTION,  UUID.fromString("18c5fd5b-09f3-491d-8c9a-e84b6a34a1a4")),
    INTELLIEGENCE(3, DungeoncraftAttributes.INTELLIGENCE,  UUID.fromString("b0c1fe65-2caf-4c22-80f5-e947f4674e3e")),
    WISDOM(4, DungeoncraftAttributes.WISDOM,  UUID.fromString("6acf955a-b4c3-478c-b883-df87e29ab367")),
    CHARISMA(5, DungeoncraftAttributes.CHARISMA,  UUID.fromString("3b3a6b4a-a2c0-409d-9007-e15fd5593fd2"));



   final int id;
    final  IAttribute attribute;
    final  UUID uuid;
    EnumCoreStats(int idIn, IAttribute attribute, UUID uuid) {

       this.attribute=attribute;
        this.id=idIn;
        this.uuid = uuid;
    }









}
