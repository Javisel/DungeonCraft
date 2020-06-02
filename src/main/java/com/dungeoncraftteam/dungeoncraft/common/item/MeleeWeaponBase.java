package com.dungeoncraftteam.dungeoncraft.common.item;

import com.google.common.collect.Multimap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;

public  class MeleeWeaponBase extends ItemBase {


    private IItemTier tier;
    private double attackDamage;
    private double attackSpeed;





    public MeleeWeaponBase(String name, IItemTier tier, double baseAttackDamage, double attackSpeed, Properties properties) {
        super(name, properties);
        this.tier = tier;
        attackDamage=baseAttackDamage+tier.getAttackDamage();
        this.attackSpeed=attackSpeed;


    }

    /**
     * Current implementations of this method in child classes do not use the entry argument beside ev. They just raise
     * the damage on the stack.
     *
     * @param stack
     * @param target
     * @param attacker
     */
    @Override
    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        return super.hitEntity(stack, target, attacker);


    }

    /**
     * Called when the player Left Clicks (attacks) an entity. Processed before
     * damage is done, if return value is true further processing is canceled and
     * the entity is not attacked.
     * For Dungeoncraft, used for On-Attack effects.
     *
     * @param stack  The Item being used
     * @param player The player that is attacking
     * @param entity The entity being attacked
     * @return True to cancel the rest of the interaction.
     */
    @Override
    public boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity entity) {
        return false;
    }

    /**
     * Called when a entity tries to play the 'swing' animation.
     *
     * @param stack
     * @param entity The entity swinging the item.
     * @return True to cancel any further processing by EntityLiving
     */
    @Override
    public boolean onEntitySwing(ItemStack stack, LivingEntity entity) {
        return false;
    }

    /**
     * ItemStack sensitive version of getItemAttributeModifiers
     *
     * @param slot
     * @param stack
     */
    @Override
    public Multimap<String, AttributeModifier> getAttributeModifiers(EquipmentSlotType slot, ItemStack stack) {
        Multimap<String, AttributeModifier> multimap = super.getAttributeModifiers(slot,stack);
        if (slot == EquipmentSlotType.MAINHAND) {
            multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", (double)this.attackDamage, AttributeModifier.Operation.ADDITION));
            multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", (double)this.attackSpeed, AttributeModifier.Operation.ADDITION));


            AttributeModifier mod = new AttributeModifier("DragonMod",5, AttributeModifier.Operation.ADDITION);

            String modstring =mod.toString();

            StringBuilder def = new StringBuilder();

            System.out.println(def.append("operation=").append(",").toString());






        }






        return multimap;
    }

    public IItemTier getTier() {
        return tier;
    }

    public double getAttackDamage() {
        return attackDamage;
    }

    public double getAttackSpeed() {
        return attackSpeed;
    }
}
