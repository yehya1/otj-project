package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Hotel {
    private int numOfUsedRooms;
    private List<List<Room>> allRooms;
    private int[] roomAvilebleCount ;
    Hotel(int numFloor ,int[] room){
        numOfUsedRooms = 0;
        allRooms = new ArrayList<>();
        roomAvilebleCount = room;
        Random rand = new Random();

        for(int i=0;i< numFloor && i < 10 ; i++){
            ArrayList<Room> floorRoom = new ArrayList<Room>();
            for(int j = 0 ; j < room[i] && j<100;j++){
                floorRoom.add(new Room(rand.nextInt(4)+1));
            }
            allRooms.add(floorRoom);
        }
    }
    public int checkInGuest(List<Guest> guests){
        for(int i=0;i<allRooms.size();i++) {
            for (int j = 0; j < allRooms.get(i).size(); j++) {
                if(guests.size() <= allRooms.get(i).get(j).getNumOfBeds() && allRooms.get(i).get(j).getAvailable()){
                    allRooms.get(i).get(j).setAllGuests(guests);
                    numOfUsedRooms++;
                    roomAvilebleCount[i]--;
                    return Integer.parseInt(i+""+j);
                }
            }
        }
        return -1;
    }
    public int foundGuestbypassport(int passport){
        List<Guest> g;
        for(int i=0;i<allRooms.size();i++) {
            for (int j = 0; j < allRooms.get(i).size(); j++) {
                g = allRooms.get(i).get(j).getAllGuests();
                for(int v = 0 ;  g != null && v < g.size()  ; v++){
                    if(passport == g.get(v).getPassportnumber()){
                        return Integer.parseInt(i+""+j);
                    }
                }
            }
        }
        return -1;
    }
    public String getAllGuest(){
        String guestList = "";
        for(int i=0;i<allRooms.size();i++){
            for(int j =0 ; j<allRooms.get(i).size();j++){
                if(!allRooms.get(i).get(j).getAvailable())
                    guestList = guestList + allRooms.get(i).get(j).getAllGuestString();
            }
        }

        return guestList;
    }
    public int maxAvilebleRoomFloor(){
        int max=0;
        for(int i =0 ; i<roomAvilebleCount.length-1 ;i++){
            if(roomAvilebleCount[i]<roomAvilebleCount[i+1]){
                max = i ;
            }
        }
        return max;

    }


}
