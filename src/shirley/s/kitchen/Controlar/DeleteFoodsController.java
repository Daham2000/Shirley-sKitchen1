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
import shirley.s.kitchen.BO.ItemBO;
import shirley.s.kitchen.BO.OrderBO;

public class DeleteFoodsController implements Initializable {

    @FXML
    private ComboBox<String> Foods;
    
    ItemBO I=(ItemBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.ITEM);
    OrderBO O=(OrderBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.ORDER);

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            loadAllFnames();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DeleteFoodsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handleDeleteF(ActionEvent event) throws ClassNotFoundException, SQLException {
        Optional<ButtonType> response=Alertbox.showConfaMag("Are you sure want to remove this Food", "");
        if (response.get()==ButtonType.OK) {
            boolean Rslt = I.deleteFood(Foods.getValue());
            if (Rslt) {
                Alertbox.showSimpleMsg("Delete succesfull","");
            }else{
                Alertbox.showErrorMag("Failed", "Please try again");
            }
        }else{
            Alertbox.showSimpleMsg("Oparation canceled", "");
        }
        
    }

    private void loadAllFnames() throws ClassNotFoundException, SQLException {
        ArrayList<String> list = O.loadAllFNames();
        for (int i = 0; i < list.size(); i++) {
            Foods.getItems().add(list.get(i));
        }
    }

}
