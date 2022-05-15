package System_Users;
import Gym_Components.Gym_Class;
import Gym_Components.Member;
import  Gym_Components.Trainer;
import java.time.Instant;
import java.util.*;
import gym_system.gym_management_system.GymSystem;

public class Administrator  {
   private String password;
   private String username;

   private static List<Gym_Class> gymClassesList = new ArrayList<Gym_Class>();


    public Administrator (String password ,String username) {
        this.password=password;
        this.username=username.toUpperCase(Locale.ROOT);
    }
    
    public String getUsername () {
        return this.username.toUpperCase(Locale.ROOT);
    }

    public String getPassword () {
        return this.password;
    }

    public void setUsername (String username) {
        this.username=username.toUpperCase(Locale.ROOT);
    }
    public void setPassword (String password) {
        this.password=password;
    }

    public boolean assign_trainer_to_class (Trainer assigned_trainer, Gym_Class assigned_class) {
//        Trainer assigned_trainer=findTrainer(trainer_id);
//        Gym_Class assigned_class=findClass(class_type);
        boolean is_available = true;
//        if (assigned_class==null || assigned_trainer==null) {
//            System.out.println ("No such trainer or class found ! Please try again !");
//        }
//        else {
            List<Gym_Class> assigned_trainer_classes=assigned_trainer.getGymClasses();
        for (int i=0 ; i<assigned_trainer.getGymClasses().size() ; i++ ) {
            if (assigned_trainer.getGymClasses().isEmpty()){
              assigned_class.setTrainer(assigned_trainer);
                assigned_trainer_classes.add(assigned_class);
                break;
            } else if (!(((assigned_class.getStart_time().isBefore(assigned_trainer.getGymClasses().get(i).getStart_time()))&&
                    (assigned_class.getEnd_time().isBefore(assigned_trainer.getGymClasses().get(i).getStart_time())))||
                    assigned_class.getStart_time().isAfter(assigned_trainer.getGymClasses().get(i).getStart_time()))) {
                is_available=false;
                break;
            }
        }
        if (is_available){
            assigned_class.setTrainer(assigned_trainer);
            assigned_trainer_classes.add(assigned_class);
            return true;
        }
        else {
            return false;
        } //}
    }
    public boolean assign_trainer_to_member (Trainer assigned_trainer, Member assigned_member) {

//        if (assigned_trainer==null || assigned_member==null) {
//            System.out.println ("No such trainer or member found ! Please try again !");
//        }
//            else {
            if (assigned_trainer.getMembers().isEmpty()) {
                assigned_trainer.getMembers().add(assigned_member);
                assigned_member.setTrainer(assigned_trainer);
                return true;
            }
            else {
                if (assigned_member.getTrainer() != null) {
                    if (assigned_member.getTrainer() == assigned_trainer) {
                        return false;
                    } else {
                        assigned_member.setTrainer(assigned_trainer);
                        List<Member> trainer_members = assigned_trainer.getMembers();
                        trainer_members.add(assigned_member);
                        return true;
                    }
                } else return false;
            }
            //}
        }


public void edit_trainer (){

    System.out.println("Enter trainer nationalId : ");
    Scanner myScanner = new Scanner(System.in);
    String trainer_id = myScanner.nextLine().toUpperCase(Locale.ROOT);
    Trainer edited_trainer = findTrainer(trainer_id);
    if (edited_trainer== null){
        System.out.println("No result matches");
    }
    else {
        System.out.println("Edit trainer name (N)");
        System.out.println("Edit trainer NationalId (I)");
        System.out.println("Edit trainer gender (G)");
        System.out.println("Edit trainer phone_number (P)");
        Scanner first_input = new Scanner(System.in);
        String choice = first_input.nextLine();
        Scanner second_input= new Scanner(System.in);

        switch(choice) {
            case ("N"):
                System.out.println("Please enter a trainer name :");
                String name = second_input.nextLine();
                edited_trainer.set_name(name);
                System.out.println("Trainer's name is set to " + edited_trainer.get_name());
                break;
            case ("I"):
                System.out.println("Please enter trainer new NationalID :");
                String nationalID= second_input.nextLine();
                edited_trainer.set_national_id (nationalID);
                System.out.println("Trainer's nationalId is set to " + edited_trainer.get_national_id());
                break;
            case ("G"):
                System.out.println("Please enter trainer gender :");
                String gender= second_input.nextLine();
                edited_trainer.set_gender(gender);
                System.out.println("Trainer's gender is set to " + edited_trainer.get_gender());
                break;
            case ("P"):
                System.out.println("Please trainer phone_number : ");
                String phone_number= second_input.nextLine();
                edited_trainer.set_phone_number(phone_number);
                System.out.println("Trainer's phone_number is set to " + edited_trainer.getPhone_number());
                break;
            default:
                System.out.println("Please enter a valid choice !");
        }}

    }

    
    //make function find class in Main
    public void open_class (String class_name, String day, String time, String description, int maxMemberCount){
//        String name = "";
//        String day = "";
//        String time = "";
//        String description = "";
//        int maxMemberCount = 0;
//        Scanner myScanner =new Scanner(System.in);
//        System.out.println("Enter class name : ");
//        String class_name = myScanner.nextLine().toUpperCase(Locale.ROOT);
//        Gym_Class new_class = findClass(class_name);
//
//        if (new_class==null) {
//            Instant start_time = Gym_Class.get_instant();
//            Instant end_time = Gym_Class.get_instant(start_time);
//            System.out.println("Enter class description : ");
//            description = myScanner.nextLine();
//            System.out.println("Enter class maximum member count  : ");
//            maxMemberCount = myScanner.nextInt();
//            myScanner.nextLine();
//
//           GymSystem.getGym_classes().add(new Gym_Class(class_name, description, maxMemberCount,start_time,end_time));
//           System.out.println("Class " + new_class.getType() + "has been added successfully!");
//        }
//        else {
//            System.out.println("Class : " + class_name + " already exists");
//        }
    }
    // for entring a number ; we do exceptions?
    public void edit_class (){
        System.out.println("Enter class name: ");
        Scanner myScanner = new Scanner(System.in);
        String class_name = myScanner.nextLine().toUpperCase(Locale.ROOT);
        Gym_Class edited_class = findClass(class_name);
        if (edited_class == null){
            System.out.println("No result matches");
        }
        else {
            System.out.println("Edit class name (N)");
            System.out.println("Edit class time and date (S)");
            System.out.println("Edit class description (D)");
            System.out.println("Edit class members limited number (N)");
            System.out.println("Edit class trainer (T)");
            Scanner first_input = new Scanner(System.in);
            String choice = first_input.nextLine();
            Scanner second_input= new Scanner(System.in);

            switch(choice) {
                case ("N"):
                    System.out.println("Please enter a Class name :");
                    String class_type = myScanner.nextLine().toUpperCase(Locale.ROOT);
                    edited_class.setType(class_type);
                    System.out.println("Class name is set to: " + class_type);
                    break;
               case ("S"):
//                   Instant start_time = Gym_Class.get_instant();
//                   Instant end_time =Gym_Class.get_instant(start_time);
//                   edited_class.setStart_time(start_time);
//                   edited_class.setEnd_time(end_time);
//                   System.out.println("Class schedule is set on : " + start_time.toString().substring(0,10) + "from  " + start_time.toString().substring(11,16) +  " to " + end_time.toString().substring(11,16) );
                    break;
                case ("D"):
                    System.out.println("Please enter a description : ");
                    String description= myScanner.nextLine().toUpperCase(Locale.ROOT);;
                    edited_class.setDescription(description);
                    System.out.println("Class description is set to: " + description);
                    break;
                case ("M"):
                    System.out.println("Please enter a maximum number : ");
                    int maxnumber= myScanner.nextInt();
                    edited_class.setMembers_limited_number(maxnumber);
                    System.out.println("Class maximum members count is set to: " + maxnumber);
                    break;
                default:
                    System.out.println("Please enter a valid choice !");
            }
        }
    }
    // after making the function of view_member in specific class in Main (it sorts te classes list and returns the class to this function)
    public void view_members_in_specific_class () {
        System.out.println("Please enter a valid class type : ");
        Scanner input =new Scanner(System.in);
        String specific_class= input.nextLine().toUpperCase(Locale.ROOT);
        Gym_Class assigned_class=findClass(specific_class);
        if (assigned_class==null) {
            System.out.println ("No such class found ! Please try again !");
        }
        System.out.println("\n---------------------------------------------------------------------" +
                "-------------------------------------------------------------\n");

        System.out.format("%40s\n", "Class name: " + assigned_class.getType());
        System.out.format("%40s\n", "Class description: " + assigned_class.getDescription());
        if (!assigned_class.getClass_members().isEmpty()) {
            System.out.format("%16s%16s%16s%32s\n", "First Name",
                    "Last Name",
                    "National ID",
                    "Membership Type");
            for (int i = 0; i < assigned_class.getClass_members().size(); i++) {
                System.out.format("%16s%16s%16s%32s\n",
                        assigned_class.getClass_members().get(i).get_name(),
                        assigned_class.getClass_members().get(i).get_national_id());
                       //membership //specific_class.getClass_members().get(i).get_name(),
            }
        }else {
            System.out.println("There are no members currently in this class");
        }
        System.out.println("\n---------------------------------------------------------------------" +
                "-------------------------------------------------------------\n");
    }

