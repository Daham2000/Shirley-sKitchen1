package shirley.s.kitchen.Controlar;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import shirley.s.kitchen.AlertBox.Alertbox;
import shirley.s.kitchen.BO.BOFactory;
import shirley.s.kitchen.BO.CustomerBO;
import shirley.s.kitchen.DTO.CustomerDTO;

public class AddCustomerController implements Initializable {

    @FXML
    private TextField C_name;
    @FXML
    private TextField C_num;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    CustomerBO B = (CustomerBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.CUSTOMER);

    @FXML
    private void AddCus(ActionEvent event) throws ClassNotFoundException, SQLException {
        CustomerDTO customerDTO = new CustomerDTO("", C_name.getText(), Integer.parseInt(C_num.getText()));
        boolean R = B.AddCustomer(customerDTO);
        if (R) {
            Alertbox.showSimpleMsg("Succesfull added", "");
        } else {
            Alertbox.showErrorMag("Failed", "Please try again.");
        }
    }

}
