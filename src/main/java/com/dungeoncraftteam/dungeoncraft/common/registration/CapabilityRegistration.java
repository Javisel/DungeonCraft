package com.dungeoncraftteam.dungeoncraft.common.registration;

import com.dungeoncraftteam.dungeoncraft.DungeonCraft;
import com.dungeoncraftteam.dungeoncraft.common.capabilities.entity.EntityDataProvider;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CapabilityRegistration {


    @SubscribeEvent
    public static void attachCapability( final AttachCapabilitiesEvent<Entity> event) {





        if (event.getObject() instanceof LivingEntity) {
            event.addCapability(new ResourceLocation(DungeonCraft.MODID, "entitydata"), new EntityDataProvider());

        }

    }



}