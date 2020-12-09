package shirley.s.kitchen.getWndws;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class getWindow {

    private static getWindow window;

    //Locations
    private static final String icon_loc = "/shirley/assects/icons8-online-store-96.png";
    private static final String addcusloca = "/shirley/s/kitchen/View/AddCustomer.fxml";
    private static final String rmvcusloca = "/shirley/s/kitchen/View/RemoveCustomer.fxml";
    private static final String uptcusloca = "/shirley/s/kitchen/View/Updatecustomer.fxml";
    private static final String viewcusloca = "/shirley/s/kitchen/View/ViewCustomers.fxml";
    private static final String viewstoloca = "/shirley/s/kitchen/View/ViewStore.fxml";
    private static final String viewstoOrdersloc = "/shirley/s/kitchen/View/ViewOrders.fxml";
    private static final String updfoodsloc = "/shirley/s/kitchen/View/UpdateFood.fxml";
    private static final String Addfoodtostoreloc = "/shirley/s/kitchen/View/AddFood.fxml";
    private static final String deletefoodloc = "/shirley/s/kitchen/View/DeleteFoods.fxml";

    public getWindow() {
    }

    public static getWindow getInstance() {
        if (window == null) {
            window = new getWindow();
        }
        return window;
    }

    public enum WindowType {
        Addcus, RemCus, UpdCUs, ViewCUs, ViewStore, ViewOrders, 
        UptFoods, Addfoodtostore, deletefood;
    }

    public static Scene getScene(Parent root) {
        Scene scn = new Scene(root);
        return scn;
    }

    public static Stage getStage() {
        return new Stage();
    }

    public static void getStageIcon(Stage stage) {
        stage.getIcons().add(new Image(icon_loc));
    }

    public Parent getparent() throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource(addcusloca));
        return parent;
    }

    public Parent getParent(WindowType type) throws IOException {
        switch (type) {
            case Addcus:
                return FXMLLoader.load(getClass().getResource(addcusloca));
            case RemCus:
                return FXMLLoader.load(getClass().getResource(rmvcusloca));
            case UpdCUs:
                return FXMLLoader.load(getClass().getResource(uptcusloca));
            case ViewCUs:
                return FXMLLoader.load(getClass().getResource(viewcusloca));
            case ViewStore:
                return FXMLLoader.load(getClass().getResource(viewstoloca));
            case ViewOrders:
                return FXMLLoader.load(getClass().getResource(viewstoOrdersloc));
            case UptFoods:
                return FXMLLoader.load(getClass().getResource(updfoodsloc));
            case Addfoodtostore:
                return FXMLLoader.load(getClass().getResource(Addfoodtostoreloc));
            case deletefood:
                return FXMLLoader.load(getClass().getResource(deletefoodloc));
            default:
                return null;
        }
    }

}
