package com.dungeoncraftteam.dungeoncraft.common;

import com.dungeoncraftteam.dungeoncraft.common.capabilities.entity.EntityDataProvider;
import com.dungeoncraftteam.dungeoncraft.common.capabilities.entity.IEntityData;
import net.minecraft.entity.LivingEntity;

public class DCUtilities {



    public static IEntityData getEntityData(LivingEntity entity) {



        return  entity.getCapability(EntityDataProvider.Entity_DATA_CAPABILITY,null).orElseThrow(NullPointerException::new);
    }




    public static void recalculateCoreStats(LivingEntity entity) {









    }













}
