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

    protected static List<Employee> employees = new ArrayList<>();
    protected static List<Trainer> trainers = new ArrayList<>();

    protected static List<Member> members = new ArrayList<Member>();
    protected static List<Gym_Class> gym_classes = new ArrayList<>();

    public static List<Employee> getEmployees() {
        return employees;
    }

    public static List<Trainer> getTrainers() {
        return trainers;
    }

    Administrator admin1 = new Administrator("123", "farouha");


    public static List<Member> getMembers() {
        return members;
    }

    public static List<Gym_Class> getGym_classes() {
        return gym_classes;
    }

    Employee loggedInEmployee = null;

    /**
     * Employee methods
     */

    public Employee employeeLogin() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please Enter the following data to login : ");
        System.out.println("Enter the Employee's Username : ");
        String Username = input.next().toUpperCase(Locale.ROOT);

        System.out.println("Enter the Employee's Password : ");
        String Password = input.next();
        for (Employee P : employees) {
            if (P.getUsername().equals(Username) && P.getPassword().equals(Password)) {
                System.out.println("Welcome " + P.get_name());
                return P;
            }
        }
        System.out.println("Invalid Username or Password!");
        return null;
    }


    private void employeeRegister() {
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
    boolean status= false;
    public boolean adminLogin() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please Enter Admin Username : ");
        String Username = input.next().toUpperCase(Locale.ROOT);
        System.out.println("Please Enter Admin Password : ");
        String Password = input.next();
        if (admin1.getUsername().equals(Username) && admin1.getPassword().equals(Password)) {
            System.out.println("Welcome " + admin1.getUsername());
            status = true;
            return true;

        }
        System.out.println("Invalid Username or Password!");
        return false;
    }


     public void signout () {
//         System.out.println("Do you really want to sign out ? Y/N ");
//         Scanner signout = new Scanner(System.in);
//         String reply = signout.nextLine();
//         if (reply == "Y") {
             loggedInEmployee = null;
             status = false;
             System.out.println("Signed out successfully");

         }


    public void run_system() {
        Employee employee1 = new Employee("Anas","123","male","1643","anas","123");
        Employee employee2 = new Employee("Anas","123","male","1643","anass","1234");
        employees.add(employee1);
        employees.add(employee2);

        int X;
        Scanner myScanner = new Scanner(System.in);
        do {

            System.out.println("Choose position:");
            System.out.println("Admin    (1)");
            System.out.println("Employee (2)");
            X = myScanner.nextInt();
            if (X == 1) {
                while(status ==false){ adminLogin();}
                if (status) {
                    System.out.println("Choose:");
                    System.out.println("Trainers Management (1)");
                    System.out.println("Classes Management  (2)");
                    System.out.println("Members Management  (3)");
                    System.out.println("Sign out            (4)");
                    X = myScanner.nextInt();
                    if (X == 1) {
                        System.out.println("Choose:");
                        System.out.println("Add Trainer              (1)");
                        System.out.println("Edit Trainer             (2)");
                        System.out.println("Remove Trainer           (3)");
                        System.out.println("Assign Trainer to Class  (4)");
                        System.out.println("Assign Trainer to Member (5)");
                        System.out.println("Sign out                 (6)");
                        X = myScanner.nextInt();
                        switch (X) {
                            case 1: {
                                admin1.add_trainer();
                                break;
                            }
                            case 2: {
                                admin1.edit_trainer();
                                break;
                            }
                            case 3: {
                                admin1.delete_trainer();
                                break;
                            }
                            case 4: {
                                admin1.assign_trainer_to_class();
                                break;
                            }
                            case 5: {
                                admin1.assign_trainer_to_member();
                                break;
                            }
                            case 6: {
                                signout();
                                break;
                            }
                        }
                    } else if (X == 2) {
                        System.out.println("Choose:");
                        System.out.println("Open Class                            (1)");
                        System.out.println("Edit Class                            (2)");
                        System.out.println("Remove Class                          (3)");
                        System.out.println("View members in a specific class      (4)");
                        System.out.println("Sign out                              (5)");

                        X = myScanner.nextInt();
                        switch (X) {
                            case 1: {
                                admin1.findClass("YUGA");
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
                    } else if (X == 3) {
                        System.out.println("Choose:");
                        System.out.println("View members in specific class      (1)");
                        System.out.println("View members in specific membership (2)");
                        System.out.println("View all members infos              (3)");
                        System.out.println("Sign out                            (4)");

                        X = myScanner.nextInt();
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
                    if (X==4){
                        signout();
                    }

                }


            } else if (X == 2) {
                System.out.println("Choose:");
                System.out.println("Register (1)");
                System.out.println("login    (2)");
                X = myScanner.nextInt();
                if (X == 1) {
                    employeeRegister();
                } else if (X == 2) {
                    while(loggedInEmployee ==null){ loggedInEmployee = employeeLogin();}
                    if (loggedInEmployee != null) {
                        System.out.println("Choose:");
                        System.out.println("Add Member                 (1)");
                        System.out.println("Edit Member                (2)");
                        System.out.println("Delete Member              (3)");
                        System.out.println("Add Member to a Class      (4)");
                        System.out.println("Remove Member from a Class (5)");
                        System.out.println("View Members in a class    (6)");
                        System.out.println("View Members info          (7)");
                        System.out.println("Sign out                   (8)");
                        X = myScanner.nextInt();
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

                }
            }
        }while (X!=0);
        }




























}