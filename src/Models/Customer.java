package Models;

public class Customer extends User{

    private String first_name;
    private String last_name;
    private String phone_number;
    private String email;
    private String address;


    public Customer(){
        super(null,null);
        first_name= null;
        last_name = null;
        phone_number = null;
        email = null;
        address = null;
    }

    public Customer(String username, String password, String first_name, String last_name, String phone_number, String address, String email) {
        super(username, password);
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone_number = phone_number;
        this.email = email;
        this.address = address;
    }

    public String getAddress() {return address;}

    public String getFirst_name() {return first_name;}

    public String getLast_name() {return last_name;}

    public String getEmail() {return email;}

    public String getPhone_number() {return phone_number;}

    public void setFirst_name(String first_name) {this.first_name = first_name;}

    public void setLast_name(String last_name) {this.last_name = last_name;}

    public void setAddress(String address) {this.address = address;}

    public void setEmail(String email) {this.email = email;}

    public void setPhone_number(String phone_number) {this.phone_number = phone_number;}

    @Override
    public String toString() {
        return "Customer{" +
                "first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
