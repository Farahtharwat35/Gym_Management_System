package gym_system.gym_management_system;

import Gym_Components.Gym_Class;
import Gym_Components.Member;
import Gym_Components.Trainer;
import System_Users.Administrator;
import System_Users.Employee;

import java.time.Instant;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import System_Users.Person;

public class GymSystem {

    protected static List<Employee> employees = new ArrayList<>();
    protected static List<Trainer> trainers = new ArrayList<>();

    protected static List<Member> members = new ArrayList<Member>();
    protected static List<Gym_Class> gym_classes = new ArrayList<>();

    static Administrator admin1 = new Administrator("", "");
    static Employee loggedInEmployee = null;
    public GymSystem (){ // created for testing
        Employee employee1 = new Employee("ANAS","302087010230","male","01010006287","anas","123");
        Employee employee2 = new Employee("EZZ","3020102582847","male","01010006281","anass","1234");
        Employee employee3 = new Employee("EZZ","3020102582841","male","01010006282","","");
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        Gym_Class class1=new Gym_Class("YOGA","low","Wednesday", 10,null ,null);
        gym_classes.add(class1);
        Gym_Class class2=new Gym_Class("dance","high", "Tuesday", 10,null,null);
        gym_classes.add(class2);
        Trainer trainer1 = new Trainer("Ahmed", "3020509010259", "male", "01010006286");
        GymSystem.getTrainers().add(trainer1);
        Trainer trainer2 = new Trainer("Fathy", "3020607080901", "male", "01010006289");
        GymSystem.getTrainers().add(trainer2);
        Member member1 = new Member("Mazen","30208101047689","male","01064887164","OPEN");
        getMembers().add(member1);
        Member member2 = new Member("Maha","302081010446543","female","0106487831","PAY AS YOU GO");
        getMembers().add(member2);
    }

    Scanner myScanner =new Scanner(System.in);
    public static List<Employee> getEmployees() {
        return employees;
    }

    public static List<Trainer> getTrainers() {
        return trainers;
    }

    public static List<Member> getMembers() {
        return members;
    }

    public static List<Gym_Class> getGym_classes() {
        return gym_classes;
    }

    public void manage_trainers (){

        System.out.println("Choose:");
        System.out.println("Add Trainer              (1)");
        System.out.println("Edit Trainer             (2)");
        System.out.println("Remove Trainer           (3)");
        System.out.println("Assign Trainer to Class  (4)");
        System.out.println("Assign Trainer to Member (5)");
        System.out.println("Sign out                 (6)");
        int X = myScanner.nextInt();
        switch (X) {
            case 1: {
//                admin1.add_trainer();
                break;
            }
            case 2: {
//                admin1.edit_trainer();
                break;
            }
            case 3: {
//                admin1.delete_trainer();
                break;
            }
            case 4: {
//                admin1.assign_trainer_to_class();
                break;
            }
            case 5: {
//                admin1.assign_trainer_to_member();
                break;
            }
            case 6: {
                signout();
                break;
            }
        }
    }
    public void manage_classes(){
        System.out.println("Choose:");
        System.out.println("Open Class                            (1)");
        System.out.println("Edit Class                            (2)");
        System.out.println("Remove Class                          (3)");
        System.out.println("View members in a specific class      (4)");
        System.out.println("Sign out                              (5)");

        int X = myScanner.nextInt();
        switch (X) {
            case 1: {
//                admin1.open_class();
                break;
            }
            case 2: {
                admin1.edit_class();
                break;
            }
            case 3: {
                admin1.delete_class();
                break;
            }
            case 4: {
                admin1.view_members_in_specific_class();
                break;
            }
            case 5: {
                signout();
                break;
            }

        }
    }
    public void manage_members(){
        System.out.println("Choose:");
        System.out.println("View members in specific class      (1)");
        System.out.println("View members in specific membership (2)");
        System.out.println("View all members infos              (3)");
        System.out.println("Sign out                            (4)");

        int X = myScanner.nextInt();
        switch (X) {
            case 1: {
                admin1.view_members_in_specific_class();
                break;
            }
            case 2: {
                admin1.view_members_in_specific_membership();
                break;
            }
            case 3: {
                admin1.view_all_members_infos();
                break;
            }
            case 4: {
                signout();
                break;
            }

        }
    }
    public void manage_employees (){
        System.out.println("Choose:");
        System.out.println("Add Member                 (1)");
        System.out.println("Edit Member                (2)");
        System.out.println("Delete Member              (3)");
        System.out.println("Add Member to a Class      (4)");
        System.out.println("Remove Member from a Class (5)");
        System.out.println("View Members in a class    (6)");
        System.out.println("View Members info          (7)");
        System.out.println("Sign out                   (8)");
        int X = myScanner.nextInt();
        switch (X) {
            case 1: {
                loggedInEmployee.addMember();
                break;
            }
            case 2: {
                loggedInEmployee.editMember();
                break;
            }
            case 3: {
                loggedInEmployee.deleteMember();
                break;
            }
            case 4: {
                loggedInEmployee.addMemberToClass();
                break;
            }
            case 5: {
                loggedInEmployee.removeMemberFromClass();
                break;
            }
            case 6: {
                loggedInEmployee.viewMembersInGymClass();
                break;
            }
            case 7: {
                loggedInEmployee.viewMemberInfo();
                break;
            }
            case 8: {
                signout();
                break;
            }
        }
    }

