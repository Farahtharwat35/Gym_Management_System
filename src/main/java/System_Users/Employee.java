package System_Users;
import java.util.List;
import java.util.Scanner;
public class Employee extends Person {
    private String username;
    private String password;
//    private List<Member> members;

    //constructor
    public Employee (String name,String national_id , String gender ,String phone_number , String username ,String password) {
        super(name, national_id, gender, phone_number);
        this.username=username;
        this.password=password;
        this.password=password;
    }


    //getters and setters

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
/*
    public List<Member> getMembers() {return members;}
*/
    public void addMember() {
        Member addedMember= new Member();
    }
    public void removeMember(Member removedMember) {

        //Member addedMember= new Member();
    }


    public void login () {
        boolean Sucess=false;
        while(!Sucess){
            Scanner Username = new Scanner(System.in);
            System.out.println("Please Enter Username : ");
            String user = Username.next();

            Scanner Password = new Scanner(System.in);
            System.out.println("Please Enter Password : ");
            String pass = Password.next();

            if (username.equals(user) && password.equals(pass)) {
                System.out.println("Logged In");
                Sucess=true;
            }
            else {
                System.out.println("Invalid Username or Password!");
            }
        }





    }

}

