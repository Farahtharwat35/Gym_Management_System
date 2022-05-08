package System_Users;
//import Gym_Components.Gym_Class;
import Gym_Components.Gym_Class;
import Gym_Components.Member;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * iterate over list of members
 */

public class Employee extends Person {
    private String username;
    private String password;
    private static List<Member> memberList = new ArrayList<Member>();



    //constructors
    public Employee() { }
    public Employee (String name,String national_id , String gender ,String phone_number , String username ,String password) {
        super(name, national_id, gender, phone_number);
        this.username=username;
        this.password=password;
        this.password=password;
//        this.gymClassesList=gymClassesList;
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
    public static List<Member> viewMemberList() {
        return memberList;
    }

    public static void viewGymClassesList() {
        System.out.print(Administrator.getGymClassesList());
    }


    //  adding/removing members from list of members
    public static void addMemberToList(Member addedMember) {
        memberList.add(addedMember);
    }
    public static void removeMemberFromList(Member removedMember) { memberList.remove(removedMember);}
 //input not needed probably
//    public static void addMember() {
//        Scanner myScanner = new Scanner(System.in);
//        System.out.println("Please Enter the member's name : ");
//        String name = myScanner.next();
//        System.out.println("Please Enter the member's ID : ");
//        String national_id = myScanner.next();
//        System.out.println("Please Enter the member's gender : ");
//        String gender = myScanner.next();
//        System.out.println("Please Enter the member's phone number : ");
//        String phone_number = myScanner.next();
//        System.out.println("Please Enter the membership type, 1 for Pay as you go, 2 for Open membership, 3 for Term membership  : ");
//        int typeIndex = myScanner.nextInt();
//
//        Member addedMember= new Member(name, national_id, gender, phone_number, typeIndex);
//        memberList.add(addedMember);
//    }

    /**
     *
     * adding/removing members from classes
     */
    //adding/removing member from class
//    public  List<Gym_Class> getMemberClasses(Member member) {
//        return gymClassesList;
//    }
    public static void addMemberToClass(Member memberOfClass, Gym_Class gym_class) {
        gym_class.addMemberToClass(memberOfClass);
        memberOfClass.getAttendedList().add(gym_class);
    }
    public static void viewMemberClasses(Member memberOfClass) {
        System.out.println(memberOfClass.getAttendedList());
    }

//
//    public static void removeMemberFromClass(Member memberOfClass) {
//        gymClassesList.add(memberOfClass);
//    }





//
////login to be done
//    public void login () {
//        boolean Sucess=false;
//        while(!Sucess){
//            Scanner Username = new Scanner(System.in);
//            System.out.println("Please Enter Username : ");
//            String user = Username.next();
//
//            Scanner Password = new Scanner(System.in);
//            System.out.println("Please Enter Password : ");
//            String pass = Password.next();
//
//            if (username.equals(user) && password.equals(pass)) {
//                System.out.println("Logged In");
//                Sucess=true;
//            }
//            else {
//                System.out.println("Invalid Username or Password!");
//            }
//        }
//    }






}

