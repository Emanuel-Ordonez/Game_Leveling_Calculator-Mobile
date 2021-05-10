package com.example.cs481projectapp.cogfacilities;

import java.util.ArrayList;

public abstract class CogFacility {

    protected CogType facilityType;
    public abstract String calculateStats(int totalObtained, int totalNeeded);
    public abstract String printStats(ArrayList<Integer> nums);
    public void setFacilityType(CogType facilityType) {
        this.facilityType = facilityType;
    }
    public CogType getFacilityType() {
        return facilityType;
    }
}
