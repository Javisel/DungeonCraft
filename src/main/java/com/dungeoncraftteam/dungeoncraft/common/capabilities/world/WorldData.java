package com.dungeoncraftteam.dungeoncraft.common.capabilities.world;

import com.dungeoncraftteam.dungeoncraft.DungeonCraft;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.IWorld;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.storage.DimensionSavedDataManager;
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

    public static final String PARTIES = "parties";
    @Override
    public void read(CompoundNBT nbt) {




        parties.clear();
        CompoundNBT partytag = nbt.getCompound(PARTIES);
        boolean cancont  =true;

        int i =0;
        while (cancont) {

            if (partytag.contains("party_"+i)) {
                parties.add(Party.fromNBT(partytag.getCompound("party_"+i)));



            }


        }




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

        dungeoncraftWorld.put(PARTIES,partytag);



        return dungeoncraftWorld;
    }


    public static WorldData get(IWorld world)
    {
        if (!(world instanceof ServerWorld))
        {
            return new WorldData();
        }

        ServerWorld overworld = ((ServerWorld)world).getServer().getWorld(DimensionType.OVERWORLD);
        DimensionSavedDataManager storage = overworld.getSavedData();
        return storage.getOrCreate(WorldData::new, DungeonCraft.MODID+":worlddata");
    }


}
