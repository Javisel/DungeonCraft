package com.dungeoncraftteam.dungeoncraft.common.item;

import com.dungeoncraftteam.dungeoncraft.common.DCUtilities;
import com.dungeoncraftteam.dungeoncraft.common.attributes.attributesystem.DungeoncraftAttributes;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

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


        System.out.println(playerIn.getDisplayName().getString() + "'s Attack Damage: " + playerIn.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getValue());

            DCUtilities.applyEntityModifier(playerIn, DungeoncraftAttributes.STRENGTH, new AttributeModifier(UUID.randomUUID(),"random",10, AttributeModifier.Operation.ADDITION));

        System.out.println(playerIn.getDisplayName().getString() + "'s Attack Damage: " + playerIn.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getValue());





        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
