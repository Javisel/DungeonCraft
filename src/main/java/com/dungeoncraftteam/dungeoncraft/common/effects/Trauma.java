package com.dungeoncraftteam.dungeoncraft.common.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AbstractAttributeMap;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectType;

import java.util.ArrayList;
import java.util.UUID;

public class Trauma extends EffectBase {


    public Trauma() {
        super("trauma", EffectType.HARMFUL,1234);
        addAttributesModifier(SharedMonsterAttributes.ATTACK_SPEED,"08ff136b-9b9b-4660-9987-9eb66f71ff44",-10, AttributeModifier.Operation.MULTIPLY_TOTAL);

    }

    @Override
    public void applyAttributesModifiersToEntity(LivingEntity p_111185_1_, AbstractAttributeMap p_111185_2_, int p_111185_3_) {
        super.applyAttributesModifiersToEntity(p_111185_1_, p_111185_2_, p_111185_3_);

        ArrayList<ItemStack> equipment = (ArrayList<ItemStack>) p_111185_1_.getEquipmentAndArmor();

        for (ItemStack stack : equipment) {

            stack.attemptDamageItem(2 * p_111185_3_,p_111185_1_.getRNG(),null);
        }



    }
}

