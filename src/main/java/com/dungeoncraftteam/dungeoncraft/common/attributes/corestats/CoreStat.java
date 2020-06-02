package com.dungeoncraftteam.dungeoncraft.common.attributes.corestats;

import com.dungeoncraftteam.dungeoncraft.common.DCUtilities;
import com.dungeoncraftteam.dungeoncraft.common.attributes.attributesystem.DungeoncraftAttributes;
import com.dungeoncraftteam.dungeoncraft.common.capabilities.entity.IEntityData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.RangedAttribute;

import javax.annotation.Nullable;
import java.util.HashMap;

public  class CoreStat extends RangedAttribute {


  public static class modifier{

        AttributeModifier.Operation operation;
        double value;


        public modifier(AttributeModifier.Operation operation, double value) {
            this.operation = operation;
            this.value = value;
        }
    }



    public final EnumCoreStats stat;
    public  HashMap<IAttribute, modifier> attributesModified;




    public CoreStat(@Nullable IAttribute parentIn, String unlocalizedNameIn, EnumCoreStats stat,  HashMap<IAttribute, modifier> attributesModified) {
        //TODO replace Default, Minimum and Max with Config values
        super(parentIn, unlocalizedNameIn, 0, -10, 40);
        this.stat = stat;
        this.attributesModified = attributesModified;
    }


    public void constructAttribute(LivingEntity entity) {

        if (attributesModified.isEmpty()) {
            return;
        }

        IEntityData entityData = DCUtilities.getEntityData(entity);

        int truevalue = (int) (entityData.getStatMap().getAttributeInstanceByName(this.getName()).getValue() - 10);

        for (IAttribute attribute : attributesModified.keySet()) {

            if (DungeoncraftAttributes.attributes.contains(attribute)) {

                if (entityData.getStatMap().getAttributeInstanceByName(attribute.getName()).getModifier(stat.uuid) !=null) {
                    entityData.getStatMap().getAttributeInstanceByName(attribute.getName()).removeModifier(stat.uuid);
                }

                entityData.getStatMap().getAttributeInstance(attribute).applyModifier(new AttributeModifier(stat.uuid,stat.name()+".modifier",attributesModified.get(attribute).value *truevalue,attributesModified.get(attribute).operation));


            } else {


                if (entity.getAttributes().getAttributeInstanceByName(attribute.getName()).getModifier(stat.uuid) !=null) {
                    entity.getAttributes().getAttributeInstanceByName(attribute.getName()).removeModifier(stat.uuid);
                }

                AttributeModifier.Operation operation;

                if (attributesModified.get(attribute).operation== AttributeModifier.Operation.ADDITION) {

                    operation= AttributeModifier.Operation.ADDITION;
                }

               else if (attributesModified.get(attribute).operation== AttributeModifier.Operation.MULTIPLY_BASE) {

                    operation= AttributeModifier.Operation.MULTIPLY_BASE;
                } else
                 {

                    operation= AttributeModifier.Operation.MULTIPLY_TOTAL;
                }

                entity.getAttribute(attribute).applyModifier(new AttributeModifier(stat.uuid,stat.name()+".modifier",attributesModified.get(attribute).value *truevalue,operation));


            }



        }





    }




}
