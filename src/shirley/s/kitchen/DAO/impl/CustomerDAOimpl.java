package shirley.s.kitchen.DAO.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import shirley.s.kitchen.DAO.CrudUtil;
import shirley.s.kitchen.DAO.CustomerDAO;
import shirley.s.kitchen.Entity.Customer;

public class CustomerDAOimpl implements CustomerDAO {

    String sql;

    @Override
    public boolean AddCustomer(Customer customer) throws ClassNotFoundException, SQLException {
        sql = "insert into customer values(?,?,?)";
        return CrudUtil.executeUpdate(sql, customer.getC_id(), customer.getP_num(), customer.getName());
    }

    @Override
    public int getCountofcus() {
        int i = 0;
        try {
            sql = "select count(C_id) from customer";
            ResultSet set = CrudUtil.executeQuery(sql);
            while (set.next()) {
                i = set.getInt(1);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CustomerDAOimpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }

    @Override
    public boolean RemoveCustomer(int Pnum) throws ClassNotFoundException,SQLException{
        sql="update customer set Pnum=000, Name=?  where Pnum=?";
        return CrudUtil.executeUpdate(sql,"null", Pnum);
    }

    @Override
    public boolean UpdateCustomer(Customer customer) throws ClassNotFoundException,SQLException{
        sql="update customer set Pnum=?, Name=?  where Pnum=?";
        return CrudUtil.executeUpdate(sql,customer.getP_num(), customer.getName(), 
                customer.getP_num());   

    }

    @Override
    public ArrayList<String> getCusbydate(String date) throws ClassNotFoundException, SQLException {
        sql="select distinct C_id from Orders where Order_date=?";
        ResultSet set = CrudUtil.executeQuery(sql, date);
        ArrayList<String> list=new ArrayList<>();
        while(set.next()){
            list.add(set.getString(1));
        }
        return list;
    }

    @Override
    public Customer ViewCustomer(String Cid) throws ClassNotFoundException, SQLException {
        sql="select distinct Name,Pnum from customer where C_id=? group by C_id limit 1";
        ResultSet set = CrudUtil.executeQuery(sql, Cid);
        Customer customer=new Customer();
        while(set.next()){
            customer=new Customer(set.getString(1),set.getInt(2));
        }
        return customer;
    }

}
