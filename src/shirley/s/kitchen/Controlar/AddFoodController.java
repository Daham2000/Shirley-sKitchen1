package shirley.s.kitchen.Controlar;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import shirley.s.kitchen.AlertBox.Alertbox;
import shirley.s.kitchen.BO.BOFactory;
import shirley.s.kitchen.BO.ItemBO;
import shirley.s.kitchen.DTO.ItemDTO;

public class AddFoodController implements Initializable {

    @FXML
    private TextField Qty;
    @FXML
    private DatePicker M_date;
    @FXML
    private DatePicker Exp_date;
    @FXML
    private TextField Name;
    @FXML
    private TextField UnitPrice;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    ItemBO B=(ItemBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.ITEM);

    @FXML
    private void handleAddFood(ActionEvent event) throws ClassNotFoundException, SQLException {
        ItemDTO item=new ItemDTO("", Name.getText(), M_date.getValue().toString(), 
                Exp_date.getValue().toString(), Integer.parseInt(Qty.getText()), 
                Double.parseDouble(UnitPrice.getText()));
        boolean result= B.addItem(item);
        if (result) {
            Alertbox.showSimpleMsg("Added succesfull", "");
        }else{
            Alertbox.showErrorMag("Failed", "Please try again.");
        }
    }

}
