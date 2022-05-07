package gym_system.gym_management_system;

import System_Users.Employee;
import System_Users.Member;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static System_Users.Member.getMemberList;
//import static System_Users.Member.getMemberList;

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


        System.out.println("Testing Output");
        Employee.addMember();
        Employee.addMember();
        System.out.println(getMemberList());



        //launch();
    }
}