package System_Users;
import Gym_Components.Gym_Class;
import  Gym_Components.Trainer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Locale;

// fuction for checking id
// function for find person
//make function find class in Main
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
        boolean is_available = false;
        for (int i=0 ; i<trainer.getGymClasses().size() ; i++ ) {
            if (trainer.getGymClasses().isEmpty()){
                gym_class.setTrainer(trainer);
                trainer_classes = trainer.getGymClasses();
                trainer_classes.add(gym_class);
                System.out.println("ASSIGN SUCCESS")
                break;
            }
            is_available=((gym_class.getStart_time().isBefore(trainer.getGymClasses().get(i).getStart_time())&&(gym_class.getEnd_time().isBefore(trainer.getGymClasses().get(i).getStart_time()) )|| gym_class.getStart_time().isAfter((trainer.getGymClasses().get(i).getStart_time()));
        }
        if (is_available){
            gym_class.setTrainer(trainer);
            trainer_classes = trainer.getGymClasses();
            trainer_classes.add(gym_class);
            System.out.println("ASSIGN SUCCESS")
        }
        else {
            System.out.println("ASSIGN FAIL")
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

    public void assign_trainer_to_member (Member member,Trainer trainer) {
            if (trainer.getMembers().isEmpty()) {
                trainer.getMembers().add(member);
                member.setTrainer (trainer)
                System.out.println("TRAINER ADDED SUCCESSFULLY");
                break;
            else {
                if (member.getTrainer ()!=null){
                    if (member.getTrainer () == trainer ) {
                        System.out.println ("TRAINER ALREADY EXISTS")
                    }
                    else {
                        member.setTrainer(trainer);
                        trainer.getMember().add(member);
                        System.out.println ("TRAINER ASSINED SUCCESSFULLY")
                    }
                }
            }
        }
    }

    public void add_trainer (String trainer_name,String name,String national_id,String gender,String phone_number){
                Trainer trainer_name = new Trainer (name,national_id,gender,phone_number);
                // don't forget to override to string methode here
                System.out.println("Added Trainer : " )
    }

//.. public void edit_trainer (String trainer_name,String name,String national_id,String gender,String phone_number){
      //  Trainer trainer_name = new Trainer (name,national_id,gender,phone_number);
        // don't forget to override to string methode here
      //  System.out.println ("Added Trainer : " )
//.. }

    public String delete_trainer(Trainer trainer){
         trainer=null;
        // don't forget to override to string methode here
        if (trainer==null){
            System.out.println ("Trainer deleted successfully")
        }
        else {
            System.out.println ("Trainer delete Fail")
        }

    }
    //make function find class in Main
    public void open_class (List <Gym_Class> classes){
        String name = "";
        String day = "";
        String time = "";
        Instant start_time =  Instant.parse("");;
        Instant end_time =  Instant.parse("");
        String description = "";
        int maxMemberCount = 0;

        System.out.println("Enter class name");
        class_name = myScanner.nextLine().toUpperCase(Locale.ROOT);
        Gym_Class new_class = findClass(class_name,classes);

        if (new_class == null) {
            System.out.println("Enter class day");
            day = myScanner.nextLine();
            System.out.println("Enter class start time");
            start_time = myScanner.nextLine();
            System.out.println("Enter class end time");
            end_time = myScanner.nextLine();
            System.out.println("Enter class description");
            description = myScanner.nextLine();
            System.out.println("Enter class maximum member");
            maxMemberCount = myScanner.nextInt();
            myScanner.nextLine();

            classes.add(new (class_name, day,start_time,end_time, description, maxMemberCount));
        }
        else {
            System.out.println("Class : " + class_name + " already exists");
        }
    }
    public void edit_class (List <Gym_Class> classes){
        System.out.println("Enter class name");
        class_name = myScanner.nextLine().toUpperCase(Locale.ROOT);
        Gym_Class edited_class = findClass(class_name,classes);
        if (new_class == null){
            System.out.println("No result matches")
        }
        else {
            System.out.println("Edit class name (N)");
            System.out.println("Edit class start time (S)");
            System.out.println("Edit class end time (E)");
            System.out.println("Edit class description (D)");
            System.out.println("Edit class members limited number (N)");
            System.out.println("Edit class trainer (T)");
            Scanner input = new Scanner.(System.in);
            choice_1 = input.nextLine();
            choice_2 = input.nextInt();

            switch(choice) {
                case ("Edit class name (N)"):
                    edited_class.setType(choice_1);
                    break;
                case ("Edit class start time (S) "):
                    Instant start =Instant.parse(choice_1);,
                    edited_class.setStart_time (start)
                    break;
               case ("Edit class start time (S) "):
                   Instant end =Instant.parse(choice_1);
                   edited_class.setStart_time(end);
                    break;
                case ("Edit class description (D)"):
                    edited_class.setDescription(choice_1);
                    break;
                case ("Edit class members limited number (N)"):
                    edited_class.setMembers_limited_number(choice_2);
                    break;
                default:
                    System.out.println("Please enter a valid choice !");
                    // code block
            }


        }
    }

