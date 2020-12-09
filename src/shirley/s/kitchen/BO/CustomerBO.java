package shirley.s.kitchen.BO;

import java.sql.SQLException;
import java.util.ArrayList;
import shirley.s.kitchen.DTO.CustomerDTO;

public interface CustomerBO extends SuperBO {

    public boolean AddCustomer(CustomerDTO customer) throws ClassNotFoundException, SQLException;

    public boolean RemoveCustomer(int Pnum) throws ClassNotFoundException, SQLException;

    public boolean UpdateCustomer(CustomerDTO customer) throws ClassNotFoundException, SQLException;

    public ArrayList<CustomerDTO> ViewCustomer(String date) throws ClassNotFoundException, SQLException;
}
