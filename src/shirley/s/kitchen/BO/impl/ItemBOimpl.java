
package shirley.s.kitchen.BO.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import shirley.s.kitchen.BO.ItemBO;
import shirley.s.kitchen.DAO.DAOFactory;
import shirley.s.kitchen.DAO.ItemDAO;
import shirley.s.kitchen.DAO.OrderDAO;
import shirley.s.kitchen.DTO.ItemDTO;
import shirley.s.kitchen.Entity.Item;

public class ItemBOimpl implements ItemBO{
    
    ItemDAO I=(ItemDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ITEM);
    OrderDAO O=(OrderDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ORDERS);

    @Override
    public boolean addItem(ItemDTO item) throws ClassNotFoundException, SQLException {
        int countofFoods= I.countofFoods()+1;
        String I_code="I00"+countofFoods;
        Item Itm=new Item(I_code, item.getI_name(), item.getM_date(), item.getExp_date(), 
                item.getQtyonhand(), item.getUnitPrice());
        return I.addItem(Itm);
    }

    @Override
    public int getQty(String id) throws ClassNotFoundException, SQLException {
        return I.getQty(id);
    }

    @Override
    public void updateItemQ(ItemDTO item) throws ClassNotFoundException, SQLException {
        I.updateItemQ(item.getI_code(), item.getQtyonhand());
    }

    @Override
    public ArrayList<ItemDTO> loadAllIDetails() throws ClassNotFoundException, SQLException {
        ArrayList<Item> allItems = I.getAllItems();
        ArrayList<ItemDTO> list=new ArrayList<>();
        for(Item it: allItems){
            list.add(new ItemDTO(it.getI_name(), it.getQtyonhand(), it.getM_date(), it.getExp_date()));
        }
        return list;
    }

    @Override
    public boolean updateFoods(ItemDTO item) throws ClassNotFoundException, SQLException {
        Item i=new Item();
        i.setI_code(item.getI_code());
        i.setQtyonhand(item.getQtyonhand());
        i.setM_date(item.getM_date());
        i.setExp_date(item.getExp_date());
        i.setUnitPrice(item.getUnitPrice());
        return I.updateFoods(i);
    }

    @Override
    public boolean deleteFood(String Iname) throws ClassNotFoundException, SQLException {
        String Icode=O.getFid(Iname);
        return I.deleteItem(Icode);
    }
    
}
