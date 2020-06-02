package com.dungeoncraftteam.dungeoncraft.common.effects;

import com.dungeoncraftteam.dungeoncraft.common.combatengine.EnumDamageType;
import com.dungeoncraftteam.dungeoncraft.common.combatengine.damagesources.DCEntityDamageSource;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectType;

public class Burning extends EffectBase {



    public Burning() {
        super("burning",EffectType.HARMFUL,10);
    }

    @Override
    public void performEffect(LivingEntity entity, int amplifier) {

        entity.attackEntityFrom(new DCEntityDamageSource(EnumDamageType.FIRE,null),10*amplifier);




    }


    @Override
    public boolean isReady(int duration, int p_76397_2_) {
        return duration % 20 == 0;
    }
}
