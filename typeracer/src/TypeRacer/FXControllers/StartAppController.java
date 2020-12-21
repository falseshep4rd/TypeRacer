package TypeRacer.FXControllers;

import TypeRacer.Utils.Alerts;
import TypeRacer.Utils.MoveToNewWindow;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StartAppController implements Initializable {

    public Button playBtn;
    public Button lbBtn;
    public Button exitBtn;
    public MenuItem infoMenu;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    @FXML
    private void loadPlayWindow() throws Exception {
        MoveToNewWindow.moveToNewWindow("/TypeRacer/FXML/Play.fxml", playBtn);
    }

    public void leaderboards() throws IOException {
        MoveToNewWindow.moveToNewWindow("/TypeRacer/FXML/Leaderboards.fxml", lbBtn);
    }

    public void exit() {
        Alerts.alert(Alert.AlertType.CONFIRMATION, "TypeRacer", "Closing game", "Are you sure?", true);
    }

    public void alertInfo() {
        Alerts.alert(Alert.AlertType.INFORMATION, "TypeRacer", "Information",
                "The timer starts when you type your first letter\n\n"
                        + "Press Play to play the game, and Leaderboards to see leaderboards\n\n"
                        + "You can save your score to leaderboards if you press save button\n\n"
                        + "Press OK to begin");
    }
}
