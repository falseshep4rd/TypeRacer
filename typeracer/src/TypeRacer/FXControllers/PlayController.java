package TypeRacer.FXControllers;

import TypeRacer.DataRW.DataRW;
import TypeRacer.Utils.MoveToNewWindow;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.time.LocalTime;
import java.util.*;

public class PlayController implements Initializable {

    public TextField inputText;
    public TextArea text;
    public TextArea outputText;
    public Button saveBtn;
    public Button backBtn;

    double start;
    int flag = 0;
    int chars = 0;
    int i = 0;
    int score = 0;
    int level = 10;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        text.setEditable(false);
        outputText.setEditable(false);
        populateText();
    }

    public void populateText() {
        Random random = new Random();
        text.setText(Objects.requireNonNull(DataRW.loadFromFile())[random.nextInt(Objects.requireNonNull(DataRW.loadFromFile()).length)]);
    }

    public void keyTyped() {
        if (flag == 0) {
            start = LocalTime.now().toNanoOfDay();
            flag = 1;
        }
        if (inputText.getText().length() == text.getText().length()) {
            if (inputText.getText().equals(text.getText())) {
                i++;
                chars += inputText.getText().length();
                outputText.setText("Correct\n" + i + "/" + level);
                outputText.setStyle("-fx-text-inner-color: green;");
                inputText.clear();
                if (i == level) {
                    double end = LocalTime.now().toNanoOfDay();
                    double seconds = (end - start) / 1000000000.0;
                    score = calculateWPM(chars, seconds);
                    outputText.setStyle("-fx-text-inner-color: blue;");
                    outputText.setText(score + " words per minute!");
                    inputText.setEditable(false);
                }
                populateText();
            } else {
                outputText.setText("Incorrect");
                outputText.setStyle("-fx-text-inner-color: red;");
            }
        }
    }

    public int calculateWPM(int numChars, double seconds) {
        return (int) ((((double) numChars / 5) / seconds) * 60);
    }

    public void saveScore() throws IOException {
        if (score > 0) {
            MoveToNewWindow.moveToNewWindow("/TypeRacer/FXML/SaveScore.fxml", saveBtn, score);
        }
    }

    public void mainMenu() throws IOException {
        MoveToNewWindow.moveToNewWindow("/TypeRacer/FXML/StartApp.fxml", backBtn);
    }
}

