package Models;

public class Restaurant extends User {
    private int restaurantID;
    private String name;
    private String address;
    private String phoneNumber;
    private String openingHoursMonday;
    private String openingHoursTuesday;
    private String openingHoursWednesday;
    private String openingHoursThursday;
    private String openingHoursFriday;
    private String openingHoursSaturday;
    private String openingHoursSunday;
    private String description;
    private DeliveryOption deliveryOption1;
    private DeliveryOption deliveryOption2;
    private Menu menu;


    public Restaurant(int restaurantID, String name, String address, String phoneNumber, String monday,
                      String tuesday, String wednesday, String thursday, String friday, String saturday, String sunday,
                      String description, DeliveryOption deliveryOption1, DeliveryOption deliveryOption2) {
        this.restaurantID = restaurantID;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.openingHoursMonday = monday;
        this.openingHoursTuesday = tuesday;
        this.openingHoursWednesday = wednesday;
        this.openingHoursThursday = thursday;
        this.openingHoursFriday = friday;
        this.openingHoursSaturday = saturday;
        this.openingHoursSunday = sunday;
        this.description = description;
        this.deliveryOption1 = deliveryOption1;
        this.deliveryOption2 = deliveryOption2;
    }

    public Restaurant(String name, String address, String phoneNumber, String openingHoursMonday,
                      String openingHoursTuesday, String openingHoursWednesday, String openingHoursThursday,
                      String openingHoursFriday, String openingHoursSaturday, String openingHoursSunday,
                      String description, DeliveryOption deliveryOption1, DeliveryOption deliveryOption2) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.openingHoursMonday = openingHoursMonday;
        this.openingHoursTuesday = openingHoursTuesday;
        this.openingHoursWednesday = openingHoursWednesday;
        this.openingHoursThursday = openingHoursThursday;
        this.openingHoursFriday = openingHoursFriday;
        this.openingHoursSaturday = openingHoursSaturday;
        this.openingHoursSunday = openingHoursSunday;
        this.description = description;
        this.deliveryOption1 = deliveryOption1;
        this.deliveryOption2 = deliveryOption2;
    }

    public Restaurant() {
    }

    public int getRestaurantID() {
        return restaurantID;
    }

    public DeliveryOption getDeliveryOption1() {
        return deliveryOption1;
    }

    public DeliveryOption getDeliveryOption2() {
        return deliveryOption2;
    }

    public String getOpeningHoursMonday() {
        return openingHoursMonday;
    }

    public String getOpeningHoursTuesday() {
        return openingHoursTuesday;
    }

    public String getOpeningHoursWednesday() {
        return openingHoursWednesday;
    }

    public String getOpeningHoursThursday() {
        return openingHoursThursday;
    }

    public String getOpeningHoursFriday() {
        return openingHoursFriday;
    }

    public String getOpeningHoursSaturday() {
        return openingHoursSaturday;
    }

    public String getOpeningHoursSunday() {
        return openingHoursSunday;
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

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setDeliveryOption1(DeliveryOption deliveryOption1) {
        this.deliveryOption1 = deliveryOption1;
    }

    public void setDeliveryOption2(DeliveryOption deliveryOption2) {
        this.deliveryOption2 = deliveryOption2;
    }

    public void setOpeningHoursMonday(String openingHoursMonday) {
        this.openingHoursMonday = openingHoursMonday;
    }

    public void setOpeningHoursTuesday(String openingHoursTuesday) {
        this.openingHoursTuesday = openingHoursTuesday;
    }

    public void setOpeningHoursWednesday(String openingHoursWednesday) {
        this.openingHoursWednesday = openingHoursWednesday;
    }

    public void setOpeningHoursThursday(String openingHoursThursday) {
        this.openingHoursThursday = openingHoursThursday;
    }

    public void setOpeningHoursFriday(String openingHoursFriday) {
        this.openingHoursFriday = openingHoursFriday;
    }

    public void setOpeningHoursSaturday(String openingHoursSaturday) {
        this.openingHoursSaturday = openingHoursSaturday;
    }

    public void setOpeningHoursSunday(String openingHoursSunday) {
        this.openingHoursSunday = openingHoursSunday;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "restaurantID=" + restaurantID +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", openingHoursMonday='" + openingHoursMonday + '\'' +
                ", openingHoursTuesday='" + openingHoursTuesday + '\'' +
                ", openingHoursWednesday='" + openingHoursWednesday + '\'' +
                ", openingHoursThursday='" + openingHoursThursday + '\'' +
                ", openingHoursFriday='" + openingHoursFriday + '\'' +
                ", openingHoursSaturday='" + openingHoursSaturday + '\'' +
                ", openingHoursSunday='" + openingHoursSunday + '\'' +
                ", description='" + description + '\'' +
                ", deliveryOption1=" + deliveryOption1 +
                ", deliveryOption2=" + deliveryOption2 +
                '}';
    }
}
