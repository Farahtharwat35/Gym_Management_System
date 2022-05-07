package System_Users;
import java.util.List;
import java.util.Scanner;
public class Employee extends Person {
    private String username;
    private String password;
//    private List<Member> members;

    //constructors

    public Employee() { }

    public Employee (String name,String national_id , String gender ,String phone_number , String username ,String password) {
        super(name, national_id, gender, phone_number);
        this.username=username;
        this.password=password;
        this.password=password;
        System.out.println("Employee Created Successfully");
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

    //adding a new member method
    public static void addMember() {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please Enter the member's name : ");
        String name = myScanner.next();
        System.out.println("Please Enter the member's ID : ");
        String national_id = myScanner.next();
        System.out.println("Please Enter the member's gender : ");
        String gender = myScanner.next();
        System.out.println("Please Enter the member's phone number : ");
        String phone_number = myScanner.next();
        System.out.println("Please Enter the membership type, 1 for Pay as you go, 2 for Open membership, 3 for Term membership  : ");
        int typeIndex = myScanner.nextInt();

        //creating object of the member
        Member addedMember= new Member(name, national_id, gender, phone_number, typeIndex-1);
        addedMember.addMemberToList(addedMember);   //adding the member to the arraylist
    }

//login to be done
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

