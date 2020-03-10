package com.dungeoncraftteam.dungeoncraft.common.item;

import net.minecraft.item.IItemTier;

public class MeleeWeaponBase extends ItemBase {


    private IItemTier tier;
    private double attackDamage;
    private double attackSpeed;

    public MeleeWeaponBase(String name, IItemTier tier, double baseAttackDamage, double attackSpeed, int baseDurability, Properties properties) {
        super(name, properties.maxDamage((tier.getMaxUses()+baseDurability)));
        this.tier = tier;

        attackDamage=baseAttackDamage+tier.getAttackDamage();
        this.attackSpeed=attackSpeed;






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
