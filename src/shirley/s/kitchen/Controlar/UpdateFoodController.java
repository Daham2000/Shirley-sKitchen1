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
import javafx.scene.control.TextField;
import shirley.s.kitchen.AlertBox.Alertbox;
import shirley.s.kitchen.BO.BOFactory;
import shirley.s.kitchen.BO.ItemBO;
import shirley.s.kitchen.BO.OrderBO;
import shirley.s.kitchen.DTO.ItemDTO;

public class UpdateFoodController implements Initializable {

    @FXML
    private ComboBox<String> F_name;
    @FXML
    private TextField Qty;
    @FXML
    private DatePicker M_date;
    @FXML
    private DatePicker Exp_date;

    OrderBO O = (OrderBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.ORDER);
    ItemBO I = (ItemBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.ITEM);
    @FXML
    private TextField UnitP;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            loadAllItemNames();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UpdateFoodController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void AddtoStor(ActionEvent event) throws ClassNotFoundException, SQLException {
        ItemDTO item = new ItemDTO();
        String fid = O.getFid(F_name.getValue());
        item.setI_code(fid);
        item.setQtyonhand(Integer.parseInt(Qty.getText()));
        item.setM_date(M_date.getValue().toString());
        item.setExp_date(Exp_date.getValue().toString());
        item.setUnitPrice(Integer.parseInt(UnitP.getText()));
        boolean R = I.updateFoods(item);
        if (R) {
            Alertbox.showSimpleMsg("Item updated success", "");
        } else {
            Alertbox.showErrorMag("Failed", "Please try again");
        }
    }

    private void loadAllItemNames() throws ClassNotFoundException, SQLException {
        ArrayList<String> AllFNames = O.loadAllFNames();
        for (int i = 0; i < AllFNames.size(); i++) {
            F_name.getItems().add(AllFNames.get(i));
        }
    }

}