    /**
     * Employees methods
     */

    public static Employee employeeLogin(String username, String password) {

        for (Employee P : employees) {
            if (P.getUsername().equals(username) && P.getPassword().equals(password)) {
                //System.out.println("Welcome " + P.get_name());
                return P;
            }
        }
        return null;
    }

    public static boolean checkid(String national_id)
    {
        Employee new_employee = findEmployee(employees, national_id);
        if (new_employee == null) {
        return true;
        }
        else {
            return false;
        }
    }
    public void employeeRegister() {
        String name = "";
        String national_id = "";
        String gender = "";
        String phone_number = "";
        String username = "";
        String password = "";
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please Enter the following data to register an Employee:");
        System.out.println("Enter the new Employee's nationalId:");
        national_id = myScanner.nextLine();
        Employee new_employee = findEmployee(employees, national_id);

        if (new_employee == null) {
            System.out.println("Enter Employee's name :");
            name = myScanner.nextLine();
            System.out.println("Enter Employee's gender :");
            gender = myScanner.nextLine();
            System.out.println("Enter Employee's phone number :");
            phone_number = myScanner.nextLine();
            System.out.println("Enter Employee's username :");
            username = myScanner.nextLine();
            System.out.println("Enter Employee's password :");
            password = myScanner.nextLine();
            employees.add(new Employee(name, national_id, gender, phone_number, username, password));
            System.out.println(name + " has been registered successfully!");
        } else {
            System.out.println("Trainer : " + new_employee + " already exists");
        }
    }

    public static Employee findEmployee(List<Employee> employees, String national_id) {
        for (Employee P : employees) {
            if (P.get_national_id().equals(national_id)) {
                return P;
            }
        }
        return null;
    }

    /**
     * Admin Methods
     */
    static boolean status= false;
    public static boolean adminLogin() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please Enter Admin Username : ");
        String Username = input.next().toUpperCase(Locale.ROOT);
        System.out.println("Please Enter Admin Password : ");
        String Password = input.next();
        if (Administrator.getUsername().equals(Username) && Administrator.getPassword().equals(Password)) {
            System.out.println("Welcome " + Administrator.getUsername());
            status = true;
            return true;

        }
        System.out.println("Invalid Username or Password!");
        return false;
    }

    /**
     * Signout Method
     */
     public static void signout () {
             loggedInEmployee = null;
             status = false;
             System.out.println("Signed out successfully");
         }




























}