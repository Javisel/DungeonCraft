package com.dungeoncraftteam.dungeoncraft.common.capabilities.player;

import com.dungeoncraftteam.dungeoncraft.common.capabilities.world.Party;
import net.minecraft.nbt.CompoundNBT;
import org.lwjgl.system.CallbackI;

public class PlayerData implements IPlayerData {






    @Override
    public CompoundNBT writeNBT() {



        return new CompoundNBT();
    }

    @Override
    public void readNBT(CompoundNBT nbt) {

    }
}