    public void view_all_members_infos () {
        if (!GymSystem.getMembers().isEmpty()) {
            System.out.println("\n---------------------------------------------------------------------" +
                    "-------------------------------------------------------------\n");
            System.out.format("%16s%16s%16s\n",
                    "Name",
                    "National ID",
                    "Gender" ,
                    "Phone_Number"
                    );

            for (Person member : GymSystem.getMembers()) {
                System.out.format("%16s%16s%16s\n", member.get_name(),
                        member.get_name(),
                        member.get_national_id());
            }
            System.out.println("\n---------------------------------------------------------------------" +
                    "-------------------------------------------------------------\n");
        }else {
            System.out.println("There are no members available !");
        }
    }

    public void view_members_in_specific_membership () {
        Scanner myScanner = new Scanner(System.in);
        boolean is_found=false;
        System.out.println("Enter the membership, \"Pay as You go\", \"Open\" or \"Term\" membership :");
        String enteredMembership = myScanner.nextLine().toUpperCase(Locale.ROOT);
        System.out.println("Members of the selected membership type: ");
        for (Member P : GymSystem.getMembers()) {
            System.out.println(P.getMembership_type());
            if (P.getMembership_type().equals(enteredMembership)) {
                System.out.println("Members using this membership are : " + P.get_name());
                is_found=true;
                break;
            }
        }
        if (!is_found){
            System.out.println("No members using this membership type");
        }
    }
//
    public void delete_trainer(String trainer_id) {

        Trainer delete_trainer=findTrainer(trainer_id);
        if (delete_trainer!=null) {
            for (int i = 0; i < GymSystem.getTrainers().size(); i++) {
                    GymSystem.getTrainers().remove(delete_trainer);
                    System.out.println("Trainer " + delete_trainer.get_name() + " has been deleted successfully ! \n");
            }
        }
        else {
        System.out.println("No Such Trainer " + delete_trainer.get_name() + " Found\n"); }
    }
    public void delete_class() {
        System.out.println("Please enter class type :");
        Scanner class_type_input  =new Scanner(System.in);
        String class_type = class_type_input.nextLine().toUpperCase();
        Gym_Class delete_class =findClass(class_type);
        if (delete_class !=null) {
            for (int i = 0; i < GymSystem.getGym_classes().size(); i++) {
                GymSystem.getGym_classes().remove(delete_class);
                System.out.println("Class " +  delete_class.getType() + " has been deleted successfully ! \n");
            }
        }
        else {
            System.out.println("No Such Class " + " Found\n"); }
    }

