package launcher;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import view.MainWindow;
import viewmodel.PantryVM;

import java.io.IOException;

public class Launcher extends Application {

    private final PantryVM viewmodel = new PantryVM();

    public Launcher() throws ClassNotFoundException {}

    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("/fxml/MainWindow.fxml"));
        fxmlloader.setController(new MainWindow(viewmodel));

        Parent root = fxmlloader.load();
        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {

        try {
            viewmodel.save();
        } catch (IOException ex) {
            new Alert(Alert.AlertType.ERROR, "could not save : " + ex.getMessage(), ButtonType.OK).setHeaderText(null);
        }

        super.stop();
    }
}
