package gym_system.gym_management_system;

//import Gym_Components.Gym_Class;
import Gym_Components.Gym_Class;
import Gym_Components.Member;
import Gym_Components.Trainer;
import System_Users.Administrator;
import System_Users.Employee;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.*;
import gym_system.gym_management_system.*;
//import static Gym_Components.Member.getMemberList;
//import static Gym_Components.Member.getMemberList;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
/**
 *assign trainer to class
 *
 */
        Administrator admin1 = new Administrator( "123", "farouha");
        Trainer trainer1 = new Trainer("Ahmed", "302050", "female", "01010600");
        GymSystem.getTrainers().add(trainer1);

      Instant start_time = Gym_Class.get_instant();
        Instant end_time = Gym_Class.get_instant(start_time);
//        System.out.println(start_time.toString());

   Gym_Class class1=new Gym_Class("yoga","low",10,start_time,end_time);
//   Gym_Class class2=new Gym_Class("dance","low",10,start_time,end_time);
      GymSystem.getGym_classes().add(class1);
//        GymSystem.getGym_classes().add(class2);
//
//        admin1.assign_trainer_to_class();
//        admin1.assign_trainer_to_class();
//        for (int i=0;i<trainer1.getGymClasses().size();i++){
//            System.out.println("Trainer's new class is " + trainer1.getGymClasses().get(i).getType());
//        }
        /**
         * assign trainer to member
         *
         */

        Member member1 = new Member ("Ahmed", "302040", "female", "01010600","Pay as You GO");
        GymSystem.getMembers().add(member1);
//        admin1.assign_trainer_to_member();
//        for (int i=0;i<trainer1.getMembers().size();i++) {
//            System.out.println("Trainer is assigned to  " + trainer1.getMembers().get(i).get_name());
//        }
        /**
         * edit trainer
         *
         */

//        admin1.edit_trainer();

        /**
         * open class
         *
         */
//        admin1.open_class();

        /**
         * edit class
         *
         */
//        admin1.edit_class();
        /**
         * view_in_specific class
         *
         */
//        admin1.view_members_in_specific_class();
        /**
         * view_in_specific
         *
         */
//        admin1.view_all_members_infos();
//        admin1.view_members_in_specific_membership();
//        admin1.delete_class();
        admin1.delete_trainer();
    }

}