    public Member findMember (String national_id) {
        boolean is_found=false;
        Member assigned_member=null;
        for (Member C : GymSystem.getMembers() ) {
            if (C.get_national_id().equals(national_id)) {
                is_found=true ;
                assigned_member=C;
                break;
            }

        }
        return assigned_member;
    }

    public Gym_Class findClass ( String class_name ) {
        boolean is_found=false;
        Gym_Class assigned_class=null;
        for (Gym_Class C : GymSystem.getGym_classes() ) {
            if (C.getType().equals(class_name)) {
                is_found=true ;
              assigned_class=C;
                break;
            }
        }
           return assigned_class;
    }
    public Trainer findTrainer (String national_id) {
        boolean is_found=false;
        Trainer assigned_trainer=null;
        for (Trainer C : GymSystem.getTrainers() ) {
            if (C.get_national_id().equals(national_id)) {
                is_found=true ;
                assigned_trainer=C;
                break;
            }

        }
        return assigned_trainer;
    }

    public boolean checktrainer_id(String national_id){
        Trainer new_trainer = findTrainer(national_id);
        if(new_trainer==null)
        {
            return true;
        }
        else {
            return false;
        }
    }
//    public void add_trainer () {
//        String name = "";
//        String national_id = "";
//        String phone_number = "";
//        String gender = "";
//        Scanner myScanner =new Scanner(System.in);
//        System.out.println("Enter trainer nationalId:");
//        national_id = myScanner.nextLine();
//        Trainer new_trainer = findTrainer(national_id);
//
//        if (new_trainer==null) {
//            System.out.println("Enter trainer name :");
//            name = myScanner.nextLine();
//            System.out.println("Enter trainer gender :");
//            gender = myScanner.nextLine();
//            System.out.println("Enter trainer phone number :");
//            phone_number = myScanner.nextLine();
//            GymSystem.getTrainers().add(new Trainer(name, national_id, gender,phone_number));
//            System.out.println(name + " has been added successfully!");
//        }
//        else {
//            System.out.println("Trainer : " + new_trainer + " already exists");
//        }
//
//    }
}
