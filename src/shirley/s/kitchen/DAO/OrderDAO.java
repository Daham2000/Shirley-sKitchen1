package shirley.s.kitchen.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import shirley.s.kitchen.DTO.PaymentDTO;
import shirley.s.kitchen.Entity.Order;
import shirley.s.kitchen.Entity.OrderDetails;

public interface OrderDAO extends SuperDAO {

    public ArrayList<String> loadAllCusNames() throws ClassNotFoundException, SQLException;

    public ArrayList<Integer> loadAllPnumbers() throws ClassNotFoundException, SQLException;
    
    public ArrayList<String> loadAllFNames() throws ClassNotFoundException, SQLException;

    public Integer getC_phonenum(String n) throws ClassNotFoundException, SQLException;

    public Double gerUnitP(String name) throws ClassNotFoundException, SQLException;

    public boolean PlaseOrder(Order order) throws ClassNotFoundException, SQLException;

    public boolean PlaseOrderdetails(OrderDetails order) throws ClassNotFoundException, SQLException;

    public String getCid(int pn) throws ClassNotFoundException, SQLException;

    public String getFid(String Fname) throws ClassNotFoundException, SQLException;

    public int getCountoforders() throws ClassNotFoundException, SQLException;

    public boolean MakeaPayment(PaymentDTO paymentdetils) throws ClassNotFoundException, SQLException;

    public String getOID(String Cid) throws ClassNotFoundException, SQLException;

    public ArrayList<Order> getOidbydate(String date) throws ClassNotFoundException, SQLException;

    public Double getTotal(String Oid) throws ClassNotFoundException, SQLException;

    public String getCname(String Cid) throws ClassNotFoundException, SQLException;

    public Integer getCnum(String Cid) throws ClassNotFoundException, SQLException;

    public ArrayList<OrderDetails> getOrderdetails(String Oid) throws ClassNotFoundException, SQLException;

}
