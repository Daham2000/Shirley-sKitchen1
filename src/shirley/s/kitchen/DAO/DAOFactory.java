package shirley.s.kitchen.DAO;

import shirley.s.kitchen.DAO.impl.CustomerDAOimpl;
import shirley.s.kitchen.DAO.impl.ItemDAOimpl;
import shirley.s.kitchen.DAO.impl.OrderDAOimpl;

public class DAOFactory {

    private static DAOFactory dAOFactory;

    private DAOFactory() {

    }

    public static DAOFactory getInstance() {
        if (dAOFactory == null) {
            dAOFactory = new DAOFactory();
        }
        return dAOFactory;
    }

    public enum DAOTypes {
        CUSTOMER, ITEM, SUPLY, ORDERS, ORDERDETAILS, QUERYDAO;
    }

    public SuperDAO getDAO(DAOTypes types) {
        switch (types) {
            case CUSTOMER:
                return new CustomerDAOimpl();
            case ITEM:
                return new ItemDAOimpl();
//            case SUPLY:
//                return new SuplyDAOImpl();
            case ORDERS:
                return new OrderDAOimpl();
//            case ORDERDETAILS:
//                //return new OrderDetailsDAOImpl();
//            case QUERYDAO:
//                //return new QueryDAOImpl();
            default:
                return null;
        }
    }
    
}
