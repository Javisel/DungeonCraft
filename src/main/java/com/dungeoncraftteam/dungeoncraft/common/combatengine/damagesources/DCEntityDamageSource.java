package com.dungeoncraftteam.dungeoncraft.common.combatengine.damagesources;

import com.dungeoncraftteam.dungeoncraft.common.combatengine.EnumDamageArchetype;
import com.dungeoncraftteam.dungeoncraft.common.combatengine.EnumDamageSubType;
import net.minecraft.entity.Entity;
import net.minecraft.util.EntityDamageSource;

import javax.annotation.Nullable;

public class DCEntityDamageSource extends EntityDamageSource {



    private EnumDamageArchetype archetype;

    private EnumDamageSubType damageType;
    public DCEntityDamageSource(EnumDamageArchetype damageArchetype, EnumDamageSubType damageTypes, @Nullable Entity source) {
        super(damageTypes.getName() +".entitydamage", source);

        this.damageType=damageTypes;
        this.archetype=damageArchetype;





    }



    public EnumDamageArchetype getArchetype() {
        return archetype;
    }


    public EnumDamageSubType getSubtype() {
        return damageType;
    }

}
