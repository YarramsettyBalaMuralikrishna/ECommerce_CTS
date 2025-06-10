package inClass;
// import sql package
import java.sql.*;
import java.util.Stack;

public class sqlConnect {
    public static  void  main(String[] args) throws  Exception{
        String url = "jdbc:mysql://localhost:3306/inclass", user = "root", password = "bala1618";



        // curd for customer
        String tableCreation = "create table customer( cName varchar(50) not null, cMobile varchar(20) not null , cEmail varchar(50) not null unique, primary key(cEmail)  )";
        String insertData = "INSERT INTO customer (cName, cMobile, cEmail) VALUES " +
                "('bala', '123213', 'bala@gmail.com'), " +
                "('murali', '454545', 'murali@gmail.com'), " +
                "('krishna', '1616161', 'krishna@gmail.com')";
        String updateData = "update `customer` set cMobile =  '16' where cEmail = 'bala@gmail.com'";
        String deleteData = "delete from customer where cEmail = 'murali@gmail.com'";
        String fetchDetails = "select * from customer";

        // load the driver
        Class.forName("com.mysql.jdbc.Driver");
        // establish connection
        Connection con = DriverManager.getConnection(url, user, password);
        // create statement
        Statement st = con.createStatement();
        // execute query
        st.execute(tableCreation);
        st.execute(insertData);
        ResultSet res = st.executeQuery(fetchDetails);
        while (res.next()){
                System.out.println("Name: " + res.getString(1));
                System.out.println("Mobile: " + res.getLong(2));
                System.out.println("Email: " + res.getString(3));
                System.out.println();
        }
        res.close();
        st.executeUpdate(updateData);
        res = st.executeQuery(fetchDetails);
        while (res.next()){
            System.out.println(" updated ");
            System.out.println("Name: " + res.getString(1));
            System.out.println("Mobile: " + res.getLong(2));
            System.out.println("Email: " + res.getString(3));
            System.out.println();
        }
        res.close();
        st.execute(deleteData);
        res = st.executeQuery(fetchDetails);
        while (res.next()){
            System.out.println(" deleted items");
            System.out.println("Name: " + res.getString(1));
            System.out.println("Mobile: " + res.getLong(2));
            System.out.println("Email: " + res.getString(3));
            System.out.println();
        }
        st.close();
        con.close();


//                query = "select * from user";
//        String insQuery = "insert into user(userName, mobile, email) values('srivalli', '123654' ,'srivalli@gmail.com')";
        // load the driver
//        Class.forName("com.mysql.jdbc.Driver");
//        // establish connection
//        Connection con = DriverManager.getConnection(url, user, password);
//        // create statement
//        Statement st = con.createStatement();
//        // execute query
//        int ins = st.executeUpdate(insQuery);
//        if(ins == 1){
//            System.out.println("resulted executed successfully");
//        }else{
//            System.out.println("error");
//        }
//        ResultSet res = st.executeQuery(query);
//
////         process the result
//         while(res.next()) {
//                System.out.println(res);
//                System.out.println("Name: " + res.getString(1));
//                System.out.println("Mobile: " + res.getLong(2));
//                System.out.println("Email: " + res.getString(3));
//                System.out.println();
//         }
//         st.close();
//         con.close();

    }
}