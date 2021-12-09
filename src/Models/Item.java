package Models;

public class Item {
    private int itemID;
    private String name;
    private String description;
    private double price;
    private int categoryId;
    private int discount;

    public Item(){
        itemID = 0;
        name = null;
        description = null;
        price = 0;
        categoryId = 0;
        discount = 0;
    }

    public Item(int itemID, String name, String description, double price, int categoryId, int discount)
    {
        this.itemID = itemID;
        this.name = name;
        this.description = description;
        this.price = price;
        this.categoryId = categoryId;
        this.discount = discount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setDiscount ( int discount) {this.discount = discount;}

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public int getItemID() {
        return itemID;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public int getDiscount() {return discount;}

    @Override
    public String toString() {
        return "Item{" +
                "itemID=" + itemID +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", categoryId='" + categoryId + '\'' +
                ", discount='" + discount + '\'' +
                '}';
    }
}

