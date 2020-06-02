package com.dungeoncraftteam.dungeoncraft.common.action.spells;

import com.dungeoncraftteam.dungeoncraft.common.action.AbstractAction;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class SecondWind extends AbstractAction {



    public SecondWind() {
        super("second_wind");
    }

    @Override
    public void addtoActionList(LivingEntity caster) {



        super.addtoActionList(caster);
    }

    @Override
    public void attemptCast(LivingEntity caster, World world, ItemStack casitem) {

        if (canCast(caster, world, casitem)) {

            float missinghealth = (caster.getMaxHealth() - caster.getHealth()) * 0.10f;
            float maxhealth = caster.getMaxHealth() * 0.10f;


            caster.heal(missinghealth+maxhealth);


            if (world.isRemote) {


                 world.playMovingSound(null,caster, SoundEvents.ENTITY_GENERIC_EXTINGUISH_FIRE, SoundCategory.AMBIENT,1,1);




            }





        }


    }

    @Override
    public float getCost(LivingEntity caster, World world, ItemStack castitem) {
        return super.getCost(caster, world, castitem);
    }

    @Override
    public boolean canCast(LivingEntity caster, World world, ItemStack castitem) {
        return super.canCast(caster, world, castitem);
    }

    @Override
    public void tickAction(LivingEntity caster, World world, ItemStack casitem) {
        super.tickAction(caster, world, casitem);
    }



    @Override
    public List<ITextComponent> getTooltip(@Nullable PlayerEntity playerIn, ITooltipFlag advanced) {
        return super.getTooltip(playerIn, advanced);
    }
}
