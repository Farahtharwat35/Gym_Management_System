package System_Users;
import Gym_Components.Gym_Class;
import Gym_Components.Member;
import Gym_Components.Trainer;
import gym_system.gym_management_system.GymSystem;
import java.util.*;


public class Employee extends Person {
    private String username;
    private String password;

    public Employee(String name, String national_id, String gender, String phone_number, String username, String password) {
        super(name, national_id, gender, phone_number);
        this.username = username.toUpperCase(Locale.ROOT);
        this.password = password;
    }
    public String getUsername() {
        return username.toUpperCase(Locale.ROOT);
    }
    public String getPassword() {
        return password;
    }


    private static Member findMember(String national_id) {
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
    public void addMember() {
        String memberName = "";
        String memberNational_id = "";
        String memberPhoneNumber = "";
        String memberGender = "";
        int membershipTypeIndex;

        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please fill the following data to add a member:");
        System.out.println("Enter member's nationalId:");
        memberNational_id = myScanner.nextLine();
        Member new_member = findMember(memberNational_id);

        if (new_member == null) {
            System.out.println("Enter member's name :");
            memberName = myScanner.nextLine().toUpperCase(Locale.ROOT);
            System.out.println("Enter member's gender :");
            memberGender = myScanner.nextLine().toUpperCase(Locale.ROOT);
            System.out.println("Enter member's phone number :");
            memberPhoneNumber = myScanner.nextLine();
            System.out.println("Enter the membership, \"Pay as You go\", \"Open\" or \"Term\" membership :");
            String enteredMembership = myScanner.nextLine().toUpperCase(Locale.ROOT);
            while(IsMembershipTypeAvailable(enteredMembership)==false) {
                enteredMembership = myScanner.nextLine().toUpperCase(Locale.ROOT);
            }
            GymSystem.getMembers().add(new Member(memberName, memberNational_id, memberGender, memberPhoneNumber, enteredMembership));
            System.out.println("Member " + memberName+ " added successfully");

        } else {
            System.out.println("Member : " + new_member + " already exists");
        }
    }

    public void editMember() {
        System.out.println("Enter member's national ID");
        Scanner myScanner = new Scanner(System.in);
        String member_id = myScanner.nextLine();
        Member edited_member = findMember(member_id);
        if (edited_member == null) {
            System.out.println("No result matches");
        } else {
            System.out.println("Edit member's name (N)");
            System.out.println("Edit member's NationalId (I)");
            System.out.println("Edit member's gender (G)");
            System.out.println("Edit member's phone_number (P)");
            System.out.println("Edit member's Membership type (M)");
            String choice = myScanner.nextLine();
            switch (choice) {
                case ("N"):
                    System.out.println("Please enter Member's new name :");
                    String name = myScanner.nextLine().toUpperCase(Locale.ROOT);
                    edited_member.set_name(name);
                    System.out.println("Name edited successfully");
                    break;
                case ("I"):
                    System.out.println("Please enter member's new NationalID :");
                    String nationalID = myScanner.nextLine();
                    edited_member.set_national_id(nationalID);
                    System.out.println("ID edited successfully");
                    break;
                case ("G"):
                    System.out.println("Please enter member's gender :");
                    String gender = myScanner.nextLine().toUpperCase(Locale.ROOT);
                    edited_member.set_gender(gender);
                    System.out.println("Gender edited successfully");
                    break;
                case ("P"):
                    System.out.println("Please member's phone_number : ");
                    String phone_number = myScanner.nextLine();
                    edited_member.set_phone_number(phone_number);
                    System.out.println("Phone number edited successfully");
                    break;
                case ("M"):
                    System.out.println("Enter the membership, \"Pay as You go\", \"Open\" or \"Term\" membership :");
                    String enteredMembership = myScanner.nextLine().toUpperCase(Locale.ROOT);
                    while(IsMembershipTypeAvailable(enteredMembership)==false) {
                        enteredMembership = myScanner.nextLine().toUpperCase(Locale.ROOT);
                    }
                    edited_member.setMembership_type(enteredMembership);
                    System.out.println("Membership edited successfully");
                default:
                    System.out.println("Please enter a valid choice !");
            }
        }
    }
    public void deleteMember( ) {
        System.out.println("Please enter Member nationalId :");
        Scanner delete_member_id =new Scanner(System.in);
        String member_id= delete_member_id.nextLine();
        Member delete_member=findMember(member_id);
        if (delete_member!=null) {
            for (int i = 0; i < GymSystem.getMembers().size(); i++) {
                GymSystem.getMembers().remove(delete_member);
                System.out.println("Member " + delete_member.get_name() + " has been deleted successfully ! \n");


  
            }
        }
        else {
            System.out.println("No Such Member " + delete_member.get_name() + " Found\n");
        }
    }


    public static void addMemberToClass() {
        String national_id,gymClassName;
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please fill the following data to add a member to a class:");
        System.out.println("Please enter the Class name");
        gymClassName = myScanner.nextLine().toUpperCase();
        Gym_Class gym_class = findGymClass(gymClassName);
        System.out.println("Please enter the member's national ID");
        national_id = myScanner.nextLine();
         Member addedMember = findMember(national_id);
        gym_class.addMemberToClass(addedMember);
        addedMember.getMemberAttendedClasses().add(gym_class);
        gym_class.addMemberToClass(addedMember);

        System.out.println("Member added to the class successfully");

    }

    public static void removeMemberFromClass() {
        String gymClassName,national_id;
        System.out.println("Please fill the following data to remove a member to a class:");
        System.out.println("Please enter the Class name");
        Scanner myScanner = new Scanner(System.in);
        gymClassName = myScanner.nextLine().toUpperCase(Locale.ROOT);
        Gym_Class gym_class = findGymClass(gymClassName);
        System.out.println("Please enter the member's national ID");
        national_id = myScanner.nextLine();
        Member memberToBeRemoved = findMember(national_id);

        gym_class.EmployeeRemoveClass_members(memberToBeRemoved);
        memberToBeRemoved.getMemberAttendedClasses().remove(gym_class);
        System.out.println("Member removed from class successfully");
    }

    public static void viewMemberClasses() {
        String national_id;
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please enter the member's national ID");
        national_id = myScanner.nextLine();
        Member memberOfClass = findMember(national_id);
        System.out.println(memberOfClass.getMemberAttendedClasses());
    }

    public static Gym_Class findGymClass (String class_name) {
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

    public void viewMembersInGymClass () {
        System.out.println("Please enter a valid class type : ");
        Scanner input =new Scanner(System.in);
        String specific_class= input.nextLine().toUpperCase(Locale.ROOT);
        Gym_Class assigned_class=findGymClass(specific_class);
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


    public boolean IsMembershipTypeAvailable(String enteredType){
        for(int i=0; i<Member.membershipTypeOptions.length; i++){
            if( enteredType.equals(Member.membershipTypeOptions[i])) return  true;
        }
        System.out.println("Please Enter a valid membership option \"Pay as You go\", \"Open\" or \"Term\" : ");
        return  false;
    }

    public void membersOfMembershipType() {
        boolean found = false;
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter the membership name to search, \"Pay as You go\", \"Open\" or \"Term\" membership :");
        String enteredMembership = myScanner.next().toUpperCase(Locale.ROOT);
        System.out.println("Members of the selected membership type: ");
        for (Member P : GymSystem.getMembers()) {
            if (P.getMembership_type().equals(enteredMembership)) {
                System.out.println(P.get_name());
                found = true;
            }
        }
        if(found== false)   System.out.println("No Members currently in the class");

    }
    public void viewMemberInfo() {
        boolean found = false;
        String national_id;
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please enter the member's national ID to view info");
        national_id = myScanner.nextLine();
        for (Member P : GymSystem.getMembers()) {
            if (P.get_national_id().equals(national_id)){
                System.out.println(P);
                found=true;
            }
        }
        if(found==false)     System.out.println("Member Not Found");
    }

}


