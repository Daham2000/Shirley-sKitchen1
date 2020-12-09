package shirley.s.kitchen.DAO.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import shirley.s.kitchen.DAO.CrudUtil;
import shirley.s.kitchen.DAO.OrderDAO;
import shirley.s.kitchen.DTO.PaymentDTO;
import shirley.s.kitchen.Entity.Order;
import shirley.s.kitchen.Entity.OrderDetails;

public class OrderDAOimpl implements OrderDAO {

    String sql;

    @Override
    public ArrayList<String> loadAllCusNames() throws ClassNotFoundException, SQLException {
        sql = "select Name from customer where Name!=?";
        ResultSet set = CrudUtil.executeQuery(sql,"null");
        ArrayList<String> list = new ArrayList<>();
        while (set.next()) {
            list.add(set.getString("Name"));
        }
        return list;
    }

    @Override
    public ArrayList<String> loadAllFNames() throws ClassNotFoundException, SQLException {
        sql = "select I_name from item";
        ResultSet set = CrudUtil.executeQuery(sql);
        ArrayList<String> list = new ArrayList<>();
        while (set.next()) {
            list.add(set.getString("I_name"));
        }
        return list;
    }

    @Override
    public Integer getC_phonenum(String n) throws ClassNotFoundException, SQLException {
        sql = "select Pnum from customer where Name=?";
        ResultSet set = CrudUtil.executeQuery(sql, n);
        int num = 0;
        while (set.next()) {
            num = set.getInt(1);
        }
        return num;
    }

    @Override
    public Double gerUnitP(String name) throws ClassNotFoundException, SQLException {
        Double Unit_P = 0.0;
        sql = "select UnitPrice from item where I_name=?";
        ResultSet set = CrudUtil.executeQuery(sql, name);
        while (set.next()) {
            Unit_P = set.getDouble("UnitPrice");
        }
        return Unit_P;
    }

    @Override
    public ArrayList<Integer> loadAllPnumbers() throws ClassNotFoundException, SQLException {
        ArrayList<Integer> list = new ArrayList<>();
        sql = "select Pnum from customer where Pnum!=0";
        ResultSet set = CrudUtil.executeQuery(sql);
        while (set.next()) {
            list.add(set.getInt(1));
        }
        return list;
    }

    @Override
    public boolean PlaseOrder(Order order) throws ClassNotFoundException, SQLException {
        sql = "insert into orders values(?,?,?)";
        return CrudUtil.executeUpdate(sql, order.getO_id(), order.getOrder_date(), order.getC_id());
    }

    @Override
    public boolean PlaseOrderdetails(OrderDetails order) throws ClassNotFoundException, SQLException {
        sql = "insert into orderdetails values(?,?,?,?)";
        return CrudUtil.executeUpdate(sql, order.getO_id(), order.getI_code(), order.getQty(), order.getI_total());
    }

    @Override
    public String getCid(int pn) throws ClassNotFoundException, SQLException {
        sql = "select C_id from customer where Pnum=?";
        ResultSet set = CrudUtil.executeQuery(sql, pn);
        String Cid = "";
        while (set.next()) {
            Cid = set.getString(1);
        }
        return Cid;
    }

    @Override
    public String getFid(String Fname) throws ClassNotFoundException, SQLException {
        sql = "select I_code from item where I_name=?";
        ResultSet set = CrudUtil.executeQuery(sql, Fname);
        String Icode = "";
        while (set.next()) {
            Icode = set.getString(1);
        }
        return Icode;
    }

    @Override
    public int getCountoforders() throws ClassNotFoundException, SQLException {
        sql = "select count(O_id) from orders";
        ResultSet set = CrudUtil.executeQuery(sql);
        int i = 1;
        while (set.next()) {
            i = set.getInt(1);
        }
        return i;
    }

    @Override
    public boolean MakeaPayment(PaymentDTO paymentdetils) throws ClassNotFoundException, SQLException {
        sql = "insert into payment values(?,?,?,?)";
        return CrudUtil.executeUpdate(sql, paymentdetils.getPay_time(), paymentdetils.getTotal(),
                 paymentdetils.getP_status(), paymentdetils.getO_id());
    }

    @Override
    public String getOID(String Cid) throws ClassNotFoundException, SQLException {
        sql = "select O_id from orders where C_id=?";
        String OID = "";
        ResultSet set = CrudUtil.executeQuery(sql, Cid);
        while (set.next()) {
            OID = set.getString(1);
        }
        return OID;
    }

    @Override
    public ArrayList<Order> getOidbydate(String date) throws ClassNotFoundException, SQLException {
        sql = "select O_id,C_id from orders where Order_date=?";
        ArrayList<Order> Oid = new ArrayList<>();
        ResultSet set = CrudUtil.executeQuery(sql, date);
        while (set.next()) {
            Oid.add(new Order(set.getString(1), set.getString(2)));
        }
        return Oid;
    }

    @Override
    public Double getTotal(String Oid) throws ClassNotFoundException, SQLException {
        sql = "select Total from payment where O_id=?";
        ResultSet set = CrudUtil.executeQuery(sql, Oid);
        double tot = 0.0;
        while (set.next()) {
            tot = set.getDouble(1);
        }
        return tot;
    }

    @Override
    public String getCname(String Cid) throws ClassNotFoundException, SQLException {
        sql = "select Name from customer where C_id=?";
        ResultSet set = CrudUtil.executeQuery(sql, Cid);
        String Cids = "";
        while (set.next()) {
            Cids = set.getString(1);
        }
        return Cids;
    }

    @Override
    public Integer getCnum(String Cid) throws ClassNotFoundException, SQLException {
        sql = "select Pnum from customer where C_id=?";
        ResultSet set = CrudUtil.executeQuery(sql, Cid);
        int Cnums = 0;
        while (set.next()) {
            Cnums = set.getInt(1);
        }
        return Cnums;
    }

    @Override
    public ArrayList<OrderDetails> getOrderdetails(String Oid) throws ClassNotFoundException, SQLException {
        sql = "select I_code,Qty from Orderdetails where O_id=?";
        ResultSet set = CrudUtil.executeQuery(sql, Oid);
        ArrayList<OrderDetails> orderDetails = new ArrayList<>();
        while (set.next()) {
            orderDetails.add(new OrderDetails(set.getString("I_code"), set.getInt("Qty")));
        }
        return orderDetails;
    }

}
