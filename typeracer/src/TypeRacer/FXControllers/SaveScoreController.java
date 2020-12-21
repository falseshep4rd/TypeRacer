package TypeRacer.FXControllers;

import TypeRacer.DataRW.DataRW;
import TypeRacer.Utils.Alerts;
import TypeRacer.Utils.MoveToNewWindow;
import TypeRacer.Players.Champion;
import TypeRacer.Players.ChampionList;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class SaveScoreController {
    public Button saveBtn;
    public TextField nameText;
    public TextField usernameText;
    public TextField descriptionText;
    public Button backBtn;
    int score;

    public void setScore(int score) {
        this.score = score;
    }

    public void saveToFile() {
        ChampionList championList = DataRW.loadLeaderboards();
        championList.getChampionArrayList().add(new Champion(nameText.getText(), usernameText.getText(), descriptionText.getText(), score));
        DataRW.writeIntoFile(championList);
        alertSaved();
    }

    public void mainMenu() throws IOException {
        MoveToNewWindow.moveToNewWindow("/TypeRacer/FXML/StartApp.fxml", backBtn);
    }

    public void alertSaved() {
        Alerts.alert(Alert.AlertType.INFORMATION, "TypeRacer", "Information", "Game has been recorded");
    }
}
