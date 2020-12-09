package shirley.s.kitchen.Controlar;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import shirley.s.kitchen.BO.BOFactory;
import shirley.s.kitchen.BO.ItemBO;
import shirley.s.kitchen.DTO.ItemDTO;

public class ViewStoreController implements Initializable {

    @FXML
    private TableView<ItemDTO> Table;
    @FXML
    private TableColumn<ItemDTO, String> Food_Name;
    @FXML
    private TableColumn<ItemDTO, Integer> QtyOnStr;
    @FXML
    private TableColumn<ItemDTO, String> M_date;
    @FXML
    private TableColumn<ItemDTO, String> Exp_date;

    ItemBO I = (ItemBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.ITEM);
    
    ObservableList<ItemDTO> list=FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Food_Name.setCellValueFactory(new PropertyValueFactory<>("I_name"));
        QtyOnStr.setCellValueFactory(new PropertyValueFactory<>("Qtyonhand"));
        M_date.setCellValueFactory(new PropertyValueFactory<>("M_date"));
        Exp_date.setCellValueFactory(new PropertyValueFactory<>("Exp_date"));
        
        try {
            loadAllDetails();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ViewStoreController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadAllDetails() throws ClassNotFoundException, SQLException {
        ArrayList<ItemDTO> Alldetails = I.loadAllIDetails();
        for (int i = 0; i < Alldetails.size(); i++) {
            list.add(Alldetails.get(i));
        }
        Table.setItems(list);
    }

}
