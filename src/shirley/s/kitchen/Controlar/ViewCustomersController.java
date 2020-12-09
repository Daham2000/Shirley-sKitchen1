package shirley.s.kitchen.Controlar;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import shirley.s.kitchen.BO.BOFactory;
import shirley.s.kitchen.BO.CustomerBO;
import shirley.s.kitchen.BO.OrderBO;
import shirley.s.kitchen.DTO.CustomerDTO;

public class ViewCustomersController implements Initializable {

    @FXML
    private ComboBox<Integer> Phonenum;
    @FXML
    private ComboBox<String> Name;
    @FXML
    private ComboBox<String> Cid;
    @FXML
    private DatePicker date;

    OrderBO O = (OrderBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.ORDER);
    CustomerBO C = (CustomerBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.CUSTOMER);

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            loadAllCusNames();
            loadALlPnum();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(RemoveCustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handleTbhlnyPnum(ActionEvent event) {
    }

    @FXML
    private void handletabByName(ActionEvent event) throws ClassNotFoundException, SQLException {
        Integer c_phonenum = O.getC_phonenum(Name.getValue());
        Phonenum.setValue(c_phonenum);
    }

    @FXML
    private void handletabebyCid(ActionEvent event) {
    }

    @FXML
    private void loadAllCuss(ActionEvent event) throws ClassNotFoundException, SQLException {
        Name.getItems().clear();
        Phonenum.getItems().clear();
        ArrayList<CustomerDTO> Clist = C.ViewCustomer(date.getValue().toString());
        for (CustomerDTO cus : Clist) {
            Name.getItems().add(cus.getName());
            Phonenum.getItems().add(cus.getP_num());
        }
    }

    private void loadAllCusNames() throws ClassNotFoundException, SQLException {
        ArrayList<String> list = O.loadAllCusNames();
        for (int i = 0; i < list.size(); i++) {
            Name.getItems().add(list.get(i));
        }
    }

    private void loadALlPnum() throws ClassNotFoundException, SQLException {
        ArrayList<Integer> list = O.loadAllPnumbers();
        for (int i = 0; i < list.size(); i++) {
            Phonenum.getItems().add(list.get(i));
        }
    }

}
