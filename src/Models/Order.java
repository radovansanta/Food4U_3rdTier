package Models;

public class Order {

    private String comment;
    private String address;
    private  double price;
    private String date;

    public Order(){
       comment= null;
       address= null;
       price= 0;
       date = null;
    }
    public Order(String comment,String address, double price, String date){
        this.comment = comment;
        this.address = address;
        this.price = price;
        this.date = date;
    }

    public void setAddress(String address) {this.address = address;}

    public void setComment(String comment) {this.comment = comment;}

    public void setDate(String date) {this.date = date;}

    public void setPrice(double price) {this.price = price;}

    public String getAddress() {return address;}

    public double getPrice() {return price;}

    public String getComment() {return comment;}

    public String getDate() {return date;}
}
