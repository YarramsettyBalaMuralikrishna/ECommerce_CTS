package order;

public interface orderService {
    void addOrder(Order order);
    void getAllOrdersWithProducts();
    void displayOrders(String userID);

}
