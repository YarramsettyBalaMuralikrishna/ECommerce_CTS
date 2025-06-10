import Product.Product;
import Product.ProductDetails;
import order.AddOrders;
import order.Order;
import utils.DBConnection;

import java.util.ArrayList;
import java.util.List;
import  java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) throws  Exception {
        List<int[]> receivedItems = new ArrayList<>();
        // prodID, quantity, unitCost
        String date = "08-06-2025";
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
        Date utilDate = sdf.parse(date);
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        receivedItems.add(new int[] {100, 2, 123});
        receivedItems.add(new int[] {7, 3, 789});
        receivedItems.add(new int[] {10, 1, 4560});
        AddOrders placeOrder = new AddOrders();
        placeOrder.addOrder(new Order(1,"24dfst",sqlDate, receivedItems));
        receivedItems.clear();
        receivedItems.add(new int[] {1, 5, 12});
        receivedItems.add(new int[] {5, 4, 79});
        receivedItems.add(new int[] {8, 3, 450});
        placeOrder.addOrder(new Order(2,"sdfgh45",sqlDate, receivedItems));

        placeOrder.getAllOrdersWithProducts();
        placeOrder.displayOrders("178");
//        ------cart---------------

    }
}