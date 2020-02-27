package com.dungeoncraftteam.dungeoncraft.common.item;

import com.dungeoncraftteam.dungeoncraft.common.combatengine.EnumDamageSubType;
import com.dungeoncraftteam.dungeoncraft.common.combatengine.SubtypeModifier;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemTier;

import javax.annotation.Nullable;
import java.util.HashMap;

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
