import Product.Product;
import Product.ProductDetails;
import User.User;
import User.UserDetails;
import order.AddOrders;
import order.Order;
import order.OrderedItem;
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
        List<OrderedItem> receivedItems = new ArrayList<>();
        // prodID, quantity, unitCost, prodName
//        String date = "08-06-2025";
//        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
//        Date utilDate = sdf.parse(date);
//        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
//        receivedItems.add(new OrderedItem(100, 4, 84.59,"apple"));
//        receivedItems.add(new OrderedItem(101, 12, 16.02,"apple"));
//        receivedItems.add(new OrderedItem(17, 1, 7999,"vrHeadset"));
//        AddOrders placeOrder = new AddOrders();
//        placeOrder.addOrder(new Order(1,"24dfst",sqlDate, receivedItems));
//        receivedItems.clear();
//        receivedItems.add(new OrderedItem(1, 4, 1499.99,"bluetooth Speaker"));
//        receivedItems.add(new OrderedItem(5, 12, 89.99,"usb cable"));
//        receivedItems.add(new OrderedItem(8, 1, 1199,"powerBank"));
//        placeOrder.addOrder(new Order(2,"sdfgh45",sqlDate, receivedItems));
//        AddOrders adorr = new AddOrders();
//        adorr.displayOrders("sdfgh45");
//
//        placeOrder.getAllOrdersWithProducts();
//        placeOrder.displayOrders("178");
//        ------cart---------------
//        ProductDetails productDetails = new ProductDetails();
//        productDetails.addProduct(new Product(101,16.02,"banana","tasty banana","httpd://banana.jpeg","very good quality" ));
//        productDetails.getProductByID(101);
//        productDetails.getAllProducts();
//        ----user
        UserDetails user = new UserDetails();
        user.addUser(new User(65,5,"bala","murali","ancd asdsd","bunty@gmail.com"));

    }
}