package shirley.s.kitchen.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import shirley.s.kitchen.Entity.Item;

public interface ItemDAO extends SuperDAO {

    public boolean addItem(Item item) throws ClassNotFoundException, SQLException;

    public int countofFoods() throws ClassNotFoundException, SQLException;

    public int getQty(String id) throws ClassNotFoundException, SQLException;

    public void updateItemQ(String id, int Q) throws ClassNotFoundException, SQLException;

    public ArrayList<Item> getAllItems() throws ClassNotFoundException, SQLException;

    public boolean updateFoods(Item item) throws ClassNotFoundException, SQLException;
    
    public String getFName(String ICode) throws ClassNotFoundException, SQLException;
    
    public boolean deleteItem(String Icode) throws ClassNotFoundException, SQLException;

}
