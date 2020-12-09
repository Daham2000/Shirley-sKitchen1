package shirley.s.kitchen.BO.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import shirley.s.kitchen.BO.OrderBO;
import shirley.s.kitchen.DAO.DAOFactory;
import shirley.s.kitchen.DAO.ItemDAO;
import shirley.s.kitchen.DAO.OrderDAO;
import shirley.s.kitchen.DBConnection.DBConnection;
import shirley.s.kitchen.DTO.CustomDTO;
import shirley.s.kitchen.DTO.OrderDetailsDTO;
import shirley.s.kitchen.DTO.PaymentDTO;
import shirley.s.kitchen.Entity.Order;
import shirley.s.kitchen.Entity.OrderDetails;
import shirley.s.kitchen.Entity.Payment;

public class OrderBOimpl implements OrderBO {

    OrderDAO O = (OrderDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ORDERS);
    ItemDAO I = (ItemDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ITEM);

    @Override
    public ArrayList<String> loadAllCusNames() throws ClassNotFoundException, SQLException {
        return O.loadAllCusNames();
    }

    @Override
    public ArrayList<String> loadAllFNames() throws ClassNotFoundException, SQLException {
        return O.loadAllFNames();
    }

    @Override
    public Integer getC_phonenum(String n) throws ClassNotFoundException, SQLException {
        return O.getC_phonenum(n);
    }

    @Override
    public Double gerUnitP(String name) throws ClassNotFoundException, SQLException {
        return O.gerUnitP(name);
    }

    @Override
    public ArrayList<Integer> loadAllPnumbers() throws ClassNotFoundException, SQLException {
        return O.loadAllPnumbers();
    }

    @Override
    public boolean PlaceOrder(CustomDTO order) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);

        Order ordertbl = new Order(order.getO_id(), order.getOrder_date(), order.getC_id());
        OrderDetails orderdettbl = new OrderDetails(order.getO_id(), order.getI_code(),
                order.getQty(), order.getI_total());
        boolean PlaseOrderR = O.PlaseOrder(ordertbl);
        if (PlaseOrderR) {
            boolean PlaseOrderdetailsR = O.PlaseOrderdetails(orderdettbl);
            if (!PlaseOrderdetailsR) {
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }
            connection.commit();
            connection.setAutoCommit(true);
            return true;
        }
        connection.rollback();
        connection.setAutoCommit(true);
        return false;
    }

    @Override
    public String getCids(int n) throws ClassNotFoundException, SQLException {
        return O.getCid(n);
    }

    @Override
    public String getFid(String Fname) throws ClassNotFoundException, SQLException {
        return O.getFid(Fname);
    }

    @Override
    public String getCountoforders() throws ClassNotFoundException, SQLException {
        int countoforders = O.getCountoforders();
        String Oid = "O00" + (countoforders + 1);
        return Oid;
    }

    @Override
    public String getOID(String Cid) throws ClassNotFoundException, SQLException {
        return O.getOID(Cid);
    }

    @Override
    public boolean MakePayment(PaymentDTO payment) throws ClassNotFoundException, SQLException {
        Payment pay = new Payment(payment.getPay_time(), payment.getTotal(),
                payment.getP_status(), payment.getO_id());
        return O.MakeaPayment(payment);
    }

    @Override
    public ArrayList<CustomDTO> getOrderDe(String date) throws ClassNotFoundException, SQLException {
        ArrayList<Order> Orders = new ArrayList<>();
        ArrayList<Order> list = O.getOidbydate(date);
        ArrayList<CustomDTO> D = new ArrayList<>();
        ArrayList<Double> tots = new ArrayList<>();
        ArrayList<String> Fnames = new ArrayList<>();
        ArrayList<Integer> Fnums = new ArrayList<>();
        for (Order O : list) {
            Orders.add(new Order(O.getO_id(), O.getC_id()));
        }
        for (Order O2 : Orders) {
            tots.add(O.getTotal(O2.getO_id()));
        }
        for (Order O2 : Orders) {
            Fnames.add(O.getCname(O2.getC_id()));
        }
        for (Order O2 : Orders) {
            Fnums.add(O.getCnum(O2.getC_id()));
        }
        System.out.println(Fnums);
        for (int i = 0; i < Orders.size(); i++) {
            D.add(new CustomDTO(Fnames.get(i), Fnums.get(i), tots.get(i)));
        }
        return D;
    }

    @Override
    public ArrayList<OrderDetailsDTO> getOrderdetails(Integer Pnum) throws ClassNotFoundException, SQLException {
        String cid = O.getCid(Pnum);
        String oid = O.getOID(cid);
        ArrayList<OrderDetails> orderdelist = O.getOrderdetails(oid);
        ArrayList<OrderDetailsDTO> orderdDTO = new ArrayList<>();
        for (OrderDetails OD : orderdelist) {
            String Fname = I.getFName(OD.getI_code());
            orderdDTO.add(new OrderDetailsDTO(Fname, OD.getQty()));
        }
        return orderdDTO;
    }

}
