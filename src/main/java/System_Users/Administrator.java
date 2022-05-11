package System_Users;
import Gym_Components.Gym_Class;
import Gym_Components.Member;
import  Gym_Components.Trainer;
import java.time.Instant;
import java.util.*;
import gym_system.gym_management_system.GymSystem;


// fuction for checking id
// function for find person
//make function find class in Main
// will do function for finding trainer by national id in Main
// will do function for finding class in Main from array list
// function in Main takes the reply and displays the menu or stays in the view
public class Administrator extends Person {
   private String password;
   private String username;
   private static List<Gym_Class> gymClassesList = new ArrayList<Gym_Class>();


    public Administrator (String name,String national_id,String gender,String phone_number,String password ,String username) {
        super(name, phone_number, national_id, gender);
        this.password=password;
        this.username=username.toUpperCase(Locale.ROOT);
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

    // down cast administartor to person to be easy in personfinder()
    public static List<Gym_Class> getGymClassesList() {
        return gymClassesList;
    }
    public static void setGymClassesList(List<Gym_Class> gymClassesList) {
        Administrator.gymClassesList = gymClassesList;
    }

    public void login (List <Administrator> administrator) {

            Scanner input = new Scanner(System.in);
            System.out.println("Please Enter Username : ");
            String username = input.next().toUpperCase(Locale.ROOT);
            System.out.println("Please Enter Password : ");
            String pass = input.next();
            boolean valid_data = false;
        for (int i=0; i<administrator.size() ; i++ ) {
            if (administrator.get(i).getUsername().equals(username) && administrator.get(i).getPassword().equals(pass)) {
                System.out.println("Logged In");
                valid_data = true;
                break;
            } // here will relate the view to a function in Main
            }
            if (valid_data){
                System.out.println("Welcome!");
            }
            else {
                    System.out.println("Invalid Username And Password!");
                }


        }
// will do function for finding trainer by national id in Main
// will do function for finding class in Main from array list
    public void assign_trainer_to_class (List <Trainer> gym_trainer,List <Gym_Class> gym_classses) {
        System.out.println("Please enter trainer NationalID :");
        Scanner input =new Scanner(System.in);
        String trainer_id=input.nextLine();
        System.out.println("Please enter class type :");
        String class_type= input.nextLine();
        Trainer assigned_trainer=findTrainer(gym_trainer,trainer_id);
        List<Gym_Class> assigned_trainer_classes=assigned_trainer.getGymClasses();
        Gym_Class assigned_class=findClass(gym_classses,class_type);
        boolean is_available = true;
        if (assigned_class==null || assigned_trainer==null) {
            System.out.println ("No such trainer or class found ! Please try again !");
        }
        else {
        for (int i=0 ; i<assigned_trainer.getGymClasses().size() ; i++ ) {
            if (assigned_trainer.getGymClasses().isEmpty()){
              assigned_class.setTrainer(assigned_trainer);
                assigned_trainer_classes.add(assigned_class);
                System.out.println("ASSIGN SUCCESS");
                break;
            } else if ((((assigned_class.getStart_time().isBefore(assigned_trainer.getGymClasses().get(i).getStart_time()))&&(assigned_class.getEnd_time().isBefore(assigned_trainer.getGymClasses().get(i).getStart_time())))||assigned_class.getStart_time().isAfter(assigned_trainer.getGymClasses().get(i).getStart_time()))) {
                is_available=false;
                break;
            }
        }
        if (is_available){
            assigned_class.setTrainer(assigned_trainer);
            assigned_trainer_classes.add(assigned_class);
            System.out.println("ASSIGN SUCCESS");
        }
        else {
            System.out.println("ASSIGN FAIL");
        } }
    }
    public void assign_trainer_to_member (List <Member> members , List<Trainer> trainers) {
            Scanner input = new Scanner(System.in);
            System.out.println("Please enter trainer nationalId :");
            String trainer_national_id = input.next();
            System.out.println("Please enter member nationalId :");
             String member_national_id = input.next();
            Trainer assigned_trainer=findTrainer(trainers,trainer_national_id);
            Member assigned_member= findMember(members,member_national_id);
        if (assigned_trainer==null || assigned_member==null) {
            System.out.println ("No such trainer or member found ! Please try again !");
        }
            else {
            if (assigned_trainer.getMembers().isEmpty()) {
                assigned_trainer.getMembers().add(assigned_member);
                assigned_member.setTrainer(assigned_trainer);
                System.out.println("TRAINER ASSIGNED SUCCESSFULLY");
            }
            else {
                if (assigned_member.getTrainer()!=null){
                    if (assigned_member.getTrainer () == assigned_trainer ) {
                        System.out.println ("TRAINER ALREADY EXISTS");
                    }
                    else {
                        assigned_member.setTrainer(assigned_trainer);
                        List <Member> trainer_members= assigned_trainer.getMembers();
                       trainer_members.add(assigned_member);
                        System.out.println ("TRAINER ASSIGNED SUCCESSFULLY");
                    }
                }
            }}
        }


public void edit_trainer (List <Trainer> trainer){


    System.out.println("Enter trainer nationalId : ");
    Scanner myScanner = new Scanner(System.in);
    String trainer_id = myScanner.nextLine().toUpperCase(Locale.ROOT);
    Trainer edited_trainer = findTrainer(trainer,trainer_id);
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
                break;
            case ("I"):
                System.out.println("Please enter trainer new NationalID :");
                String nationalID= second_input.nextLine();
                edited_trainer.set_national_id (nationalID);
                break;
            case ("G"):
                System.out.println("Please enter trainer gender :");
                String gender= second_input.nextLine();
                edited_trainer.set_gender(gender);
                break;
            case ("P"):
                System.out.println("Please trainer phone_number : ");
                String phone_number= second_input.nextLine();
                edited_trainer.set_phone_number(phone_number);
                break;
            default:
                System.out.println("Please enter a valid choice !");
        }}}

    
    //make function find class in Main
    public void open_class (List <Gym_Class> classes){
        String name = "";
        String day = "";
        String time = "";
        Instant start_time ;
        Instant end_time;
        String description = "";
        int maxMemberCount = 0;
        Scanner myScanner =new Scanner(System.in);
        System.out.println("Enter class name : ");
        String class_name = myScanner.nextLine().toUpperCase(Locale.ROOT);
        Gym_Class new_class = findClass(classes,class_name);

        if (new_class==null) {
            System.out.println("Enter class day :");
            day = myScanner.nextLine();
            System.out.println("Enter class start time :");
            start_time = Instant.parse(myScanner.nextLine());
            System.out.println("Enter class end time :");
            end_time = Instant.parse(myScanner.nextLine());
            System.out.println("Enter class description : ");
            description = myScanner.nextLine();
            System.out.println("Enter class maximum member  : ");
            maxMemberCount = myScanner.nextInt();
            myScanner.nextLine();

            classes.add(new Gym_Class(class_name, description, maxMemberCount,start_time,end_time));
        }
        else {
            System.out.println("Class : " + class_name + " already exists");
        }
    }
    // for entring a number ; we do exceptions?
    public void edit_class (List <Gym_Class> classes){
        System.out.println("Enter class name");
        Scanner myScanner = new Scanner(System.in);
        String class_name = myScanner.nextLine().toUpperCase(Locale.ROOT);
        class_name = myScanner.nextLine().toUpperCase(Locale.ROOT);
        Gym_Class edited_class = findClass(classes,class_name);
        if (edited_class == null){
            System.out.println("No result matches");
        }
        else {
            System.out.println("Edit class name (N)");
            System.out.println("Edit class start time (S)");
            System.out.println("Edit class end time (E)");
            System.out.println("Edit class description (D)");
            System.out.println("Edit class members limited number (N)");
            System.out.println("Edit class trainer (T)");
            Scanner first_input = new Scanner(System.in);
            String choice = first_input.nextLine();
            Scanner second_input= new Scanner(System.in);

            switch(choice) {
                case ("N"):
                    System.out.println("Please enter a Class name :");
                    String class_type = second_input.nextLine();
                    edited_class.setType(class_type);
                    break;
                case ("S"):
                    System.out.println("Please enter a start time for the Class :");
                    String start_time= second_input.nextLine();
                    Instant start =Instant.parse(start_time);
                    edited_class.setStart_time (start);
                    break;
               case ("E"):
                   System.out.println("Please enter an end time for the Class :");
                   String end_time= second_input.nextLine();
                   Instant end =Instant.parse(end_time);
                   edited_class.setStart_time(end);
                    break;
                case ("D"):
                    System.out.println("Please enter a description : ");
                    String description= second_input.nextLine();
                    edited_class.setDescription(description);
                    break;
                case ("M"):
                    System.out.println("Please enter a maximum number : ");
                    int maxnumber= second_input.nextInt();
                    edited_class.setMembers_limited_number(maxnumber);
                    break;
                default:
                    System.out.println("Please enter a valid choice !");
            }
        }
    }
    // after making the function of view_member in specific class in Main (it sorts te classes list and returns the class to this function)
    public void view_members_in_specific_class (List<Gym_Class> gym_classes) {
        Scanner input =new Scanner(System.in);
        System.out.println("Please enter a valid class type : ");
        String specific_class= input.nextLine();
        Gym_Class assigned_class=findClass(gym_classes,specific_class);
        if (assigned_class==null) {
            System.out.println ("No such class found ! Please try again !");
        }
        System.out.println("\n---------------------------------------------------------------------" +
                "-------------------------------------------------------------\n");

        System.out.format("%40s\n", "Class name: " + assigned_class.getType());
        System.out.format("%60s\n", "Class description: " + assigned_class.getDescription());
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

    public void view_all_members_infos (List <Member> members) {
        if (!members.isEmpty()) {
            System.out.println("\n---------------------------------------------------------------------" +
                    "-------------------------------------------------------------\n");
            System.out.format("%16s%16s%16s\n", "First Name",
                    "Name",
                    "National ID",
                    "Gender" ,
                    "Phone_Number"
                    );

            for (Person member : members) {
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

    public void membersOfMembershipType() {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter the membership, \"Pay as You go\", \"Open\" or \"Term\" membership :");
        String enteredMembership = myScanner.next();
        System.out.println("Members of the selected membership type: ");
        for (Member P : GymSystem.getMembers()) {
            if (P.getMembership_type().equals(enteredMembership)) {
                System.out.println(P.get_name() + "/n");
            }
        }
    }
//    public void view_members_in_specific_membership (List<Member> members) {
//        Scanner input_membership = new Scanner(System.in);
//        System.out.println("Please enter a valid membership : Pay as You go,Open,Term ");
//        for (int i = 0; i < members.size(); i++) {
//            Member member = (Member) members.get(i);
////    to rizk        if (member.getMembershipType().equals(membership)){
////                membersInSpecificMemberShip.add(member);
////            }
//        }
//        if (!membersInSpecificMemberShip.isEmpty()) {
//            System.out.println("\n---------------------------------------------------------------------" +
//                    "-------------------------------------------------------------\n");
//            System.out.format("%16s%16s%16s%32s\n", "First Name",
//                    "Last Name",
//                    "National ID",
//                    "Membership Type");
//
//            for (Member member : membersInSpecificMemberShip) {
//                System.out.format("%16s%16s%16s%32s\n",
//                        member.get_name(),
//                        member.get_national_id());
//                       //rizk //member.getMembershipType());
//            }
//            System.out.println("\n---------------------------------------------------------------------" +
//                    "-------------------------------------------------------------\n");
//        }else {
//            System.out.println("There are no members currently in the class");
//        }
//    }
    public void delete_trainer(List<Trainer> trainers_gym ) {
        System.out.println("Please enter trainer nationalId :");
        Scanner delete_trainer_id =new Scanner(System.in);
        String trainer_id= delete_trainer_id.nextLine();
        Trainer delete_trainer=findTrainer(trainers_gym,trainer_id);
        if (delete_trainer!=null) {
            for (int i = 0; i < trainers_gym.size(); i++) {
                    trainers_gym.remove(delete_trainer);
                    System.out.println("\nTrainer: " +
                            delete_trainer.get_name() + " has been deleted successfully ! \n");
            }
        }
        else {
        System.out.println("\nNo Such Trainer " + delete_trainer.get_name() + " "+
              " Found\n"); }
    }
    public void delete_class(List<Gym_Class> gym_classes) {
        System.out.println("Please enter class type :");
        Scanner class_type_input  =new Scanner(System.in);
        String class_type = class_type_input.nextLine();
        Gym_Class delete_class =findClass(gym_classes,class_type);
        if (delete_class !=null) {
            for (int i = 0; i < gym_classes.size(); i++) {
                gym_classes.remove(delete_class);
                System.out.println("\nClass: " +
                        delete_class.getType() + " has been deleted successfully ! \n");
            }
        }
        else {
            System.out.println("\nNo Such Class " + " "+
                    " Found\n"); }
    }

    public Trainer findTrainer (List <Trainer> trainers , String national_id ) {
        for (Trainer P : trainers ) {
            if (P.get_national_id().equals(national_id))
            {
                return P;
            }

        }
        return null;
    }
    public Member findMember (List <Member> members , String national_id ) {
        for (Member M : members ) {
            if (M.get_national_id().equals(national_id))
            {
                return M;
            }

        }
        return null;
    }
    private Gym_Class findClass (List <Gym_Class> gym_classes , String class_name ) {
        for (Gym_Class C : gym_classes ) {
            if (C.getType().equals(class_name)) {
                return C ;
            }
        }
        return null;
    }

    public void add_trainer (List <Trainer> trainers) {
        String name = "";
        String national_id = "";
        String phone_number = "";
        String gender = "";
        Scanner myScanner =new Scanner(System.in);
        System.out.println("Enter trainer nationalId:");
        national_id = myScanner.nextLine();
        Trainer new_trainer = findTrainer(trainers,national_id);

        if (new_trainer==null) {
            System.out.println("Enter trainer name :");
            name = myScanner.nextLine();
            System.out.println("Enter trainer gender :");
            gender = myScanner.nextLine();
            System.out.println("Enter trainer phone number :");
            phone_number = myScanner.nextLine();
            trainers.add(new Trainer(name, national_id, gender,phone_number));
        }
        else {
            System.out.println("Trainer : " + new_trainer + " already exists");
        }

    }


    // function in Main takes the reply and displays the menu or stays in the view
    public String signout () {
        System.out.println("Do you really want to sign out ? Y/N ") ;
        Scanner signout =new Scanner(System.in);
        String reply = signout.nextLine();
        return reply;
    }
}
