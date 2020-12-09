package shirley.s.kitchen.DTO;

public class OrderDetailsDTO {

    private String O_id;
    private String I_code;
    private int Qty;
    private double I_total;

    public OrderDetailsDTO() {
    }
    
    public OrderDetailsDTO(String I_code, int Qty) {
        this.I_code = I_code;
        this.Qty = Qty;
    }

    public OrderDetailsDTO(String O_id, String I_code, int Qty, double I_total) {
        this.O_id = O_id;
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
}
