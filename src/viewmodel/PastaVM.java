package viewmodel;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import model.Pasta;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PastaVM implements PropertyChangeListener {
    private final Pasta model;

    private final DoubleProperty avgWeightPer = new SimpleDoubleProperty();
    public double getAvgWeightPer() {return avgWeightPer.get();}
    public DoubleProperty avgWeightPerProperty() {return avgWeightPer;}
    public void setAvgWeightPer(double avgWeightPer) {this.avgWeightPer.set(avgWeightPer);}

    public PastaVM(Object obj) {
        // loads model
        if(obj instanceof Pasta) {
            model = (Pasta) obj;
        } else {
            model = new Pasta();
        }
        setAvgWeightPer(model.getAvgWeightPer());

        // subscribes to model
        model.addListener(this);

        // promises to update model
        avgWeightPer.addListener((__, ___, newV) -> model.setAvgWeightPer(newV.doubleValue()));
    }

    public PastaVM() {
        this(null);
    }

    public Pasta getModel() {
        return model;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getPropertyName().equals(Pasta.PROP_PASTA_AVGWEIGHTPER)) {
            setAvgWeightPer((Double) evt.getNewValue());
        }
    }
}
