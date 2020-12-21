package TypeRacer;

import TypeRacer.Players.Champion;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StartApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXML/StartApp.fxml"));
        primaryStage.setTitle("TypeRacer");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        Champion champion = new Champion();
        Champion champion1 = new Champion();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
