package com.dungeoncraftteam.dungeoncraft.common.item;

import com.dungeoncraftteam.dungeoncraft.common.DCUtilities;
import com.dungeoncraftteam.dungeoncraft.common.attributes.attributesystem.DungeoncraftAttributes;
import com.google.common.collect.Multimap;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.apache.commons.lang3.StringUtils;

import java.util.UUID;

public class TestingStick extends ItemBase {


    public TestingStick() {
        super("testing_stick",new Item.Properties());
    }


    /**
     * Called to trigger the item's "innate" right click behavior. To handle when this item is used on a Block, see
     * {@link #onItemUse}.
     *
     * @param worldIn
     * @param playerIn
     * @param handIn
     */
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {

        if (!worldIn.isRemote) {

            if (playerIn.isSneaking()) {

                DCUtilities.removeAllModifiers(playerIn, DungeoncraftAttributes.STRENGTH);
                System.out.println(playerIn.getDisplayName().getString() + "'s Strength: " + DCUtilities.getEntityData(playerIn).getStatMap().getAttributeInstance(DungeoncraftAttributes.STRENGTH).getValue());
                System.out.println(playerIn.getDisplayName().getString() + "'s Attack Damage: " + playerIn.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getValue());


            } else {

                System.out.println(playerIn.getDisplayName().getString() + "'s Strength Pre-Buff: " + DCUtilities.getEntityData(playerIn).getStatMap().getAttributeInstance(DungeoncraftAttributes.STRENGTH).getValue());
                System.out.println(playerIn.getDisplayName().getString() + "'s Attack Damage pre-buff: " + playerIn.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getValue());

                DCUtilities.applyEntityModifier(playerIn, DungeoncraftAttributes.STRENGTH, new AttributeModifier(UUID.randomUUID(), "random", 10, AttributeModifier.Operation.ADDITION));
                System.out.println(playerIn.getDisplayName().getString() + "'s Strength Post-Buff: " + DCUtilities.getEntityData(playerIn).getStatMap().getAttributeInstance(DungeoncraftAttributes.STRENGTH).getValue());

                System.out.println(playerIn.getDisplayName().getString() + "'s Attack Damage Post-Buff: " + playerIn.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getValue());


                playerIn.getCooldownTracker().setCooldown(this, 60);


                {

                }
            }
        }
        return super.onItemRightClick(worldIn, playerIn, handIn);

    }
    @Override
    public Multimap<String, AttributeModifier> getAttributeModifiers(EquipmentSlotType slot, ItemStack stack) {
        Multimap<String, AttributeModifier> multimap = super.getAttributeModifiers(slot,stack);
        if (slot == EquipmentSlotType.MAINHAND) {
            multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier",+25, AttributeModifier.Operation.ADDITION));
            multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", -3, AttributeModifier.Operation.ADDITION));


            AttributeModifier mod = new AttributeModifier("DragonMod",5, AttributeModifier.Operation.ADDITION);

            String modstring =mod.toString();

            System.err.println(modstring);

          System.out.println("Operation: " +   StringUtils.substringBetween(modstring,"operation=",","));







        }






        return multimap;
    }
}
