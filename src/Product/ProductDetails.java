package Product;
import utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class ProductDetails implements ProductService{
    private List<Product> allProducts;
    public ProductDetails(){
        this.allProducts = new ArrayList<>();
    }
    @Override
    public  void addProduct(Product product)
    {
        System.out.println(" hello product "+ product.getProductName());
        final String addProductQuery = "insert into productdetails (productID,productName,productPrice,productDescription,imageUrl,reviews) values(?,?,?,?,?,?)   ";
        try{
            Connection con = DBConnection.getConnection();
            PreparedStatement addProductIntoDB = con.prepareStatement(addProductQuery);
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
                    System.out.println(e);
        }



//        allProducts.add(product);
    }
    @Override
    public  void getAllProducts(){
        final String getALLProducts = "select * from productdetails";
        try{
            Connection con = DBConnection.getConnection();
            Statement getALLProd = con.createStatement();
            ResultSet res = getALLProd.executeQuery(getALLProducts);
            while (res.next()){
                System.out.println(
                        res.getInt(1)+" "+ res.getString(2)+" "+res.getDouble(3)+" "+
                                res.getString(4)+" "+
                                res.getString(6)
                );
            }res.close();con.close();

        }
        catch (java.lang.Exception e){
            System.out.println(e);
        }

    }
}
