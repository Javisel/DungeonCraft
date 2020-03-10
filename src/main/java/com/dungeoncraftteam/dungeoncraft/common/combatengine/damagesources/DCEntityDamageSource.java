package com.dungeoncraftteam.dungeoncraft.common.combatengine.damagesources;

import com.dungeoncraftteam.dungeoncraft.common.combatengine.EnumDamageType;
import net.minecraft.entity.Entity;
import net.minecraft.util.EntityDamageSource;

import javax.annotation.Nullable;

public class DCEntityDamageSource extends EntityDamageSource {




    private EnumDamageType damageType;
    public DCEntityDamageSource(EnumDamageType damageTypes, @Nullable Entity source) {
        super(damageTypes.getName() +".entitydamage", source);

        this.damageType=damageTypes;






    }





    public EnumDamageType getSubtype() {
        return damageType;
    }

}
