package shirley.s.kitchen.BO.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import shirley.s.kitchen.BO.CustomerBO;
import shirley.s.kitchen.DAO.CustomerDAO;
import shirley.s.kitchen.DAO.DAOFactory;
import shirley.s.kitchen.DTO.CustomerDTO;
import shirley.s.kitchen.Entity.Customer;

public class CustomerBOimple implements CustomerBO {

    CustomerDAO C = (CustomerDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CUSTOMER);

    @Override
    public boolean AddCustomer(CustomerDTO customer) throws ClassNotFoundException, SQLException {
        int Cuscount = C.getCountofcus();
        String CusID = "C00" + Cuscount;
        Customer customerEn = new Customer(CusID, customer.getName(), customer.getP_num());
        boolean result = C.AddCustomer(customerEn);
        return result;
    }

    @Override
    public boolean RemoveCustomer(int Pnum) throws ClassNotFoundException, SQLException {
        return C.RemoveCustomer(Pnum);
    }

    @Override
    public boolean UpdateCustomer(CustomerDTO customer) throws ClassNotFoundException, SQLException {
        Customer c = new Customer(customer.getName(), customer.getP_num());
        return C.UpdateCustomer(c);
    }

    @Override
    public ArrayList<CustomerDTO> ViewCustomer(String date) throws ClassNotFoundException, SQLException {
        ArrayList<String> Cidlist = C.getCusbydate(date);
        ArrayList<CustomerDTO> list = new ArrayList<>();   
        for (String CC : Cidlist) { 
            Customer cus = C.ViewCustomer(CC);
            CustomerDTO cdto = new CustomerDTO();
            cdto.setName(cus.getName());
            cdto.setP_num(cus.getP_num());
            list.add(cdto);
        }
        return list;
    }

}
