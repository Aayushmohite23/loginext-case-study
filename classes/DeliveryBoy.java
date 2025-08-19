package classes;
public class DeliveryBoy {
    public int id;
    public int freeTime;
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DeliveryBoy(int id,int freeTime){
        this.id= id;
        this.freeTime=freeTime;
    }
}
