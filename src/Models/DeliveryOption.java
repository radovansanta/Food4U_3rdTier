package Models;

public class DeliveryOption {
    private int deliveryID;
    private String deliveryName;
    private double price;

    public DeliveryOption(){}

    public DeliveryOption(int deliveryID, String deliveryName, double price){
        this.deliveryID = deliveryID;
        this.deliveryName = deliveryName;
        this.price = price;
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

    public void setDeliveryID(int deliveryID) {
        this.deliveryID = deliveryID;
    }

    public void setDeliveryName(String deliveryName) {
        this.deliveryName = deliveryName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "DeliveryOption{" +
                "deliveryID=" + deliveryID +
                ", deliveryName='" + deliveryName + '\'' +
                ", price=" + price +
                '}';
    }
}
