package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pantry implements Serializable {

    public static final String PROP_PANTRY_ADD = "model.pantry.addPasta";
    public static final String PROP_PANTRY_RMV = "model.pantry.removePasta";

    private transient PropertyChangeSupport support;

    private PropertyChangeSupport getSupport() {
        if (support == null) {
            support = new PropertyChangeSupport(this);
        }
        return support;
    }

    private final List<Pasta> pasta;

    public Pantry(List<Pasta> pasta) {
        this.pasta = pasta != null ? pasta : new ArrayList<>();
    }

    public Pantry() {
        this(null);
    }

    /**
     * @return an UNMODIFIABLE LIST of pasta
     */
    public List<Pasta> getPasta() {
        return Collections.unmodifiableList(pasta);
    }

    public void addPasta(Pasta toAdd) {
        if (toAdd == null) {
            System.err.println("cannot add null to Pantry.pasta");
        }
        else {
            int index = 0;
            this.pasta.add(index, toAdd);
            getSupport().fireIndexedPropertyChange(PROP_PANTRY_ADD,
                                                   index,
                                                   getPasta().size() > index + 1 ? getPasta().get(index + 1) : null,
                                                   toAdd);
        }
    }

    public void removePasta(Pasta toRemove) {
        if (toRemove == null) {
            System.err.println("cannot remove null from Pantry.pasta");
        }
        else {
            int index = getPasta().indexOf(toRemove);
            if (index >= 0) {
                this.pasta.remove(toRemove);
                getSupport().fireIndexedPropertyChange(PROP_PANTRY_RMV,
                                                       index,
                                                       toRemove,
                                                       getPasta().size() >= index + 1 ? getPasta().get(index) : null);
            }
        }
    }

    public void addListener(PropertyChangeListener listener) {
        getSupport().addPropertyChangeListener(listener);
    }
}
