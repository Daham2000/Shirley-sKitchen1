package shirley.s.kitchen.DTO;

public class CustomDTO {

    private String O_id;
    private String Order_date;
    private String C_id;
    private String I_code;
    private int Qty;
    private double I_total;
    private String C_name;
    private int num;

    public CustomDTO() {
    }
    
    public CustomDTO(String C_name, int num, double I_total) {
        this.I_total = I_total;
        this.num=num;
        this.C_name=C_name;
    }

    public CustomDTO(String O_id, String Order_date, String C_id, String I_code, int Qty, double I_total) {
        this.O_id = O_id;
        this.Order_date = Order_date;
        this.C_id = C_id;
        this.I_code = I_code;
        this.Qty = Qty;
        this.I_total = I_total;
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

    /**
     * @return the I_code
     */
    public String getI_code() {
        return I_code;
    }

    /**
     * @param I_code the I_code to set
     */
    public void setI_code(String I_code) {
        this.I_code = I_code;
    }

    /**
     * @return the Qty
     */
    public int getQty() {
        return Qty;
    }

    /**
     * @param Qty the Qty to set
     */
    public void setQty(int Qty) {
        this.Qty = Qty;
    }

    /**
     * @return the I_total
     */
    public double getI_total() {
        return I_total;
    }

    /**
     * @param I_total the I_total to set
     */
    public void setI_total(double I_total) {
        this.I_total = I_total;
    }

    /**
     * @return the C_name
     */
    public String getC_name() {
        return C_name;
    }

    /**
     * @param C_name the C_name to set
     */
    public void setC_name(String C_name) {
        this.C_name = C_name;
    }

    /**
     * @return the num
     */
    public int getNum() {
        return num;
    }

    /**
     * @param num the num to set
     */
    public void setNum(int num) {
        this.num = num;
    }

}
