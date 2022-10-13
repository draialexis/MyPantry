package viewmodel;

import data.Loadable;
import data.Loader;
import data.Saver;
import data.Stub;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ReadOnlyListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Pantry;
import model.Pasta;

import java.beans.IndexedPropertyChangeEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;

public class PantryVM implements PropertyChangeListener {

    private final Pantry model;

    private final ObservableList<PastaVM> pastaObs = FXCollections.observableArrayList();
    private final ListProperty<PastaVM> pasta = new SimpleListProperty<>(pastaObs);
    public ObservableList<PastaVM> getPasta() {return FXCollections.unmodifiableObservableList(pasta.get());}
    public ReadOnlyListProperty<PastaVM> pastaProperty() {return pasta;}

    public PantryVM() throws ClassNotFoundException {
        Pantry tmpModel;
        Loadable loader;
        try {

            loader = Loader.getInstance();
            tmpModel = loader.load();

        } catch (IOException e) {

            loader = new Stub();

            try{

                tmpModel = loader.load();

            } catch (IOException ex) {

                tmpModel = new Pantry();

            }
        }

        // loads from model
        model = tmpModel;
        model.getPasta().forEach(p -> pastaObs.add(new PastaVM(p)));

        // subscribes to model
        model.addListener(this);

        // promises to update model in its methods...
    }

    public void save() throws IOException {
        Saver.getInstance().save(model);
    }

    public void removePasta(PastaVM toRemove) {
        model.removePasta(toRemove.getModel());
    }

    public void addPasta(PastaVM toAdd) {
        model.addPasta(toAdd.getModel());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getPropertyName().equals(Pantry.PROP_PANTRY_ADD)) {
            pastaObs.add(
                    ((IndexedPropertyChangeEvent) evt).getIndex(),
                         new PastaVM((Pasta) evt.getNewValue())
            );
        }
        if(evt.getPropertyName().equals(Pantry.PROP_PANTRY_RMV)) {
            pastaObs.remove(((IndexedPropertyChangeEvent) evt).getIndex());
        }

    }
}
