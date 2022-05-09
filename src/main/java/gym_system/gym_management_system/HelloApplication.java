package gym_system.gym_management_system;

//import Gym_Components.Gym_Class;
import Gym_Components.Gym_Class;
import Gym_Components.Member;
import System_Users.Administrator;
import System_Users.Employee;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

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
 * admin methods
 *
 */





/**
 * Employee methods
 *
 */


        System.out.println("Testing Output");
        Gym_Class Fitness= new Gym_Class("Fitness","Fitness",5, null, null);
        Administrator admin = new Administrator("zeko","zeko");
        Administrator.getGymClassesList().add(Fitness);
        Member member= new Member("mohamed", "100", "male", "0101010",1);
        Employee.addMemberToList(member);
        Employee.addMemberToClass(member,Fitness);
        Employee.viewMemberClasses(member);
////        System.out.println(Employee.viewMemberList());
//        Member gira= new Member("gira", "99", "male", "0101010",2);
//        Employee.addMemberToList(gira);
//        System.out.println(Employee.viewMemberList());




        //launch();
    }
}