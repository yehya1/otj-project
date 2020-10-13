package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Hotel h =new Hotel(20, new int[]{10,100,10,10,10,10,10,10,10,10,10,10});
        int Selection;
        do{
            System.out.println("for checkIn click 1.");
            System.out.println("for found person py passport click 2.");
            System.out.println("for show person in hotel click 3.");
            System.out.println("for max floor room avilible click 4");
            System.out.println("for exit click 5.");
            Selection = input.nextInt();
            if(Selection == 1){
                List<Guest> g =new ArrayList<Guest>();
                System.out.println("pleas enter name and passport number for back enter 1:");
                while (true){
                    System.out.println("enter name:");
                    String name = input.next();
                    System.out.println("enter passport:");
                    int passport = Integer.parseInt(input.next());
                    if(name =="1"||passport==1)
                        break;
                    g.add(new Guest(name,passport));
                }
                int num = h.checkInGuest(g);
                if(num != -1)
                    System.out.println("room number is:"+num);
                else
                    System.out.println("no room????");

            }
            if(Selection==2){
                System.out.println("enter passport:");
                int passport = input.nextInt();
                int num = h.foundGuestbypassport(passport);
                if(num!=-1)
                    System.out.println("room number :"+num );
                else
                    System.out.println("not exist/??");
            }
            if(Selection==3)
                System.out.println(h.getAllGuest());
            if(Selection==4){
                System.out.println("max floor room avilible is "+h.maxAvilebleRoomFloor());
            }
            if(Selection==5)
                break;

        }while (true);

	// write your code here
    }
}
