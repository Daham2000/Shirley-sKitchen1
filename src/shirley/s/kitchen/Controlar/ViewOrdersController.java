package shirley.s.kitchen.Controlar;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import shirley.s.kitchen.BO.BOFactory;
import shirley.s.kitchen.BO.OrderBO;
import shirley.s.kitchen.DTO.CustomDTO;
import shirley.s.kitchen.DTO.OrderDetailsDTO;

public class ViewOrdersController implements Initializable {

    @FXML
    private DatePicker Date;
    @FXML
    private TableView<CustomDTO> TableView;
    @FXML
    private TableColumn<CustomDTO, String> C_name;
    @FXML
    private TableColumn<CustomDTO, Integer> P_number;
    @FXML
    private TableColumn<CustomDTO, Double> Total;

    OrderBO O = (OrderBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.ORDER);

    ObservableList<CustomDTO> list = FXCollections.observableArrayList();
    ObservableList<String> list2 = FXCollections.observableArrayList();
    @FXML
    private ListView<String> listView;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        C_name.setCellValueFactory(new PropertyValueFactory<>("C_name"));
        P_number.setCellValueFactory(new PropertyValueFactory<>("num"));
        Total.setCellValueFactory(new PropertyValueFactory<>("I_total"));
    }

    @FXML
    private void LoadTable(ActionEvent event) throws ClassNotFoundException, SQLException {
        ArrayList<CustomDTO> orderDe = O.getOrderDe(Date.getValue().toString());
        for (CustomDTO C : orderDe) {
            list.add(C);
        }
        TableView.setItems(list);
    }

    @FXML
    private void loadOrderDetails(MouseEvent event) throws ClassNotFoundException, SQLException {
        listView.getItems().clear();
        list2.clear();
        int selectedIndex = TableView.getSelectionModel().getSelectedIndex();
        CustomDTO get = TableView.getItems().get(selectedIndex);
        Integer Pnum = get.getNum();
        ArrayList<OrderDetailsDTO> orderdlist = O.getOrderdetails(Pnum);
        for (OrderDetailsDTO OO : orderdlist) {
            list2.add((OO.getI_code() + "  -  " + OO.getQty()));
        }
        listView.setItems(list2);
    }

}
