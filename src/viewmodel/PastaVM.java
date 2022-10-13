package viewmodel;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import model.Pasta;

public class PastaVM {
    private final Pasta model;

    private final DoubleProperty avgWeightPer = new SimpleDoubleProperty();
    public double getAvgWeightPer() {return avgWeightPer.get();}
    public DoubleProperty avgWeightPerProperty() {return avgWeightPer;}
    public void setAvgWeightPer(double avgWeightPer) {this.avgWeightPer.set(avgWeightPer);}

    public PastaVM(Pasta p) {
        // loads model
        model = p;
        setAvgWeightPer(p.getAvgWeightPer());

        // subscribes to model
//        model.addListener(this);

        // promises to update model
        avgWeightPer.addListener((__, ___, newV) -> model.setAvgWeightPer(newV.doubleValue()));
    }

    public PastaVM(double avgWeightPer) {
        this(new Pasta(avgWeightPer));
    }

    public PastaVM() {
        this(0.0);
    }

    public Pasta getModel() {
        return model;
    }
}
