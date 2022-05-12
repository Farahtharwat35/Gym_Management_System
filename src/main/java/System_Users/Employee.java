package System_Users;
//import Gym_Components.Gym_Class;
import Gym_Components.Gym_Class;
import Gym_Components.Member;
import Gym_Components.Trainer;
import gym_system.gym_management_system.GymSystem;

import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import  Gym_Components.Member;


public class Employee extends Person {
    private String username;
    private String password;


    //constructors


    public Employee(String name, String national_id, String gender, String phone_number, String username, String password) {
        super(name, national_id, gender, phone_number);
        this.username = username.toUpperCase(Locale.ROOT);
        this.password = password;
//        this.gymClassesList=gymClassesList;
        System.out.println("Employee Created Successfully");
    }


    //getters and setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    //finding gym class method only used by the other two methods
    public static Gym_Class findGymClass(String gymClassName) {
        for (Gym_Class P : GymSystem.getGym_classes()) {
            if (P.getType().equals(gymClassName)) {
                return P;
            }
        }
        return null;
    }

    //  finding/ adding/removing members
    //finding method only used by the other two methods
    public static Member findMember(String national_id) {
        for (Member P : GymSystem.getMembers()) {
            if (P.get_national_id().equals(national_id)) {
                return P;
            }

        }
        return null;
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
            memberName = myScanner.nextLine();
            System.out.println("Enter member's gender :");
            memberGender = myScanner.nextLine();
            System.out.println("Enter member's phone number :");
            memberPhoneNumber = myScanner.nextLine();
            System.out.println("Enter the membership, \"Pay as You go\", \"Open\" or \"Term\" membership :");
            String enteredMembership = myScanner.nextLine();
            while(IsMembershipTypeAvailable(enteredMembership)==false) {
                enteredMembership = myScanner.nextLine();
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
        String member_id = myScanner.nextLine().toUpperCase(Locale.ROOT);
        Member edited_member = findMember(member_id);
        if (edited_member == null) {
            System.out.println("No result matches");
        } else {
            System.out.println("Edit member's name (N)");
            System.out.println("Edit member's NationalId (I)");
            System.out.println("Edit member's gender (G)");
            System.out.println("Edit member's phone_number (P)");
            System.out.println("Edit member's Membership type (M)");
            Scanner first_input = new Scanner(System.in);
            String choice = first_input.nextLine();
            Scanner second_input = new Scanner(System.in);
            Scanner third_input = new Scanner(System.in);

            switch (choice) {
                case ("N"):
                    System.out.println("Please enter Member's new name :");
                    String name = second_input.nextLine();
                    edited_member.set_name(name);
                    break;
                case ("I"):
                    System.out.println("Please enter member's new NationalID :");
                    String nationalID = second_input.nextLine();
                    edited_member.set_national_id(nationalID);
                    break;
                case ("G"):
                    System.out.println("Please enter member's gender :");
                    String gender = second_input.nextLine();
                    edited_member.set_gender(gender);
                    break;
                case ("P"):
                    System.out.println("Please member's phone_number : ");
                    String phone_number = second_input.nextLine();
                    edited_member.set_phone_number(phone_number);
                    break;
                case ("M"):

                    System.out.println("Enter the membership, \"Pay as You go\", \"Open\" or \"Term\" membership :");
                    String enteredMembership = myScanner.nextLine();
                    while(IsMembershipTypeAvailable(enteredMembership)==false) {
                        enteredMembership = myScanner.nextLine();
                    }
                    edited_member.setMembership_type(enteredMembership);
//                    switch (enteredMembership.toUpperCase(Locale.ROOT)) {
//                        case ("Pay as You go"):
//                            edited_member.setMembership_type("PAYG");
//                            break;
//                        case ("Open"):
//                            edited_member.setMembership_type("Open");
//                            break;
//                        case ("Term"):
//                            edited_member.setMembership_type("Term");
//                            break;
//                        default:
//                            System.out.println("Please enter a valid choice !");
//
//                    }


                    //
                default:
                    System.out.println("Please enter a valid choice !");
            }
        }
    }

    public void deleteMember() {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter member's National_ID to delete: ");
        String national_id = myScanner.nextLine().toUpperCase(Locale.ROOT);
        for (Member P : GymSystem.getMembers()) {
            if (P.get_national_id().equals(national_id)) {
                GymSystem.getMembers().remove(P);
            } else {
                System.out.println(P.get_name() + "Not Found");
            }
        }
    }


    //adding/removing members from gym_classes
    public static void addMemberToClass() {
        String national_id,gymClassName;
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please fill the following data to add a member to a class:");
        System.out.println("Please enter the Class name");
        gymClassName = myScanner.nextLine();
        Gym_Class gym_class = findGymClass(gymClassName);
        System.out.println("Please enter the member's national ID");
        national_id = myScanner.nextLine();
         Member addedMember = findMember(national_id);
        gym_class.addMemberToClass(addedMember);    //findmember returns the member if it exists
        addedMember.getMemberAttendedClasses().add(gym_class);
        gym_class.addMemberToClass(addedMember);
    }

    public static void removeMemberFromClass() {
        String gymClassName,national_id;
        System.out.println("Please fill the following data to remove a member to a class:");
        System.out.println("Please enter the Class name");
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please enter the Class name");
        gymClassName = myScanner.nextLine();
        Gym_Class gym_class = findGymClass(gymClassName);
        System.out.println("Please enter the member's national ID");
        national_id = myScanner.nextLine();
        Member memberToBeRemoved = findMember(national_id);

        gym_class.EmployeeRemoveClass_members(memberToBeRemoved);
        memberToBeRemoved.getMemberAttendedClasses().remove(gym_class);
    }

    public static void viewMemberClasses() {
        String national_id;
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please enter the member's national ID");
        national_id = myScanner.nextLine();
        Member memberOfClass = findMember(national_id);
        System.out.println(memberOfClass.getMemberAttendedClasses());
    }




    //view all members in a specific gym class
    public void viewMembersInGymClass() {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Write the gym class:");
        String className = myScanner.next().toUpperCase(Locale.ROOT);
        for (Gym_Class P : GymSystem.getGym_classes()) {
            if (P.getType().equals(className)) {
                System.out.println("Members of the selected gym class:    ");
                Gym_Class.getClass_members();
            }
            else {
                System.out.println("Invalid Class Name!");
            }
        }
    }


    public boolean IsMembershipTypeAvailable(String enteredType){
        for(int i=0; i<Member.membershipTypeOptions.length; i++){
            if( enteredType.equals(Member.membershipTypeOptions[i])) return  true;
        }
        System.out.println("Please Enter a valid membership option \"Pay as You go\", \"Open\" or \"Term\" : ");
        return  false;
    }

    //view all members of a specific membership type
    public void membersOfMembershipType() {
        boolean found = false;
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter the membership name to search, \"Pay as You go\", \"Open\" or \"Term\" membership :");
        String enteredMembership = myScanner.next();
        System.out.println("Members of the selected membership type: ");
        for (Member P : GymSystem.getMembers()) {
            if (P.getMembership_type().equals(enteredMembership)) {
                System.out.println(P.get_name());
                found = true;
            }
        }
        if(found== false)   System.out.println("No Members currently in the class");

    }


    //view a member info
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


