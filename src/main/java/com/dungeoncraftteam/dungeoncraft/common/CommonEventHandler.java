package com.dungeoncraftteam.dungeoncraft.common;

import com.dungeoncraftteam.dungeoncraft.common.network.EntityDataMessage;
import com.dungeoncraftteam.dungeoncraft.common.registration.PacketRegistration;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.network.NetworkDirection;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)

public class CommonEventHandler {

    @SubscribeEvent
    public void tick(TickEvent.PlayerTickEvent e) {

        if (e.phase== TickEvent.Phase.END && !e.player.getEntityWorld().isRemote) {

            DCUtilities.getEntityData(e.player).tick();

            if (DCUtilities.getEntityData(e.player).getTicks()==20) {

                e.player.heal((float) DCUtilities.getEntityData(e.player).getHealthRegen().getValue());
                DCUtilities.getEntityData(e.player).addResourceAmount((float) DCUtilities.getEntityData(e.player).getResourceRegen().getValue());
                PacketRegistration.HANDLER.sendTo(new EntityDataMessage(DCUtilities.getEntityData(e.player).writeNBT()), ((ServerPlayerEntity) e.player).connection.netManager, NetworkDirection.PLAY_TO_CLIENT);

            }

        }



    }













}
