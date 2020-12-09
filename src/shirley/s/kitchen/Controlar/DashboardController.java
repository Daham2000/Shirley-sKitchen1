package shirley.s.kitchen.Controlar;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import shirley.s.kitchen.AlertBox.Alertbox;
import shirley.s.kitchen.BO.BOFactory;
import shirley.s.kitchen.BO.ItemBO;
import shirley.s.kitchen.BO.OrderBO;
import shirley.s.kitchen.DTO.Cart;
import shirley.s.kitchen.DTO.CustomDTO;
import shirley.s.kitchen.DTO.ItemDTO;
import shirley.s.kitchen.DTO.PaymentDTO;
import shirley.s.kitchen.getWndws.getWindow;

public class DashboardController implements Initializable {

    @FXML
    private MenuItem setFullScreen;
    @FXML
    private AnchorPane root;

    Stage stage;
    Scene scene;

    @FXML
    private ComboBox<String> C_names;
    @FXML
    private ComboBox<String> Food_names;
    @FXML
    private TableColumn<Cart, String> F_name;
    @FXML
    private TableColumn<Cart, Integer> Qty;
    @FXML
    private TableColumn<Cart, Double> I_total;

    ObservableList<Cart> tableCart = FXCollections.observableArrayList();
    ObservableList<Cart> tableQueue = FXCollections.observableArrayList();

