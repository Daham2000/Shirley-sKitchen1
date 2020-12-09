package shirley.s.kitchen.DTO;

public class OrderDTO {

    private String O_id;
    private String Order_date;
    private String C_id;

    public OrderDTO() {
    }

    public OrderDTO(String O_id, String Order_date, String C_id) {
        this.O_id = O_id;
        this.Order_date = Order_date;
        this.C_id = C_id;
    }

    /**
     * @return the O_id
     */
    public String getO_id() {
        return O_id;
    }

    /**
     * @param O_id the O_id to set
     */
    public void setO_id(String O_id) {
        this.O_id = O_id;
    }

    /**
     * @return the Order_date
     */
    public String getOrder_date() {
        return Order_date;
    }

    /**
     * @param Order_date the Order_date to set
     */
    public void setOrder_date(String Order_date) {
        this.Order_date = Order_date;
    }

    /**
     * @return the C_id
     */
    public String getC_id() {
        return C_id;
    }

    /**
     * @param C_id the C_id to set
     */
    public void setC_id(String C_id) {
        this.C_id = C_id;
    }
}
