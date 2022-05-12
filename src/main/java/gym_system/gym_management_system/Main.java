package gym_system.gym_management_system;
import Gym_Components.Gym_Class;
import Gym_Components.Member;
import  Gym_Components.Trainer;
import System_Users.Administrator;
import System_Users.Employee;

import java.util.*;


public class Main {
    public static void main (String[] args) {
        GymSystem Gym_Management_System= new GymSystem();


        int X;
        Scanner myScanner = new Scanner(System.in);
        do {

            System.out.println("Choose position:");
            System.out.println("Admin    (1)");
            System.out.println("Employee (2)");
            X = myScanner.nextInt();
            if (X == 1) {
                while( Gym_Management_System.status ==false){  Gym_Management_System.adminLogin();}
                if ( Gym_Management_System.status) {
                    System.out.println("Choose:");
                    System.out.println("Trainers Management (1)");
                    System.out.println("Classes Management  (2)");
                    System.out.println("Members Management  (3)");
                    System.out.println("Sign out            (4)");
                    X = myScanner.nextInt();
                    if (X == 1) {
                        Gym_Management_System.manage_trainers();
                    } else if (X == 2) {
                        Gym_Management_System.manage_classes();
                    } else if (X == 3) {
                        Gym_Management_System.manage_members();
                    }
                    if (X==4){
                        Gym_Management_System.signout();
                    }
                }
            } else if (X == 2) {
                System.out.println("Choose:");
                System.out.println("Register (1)");
                System.out.println("login    (2)");
                X = myScanner.nextInt();
                if (X == 1) {
                    Gym_Management_System.employeeRegister();
                } else if (X == 2) {
                    while( Gym_Management_System.loggedInEmployee ==null){  Gym_Management_System.loggedInEmployee =  Gym_Management_System.employeeLogin();}
                    if ( Gym_Management_System.loggedInEmployee != null) {
                        Gym_Management_System.manage_employees();
                    }

                }
            }
        }while (X!=0);
    }
}

