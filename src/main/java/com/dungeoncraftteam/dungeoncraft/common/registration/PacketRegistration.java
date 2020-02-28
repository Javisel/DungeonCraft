package com.dungeoncraftteam.dungeoncraft.common.registration;

import com.dungeoncraftteam.dungeoncraft.DungeonCraft;
import com.dungeoncraftteam.dungeoncraft.common.network.EntityDataMessage;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;

public  class PacketRegistration {

    private static final String PROTOCOL_VERSION = Integer.toString(1);
    public static final SimpleChannel HANDLER = NetworkRegistry.ChannelBuilder
            .named(new ResourceLocation(DungeonCraft.MODID, "main_channel"))
            .clientAcceptedVersions(PROTOCOL_VERSION::equals)
            .serverAcceptedVersions(PROTOCOL_VERSION::equals)
            .networkProtocolVersion(() -> PROTOCOL_VERSION)
            .simpleChannel();
    private static int index;

    public static void register() {
        registerMessage(EntityDataMessage.class, EntityDataMessage::encode, EntityDataMessage::decode, EntityDataMessage.Handler::handle);

       // registerMessage(PlayerDataMessage.class, PlayerDataMessage::encode, PlayerDataMessage::decode, PlayerDataMessage.Handler::handle);

    }

    private static <MSG> void registerMessage(Class<MSG> type, BiConsumer<MSG, PacketBuffer> encoder, Function<PacketBuffer, MSG> decoder,
                                              BiConsumer<MSG, Supplier<NetworkEvent.Context>> consumer) {
        HANDLER.registerMessage(index++, type, encoder, decoder, consumer);
    }

}
