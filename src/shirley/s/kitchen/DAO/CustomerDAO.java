package shirley.s.kitchen.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import shirley.s.kitchen.Entity.Customer;

public interface CustomerDAO extends SuperDAO{

    public boolean AddCustomer(Customer customer) throws ClassNotFoundException,SQLException;
    
    public int getCountofcus();

    public boolean RemoveCustomer(int Pnum) throws ClassNotFoundException,SQLException;

    public boolean UpdateCustomer(Customer customer) throws ClassNotFoundException,SQLException;
    
    public ArrayList<String> getCusbydate(String date) throws ClassNotFoundException,SQLException;

    public Customer ViewCustomer(String Cid) throws ClassNotFoundException,SQLException;
}
