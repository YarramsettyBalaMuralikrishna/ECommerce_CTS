package order;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private int orderID;
    private double totalAmount;
    private String userID, orderItemID;
    private java.sql.Date orderDate;
    private List<int[]> orderedItems = new ArrayList<>();
    public Order(int orderID, String userID, java.sql.Date orderDate, List<int[]> receivedItems){
        this.orderID = orderID;
//        this.totalAmount = totalAmount;
        this.userID = userID;
        this.orderDate = orderDate;
//        this.orderItemID = orderItemID;
        this.orderedItems = receivedItems;
    }
    public int getOrderID(){return orderID;}
    public double getTotalAmount(){
        for(int[] i: orderedItems){
            int quantity = i[1];
            double unitCost = i[2];
            totalAmount+=(quantity* unitCost);
        }
        return totalAmount;
    }
    public String getUserID(){return userID;}
    public java.sql.Date getOrderDate(){
        return orderDate;
    }
    public String getOrderItemID(){return orderItemID;}
    public List<int[]> getOrderedProducts(){return orderedItems;}

}
