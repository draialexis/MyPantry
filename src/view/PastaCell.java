package view;

import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.BorderPane;
import viewmodel.PastaVM;

public class PastaCell extends ListCell<PastaVM> {

    private final BorderPane bp = new BorderPane();
    private final Label avgWeithtPer = new Label();
    private final Label type = new Label();

    @Override
    protected void updateItem(PastaVM item, boolean empty) {
        super.updateItem(item, empty);

        if (!empty) {

            switch (item.getClass().getSimpleName()) {
                case "PastaVM" -> type.setText("pasta");
                case "FarfalleVM" -> type.setText("farfalle");
                case "PenneVM" -> type.setText("penne");
                default -> type.setText("unknown");
            }

            avgWeithtPer.textProperty().bind(item.avgWeightPerProperty().asString());

            bp.setLeft(type);
            bp.setRight(avgWeithtPer);
            setGraphic(bp);
        }
        else {
            setGraphic(null);
        }
    }
}
