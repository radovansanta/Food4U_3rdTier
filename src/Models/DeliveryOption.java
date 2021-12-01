package Models;

public class DeliveryOption {
    private int deliveryID;
    private String deliveryName;
    private double price;
    private String username;

    public DeliveryOption(){
        deliveryID = 0;
        deliveryName = null;
        price = 0;
        username = null;
    }

    public DeliveryOption(int deliveryID, String deliveryName, double price, String username){
        this.deliveryID = deliveryID;
        this.deliveryName = deliveryName;
        this.price = price;
        this.username = username;
    }

    public DeliveryOption(String deliveryName, double price){
        this.deliveryName = deliveryName;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public int getDeliveryID() {
        return deliveryID;
    }

    public String getDeliveryName() {
        return deliveryName;
    }

    public String getUsername() {
        return username;
    }

    public void setDeliveryID(int deliveryID) {
        this.deliveryID = deliveryID;
    }

    public void setDeliveryName(String deliveryName) {
        this.deliveryName = deliveryName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "DeliveryOption{" +
                "deliveryID=" + deliveryID +
                ", deliveryName='" + deliveryName + '\'' +
                ", price=" + price +
                ", username='" + username + '\'' +
                '}';
    }
}
