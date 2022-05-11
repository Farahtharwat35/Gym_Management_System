package gym_system.gym_management_system;
import Gym_Components.Gym_Class;
import Gym_Components.Member;
import  Gym_Components.Trainer;
import System_Users.Administrator;
import System_Users.Person;
import System_Users.Employee;
import java.time.Instant;
import java.util.*;

class GymSystem {

    List<Employee> employees = new ArrayList<>();
    List<Trainer> trainers = new ArrayList<>();
    List<Member> members = new ArrayList<>();
    List<Administrator> admins = new ArrayList<>();
    List<Gym_Class> gym_classes = new ArrayList<>();
    Gym_Class YUGA = new Gym_Class();
    Member member1 = new Member();
    Administrator admin1 = new Administrator("Farah", "3020", "female", "0101000", "123", "farouha");
    Administrator admin2 = new Administrator("sara", "358", "female", "0101000", "189", "sarsoura");
    Trainer trainer1 = new Trainer("Ahmed", "302050", "female", "01010600");

    public void run_system() {
        admins.add(admin1);
        admins.add(admin2);
        trainers.add(trainer1);
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Choose position:");
        System.out.println("Admin    (1)");
        System.out.println("Employee (2)");
        int X = myScanner.nextInt();
        if (X == 1) {
            admin1.login(admins);
            if (admin1.isStatus()) {
                System.out.println("Choose:");
                System.out.println("Trainers Management (1)");
                System.out.println("Classes Management  (2)");
                System.out.println("Members Management  (3)");
                X = myScanner.nextInt();
                if (X == 1) {
                    System.out.println("Choose:");
                    System.out.println("Add Trainer              (1)");
                    System.out.println("Edit Trainer             (2)");
                    System.out.println("Remove Trainer           (3)");
                    System.out.println("Assign Trainer to Class  (4)");
                    System.out.println("Assign Trainer to Member (5)");
                    X = myScanner.nextInt();
                    switch (X) {
                        case 1: {
                            admin1.add_trainer(trainers);
                            break;
                        }
                        case 2: {
                            admin1.edit_trainer(trainers);
                            break;
                        }
                        case 3: {
                            admin1.delete_trainer(trainer1, trainers);
                            break;
                        }
                        case 4: {
                            admin1.assign_trainer_to_class(trainer1, YUGA);
                            break;
                        }
                        case 5: {
                            admin1.assign_trainer_to_member(member1, trainer1);
                        }
                    }
                } else if (X == 2) {
                    System.out.println("Choose:");
                    System.out.println("Open Class                            (1)");
                    System.out.println("Edit Class                            (2)");
                    System.out.println("Remove Class                          (3)");
                    System.out.println("View members in a specific class      (4)");
                    System.out.println("View members in a specific membership (5)");
                    System.out.println("View all members info                 (6)");
                    X = myScanner.nextInt();
                    switch (X) {
                        case 1: {
                            admin1.findClass(gym_classes, "YUGA");
                            break;
                        }
                        case 2: {
                            admin1.edit_class(gym_classes);
                            break;
                        }
                        case 3: {
                            admin1.delete_class(YUGA, gym_classes);
                            break;
                        }
                        case 4: {
                            admin1.view_members_in_specific_class(YUGA);
                            break;
                        }
                        case 5: {
                            admin1.view_members_in_specific_membership("lol", members);
                        }
                        case 6: {
                            admin1.view_all_members_infos(members);
                        }
                    }
                } else {
                    System.out.println("try again");
                }

            }
//        else if (X==2)
//        {
//            System.out.println("login (1)");
//            System.out.println("register new account (2)");
//            int X= myScanner.nextInt();
//            if (X==1)


// phone number handling


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


// Employee methods
// *
// */

//
//        System.out.println("Testing Output");
//        Gym_Class Fitness= new Gym_Class("Fitness","Fitness",5, null, null);
//        Administrator admin = new Administrator("zeko","zeko");
//        Administrator.getGymClassesList().add(Fitness);
//        Member member= new Member("mohamed", "100", "male", "0101010",1);
//        Employee.addMemberToList(member);
//        Employee.addMemberToClass(member,Fitness);
//        Employee.viewMemberClasses(member);
////        System.out.println(Employee.viewMemberList());
//        Member gira= new Member("gira", "99", "male", "0101010",2);
//        Employee.addMemberToList(gira);
//        System.out.println(Employee.viewMemberList());


        }
    }
}


    public class Main {
        public static void main(String[] args) {
            GymSystem Gym_Management_System = new GymSystem();
            Gym_Management_System.run_system();
        }
    }


