package gym_system.gym_management_system;

import Gym_Components.Gym_Class;
import Gym_Components.Member;
import Gym_Components.Trainer;
import System_Users.Administrator;
import System_Users.Employee;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import System_Users.Person;

public class GymSystem {

  protected  static List<Employee> employees = new ArrayList<>();
  protected static List<Trainer> trainers = new ArrayList<>();

  protected static List<Member> members = new ArrayList<Member>();
   protected static List<Gym_Class> gym_classes = new ArrayList<>();

    public static List<Employee> getEmployees() {
        return employees;
    }

    public static List<Trainer> getTrainers() {
        return trainers;
    }

    protected Administrator admin1 = new Administrator( "123", "farouha");

    public Administrator getAdmin1() {
        return admin1;
    }

    public static List<Member> getMembers() {
        return members;
    }

    public static List<Gym_Class> getGym_classes() {
        return gym_classes;
    }

    Employee loggedInEmployee=null;

    /**
     * Employee methods
     *
     */

    public Employee employeeLogin() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please Enter the Employee's Username : ");
        String Username= input.next().toUpperCase(Locale.ROOT);;
        System.out.println("Please Enter the Employee's Password : ");
        String Password= input.next();
        for (Employee P : employees) {
            if (P.getUsername().equals(Username) && P.getPassword().equals(Password)) {
                System.out.println("Welcome "+P.get_name());
                return P;
            }
        }
        System.out.println("Invalid Username or Password!");
        return  null;
    }


    private void employeeRegister() {
        String name = "";
        String national_id = "";
        String gender = "";
        String phone_number = "";
        String username = "";
        String password = "";
        Scanner myScanner = new Scanner(System.in);
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
        } else {
            System.out.println("Trainer : " + new_employee + " already exists");
        }
    }

    public Employee findEmployee(List<Employee> employees, String national_id) {
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

    public boolean  adminLogin() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please Enter Admin Username : ");
        String Username= input.next().toUpperCase(Locale.ROOT);;
        System.out.println("Please Enter Admin Password : ");
        String Password= input.next();
            if (admin1.getUsername().equals(Username) && admin1.getPassword().equals(Password)) {
                System.out.println("Welcome "+ admin1.getUsername());
                return true;

        }
        System.out.println("Invalid Username or Password!");
        return  false;
    }
//    public String signout () {
//        System.out.println("Do you really want to sign out ? Y/N ") ;
//        Scanner signout =new Scanner(System.in);
//        String reply = signout.nextLine();
//        if (reply=="Y"){
//            if (loggedInEmployee!=null){
//            loggedInEmployee = null;
//        } else if (adminLogin()=true) {
//
//            }
//        }
    public void run_system() {
/**
 * Running Admin:
 *
 */
// phone number handling


        Trainer trainer1 = new Trainer("Ahmed", "302050", "female", "01010600");
        trainers.add(trainer1);
//System.out.println(admin1.findTrainer(trainers , "302050"));
//admin1.edit_trainer(trainers);
//System.out.println(trainer1.get_name());
//Instant start_time = Gym_Class.get_instant();
//Instant end_time = Gym_Class.get_instant();
//Gym_Class class1=new Gym_Class("yoga","low",10,start_time,end_time);
////System.out.println(class1.getStart_time());
//    admin1.assign_trainer_to_class(trainer1,class1);
//    System.out.println(trainer1.getGymClasses());

            adminLogin();

//

/**
 * Running Employee
 *
 */

        Gym_Class fitness= new Gym_Class("fitness","fitness",5, null, null);
        gym_classes.add(fitness);
        Member member1= new Member("member1", "1111", "male", "0101010","Pay as You go");
        members.add(member1);
        Member member2= new Member("member2", "2222", "female", "0101010","Open");
        members.add(member2);
//        Employee employee1= new Employee("employee1","`12345","employee1","employee1","employee1","employee1");
//        employees.add(employee1);
        employeeRegister();
        employeeLogin();
            //the one Employee logged into the system
        while(loggedInEmployee ==null){ loggedInEmployee = employeeLogin();}
        loggedInEmployee.addMember();
        loggedInEmployee.membersOfMembershipType();
//        loggedInEmployee.viewMemberInfo();
//
//        loggedInEmployee.editMember();
//        loggedInEmployee.deleteMember();
//        loggedInEmployee.membersOfMembershipType();
//        loggedInEmployee.get_name();
//        loggedInEmployee.editMember();
//        loggedInEmployee.addMember();
//        loggedInEmployee.addMemberToClass(fitness);
//        loggedInEmployee.viewMembersInGymClass();

//        employee1.findMember("1234");
//        employee1.addMemberToClass(fitness);
//        employee1.viewMemberClasses();

//        System.out.println(gym_classes);




//        Administrator.getGymClassesList().add(Fitness);

//        Employee.addMemberToList(member);
//        Employee.addMemberToClass(member,Fitness);
//        Employee.viewMemberClasses(member);
//        Member gira= new Member("gira", "99", "male", "0101010",2);
//        Employee.addMemberToList(gira);
//        System.out.println(Employee.viewMemberList());


    }


}
