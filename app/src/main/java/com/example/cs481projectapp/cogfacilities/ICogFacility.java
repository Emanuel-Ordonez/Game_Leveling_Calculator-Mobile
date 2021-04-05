package com.example.cs481projectapp.cogfacilities;

import java.util.ArrayList;

public interface ICogFacility {
    abstract String calculateStats(int totalObtained, int totalNeeded);
    abstract String printStats(ArrayList<Integer> nums);
}
