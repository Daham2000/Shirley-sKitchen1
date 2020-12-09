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
import shirley.s.kitchen.AlertBox.Alertbox;
import shirley.s.kitchen.BO.BOFactory;
import shirley.s.kitchen.BO.CustomerBO;
import shirley.s.kitchen.BO.OrderBO;
import shirley.s.kitchen.DTO.CustomerDTO;

public class UpdatecustomerController implements Initializable {

    @FXML
    private ComboBox<String> Phonenum;
    @FXML
    private ComboBox<String> Name;

    CustomerBO C = (CustomerBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.CUSTOMER);
    OrderBO O = (OrderBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.ORDER);

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            loadALlPnum();
            loadAllCusNames();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UpdatecustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void UpdtCus(ActionEvent event) throws ClassNotFoundException, SQLException {
        CustomerDTO customer = new CustomerDTO(Name.getValue(), Phonenum.getValue());
        boolean Rslt = C.UpdateCustomer(customer);
        if (Rslt) {
            Alertbox.showSimpleMsg("Succesfully updated", "");
        } else {
            Alertbox.showErrorMag("Failed", "Try again.");
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
            Phonenum.getItems().add(list.get(i).toString());
        }
    }

    @FXML
    private void setPnum(ActionEvent event) throws ClassNotFoundException, SQLException {
        Integer c_phonenum = O.getC_phonenum(Name.getValue());
        Phonenum.setValue(c_phonenum.toString());
    }

}
