package shirley.s.kitchen.Controlar;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import shirley.s.kitchen.AlertBox.Alertbox;
import shirley.s.kitchen.BO.BOFactory;
import shirley.s.kitchen.BO.CustomerBO;
import shirley.s.kitchen.BO.OrderBO;

public class RemoveCustomerController implements Initializable {

    @FXML
    private ComboBox<Integer> Phonenum;
    @FXML
    private ComboBox<String> Name;

    CustomerBO C = (CustomerBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.CUSTOMER);
    OrderBO O = (OrderBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.ORDER);

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
    private void handleRemCus(ActionEvent event) throws ClassNotFoundException, SQLException {
        Optional<ButtonType> response = Alertbox.showConfaMag("Are you sure want to remove this Customer", "");
        if (response.get() == ButtonType.OK) {
            boolean Rslt = C.RemoveCustomer(Phonenum.getValue());
            if (Rslt) {
                Alertbox.showSimpleMsg("Delete succesfull", "");
            } else {
                Alertbox.showErrorMag("Failed", "Please try again");
            }
        } else {
            Alertbox.showSimpleMsg("Oparation canceled", "");
        }
    }

    private void loadAllCusNames() throws ClassNotFoundException, SQLException {
        ArrayList<String> list = O.loadAllCusNames();
        for (int i = 0; i < list.size(); i++) {
            Name.getItems().add(list.get(i));
        }
    }

    @FXML
    private void loadPnum(ActionEvent event) throws ClassNotFoundException, SQLException {
        Integer c_phonenum = O.getC_phonenum(Name.getValue());
        Phonenum.setValue(c_phonenum);
    }

    private void loadALlPnum() throws ClassNotFoundException, SQLException {
        ArrayList<Integer> list = O.loadAllPnumbers();
        for (int i = 0; i < list.size(); i++) {
            Phonenum.getItems().add(list.get(i));
        }
    }

}
