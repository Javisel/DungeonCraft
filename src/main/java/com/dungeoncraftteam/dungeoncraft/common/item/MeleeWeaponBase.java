package com.dungeoncraftteam.dungeoncraft.common.item;

import com.dungeoncraftteam.dungeoncraft.common.combatengine.EnumDamageSubType;
import com.dungeoncraftteam.dungeoncraft.common.combatengine.SubtypeModifier;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemTier;

import javax.annotation.Nullable;
import java.util.HashMap;

public class MeleeWeaponBase extends ItemBase {


    private ItemTier tier;
    private double attackDamage;
    private double attackSpeed;

    public MeleeWeaponBase(String name, IItemTier tier, double baseAttackDamage, double attackSpeed, int baseDurability, Properties properties, ItemTier tier1) {
        super(name, properties.maxDamage((tier1.getMaxUses()+baseDurability)));
        this.tier = tier1;

        attackDamage=baseAttackDamage+tier.getAttackDamage();
        this.attackSpeed=attackSpeed;






    }






    public ItemTier getTier() {
        return tier;
    }

    public double getAttackDamage() {
        return attackDamage;
    }

    public double getAttackSpeed() {
        return attackSpeed;
    }
}
