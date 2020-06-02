package com.dungeoncraftteam.dungeoncraft.common.effects;

import com.dungeoncraftteam.dungeoncraft.DungeonCraft;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;

public class EffectBase extends Effect {


    public EffectBase(String name, EffectType typeIn, int liquidColorIn) {
        super(typeIn, liquidColorIn);
        setRegistryName(DungeonCraft.MODID,name);
    }







}
