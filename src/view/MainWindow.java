package view;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.util.converter.NumberStringConverter;
import model.Pasta;
import viewmodel.PantryVM;
import viewmodel.PastaVM;

public class MainWindow {
    private final PantryVM viewmodel;

    @FXML
    private ListView<PastaVM> pantryLV;

    @FXML
    private TextField avgWeightTF;

    @FXML
    private void clickAddPasta() {
        viewmodel.addPasta(new PastaVM(new Pasta()));
    }

    @FXML
    private void clickRemovePasta() {
        viewmodel.removePasta(pantryLV.getSelectionModel().getSelectedItem());
    }

    public MainWindow(PantryVM viewmodel) {
        this.viewmodel = viewmodel;
    }

    @FXML
    private void initialize() {
        pantryLV.itemsProperty().bind(viewmodel.pastaProperty());
        pantryLV.setCellFactory((__) -> new PastaCell());

        pantryLV.getSelectionModel().selectedItemProperty().addListener((__, oldV, newV) -> {
            if (oldV != null) {
                avgWeightTF.textProperty().unbindBidirectional(oldV.avgWeightPerProperty());
            }
            if (newV != null) {
                avgWeightTF.textProperty().bindBidirectional(newV.avgWeightPerProperty(), new NumberStringConverter());
            }
        });
    }
}
