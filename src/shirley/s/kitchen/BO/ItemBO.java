package shirley.s.kitchen.BO;

import java.sql.SQLException;
import java.util.ArrayList;
import shirley.s.kitchen.DTO.ItemDTO;

public interface ItemBO extends SuperBO {
    public boolean addItem(ItemDTO item) throws ClassNotFoundException, SQLException;
    
    public int getQty(String id) throws ClassNotFoundException, SQLException;
    
    public void updateItemQ(ItemDTO item) throws ClassNotFoundException, SQLException;
    
    public ArrayList<ItemDTO> loadAllIDetails() throws ClassNotFoundException, SQLException;
    
    public boolean updateFoods(ItemDTO item) throws ClassNotFoundException, SQLException;
    
    public boolean deleteFood(String Icode) throws ClassNotFoundException, SQLException;
}
