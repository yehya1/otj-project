package com.company;

import java.util.List;

public class Room {


    private int numOfBeds;
    private List<Guest> allGuests;
    private boolean Available;

    Room(int numOfBeds){
        this.numOfBeds = numOfBeds;
        Available = true;
    }

    public void setAllGuests(List<Guest> allGuests) {
        this.allGuests = allGuests;
        Available = false;
    }

    public boolean getAvailable() {
        return Available;
    }

    public int getNumOfBeds() {
        return numOfBeds;
    }
    public String getAllGuestString(){
        String s="";
        for(int i=0;i<allGuests.size();i++){
            s=s+"\nname :"+allGuests.get(i).getName()+"\npassport number :"+allGuests.get(i).getPassportnumber();
        }
        return s;
    }
    public List<Guest> getAllGuests() {
        return allGuests;
    }
}
