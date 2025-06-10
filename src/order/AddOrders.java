package order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
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
            PreparedStatement orderStatement = getPreparedStatement(order); // learn abt these and how to write them
            orderStatement.setDate(4, order.getOrderDate());

            int result = orderStatement.executeUpdate();
            if(result == 1){
                System.out.println("Updated successfully");
                for (int[] prodDetails: order.getOrderedProducts()){
                    cnt++;
                    PreparedStatement detailedStatement = getPreparedStatement1();
                    detailedStatement.setInt(1, cnt);
                    detailedStatement.setInt(2, order.getOrderID());
                    detailedStatement.setInt(3, prodDetails[0]);
                    detailedStatement.setInt(4, prodDetails[1]);
                    detailedStatement.setInt(5, prodDetails[2]);
                    int res = detailedStatement.executeUpdate();
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
    private static PreparedStatement getPreparedStatement1() throws Exception{
        String addOrderDetails = "insert into orderdetails(orderItemID, orderID, productID, quantity, unitPrice) values(?,?,?,?,?)";
        Connection con = DBConnection.getConnection();
        return con.prepareStatement(addOrderDetails);
    }
    private static PreparedStatement getPreparedStatement(Order order) throws Exception {
        String addOrderQuery = "insert into orders(orderID, totalAmount, userID, orderDate) values(?,?,?,?)";
        Connection con = DBConnection.getConnection();
        PreparedStatement orderStatement = con.prepareStatement(addOrderQuery);
        orderStatement.setInt(1, order.getOrderID());
        orderStatement.setDouble(2, order.getTotalAmount());
        orderStatement.setString(3, order.getUserID());
        return orderStatement;
    }

    @Override
    public void getAllOrdersWithProducts() {
        for (Order iterator: AllOrders){
            System.out.println(" userID "+ iterator.getUserID()+ " orderID "+ iterator.getOrderID());
            System.out.println(" Product details ");
            for (int[] items: iterator.getOrderedProducts()){
                System.out.println(items[0] + " "+ items[1]+" "+ items[2]);
            }
        }
    }
    @Override
    public void displayOrders(String userID){
        for (Order iterator: AllOrders){
            if(iterator.getUserID().equals(userID)){
                System.out.println(iterator.getUserID()+" "+iterator.getOrderID()+ " "+iterator.getOrderDate()+" " +
                        " "+iterator.getTotalAmount());
            }
        }
    }
}
