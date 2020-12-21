module typeracer {
    requires javafx.fxml;
    requires javafx.controls;

    opens TypeRacer.FXControllers;
    opens TypeRacer.FXML;
    opens TypeRacer;
}