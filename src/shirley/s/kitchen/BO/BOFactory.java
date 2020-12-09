package shirley.s.kitchen.BO;

import shirley.s.kitchen.BO.impl.CustomerBOimple;
import shirley.s.kitchen.BO.impl.ItemBOimpl;
import shirley.s.kitchen.BO.impl.OrderBOimpl;

public class BOFactory {
    private static BOFactory bOFactory;

    public BOFactory() {
    }
    
    public static BOFactory getInstance(){
        if (bOFactory==null) {
            bOFactory=new BOFactory();
        }
        return bOFactory;
    }
    
    public enum BOTypes{
        CUSTOMER,ORDER,ITEM
    }
    
    public SuperBO getBO(BOTypes types){
        switch(types){
            case CUSTOMER:
                return new CustomerBOimple();
            case ORDER:
                return new OrderBOimpl();
            case ITEM:
                return new ItemBOimpl();
            default:
                return null;
        }
    }
    
}
