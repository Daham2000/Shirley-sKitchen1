package shirley.s.kitchen.Entity;

public class Item {

    private String I_code;
    private String I_name;
    private String M_date;
    private String Exp_date;
    private int Qtyonhand;
    private double UnitPrice;

    public Item() {
    }

    public Item(String I_name, int Qtyonhand, String M_date, String Exp_date) {
        this.I_name = I_name;
        this.Qtyonhand = Qtyonhand;
        this.M_date = M_date;
        this.Exp_date = Exp_date;
    }

    public Item(String I_code, String I_name, String M_date, String Exp_date, int Qtyonhand, double UnitPrice) {
        this.I_code = I_code;
        this.I_name = I_name;
        this.M_date = M_date;
        this.Exp_date = Exp_date;
        this.Qtyonhand = Qtyonhand;
        this.UnitPrice = UnitPrice;
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
     * @return the I_name
     */
    public String getI_name() {
        return I_name;
    }

    /**
     * @param I_name the I_name to set
     */
    public void setI_name(String I_name) {
        this.I_name = I_name;
    }

    /**
     * @return the M_date
     */
    public String getM_date() {
        return M_date;
    }

    /**
     * @param M_date the M_date to set
     */
    public void setM_date(String M_date) {
        this.M_date = M_date;
    }

    /**
     * @return the Exp_date
     */
    public String getExp_date() {
        return Exp_date;
    }

    /**
     * @param Exp_date the Exp_date to set
     */
    public void setExp_date(String Exp_date) {
        this.Exp_date = Exp_date;
    }

    /**
     * @return the Qtyonhand
     */
    public int getQtyonhand() {
        return Qtyonhand;
    }

    /**
     * @param Qtyonhand the Qtyonhand to set
     */
    public void setQtyonhand(int Qtyonhand) {
        this.Qtyonhand = Qtyonhand;
    }

    /**
     * @return the UnitPrice
     */
    public double getUnitPrice() {
        return UnitPrice;
    }

    /**
     * @param UnitPrice the UnitPrice to set
     */
    public void setUnitPrice(double UnitPrice) {
        this.UnitPrice = UnitPrice;
    }

}
