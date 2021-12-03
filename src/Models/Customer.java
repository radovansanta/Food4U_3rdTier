package Models;

public class Customer extends User{

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String address;


    public Customer(){
        super(null,null);
        firstName= null;
        lastName = null;
        phoneNumber = null;
        email = null;
        address = null;
    }

    public Customer(String username, String password, String firstName, String lastName, String phoneNumber, String address, String email) {
        super(username, password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    public String getAddress() {return address;}

    public String getFirstName() {return firstName;}

    public String getLastName() {return lastName;}

    public String getEmail() {return email;}

    public String getPhoneNumber() {return phoneNumber;}

    public void setFirstName(String firstName) {this.firstName = firstName;}

    public void setLastName(String lastName) {this.lastName = lastName;}

    public void setAddress(String address) {this.address = address;}

    public void setEmail(String email) {this.email = email;}

    public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
