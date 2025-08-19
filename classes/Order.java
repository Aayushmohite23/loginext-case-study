package classes;
public class Order {
    //will have other basic order details like id, restaurant, payment type,etc 
    private int orderTime;                          //private as
    private int deliveryTime;                       //order privacy needs to be maintained for user within the system

    public int getOrderTime() {
        return orderTime;
    }
    public void setOrderTime(int orderTime) {
        this.orderTime = orderTime;
    }
    public int getDeliveryTime() {
        return deliveryTime;
    }
    public void setDeliveryTime(int deliveryTime) {
        this.deliveryTime = deliveryTime;
    }
}
