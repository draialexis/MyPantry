package model;

import java.io.Serializable;

public class Pasta implements Serializable {

    /**
     * in grams
     */
    private double AvgWeightPer;

    public Pasta(double avgWeightPer) {
        AvgWeightPer = avgWeightPer;
    }

    public double getAvgWeightPer() {
        return AvgWeightPer;
    }

    public void setAvgWeightPer(double avgWeightPer) {
        AvgWeightPer = avgWeightPer;
    }
}
