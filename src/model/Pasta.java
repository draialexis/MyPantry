package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;

public class Pasta implements Serializable {

    public static final String PROP_PASTA_AVGWEIGHTPER = "";
    /**
     * in grams
     */
    private double AvgWeightPer;

    private transient PropertyChangeSupport support;

    private PropertyChangeSupport getSupport() {
        if (support == null) {
            support = new PropertyChangeSupport(this);
        }
        return support;
    }

    public Pasta(double avgWeightPer) {
        AvgWeightPer = avgWeightPer;
    }

    public Pasta() {
        this(0.0);
    }

    public double getAvgWeightPer() {
        return AvgWeightPer;
    }

    public void setAvgWeightPer(double avgWeightPer) {
        AvgWeightPer = avgWeightPer;
    }

    public void addListener(PropertyChangeListener listener) {
        getSupport().addPropertyChangeListener(listener);
    }

}
