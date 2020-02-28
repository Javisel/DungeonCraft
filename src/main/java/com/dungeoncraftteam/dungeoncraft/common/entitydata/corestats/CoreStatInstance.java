package com.dungeoncraftteam.dungeoncraft.common.entitydata.corestats;

import com.dungeoncraftteam.dungeoncraft.common.entitydata.attributesystem.DCAttributeInstance;
import com.dungeoncraftteam.dungeoncraft.common.entitydata.attributesystem.DCAttributeMap;
import net.minecraft.entity.LivingEntity;

public abstract class CoreStatInstance extends DCAttributeInstance {

    public final EnumCoreStats stat;


    public CoreStatInstance(EnumCoreStats stat, DCAttributeMap p_i1608_1_) {
        super(p_i1608_1_, stat.attribute);
        this.stat=stat;
    }

    public abstract void applyStat(LivingEntity entity);


}
