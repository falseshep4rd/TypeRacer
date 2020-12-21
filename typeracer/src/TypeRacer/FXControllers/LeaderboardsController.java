package TypeRacer.FXControllers;

import TypeRacer.DataRW.DataRW;
import TypeRacer.Utils.MoveToNewWindow;
import TypeRacer.Players.Champion;
import TypeRacer.Players.ChampionList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.net.URL;
import java.util.Comparator;
import java.util.ResourceBundle;

public class LeaderboardsController implements Initializable {
    public Button backBtn;
    public ListView<Champion> leaderboardsListView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        populateLeaderboards();
    }

    public void populateLeaderboards() {
        ChampionList championList = DataRW.loadLeaderboards();
        if (championList != null) {
            championList.getChampionArrayList().sort(Comparator.comparing(Champion::getScore).reversed());
            for (Champion c : championList.getChampionArrayList()) {
                leaderboardsListView.getItems().add(c);
            }
        }
    }

    public void mainMenu() throws IOException {
        MoveToNewWindow.moveToNewWindow("/TypeRacer/FXML/StartApp.fxml", backBtn);
    }

    public void deleteLeaderboard(ActionEvent actionEvent) {
        DataRW.deleteFile("src/Leaderboards.lib");
        leaderboardsListView.getItems().clear();
    }
}
