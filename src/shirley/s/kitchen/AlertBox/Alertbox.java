package shirley.s.kitchen.AlertBox;

import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class Alertbox {

    public static void showSimpleMsg(String Htext, String Ctext) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(Htext);
        alert.setContentText(Ctext);
        alert.showAndWait();
    }

    public static void showErrorMag(String Htext, String Ctext) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(Htext);
        alert.setContentText(Ctext);
        alert.showAndWait();
    }
    
    public static Optional<ButtonType> showConfaMag(String Htext, String Ctext) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(Htext);
        alert.setTitle("Confirmation alert");
        alert.setContentText(Ctext);
        return alert.showAndWait();
    }
}
