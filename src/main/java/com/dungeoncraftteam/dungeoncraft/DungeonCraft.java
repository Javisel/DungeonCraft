package com.dungeoncraftteam.dungeoncraft;

import com.dungeoncraftteam.dungeoncraft.client.OverlayHandler;
import com.dungeoncraftteam.dungeoncraft.common.CommonEventHandler;
import com.dungeoncraftteam.dungeoncraft.common.capabilities.entity.EntityData;
import com.dungeoncraftteam.dungeoncraft.common.capabilities.entity.EntityDataStorage;
import com.dungeoncraftteam.dungeoncraft.common.capabilities.entity.IEntityData;
import com.dungeoncraftteam.dungeoncraft.common.capabilities.player.IPlayerData;
import com.dungeoncraftteam.dungeoncraft.common.capabilities.player.PlayerData;
import com.dungeoncraftteam.dungeoncraft.common.capabilities.player.PlayerDataStorage;
import com.dungeoncraftteam.dungeoncraft.common.registration.PacketRegistration;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("dungeoncraft")
public class DungeonCraft
{
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "dungeoncraft";
    public DungeonCraft() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {

        CapabilityManager.INSTANCE.register(IEntityData.class, new EntityDataStorage(), EntityData::new);
  CapabilityManager.INSTANCE.register(IPlayerData.class, new PlayerDataStorage(), PlayerData::new);
        MinecraftForge.EVENT_BUS.register(new CommonEventHandler());
        PacketRegistration.register();


    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client


        MinecraftForge.EVENT_BUS.register(new OverlayHandler());

    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        // some example code to dispatch IMC to another mod
    }

    private void processIMC(final InterModProcessEvent event)
    {
        // some example code to receive and process InterModComms from other mods
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m->m.getMessageSupplier().get()).
                collect(Collectors.toList()));
    }
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            // register a new block here
            LOGGER.info("HELLO from Register Block");
        }
    }
}
