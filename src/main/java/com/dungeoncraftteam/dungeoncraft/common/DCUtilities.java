package com.dungeoncraftteam.dungeoncraft.common;

import com.dungeoncraftteam.dungeoncraft.common.attributes.attributesystem.DungeoncraftAttributes;
import com.dungeoncraftteam.dungeoncraft.common.attributes.corestats.CoreStat;
import com.dungeoncraftteam.dungeoncraft.common.capabilities.entity.EntityDataProvider;
import com.dungeoncraftteam.dungeoncraft.common.capabilities.entity.IEntityData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttribute;

public class DCUtilities {



    public static IEntityData getEntityData(LivingEntity entity) {



        return  entity.getCapability(EntityDataProvider.Entity_DATA_CAPABILITY,null).orElseThrow(NullPointerException::new);
    }


    public static void applyEntityModifier(LivingEntity entity, IAttribute attribute, AttributeModifier modifier) {


        IEntityData entityData = getEntityData(entity);


        if (entityData.getStatMap().getAttributeInstance(attribute) !=null) {

            entityData.getStatMap().getAttributeInstance(attribute).applyModifier(modifier);



        }
        if (attribute instanceof CoreStat) {

        ((CoreStat) attribute).constructAttribute(entity);



        }








    }


    public static void recalculateCoreStats(LivingEntity entity) {



        for (CoreStat stat : DungeoncraftAttributes.coreStats) {


            stat.constructAttribute(entity);


        }








    }













}