    @FXML
    private TableView<Cart> Table;
    @FXML
    private TextField Q;
    @FXML
    private ComboBox<Integer> Pnum;
    @FXML
    private TableView<Cart> Queue;
    @FXML
    private TableColumn<Cart, Integer> Cnumber;
    @FXML
    private TableColumn<Cart, Double> OrderTotal;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        F_name.setCellValueFactory(new PropertyValueFactory<>("F_name"));
        Qty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        I_total.setCellValueFactory(new PropertyValueFactory<>("I_total"));
        Cnumber.setCellValueFactory(new PropertyValueFactory<>("num"));
        OrderTotal.setCellValueFactory(new PropertyValueFactory<>("Total"));
        try {
            loadAllCnames();
            loadallIName();
            loadAllPnumbers();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    OrderBO O = (OrderBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.ORDER);
    ItemBO I = (ItemBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.ITEM);

    @FXML
    private void setFullScrn(ActionEvent event) {
        setStage();
        if (!stage.isFullScreen()) {
            stage.setFullScreen(true);
        }
    }

    @FXML
    private void AddCustomerNow(ActionEvent event) throws IOException {
        Parent root = getWindow.getInstance().getParent(getWindow.WindowType.Addcus);
        CreateWindow("Add Customer", root);
    }

    private void setStage() {
        stage = (Stage) root.getScene().getWindow();
    }

    @FXML
    private void Addcusnow(ActionEvent event) throws IOException {
        AddCustomerNow(event);
    }

    @FXML
    private void removecus(ActionEvent event) throws IOException {
        Parent root = getWindow.getInstance().getParent(getWindow.WindowType.RemCus);
        CreateWindow("Remove Customer", root);
    }

    private void CreateWindow(String title, Parent root) throws IOException {
        scene = getWindow.getScene(root);
        stage = getWindow.getStage();
        stage.setScene(scene);
        getWindow.getStageIcon(stage);
        stage.setTitle(title);
        stage.showAndWait();
    }

    @FXML
    private void UpdateCusNow(ActionEvent event) throws IOException {
        Parent root = getWindow.getInstance().getParent(getWindow.WindowType.UpdCUs);
        CreateWindow("Update Customer", root);
    }

    @FXML
    private void handleCloseMenu(ActionEvent event) {
        ((Stage) root.getScene().getWindow()).close();
    }

    @FXML
    private void handleViewCus(ActionEvent event) throws IOException {
        Parent root = getWindow.getInstance().getParent(getWindow.WindowType.ViewCUs);
        CreateWindow("View Customer", root);
    }

    @FXML
    private void handleViewStore(ActionEvent event) throws IOException {
        Parent root = getWindow.getInstance().getParent(getWindow.WindowType.ViewStore);
        CreateWindow("View Store", root);
    }

    @FXML
    private void handleViewOrders(ActionEvent event) throws IOException {
        Parent root = getWindow.getInstance().getParent(getWindow.WindowType.ViewOrders);
        CreateWindow("View Order", root);
    }

    @FXML
    private void handleUpdtFood(ActionEvent event) throws IOException {
        Parent root = getWindow.getInstance().getParent(getWindow.WindowType.UptFoods);
        CreateWindow("Update Foods in Store", root);
    }

    @FXML
    private void handleAddFood(ActionEvent event) throws IOException {
        Parent root = getWindow.getInstance().getParent(getWindow.WindowType.Addfoodtostore);
        CreateWindow("Add new Food", root);
    }

    @FXML
    private void AddFood(ActionEvent event) throws IOException {
        handleAddFood(event);
    }

    @FXML
    private void Updatefood(ActionEvent event) throws IOException {
        handleUpdtFood(event);
    }

    @FXML
    private void DeleteFoods(ActionEvent event) throws IOException {
        Parent root = getWindow.getInstance().getParent(getWindow.WindowType.deletefood);
        CreateWindow("Delete food from Store", root);
    }

    private void loadAllCnames() throws ClassNotFoundException, SQLException {
        ArrayList<String> NameList = O.loadAllCusNames();
        for (int i = 0; i < NameList.size(); i++) {
            C_names.getItems().add(NameList.get(i));
        }
    }

    private void loadallIName() throws ClassNotFoundException, SQLException {
        ArrayList<String> AllFNames = O.loadAllFNames();
        for (int i = 0; i < AllFNames.size(); i++) {
            Food_names.getItems().add(AllFNames.get(i));
        }
    }

    private void loadAllPnumbers() throws ClassNotFoundException, SQLException {
        ArrayList<Integer> AllPnumbers = O.loadAllPnumbers();
        for (int i = 0; i < AllPnumbers.size(); i++) {
            Pnum.getItems().add(AllPnumbers.get(i));
        }
    }

    Double Tot = 0.0;

    @FXML
    private void AddtoTable(ActionEvent event) throws ClassNotFoundException, SQLException,
            NumberFormatException {
        String fid = O.getFid(Food_names.getValue());
        int qty = I.getQty(fid);
        if (qty <= 0) {
            Alertbox.showSimpleMsg("No item in store", "Please try again");
        } else {
            int c_phonenum = O.getC_phonenum(C_names.getValue());
            Double UnitPrice = O.gerUnitP(Food_names.getValue());
            Integer Qtys = Integer.parseInt(Q.getText());
            Double I_Total = Qtys * UnitPrice;
            Tot += I_Total;
            Pnum.setValue(c_phonenum);
            tableCart.add(new Cart(Food_names.getValue(), Qtys, I_Total));
            Table.getItems().setAll(tableCart);
        }
    }

    @FXML
    private void handeplaceOrder(ActionEvent event) throws ClassNotFoundException, SQLException {
        String fid = O.getFid(Food_names.getValue());
        Integer pnum = Pnum.getValue();
        Double UnitPrice = O.gerUnitP(Food_names.getValue());
        Integer Qtys = Integer.parseInt(Q.getText());
        ItemDTO i = new ItemDTO(fid, Qtys);
        Double I_Total = Qtys * UnitPrice;
        String cids = O.getCids(Integer.parseInt(Pnum.getValue().toString()));
        String OID = O.getCountoforders();

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Calendar cal = Calendar.getInstance();
        String time = (dateFormat.format(cal.getTime()));

        int qty = I.getQty(fid);
        if (qty <= 0) {
            Alertbox.showSimpleMsg("No items on store", "Please try again");
        } else {
            I.updateItemQ(i);

            CustomDTO order = new CustomDTO(OID, time,
                    cids, fid, Qtys, I_Total);
            boolean result = O.PlaceOrder(order);
            if (result) {
                Alertbox.showSimpleMsg("Order Make Success", "");
            } else {
                Alertbox.showErrorMag("Failed", "Please try again");
            }
            UpdateQueue();
        }

    }
    Double O_total = 0.0;

    private void UpdateQueue() throws ClassNotFoundException, SQLException {
        String OID = O.getCountoforders();
        Integer pnum = Pnum.getValue();
        Integer Qtys = Integer.parseInt(Q.getText());
        Double UnitPrice = O.gerUnitP(Food_names.getValue());
        Double I_Total = Qtys * UnitPrice;
        tableQueue.add(new Cart(pnum, Tot));
        Queue.setItems(tableQueue);
        O_total = Tot;
        Tot = 0.0;
    }

    @FXML
    private void clearnow(ActionEvent event) {
        Table.getItems().clear();
        tableCart.clear();
    }

    @FXML
    private void handlePayment(ActionEvent event) throws ClassNotFoundException, SQLException {
        int selectedIndex = Queue.getSelectionModel().getSelectedIndex();
        int Pnumber = Integer.parseInt(Queue.getColumns().get(selectedIndex).getCellObservableValue(0).
                getValue().toString());
        String cids = O.getCids(Pnumber);
        String oid = O.getOID(cids);
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        String time = (dateFormat.format(cal.getTime()));
        PaymentDTO paymentDTO = new PaymentDTO(time, O_total, "Paid", oid);
        boolean Rslt = O.MakePayment(paymentDTO);
        if (Rslt) {
            Alertbox.showSimpleMsg("Payment succesfull", "");
        } else {
            Alertbox.showErrorMag("Failed", "Please try again.");
        }
    }

    @FXML
    private void ViewStore(ActionEvent event) throws IOException {
        handleViewStore(event);
    }

}
