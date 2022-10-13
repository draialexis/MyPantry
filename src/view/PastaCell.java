package view;

import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.BorderPane;
import viewmodel.PastaVM;

public class PastaCell extends ListCell<PastaVM> {

    private final BorderPane pane = new BorderPane();
    private final Label avgWeithtPerLbl = new Label();
    private final Label typeLbl = new Label();

    @Override
    protected void updateItem(PastaVM item, boolean empty) {
        super.updateItem(item, empty);

        if (!empty) {

            switch (item.getClass().getSimpleName()) {
                case "PastaVM" -> typeLbl.setText("pasta");
                case "FarfalleVM" -> typeLbl.setText("farfalle");
                case "PenneVM" -> typeLbl.setText("penne");
                default -> typeLbl.setText("unknown");
            }

            avgWeithtPerLbl.textProperty().bind(item.avgWeightPerProperty().asString());

            pane.setLeft(typeLbl);
            pane.setRight(avgWeithtPerLbl);
            setGraphic(pane);
        }
        else {
            setGraphic(null);
        }
    }
}
