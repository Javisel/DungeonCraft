package com.dungeoncraftteam.dungeoncraft.common.registration;

import com.dungeoncraftteam.dungeoncraft.DungeonCraft;
import com.dungeoncraftteam.dungeoncraft.common.attributes.attributesystem.DungeoncraftAttributes;
import com.dungeoncraftteam.dungeoncraft.common.effects.Burning;
import com.dungeoncraftteam.dungeoncraft.common.effects.DungeoncraftAttributeEffect;
import com.dungeoncraftteam.dungeoncraft.common.effects.EffectBase;
import com.dungeoncraftteam.dungeoncraft.common.effects.Trauma;
import com.dungeoncraftteam.dungeoncraft.common.item.TestingStick;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.item.Item;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

import java.util.UUID;

@ObjectHolder(DungeonCraft.MODID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)

public class EffectRegistration {


    public static Effect CORROSION = null;
    public static Effect TRAUMA = null;
    public static Effect FROSTBITE = null;
    public static Effect BURNING = null;

    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Effect> event) {
        event.getRegistry().registerAll
                (

                        CORROSION = new DungeoncraftAttributeEffect("corrosion", EffectType.HARMFUL, DungeoncraftAttributes.ARMOR,10, UUID.fromString("da8eba98-8d83-487a-aed2-5a6fe3b8cf69"), AttributeModifier.Operation.MULTIPLY_TOTAL,1234),
                        TRAUMA = new Trauma(),
                        FROSTBITE = new EffectBase("frostbite",EffectType.HARMFUL,012).addAttributesModifier(SharedMonsterAttributes.MOVEMENT_SPEED,"d854b413-9349-459a-8ce0-f15ea9e4c28b",-10, AttributeModifier.Operation.MULTIPLY_TOTAL),
                        BURNING = new Burning()

                );
    }




}
