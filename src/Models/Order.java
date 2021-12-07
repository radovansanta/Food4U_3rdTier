package Models;

public class Order {

    private int orderID;
    private String comment;
    private String address;
    private double price;
    private String date;
    private String status;
    private String customerUsername;
    private String restaurantUsername;
    private int deliveryID;

    public Order() {
        orderID = 0;
        comment = null;
        address = null;
        price = 0;
        date = null;
        status = null;
        customerUsername = null;
        restaurantUsername = null;
        deliveryID = 0;
    }

    public Order(int orderID, String comment, String address, double price, String date, String status,
                 String customerUsername, String restaurantUsername, int deliveryID) {
        this.orderID = orderID;
        this.comment = comment;
        this.address = address;
        this.price = price;
        this.date = date;
        this.status = status;
        this.customerUsername = customerUsername;
        this.restaurantUsername = restaurantUsername;
        this.deliveryID = deliveryID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDeliveryID(int deliveryID) {
        this.deliveryID = deliveryID;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCustomerUsername(String customerUsername) {
        this.customerUsername = customerUsername;
    }

    public void setRestaurantUsername(String restaurantUsername) {
        this.restaurantUsername = restaurantUsername;
    }

    public int getOrderID() {
        return orderID;
    }

    public String getAddress() {
        return address;
    }

    public double getPrice() {
        return price;
    }

    public String getComment() {
        return comment;
    }

    public String getDate() {
        return date;
    }

    public String getCustomerUsername() {
        return customerUsername;
    }

    public int getDeliveryID() {
        return deliveryID;
    }

    public String getRestaurantUsername() {
        return restaurantUsername;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", comment='" + comment + '\'' +
                ", address='" + address + '\'' +
                ", price=" + price +
                ", date='" + date + '\'' +
                ", status='" + status + '\'' +
                ", customerUsername='" + customerUsername + '\'' +
                ", restaurantUsername='" + restaurantUsername + '\'' +
                ", deliveryID=" + deliveryID +
                '}';
    }
}
