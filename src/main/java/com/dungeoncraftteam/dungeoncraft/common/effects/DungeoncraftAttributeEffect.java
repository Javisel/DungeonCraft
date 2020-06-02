package com.dungeoncraftteam.dungeoncraft.common.effects;

import com.dungeoncraftteam.dungeoncraft.common.DCUtilities;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.AbstractAttributeMap;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.potion.EffectType;

import java.util.UUID;

public class DungeoncraftAttributeEffect extends EffectBase {

    IAttribute attribute;
    float amount;
    UUID id;
    AttributeModifier.Operation operation;
    public DungeoncraftAttributeEffect(String name, EffectType typeIn, IAttribute attribute, float baseamount, UUID id, AttributeModifier.Operation operation, int liquidColorIn) {
        super(name, typeIn, liquidColorIn);
        amount=baseamount;
        this.attribute=attribute;
        this.id=id;
        this.operation=operation;

    }

    @Override
    public void applyAttributesModifiersToEntity(LivingEntity entityLivingBaseIn, AbstractAttributeMap attributeMapIn, int amplifier) {
        super.applyAttributesModifiersToEntity(entityLivingBaseIn, attributeMapIn, amplifier);

        DCUtilities.getEntityData(entityLivingBaseIn).getStatMap().getAttributeInstance(attribute).applyModifier(new AttributeModifier(id,this.getName()+".mod",amount*amplifier,operation));;



    }

    @Override
    public void removeAttributesModifiersFromEntity(LivingEntity entityLivingBaseIn, AbstractAttributeMap attributeMapIn, int amplifier) {
        super.removeAttributesModifiersFromEntity(entityLivingBaseIn, attributeMapIn, amplifier);



        DCUtilities.getEntityData(entityLivingBaseIn).getStatMap().getAttributeInstance(attribute).removeModifier(id);


    }
}
