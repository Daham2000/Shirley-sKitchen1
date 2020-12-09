package shirley.s.kitchen.Entity;

public class Payment {

    private String Pay_time;
    private double Total;
    private String P_status;
    private String O_id;

    public Payment() {
    }

    public Payment(String Pay_time, double Total, String P_status, String O_id) {
        this.Pay_time = Pay_time;
        this.Total = Total;
        this.P_status = P_status;
        this.O_id = O_id;
    }

    /**
     * @return the Pay_time
     */
    public String getPay_time() {
        return Pay_time;
    }

    /**
     * @param Pay_time the Pay_time to set
     */
    public void setPay_time(String Pay_time) {
        this.Pay_time = Pay_time;
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
     * @return the P_status
     */
    public String getP_status() {
        return P_status;
    }

    /**
     * @param P_status the P_status to set
     */
    public void setP_status(String P_status) {
        this.P_status = P_status;
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

}
