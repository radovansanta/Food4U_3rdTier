package Models;

public class Driver extends User{

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String address;
    private String licenseNumber;


    public Driver(){
        super(null,null);
        firstName= null;
        lastName = null;
        phoneNumber = null;
        email = null;
        address = null;
        licenseNumber = null;
    }

    public Driver(String username, String password,String firstName, String lastName, String phoneNumber, String email, String address, String licenseNumber) {

        super(username, password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.licenseNumber = licenseNumber;
    }

    @Override
    public void setUsername(String username) {super.setUsername(username);}

    @Override
    public void setPassword(String password) {super.setPassword(password);}

    public void setFirstName(String firstName) {this.firstName = firstName;}

    public void setLastName(String lastName) {this.lastName = lastName;}

    public void setEmail(String email) {this.email = email;}

    public void setAddress(String address) {this.address = address;}

    public void setLicenseNumber(String licenseNumber) {this.licenseNumber = licenseNumber;}

    public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}

    public String getEmail() {return email;}

    public String getAddress() {return address;}

    @Override
    public String getUsername() {return super.getUsername();}

    @Override
    public String getPassword() {return super.getPassword();}

    public String getFirstName() {return firstName;}

    public String getLastName() {return lastName;}

    public String getLicenseNumber() {return licenseNumber;}

    public String getPhoneNumber() {return phoneNumber;}

    @Override
    public String toString() {
        return "Driver{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", licenseNumber='" + licenseNumber + '\'' +
                '}';
    }
}
