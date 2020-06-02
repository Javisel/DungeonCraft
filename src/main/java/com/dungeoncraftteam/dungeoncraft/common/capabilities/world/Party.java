package com.dungeoncraftteam.dungeoncraft.common.capabilities.world;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;

import java.util.ArrayList;
import java.util.UUID;

public class Party {

    public ArrayList<UUID> getMembers() {
        return members;
    }

    private ArrayList<UUID> members;

    public Party(ArrayList<UUID> members) {
        this.members = members;
    }


    public CompoundNBT toNBT() {

        CompoundNBT players = new CompoundNBT();

        int i = 0;
        for (UUID UUID : members) {

            players.putUniqueId("player_" +i,  UUID   );
            i++;




        }



        return  players;

    }

    public static Party fromNBT(CompoundNBT nbt) {


        ArrayList<UUID> partymembers = new ArrayList<>();

        int i = 0;
        boolean cont = true;

        while (cont) {

            if (nbt.contains("player_" +i)) {

                partymembers.add(nbt.getUniqueId("player_"+i));
            } else {
                cont=false;
            }


        }


        return new Party(partymembers);


    }




    public UUID getPlayerByUUID(PlayerEntity entity) {

        for (UUID uuid : members) {


            if (entity.getUniqueID() == uuid) {

                return  uuid;
            }
        }


        return  null;
    }



}
