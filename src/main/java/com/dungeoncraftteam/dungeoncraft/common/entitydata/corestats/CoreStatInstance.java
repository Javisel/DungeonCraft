package com.dungeoncraftteam.dungeoncraft.common.entitydata.corestats;

import com.dungeoncraftteam.dungeoncraft.common.entitydata.attributesystem.DCAttributeInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.AbstractAttributeMap;

public abstract class CoreStatInstance extends DCAttributeInstance {

    public final EnumCoreStats stat;


    public CoreStatInstance(EnumCoreStats stat, AbstractAttributeMap p_i1608_1_) {
        super(p_i1608_1_, stat.attribute);
        this.stat=stat;
    }

    public abstract void applyStat(LivingEntity entity);


}
