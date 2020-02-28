package com.dungeoncraftteam.dungeoncraft.client;

import com.dungeoncraftteam.dungeoncraft.DungeonCraft;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class OverlayHandler  {

    private static final ResourceLocation RPGHUD = new ResourceLocation(DungeonCraft.MODID, "textures/gui/overlay/rpghud.png");

    Minecraft instance = Minecraft.getInstance();


    @SubscribeEvent
    public   void overlayOverride(RenderGameOverlayEvent.Pre event) {


        if (!instance.player.isCreative()) {


            if (event.getType()== RenderGameOverlayEvent.ElementType.HEALTH) {

                renderHealthBar();

            }


            if (event.isCancelable()) {
                event.setCanceled(true);
            }



            renderActiveSpells();
        }

    }

    public void renderHealthBar() {




    }

    public void renderActiveSpells(){



    }








}
