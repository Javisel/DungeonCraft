package com.dungeoncraftteam.dungeoncraft.client;

import com.dungeoncraftteam.dungeoncraft.DungeonCraft;
import com.dungeoncraftteam.dungeoncraft.common.DCUtilities;
import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.client.MainWindow;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.IngameGui;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.config.GuiUtils;
import net.minecraftforge.fml.common.Mod;

import java.awt.*;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class OverlayHandler extends GuiUtils {

    private static final ResourceLocation RPGHUD = new ResourceLocation(DungeonCraft.MODID, "textures/gui/overlay/rpghud.png");

    Minecraft instance = Minecraft.getInstance();

    private static final int barwidth=83, barheight=10;

    @SubscribeEvent
    public   void overlayOverride(RenderGameOverlayEvent.Pre event) {


        if (!instance.player.isCreative() ) {


            if (event.getType()== RenderGameOverlayEvent.ElementType.HEALTH) {

                renderHealthBar();
                event.setCanceled(true);
            }


            if (event.isCancelable()) {
                //event.setCanceled(true);
            }



            renderActives();
        }

    }
    @SubscribeEvent
    public void adjustChat(RenderGameOverlayEvent.Chat e) {

        e.setPosY(e.getPosY() - 20);



    }

    public void renderHealthBar() {
        MainWindow scaledresolution = instance.mainWindow;

        int x = scaledresolution.getScaledWidth();

        int y = scaledresolution.getScaledHeight();

        instance.textureManager.bindTexture(RPGHUD);


        //Healthbar
        drawTexturedModalRect((x/2)-92,y-40,2,53,barwidth,barheight,-1);
        float healthratio = instance.player.getHealth()/instance.player.getMaxHealth();

        GlStateManager.pushMatrix();


        if (healthratio > 0.45) {
            GlStateManager.color3f(0,1,0);

        }
        else if (healthratio<0.45 && healthratio > 0.10) {
            GlStateManager.color3f(1,216/255,0);


        } else if (healthratio<0.10) {
            GlStateManager.color3f(1,0,0);


        }

        drawTexturedModalRect(((x/2)-91),y-40+1,3,75, (int) (81*healthratio),8,-1);

        GlStateManager.color3f(0,0,0);

        String hp = instance.player.getHealth() + "/" +instance.player.getMaxHealth();
        instance.fontRenderer.drawString(hp,((x/2)-91)+instance.fontRenderer.getStringWidth(hp)/4,y-39,Color.WHITE.getRGB()   );

        GlStateManager.popMatrix();







    }

    public void renderActives(){
        MainWindow scaledresolution = instance.mainWindow;

        int x = scaledresolution.getScaledWidth();

        int y = scaledresolution.getScaledHeight();

        instance.textureManager.bindTexture(RPGHUD);


        //MANA BAR

        drawTexturedModalRect(0,y-10,2,53,barwidth,barheight,-1);


        //MANA ratio

        float manaamount = (float) (DCUtilities.getEntityData(instance.player).getResourceAmount()/DCUtilities.getEntityData(instance.player).getMaxResourceAmount().getValue());


        String manamount = DCUtilities.getEntityData(instance.player).getResourceAmount() +"/" + DCUtilities.getEntityData(instance.player).getMaxResourceAmount().getValue();


        drawTexturedModalRect(1,y-9,3,64, (int) (81 * manaamount),8,0);

        instance.fontRenderer.drawString(manamount,0+instance.fontRenderer.getStringWidth(manamount)/4,y-9, Color.WHITE.getRGB());


        instance.textureManager.bindTexture(RPGHUD);


        for (int yscale = 0; yscale < 2; yscale++) {

            for (int xscale = 0; xscale < 4; xscale++) {
                drawTexturedModalRect((21 * xscale), (y -30) - (21 * yscale), 2, 2, 20, 20, 50);

            }

        }

    instance.textureManager.bindTexture(IngameGui.GUI_ICONS_LOCATION);

    }








}