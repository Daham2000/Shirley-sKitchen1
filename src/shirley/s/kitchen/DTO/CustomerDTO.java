package shirley.s.kitchen.DTO;

public class CustomerDTO {

    private String C_id;
    private String name;
    private int P_num;

    public CustomerDTO() {
    }
    
    public CustomerDTO(String name, String P_num) {
        this.name = name;
        this.P_num =Integer.parseInt(P_num);
    }

    public CustomerDTO(String C_id, String name, int P_num) {
        this.C_id = C_id;
        this.name = name;
        this.P_num = P_num;
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
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the P_num
     */
    public int getP_num() {
        return P_num;
    }

    /**
     * @param P_num the P_num to set
     */
    public void setP_num(int P_num) {
        this.P_num = P_num;
    }
}
