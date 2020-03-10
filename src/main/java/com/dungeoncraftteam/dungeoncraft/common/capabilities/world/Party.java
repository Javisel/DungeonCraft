package com.dungeoncraftteam.dungeoncraft.common.capabilities.world;

import com.ibm.icu.text.UTF16;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.UUID;

public class Party {

    public ArrayList<PlayerEntity> getMembers() {
        return members;
    }

    private ArrayList<PlayerEntity> members;

    public Party(ArrayList<PlayerEntity> members) {
        this.members = members;
    }


    public CompoundNBT toNBT() {

        CompoundNBT players = new CompoundNBT();

        int i = 0;
        for (PlayerEntity playerEntity : members) {

            players.putUniqueId("player_" +i,  playerEntity.getUniqueID()    );
            i++;




        }



        return  players;

    }

    public void fromNBT(CompoundNBT nbt, World world) {

        members.clear();

        int i = 0;
        boolean cont = true;

        while (cont) {

            if (nbt.contains("player_" +i)) {

                members.add(world.getPlayerByUuid(nbt.getUniqueId("player_"+i)));
            } else {
                cont=false;
            }


        }






    }




    public PlayerEntity getPlayerByUUID(UUID id) {

        for (PlayerEntity playerEntity : members) {


            if (playerEntity.getUniqueID() == id) {

                return  playerEntity;
            }
        }


        return  null;
    }



}
