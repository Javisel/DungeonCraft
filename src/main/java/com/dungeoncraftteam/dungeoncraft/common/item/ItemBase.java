package com.dungeoncraftteam.dungeoncraft.common.item;

import com.dungeoncraftteam.dungeoncraft.DungeonCraft;
import net.minecraft.item.Item;

public class ItemBase extends Item {



    public ItemBase(String name,Properties properties) {
        super(properties);
        setRegistryName(DungeonCraft.MODID,name);


    }
}
