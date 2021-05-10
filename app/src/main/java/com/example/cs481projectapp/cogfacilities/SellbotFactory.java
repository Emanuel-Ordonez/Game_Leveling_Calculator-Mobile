package com.example.cs481projectapp.cogfacilities;

import java.util.ArrayList;

public class SellbotFactory implements ICogFacility {
    public String calculateStats(int totalObtained, int totalNeeded) {

        ArrayList<Integer> factories = new ArrayList<Integer>();
        int x = 0, y = 0; //temporary variables
        int total = totalNeeded - totalObtained;

        //CALCULATE LONGS NEEDED
        if(total >= 776){
            x = total / 776; //longs needed
            total = total % 776; //extra merits
        }

        //CALCULATE SHORTS NEEDED
        if(480 >= total && total > 0){
            y = total / 480; //shorts needed
            y++;
        }

        factories.add(x); //number of longs added
        factories.add(y); //number of shorts added
        return this.printStats(factories);
    }

    public String printStats(ArrayList<Integer> nums){
        //TEST?
        //System.out.print("You need :\n\t" + nums.get(0) + " long(s), and \n\t");
        //System.out.println(nums.get(1) + " short(s).");
        String x;
        x="You need :\n  " + nums.get(0) + " long(s), and \n  ";
        x+=nums.get(1) + " short(s).";
        return x;
    }
}

        /*
    TYPE    MERITS EARNED
    Short   480
    Long    776
     */
