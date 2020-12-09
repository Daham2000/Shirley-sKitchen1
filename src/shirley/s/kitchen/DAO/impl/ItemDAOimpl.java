package shirley.s.kitchen.DAO.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import shirley.s.kitchen.DAO.CrudUtil;
import shirley.s.kitchen.DAO.ItemDAO;
import shirley.s.kitchen.Entity.Item;

public class ItemDAOimpl implements ItemDAO {

    String sql;

    @Override
    public boolean addItem(Item item) throws ClassNotFoundException, SQLException {
        sql = "insert into item values(?,?,?,?,?,?)";
        return CrudUtil.executeUpdate(sql, item.getI_code(), item.getI_name(),
                item.getM_date(), item.getExp_date(), item.getQtyonhand(), item.getUnitPrice());
    }

    @Override
    public int countofFoods() throws ClassNotFoundException, SQLException {
        sql = "select count(I_code) from item";
        ResultSet set = CrudUtil.executeQuery(sql);
        int C = 0;
        while (set.next()) {
            C = set.getInt(1);
        }
        return C;
    }

    @Override
    public int getQty(String id) throws ClassNotFoundException, SQLException {
        int Q = 0;
        sql = "select Qtyonhand from item where I_code=?";
        ResultSet set = CrudUtil.executeQuery(sql, id);
        while (set.next()) {
            Q = set.getInt(1);
        }
        return Q;
    }

    @Override
    public void updateItemQ(String id, int Q) throws ClassNotFoundException, SQLException {
        sql = "update item set Qtyonhand=Qtyonhand-? where I_code=?";
        CrudUtil.executeUpdate(sql, Q, id);
    }

    @Override
    public ArrayList<Item> getAllItems() throws ClassNotFoundException, SQLException {
        sql = "select *from item";
        ResultSet set = CrudUtil.executeQuery(sql);
        ArrayList<Item> item = new ArrayList<>();
        while (set.next()) {
            item.add(new Item(set.getString("I_name"), set.getInt("Qtyonhand"), set.getString("M_date"),
                    set.getString("Exp_date")));
        }
        return item;
    }

    @Override
    public boolean updateFoods(Item item) throws ClassNotFoundException, SQLException {
        sql = "update item set M_date=?, Exp_date=?, Qtyonhand=?, UnitPrice=? where I_code=?";
        System.out.println(item.getI_code());
        return CrudUtil.executeUpdate(sql, item.getM_date(), item.getExp_date(), item.getQtyonhand(),
                item.getUnitPrice(), item.getI_code());
    }

    @Override
    public String getFName(String ICode) throws ClassNotFoundException, SQLException {
        sql = "select I_name from item where I_code=?";
        ResultSet set = CrudUtil.executeQuery(sql, ICode);
        String Fname = "";
        while (set.next()) {
            Fname = set.getString(1);
        }
        return Fname;
    }

    @Override
    public boolean deleteItem(String Icode) throws ClassNotFoundException, SQLException {
        sql = "delete from item where I_code=?";
        return CrudUtil.executeUpdate(sql, Icode);
    }

}
