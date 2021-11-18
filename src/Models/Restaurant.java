package Models;

public class Restaurant {
    private int restaurantID;
    private String name;
    private String address;
    private String phoneNumber;
    private String openingHours;
    private String description;

    public Restaurant(int restaurantID, String name, String address, String phoneNumber, String openingHours, String description){
        this.restaurantID=restaurantID;
        this.name=name;
        this.address=address;
        this.phoneNumber=phoneNumber;
        this.openingHours=openingHours;
        this.description=description;
    }

    public Restaurant(){}

    public int getRestaurantID() {
        return restaurantID;
    }

    public String getAddress() {
        return address;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public String getOpeningHours() {
        return openingHours;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRestaurantID(int restaurantID) {
        this.restaurantID = restaurantID;
    }

    public void setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "restaurantID=" + restaurantID +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", openingHours='" + openingHours + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
