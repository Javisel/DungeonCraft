package com.dungeoncraftteam.dungeoncraft.common.capabilities.world;

import com.dungeoncraftteam.dungeoncraft.DungeonCraft;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.storage.WorldSavedData;

import java.util.ArrayList;

public class WorldData extends WorldSavedData {


    public ArrayList<Party> getParties() {
        return parties;
    }

    private ArrayList<Party> parties = new ArrayList<>();

    public WorldData() {
        super(DungeonCraft.MODID + ":worlddata");
    }

    /**
     * reads in data from the NBTTagCompound into this MapDataBase
     *
     * @param nbt
     */
    @Override
    public void read(CompoundNBT nbt) {



    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {

        CompoundNBT dungeoncraftWorld = new CompoundNBT();

        CompoundNBT partytag = new CompoundNBT();

        if (!parties.isEmpty()) {


            for (int i=0; i < this.parties.size();i++) {

                partytag.put("party_"+i, parties.get(i).toNBT() );





            }


        }





        return null;
    }
}
