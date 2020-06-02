package com.dungeoncraftteam.dungeoncraft.common.action;

import com.google.common.collect.Lists;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.registries.ForgeRegistryEntry;

import javax.annotation.Nullable;
import java.util.List;

public abstract class AbstractAction extends ForgeRegistryEntry<AbstractAction> {


    public AbstractAction(String name) {
        super();
        setRegistryName(name);

    }

    public void addtoActionBar(LivingEntity caster) {



    }


    public void addtoActionInventory(LivingEntity caster) {



    }

    public void attemptCast(LivingEntity caster, World world, ActionInstance actionInstance, @Nullable ItemStack castitem) {



    }

    public float getCost(LivingEntity caster, World world, ItemStack castitem ) {


        return  0;
    }

    public boolean canCast(LivingEntity caster, World world, ActionInstance actionInstance, @Nullable ItemStack castitem) {

        return  caster.getHealth()<caster.getMaxHealth();
    }


    //For continous Spells
    public void tickAction(LivingEntity caster, World world, ActionInstance actionInstance, @Nullable ItemStack castitem) {



    }



    //Ends the currently active spell, cleaning up anything.
    public void endCast(LivingEntity caster, World world, ActionInstance actionInstance, @Nullable ItemStack castitem) {



    }
    @OnlyIn(Dist.CLIENT)
    public List<ITextComponent> getTooltip(@Nullable PlayerEntity playerIn, ITooltipFlag advanced) {
        List<ITextComponent> list = Lists.newArrayList();

        return  list;
    }
}
