package Models;

public class Restaurant extends User {

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
    private boolean visibility;

    public Restaurant() {
        super(null, null);
        name = null;
        address = null;
        phoneNumber = null;
        openingHoursMonday = null;
        openingHoursTuesday = null;
        openingHoursWednesday = null;
        openingHoursThursday = null;
        openingHoursFriday = null;
        openingHoursSaturday = null;
        openingHoursSunday = null;
        description = null;
        deliveryOption1 = null;
        deliveryOption2 = null;
        menu = null;
        visibility = false;
    }

    public Restaurant(String username, String password, String name, String address, String phoneNumber,
                      String monday, String tuesday, String wednesday, String thursday, String friday, String saturday, String sunday,
                      String description, boolean visibility) {
        super(username, password);
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
        this.visibility = visibility;
    }

    public Menu getMenu() {
        return menu;
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

    public boolean getVisibility() {
        return visibility;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
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

    public void setVisibility(boolean visibility) {
        this.visibility = visibility;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Restaurant{" +
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
                ", menu=" + menu +
                ", visibility=" + visibility +
                '}';
    }
}
