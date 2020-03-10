package com.dungeoncraftteam.dungeoncraft.common.capabilities.player;

import com.dungeoncraftteam.dungeoncraft.common.capabilities.world.Party;
import net.minecraft.nbt.CompoundNBT;
import org.lwjgl.system.CallbackI;

public class PartyData implements IPlayerData {


    Party party;

    @Override
    public Party getPlayerParty() {
        return party;
    }

    @Override
    public void joinParty(Party party) {

        if (party!=null) {

            System.err.println("Already a part of a Party!");
            this.party=party;
        }

    }

    @Override
    public CompoundNBT writeNBT() {
        return null;
    }

    @Override
    public void readNBT(CompoundNBT nbt) {

    }
}
