package order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import  utils.DBConnection;

public class AddOrders implements  orderService{

    private List<Order> AllOrders;
    static int cnt = 0;
    public AddOrders(){
        this.AllOrders = new ArrayList<>();
    }
    @Override
    public void addOrder(Order order){
        AllOrders.add(order);
        try{
            PreparedStatement orderStatement = getPreparedStatementWithOrder(order); // learn abt these and how to write them
            orderStatement.setDate(4, order.getOrderDate());

            int result = orderStatement.executeUpdate();
            if(result == 1){
                System.out.println("Order updated successfully");
                for (OrderedItem prodDetails: order.getOrderedProducts()){
                    cnt++;
                    int res = getRes(order, prodDetails);
                    if(res == 1){
                        System.out.println("Updated successfully");
                    }
                }
            }else{
                System.out.println(" ONly a HaCkEr SeeS tHiS MsG");
            }
        } catch (java.lang.Exception e) {
            throw new RuntimeException(e);
        }
        // write queries for printing each order and updating in db
    }

    private static int getRes(Order order, OrderedItem prodDetails) throws Exception {
        PreparedStatement detailedStatement = getPreparedStatement1();
        detailedStatement.setInt(1, cnt);
        detailedStatement.setInt(2, order.getOrderID());
        detailedStatement.setInt(3, prodDetails.getItemID());
        detailedStatement.setInt(4, prodDetails.getQuantity());
        detailedStatement.setDouble(5, prodDetails.getPrice());
        detailedStatement.setString(6, prodDetails.getItemName());
        return detailedStatement.executeUpdate();
    }

    private static PreparedStatement getPreparedStatement1() throws Exception{
        String addOrderDetails = "insert into orderdetails(orderItemID, orderID, productID, quantity, unitPrice, productName) values(?,?,?,?,?,?)";
        Connection con = DBConnection.getConnection();
        return con.prepareStatement(addOrderDetails);
    }

    private static PreparedStatement getPreparedStatementWithOrder(Order order) throws Exception {
        String addOrderQuery = "insert into orders(orderID, totalAmount, userID, orderDate) values(?,?,?,?)";
        Connection con = DBConnection.getConnection();
        PreparedStatement orderStatement = con.prepareStatement(addOrderQuery);
        orderStatement.setInt(1, order.getOrderID());
        orderStatement.setDouble(2, order.getTotalAmount());
        orderStatement.setString(3, order.getUserID());
        return orderStatement;
    }

//    @Override   --------------------------not useful now
//    public void getAllOrdersWithProducts() {
//        for (Order iterator: AllOrders){
//            System.out.println(" userID "+ iterator.getUserID()+ " orderID "+ iterator.getOrderID());
//            System.out.println(" Product details ");
//            for (int[] items: iterator.getOrderedProducts()){
//                System.out.println(items[0] + " "+ items[1]+" "+ items[2]);
//            }
//        }
//    }

    @Override
    public void displayOrders(String userID){
        try {
            PreparedStatement displayPrepareStatement = getDisplayOrderPreparedStatement();
            displayPrepareStatement.setString(1,userID);
            ResultSet res = displayPrepareStatement.executeQuery();
            // for fetching products in that order
            PreparedStatement displayProductPrepareStatement = getDisplayProductPreparedStatement();
            while (res.next()){
                System.out.println("Your Order Details");
                System.out.println("Total Cost: "+res.getDouble(2));
                System.out.println("Ordered Date: "+res.getDate("orderDate"));
                int orderId = res.getInt(1);
                displayProductPrepareStatement.setInt(1,orderId);
                ResultSet result = displayProductPrepareStatement.executeQuery();
                System.out.println("Product Details");
                int orderCount = 1;
                while (result.next()){
                    System.out.println("Order Number: "+ orderCount++);
                    System.out.println("Product Name: "+result.getString(6)+ "||  "+"quantity: "+result.getInt(4)+"||  unitPrice: "+result.getInt(5) );
//                    System.out.println(result.getString(6)+"     "+result.getInt(4)+"    "+result.getInt(5));
                }
            }
        } catch (java.lang.Exception e) {
            throw new RuntimeException(e);
        }
        for (Order iterator: AllOrders){
            if(iterator.getUserID().equals(userID)){
                System.out.println(iterator.getUserID()+" "+iterator.getOrderID()+ " "+iterator.getOrderDate()+" " +
                        " "+iterator.getTotalAmount());
            }
        }
    }
    private static PreparedStatement getDisplayOrderPreparedStatement() throws Exception{
        final String query = "select * from orders where userID = ?";
        Connection con = DBConnection.getConnection();
        return con.prepareStatement(query);
    }

    private static  PreparedStatement getDisplayProductPreparedStatement() throws Exception{
        final String query = "select * from orderDetails where orderId = ?";
        Connection con = DBConnection.getConnection();
        return con.prepareStatement(query);
    }
}
