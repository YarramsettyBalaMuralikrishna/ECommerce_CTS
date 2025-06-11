package order;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private int orderID;
    private double totalAmount;
    private String userID, orderItemID;
    private java.sql.Date orderDate;
    private List<OrderedItem> orderedItems = new ArrayList<>();
    public Order(int orderID, String userID, java.sql.Date orderDate, List<OrderedItem> receivedItems){
        this.orderID = orderID;
//        this.totalAmount = totalAmount;
        this.userID = userID;
        this.orderDate = orderDate;
//        this.orderItemID = orderItemID;
        this.orderedItems = receivedItems;
    }
    public int getOrderID(){return orderID;}
    public double getTotalAmount(){
        for(OrderedItem orr: orderedItems){
            int quantity = orr.getQuantity();
            double unitCost = orr.getPrice();
            totalAmount+=(quantity* unitCost);
        }
        return totalAmount;
    }
    public String getUserID(){return userID;}
    public java.sql.Date getOrderDate(){
        return orderDate;
    }
    public String getOrderItemID(){return orderItemID;}
    public List<OrderedItem> getOrderedProducts(){return orderedItems;}

}
