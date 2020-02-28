package com.dungeoncraftteam.dungeoncraft.common.spell;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.registries.ForgeRegistryEntry;

public abstract class  AbstractSpell extends ForgeRegistryEntry<AbstractSpell> {







    public AbstractSpell(String name) {
        super();
        setRegistryName(name);
    }



    public boolean attemptCast(LivingEntity caster, World world, ItemStack casitem) {



        return  false;
    }


    public void tickSpell(LivingEntity caster, World world, ItemStack casitem) {



    }



    public boolean endCast(LivingEntity caster, World world, ItemStack casitem) {



        return  false;
    }

}
