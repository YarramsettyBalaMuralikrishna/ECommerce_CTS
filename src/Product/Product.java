package Product;

public class Product {
    private int productID;
    private  double price;
    private  String productName, description, imageUrl, reviews;
    public Product(int productID, double price, String productName,String description,
                          String imageUrl, String reviews){
        this.productID = productID;
        this.price = price;
        this.productName = productName;
        this.description= description;
        this.productName= productName;
        this.imageUrl= imageUrl;
        this.reviews = reviews;
    }
    public int getProductID() {return productID; }
    public String getImageUrl() {return imageUrl; }
    public String getProductName() {return productName; }
    public double getPrice() {return price;}
    public String getDescription(){ return  description;}
    public String getReviews(){return reviews;}

    // setters implementation ..........
}
