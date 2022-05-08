package System_Users;
import Gym_Components.Gym_Class;
import  Gym_Components.Trainer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Administrator extends Person {
   private String password;
   private String username;
   private static List<Gym_Class> gymClassesList = new ArrayList<Gym_Class>();



    public Administrator (String name,String national_id,String gender,String phone_number) {
        super(name, phone_number, national_id, gender);
    }
    public Administrator (String password,String username){
        this.password=password;
        this.username=username;
    }

    public String getUsername () {
        return this.username;
    }

    public String getPassword () {
        return this.password;
    }

    public void setUsername (String username) {
        this.username=username;
    }
    public void setPassword (String password) {
        this.password=password;
    }

    public static List<Gym_Class> getGymClassesList() {
        return gymClassesList;
    }
    public static void setGymClassesList(List<Gym_Class> gymClassesList) {
        Administrator.gymClassesList = gymClassesList;
    }


    public void login () {

            username = "farah";
            password = "123";

            Scanner Username = new Scanner(System.in);
            System.out.println("Please Enter Username : ");
            String user = Username.next();

            Scanner Password = new Scanner(System.in);
            System.out.println("Please Enter Password : ");
            String pass = Password.next();

            if (username.equals(user) && password.equals(pass)) {

                System.out.println("Logged In");
            }

            else if (username.equals(user)) {
                System.out.println("Invalid Password!");
            } else if (password.equals(pass)) {
                System.out.println("Invalid Username!");
            } else {
                System.out.println("Invalid Username And Password!");
            }

        }

    public void assign_trainer (Trainer trainer, Gym_Class gym_class){
            if (trainer.isAvailable()){
                gym_class.setTrainer(trainer);
            }
    }



//    public static List<Gym_Class> getGymClassesList() {
//        return gymClassesList;
//    }
//    public static void setGymClassesList(List<Gym_Class> gymClassesList) {
//        Administrator.gymClassesList = gymClassesList;
//    }
//


}

