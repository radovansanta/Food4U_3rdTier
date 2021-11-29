package Models;

public class Item {
    private int itemID;
    private String name;
    private String description;
    private double price;

    public Item(int itemID, String name, String description, double price)
    {
        this.itemID = itemID;
        this.name = name;
        this.description = description;
        this.price = price;
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

    @Override
    public String toString() {
        return "Item{" +
                "itemID=" + itemID +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}

