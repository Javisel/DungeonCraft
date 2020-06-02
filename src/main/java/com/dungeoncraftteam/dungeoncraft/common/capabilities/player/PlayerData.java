package com.dungeoncraftteam.dungeoncraft.common.capabilities.player;

import com.dungeoncraftteam.dungeoncraft.common.action.AbstractAction;
import net.minecraft.nbt.CompoundNBT;

import java.util.ArrayList;
import java.util.HashMap;

public class PlayerData implements IPlayerData {




    ArrayList<AbstractAction> actionBar  = new ArrayList<>(4);

    HashMap<AbstractAction,CompoundNBT> actionDataMap = new HashMap<>();





    @Override
    public ArrayList<AbstractAction> getActionBar() {
        return actionBar;
    }


    @Override
    public CompoundNBT writeNBT() {



        return new CompoundNBT();
    }

    @Override
    public void readNBT(CompoundNBT nbt) {

    }
}
