package User;
public class User{
    private int mobile, age;
    private String firstName, lastName, address, email;
    public User(int mobile, int age, String firstName, String lastName, String address, String email) {
        this.mobile = mobile;
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
    }
    public  int getMobile() {return  mobile;}
    public  String getFullName() {return  firstName + " " + lastName;}
    public int getAge() { return age;}
    public String getEmail() {return email;}
    public String getAddress() {return address;}

    // implement setters also
}
