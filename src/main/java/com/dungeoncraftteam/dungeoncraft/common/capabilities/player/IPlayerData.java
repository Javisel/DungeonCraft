package com.dungeoncraftteam.dungeoncraft.common.capabilities.player;

import com.dungeoncraftteam.dungeoncraft.common.capabilities.world.Party;
import net.minecraft.nbt.CompoundNBT;

public interface IPlayerData {


     CompoundNBT writeNBT();
     void readNBT(CompoundNBT nbt);





}
