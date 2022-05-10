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

public class GymSystem {

    public static List<Employee> employees = new ArrayList<>();
    public static List<Trainer> trainers = new ArrayList<>();
    public static List<Administrator> admins = new ArrayList<>();
    public static List<Member> members = new ArrayList<Member>();
    public static List<Gym_Class> gym_classes = new ArrayList<>();


    public void employeeLogin(List<Employee> employees) {
        Scanner Username = new Scanner(System.in);
        System.out.println("Please Enter Username : ");
        String user = Username.next().toUpperCase(Locale.ROOT);
        System.out.println("Please Enter Password : ");
        Scanner Password = new Scanner(System.in);
        String pass = Password.next();
        boolean areCredentialsRight = false;
        while (areCredentialsRight == false) {
            for (Employee P : employees) {
                if (P.getUsername().equals(user) && P.getPassword().equals(pass)) {
                    System.out.println("Logged In");
                    areCredentialsRight = true;
                } // here will relate the view to a function in Main
                else {
                    System.out.println("Invalid Username or Password!");
                }
            }
        }
    }

    private void employeeRegister() {
        String name = "";
        String national_id = "";
        String gender = "";
        String phone_number = "";
        String username = "";
        String password = "";
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter Employee's nationalId:");
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


    public void run_system() {
        /**
         * admin methods
         *
         */
// phone number handling
        Administrator admin1 = new Administrator("Farah", "3020", "female", "0101000", "123", "farouha");
        Administrator admin2 = new Administrator("sara", "358", "female", "0101000", "189", "sarsoura");
        admins.add(admin1);
        admins.add(admin2);
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
//        while (true) {
//            admin1.login(admins);
//        }
//

/**
 * Employee Methods
 *
 */

        System.out.println("Testing Output");
        Gym_Class fitness= new Gym_Class("fitness","fitness",5, null, null);
        gym_classes.add(fitness);
        Member member1= new Member("member1", "1111", "male", "0101010",2);
        members.add(member1);
        Member member2= new Member("member2", "2222", "female", "0101010",1);
        members.add(member2);
        Employee employee1= new Employee("employee1","`12345","employee1","employee1","employee1","employee1");
        employees.add(employee1);
        employee1.addMemberToClass(fitness);
//        member1.viewMemberClasses();
        System.out.println(gym_classes);




//        Administrator.getGymClassesList().add(Fitness);

//        Employee.addMemberToList(member);
//        Employee.addMemberToClass(member,Fitness);
//        Employee.viewMemberClasses(member);
//        Member gira= new Member("gira", "99", "male", "0101010",2);
//        Employee.addMemberToList(gira);
//        System.out.println(Employee.viewMemberList());


    }


}
