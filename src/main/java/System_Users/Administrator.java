package System_Users;
import Gym_Components.Gym_Class;
import  Gym_Components.Trainer;
import java.util.Scanner;

public class Administrator extends Person {
   private String password;
   private String username;
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
    }

    public void assign_trainer_to_member (Member member) {
        trainer_members = trainer.getMembers();
        trainer_members.add(member);
    }

    public void add_trainer (String trainer_name,String name,String national_id,String gender,String phone_number){
                Trainer trainer_name = new Trainer (name,national_id,gender,phone_number);
                // don't forget to override to string methode here
                System.out.println ("Added Trainer : " )
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

    //public void open_class (String type, String description, Trainer trainer, int members_limited_number, int members_count , Instant start_time, Instant end_time){

       // System.out.println ("Trainer deleted successfully")
   // }


