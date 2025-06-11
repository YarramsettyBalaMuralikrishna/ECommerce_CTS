package User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import  java.util.ArrayList;

import utils.DBConnection;

public class UserDetails implements UserService {
    private List<User> allUsers;
    public UserDetails(){
        this.allUsers = new ArrayList<>();
    }
    // using array now changed fetching from DB
//    private void checkUser(User newUser) throws Exception {
//        String newUserEmail = newUser.getEmail();
//        for(User u: allUsers){
//            String curEmail = u.getEmail();
//            if(curEmail.equals(newUserEmail)){
//                throw new Exception("user already exists");
//            }
//        }
//    }
    public void addUser(User user){
        try{
            PreparedStatement CheckUser = getPreparedStatementCheckUser();
            CheckUser.setString(1,user.getEmail());
            ResultSet res = CheckUser.executeQuery();
            if(!res.next()){
                try{
                    PreparedStatement preAddUser = getPreparedStatementADDUser();
                    preAddUser.setString(1,user.getAge()+user.getFirstName());
                    preAddUser.setString(2,user.getEmail());
                    preAddUser.setInt(3,user.getMobile());
                    preAddUser.setString(4, user.getFirstName());
                    preAddUser.setString(5, user.getLastName());
                    preAddUser.setInt(6,user.getAge());
                    preAddUser.setString(7, user.getAddress());
                    int executed = preAddUser.executeUpdate();
                    if(executed == 1){
                        System.out.println("user added successfully");
                    }else{
                        throw new RuntimeException(" Something went wrong");
                    }
                }catch (RuntimeException e){
                    throw new RuntimeException(" Something went wrong");
                }

            }else{
                throw new Exception(" User already exists");
            }
        } catch (java.lang.Exception e) {
            throw new RuntimeException(e);
        }
//        try{
//            checkUser(user);
//            allUsers.add(user);
//            System.out.println(" user Created successfully ");
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//        finally {
//            System.out.println(" Done ");
//        }
    }
    private static PreparedStatement getPreparedStatementCheckUser() throws  Exception{
        String query = "select email from userDetails where email = ?";
        Connection con = DBConnection.getConnection();
        return  con.prepareStatement(query);
    }
    private static PreparedStatement getPreparedStatementADDUser() throws  Exception{
        String query = "insert into userDetails(userID, email, mobile, firstName, lastName, age, address) values(?,?,?,?,?,?,?)";
        Connection con = DBConnection.getConnection();
        return con.prepareStatement(query);
    }

    public void printAllUsers(){
        try{
            PreparedStatement prest = getPreparedStatementAllUsers();
            ResultSet res = prest.executeQuery();
            while(res.next()){
                System.out.println("User ID: "+res.getString(1)+" email: "+res.getString(2)+" mobileNumber: "+res.getInt(3)+
                        " Full Name:"+res.getString(4)+" "+res.getString(5)+" age:"+res.getInt(6)+" address: "+res.getString(7));
            }
        } catch (java.lang.Exception e){
            throw  new RuntimeException(e);
        }
        for( User user:allUsers){
            System.out.println(user.getEmail()+" "+user.getFullName()+" "+user.getAge()+" "+
                    user.getMobile()+" "+user.getAddress());
        }
    }
    private static PreparedStatement getPreparedStatementAllUsers() throws Exception{
        String query = "select * from userDetails";
        Connection con = DBConnection.getConnection();
        return con.prepareStatement(query);
    }
    // update userDetails
    // delete user by their email
}
