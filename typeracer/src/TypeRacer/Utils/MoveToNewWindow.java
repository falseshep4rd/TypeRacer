package TypeRacer.Utils;

import TypeRacer.FXControllers.SaveScoreController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public final class MoveToNewWindow {
    public static void moveToNewWindow(String path, Button button) throws IOException {
        FXMLLoader loader = new FXMLLoader(MoveToNewWindow.class.getResource(path));
        Parent root = loader.load();
        Stage stage = (Stage) button.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void moveToNewWindow(String path, Button button, int score) throws IOException {
        FXMLLoader loader = new FXMLLoader(MoveToNewWindow.class.getResource(path));
        Parent root = loader.load();

        SaveScoreController saveScore = loader.getController();
        saveScore.setScore(score);

        Stage stage = (Stage) button.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
