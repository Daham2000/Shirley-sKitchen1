package shirley.s.kitchen.BO;

import java.sql.SQLException;
import java.util.ArrayList;
import shirley.s.kitchen.DTO.CustomDTO;
import shirley.s.kitchen.DTO.OrderDetailsDTO;
import shirley.s.kitchen.DTO.PaymentDTO;

public interface OrderBO extends SuperBO {

    public ArrayList<String> loadAllCusNames() throws ClassNotFoundException, SQLException;

    public ArrayList<String> loadAllFNames() throws ClassNotFoundException, SQLException;

    public ArrayList<Integer> loadAllPnumbers() throws ClassNotFoundException, SQLException;

    public Integer getC_phonenum(String n) throws ClassNotFoundException, SQLException;

    public Double gerUnitP(String name) throws ClassNotFoundException, SQLException;

    public boolean PlaceOrder(CustomDTO order) throws ClassNotFoundException, SQLException;
    
    public String getCids(int n) throws ClassNotFoundException, SQLException;
    
    public String getFid(String Fname) throws ClassNotFoundException, SQLException;
    
    public String getCountoforders() throws ClassNotFoundException, SQLException;
    
    public String getOID(String Cid) throws ClassNotFoundException, SQLException;
    
    public boolean MakePayment(PaymentDTO payment) throws ClassNotFoundException, SQLException;
    
    public ArrayList<CustomDTO> getOrderDe(String date) throws ClassNotFoundException, SQLException;
    
    public ArrayList<OrderDetailsDTO> getOrderdetails(Integer Pnum) throws ClassNotFoundException, SQLException;
    
    
}
