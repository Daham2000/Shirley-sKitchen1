package shirley.s.kitchen.DTO;

public class Cart {

    private String F_name;
    private int qty;
    private double I_total;
    private double Total;
    private int num;
    private String C_name;

    public Cart() {
    }
    
    public Cart(int num, double Tot) {
        this.num=num;
        this.Total=Tot;
    }

    public Cart(String F_name, int qty, double I_total) {
        this.F_name = F_name;
        this.qty = qty;
        this.I_total = I_total;
    }

    /**
     * @return the F_name
     */
    public String getF_name() {
        return F_name;
    }

    /**
     * @param F_name the F_name to set
     */
    public void setF_name(String F_name) {
        this.F_name = F_name;
    }

    /**
     * @return the qty
     */
    public int getQty() {
        return qty;
    }

    /**
     * @param qty the qty to set
     */
    public void setQty(int qty) {
        this.qty = qty;
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
     * @return the Total
     */
    public double getTotal() {
        return Total;
    }

    /**
     * @param Total the Total to set
     */
    public void setTotal(double Total) {
        this.Total = Total;
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
}
