package com.dungeoncraftteam.dungeoncraft.common.capabilities.player;

import com.dungeoncraftteam.dungeoncraft.common.action.AbstractAction;
import net.minecraft.nbt.CompoundNBT;

import java.util.ArrayList;

public interface IPlayerData {


     ArrayList<AbstractAction> getActionBar();

     CompoundNBT writeNBT();
     void readNBT(CompoundNBT nbt);





}
