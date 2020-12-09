package shirley.s.kitchen.View;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import shirley.s.kitchen.getWndws.getWindow;

public class Load extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/shirley/s/kitchen/View/Dashboard.fxml"));
        Scene scn = getWindow.getScene(root);
        primaryStage.setTitle("Dashboard");
        new getWindow().getStageIcon(primaryStage);
        primaryStage.setScene(scn);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
