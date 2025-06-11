package order;

public class OrderedItem {
    private int ItemID, quantity;
    private double price;
    private String ItemName;
    public OrderedItem(int itemID, int quantity, double price, String ItemName){
        this.ItemID = itemID;
        this.quantity = quantity;
        this.price = price;
        this.ItemName = ItemName;
    }
    // getters
    public String getItemName() {
        return ItemName;
    }
    public int getItemID() {
        return ItemID;
    }
    public double getPrice() {
        return price;
    }
    public int getQuantity() {
        return quantity;
    }
    // setters
    public void setItemID(int itemID) {
        ItemID = itemID;
    }
    public void setItemName(String itemName) {
        ItemName = itemName;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
