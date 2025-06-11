package Product;
import utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class ProductDetails implements ProductService{
    private List<Product> allProducts;
    public ProductDetails(){
        this.allProducts = new ArrayList<>();
    }
    // add products
    @Override
    public  void addProduct(Product product)
    {
        System.out.println(" hello product "+ product.getProductName());
        try{
            PreparedStatement addProductIntoDB = getAddProductPreparedStmt();
//            Connection con = DBConnection.getConnection();
//            PreparedStatement addProductIntoDB = con.prepareStatement(addProductQuery);
            addProductIntoDB.setInt(1, product.getProductID());
            addProductIntoDB.setString(2, product.getProductName());
            addProductIntoDB.setDouble(3, product.getPrice());
            addProductIntoDB.setString(4, product.getDescription());
            addProductIntoDB.setString(5, product.getImageUrl());
            addProductIntoDB.setString(6, product.getReviews());
            int result = addProductIntoDB.executeUpdate();
            if(result == 1){
                System.out.println(" product updated successfully ");
            }
        } catch (Exception e) {
                    throw new RuntimeException(e);
        }
//        allProducts.add(product);
    }
    private static PreparedStatement getAddProductPreparedStmt() throws Exception{
        final String addProductQuery = "insert into productdetails (productID,productName,productPrice,productDescription,imageUrl,reviews) values(?,?,?,?,?,?) ";
        Connection con = DBConnection.getConnection();
        return con.prepareStatement(addProductQuery);
    }

    @Override
    public  void getAllProducts(){

        try{
            PreparedStatement getProductStmt = getALLProductsSTMT();
//            Connection con = DBConnection.getConnection();
//            Statement getALLProd = con.createStatement();
            ResultSet res = getProductStmt.executeQuery();
            while (res.next()){
                System.out.println(
                        res.getInt(1)+" "+ res.getString(2)+" "+res.getDouble(3)+" "+
                                res.getString(4)+" "+
                                res.getString(6)
                );
            }
        }
        catch (java.lang.Exception e){
            System.out.println(e);
        }
    }
    private static PreparedStatement getALLProductsSTMT() throws Exception{
        final String getALLProducts = "select * from productdetails";
        Connection con = DBConnection.getConnection();
        return  con.prepareStatement(getALLProducts);
    }

    public void getProductByID(int prodID){
        try{
            PreparedStatement prodIDStmt = getPreparedStatement();
            prodIDStmt.setInt(1,prodID);
            ResultSet res = prodIDStmt.executeQuery();
            while(res.next()){
                System.out.println(res.getInt(1)+" "+res.getString(2)+" "+res.getDouble(3)+" "+res.getString(4));
            }
        } catch (java.lang.Exception e) {
            throw new RuntimeException(e);
        }
    }
    private static PreparedStatement getPreparedStatement() throws Exception{
        String prodIDQuery = "select * from productdetails where productID = ?";
        Connection con = DBConnection.getConnection();
        return con.prepareStatement(prodIDQuery);
    }
}
