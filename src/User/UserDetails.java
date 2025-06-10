package User;
import java.util.List;
import  java.util.ArrayList;

public class UserDetails implements UserService {
    private List<User> allUsers;
    public UserDetails(){
        this.allUsers = new ArrayList<>();
    }
    private void checkUser(User newUser) throws Exception {
        String newUserEmail = newUser.getEmail();
        for(User u: allUsers){
            String curEmail = u.getEmail();
            if(curEmail.equals(newUserEmail)){
                throw new Exception("user already exists");
            }
        }
    }
    public void addUser(User user){
        try{
            checkUser(user);
            allUsers.add(user);
            System.out.println(" user Created successfully ");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println(" Done ");
        }

    }
    public void printAllUsers(){
        for( User user:allUsers){
            System.out.println(user.getEmail()+" "+user.getFullName()+" "+user.getAge()+" "+
                    user.getMobile()+" "+user.getAddress());
        }
    }
}
