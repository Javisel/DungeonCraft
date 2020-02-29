package com.dungeoncraftteam.dungeoncraft.common.combatengine;

import com.dungeoncraftteam.dungeoncraft.common.attributes.attributesystem.DCAttributeModifier;

import java.util.ArrayList;
import java.util.HashMap;

public class SubTypeDamageModifierMap extends HashMap<EnumDamageSubType, ArrayList<DCAttributeModifier>> {


    public SubTypeDamageModifierMap() {

        for (EnumDamageSubType subType: EnumDamageSubType.VALUES) {


            this.put(subType,new ArrayList<>());
        }


    }



    public double applyModifiers(EnumDamageSubType subType, float amount) {

        double total = amount;

        //TODO - Event for Flat damage reduction

        if (!this.get(subType).isEmpty()) {
            for (int i = 0; i < DCAttributeModifier.Operation.values().length - 1; i++) {
                for (DCAttributeModifier attributeModifier : this.get(subType)) {

                    if (i == attributeModifier.getOperation().getId()) {

                        attributeModifier.apply(total);


                    }


                }

            }
        }





        return  total;



    }









}