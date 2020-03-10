package com.dungeoncraftteam.dungeoncraft.common.registration;

import com.dungeoncraftteam.dungeoncraft.DungeonCraft;
import com.dungeoncraftteam.dungeoncraft.common.item.TestingStick;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(DungeonCraft.MODID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)

public class ItemRegistration {

    public static Item TESTING_STICK = null;

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void registerItems(final RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll
                (


                      TESTING_STICK = new TestingStick()


                );
    }


}
