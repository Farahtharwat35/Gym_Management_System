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

import static Gym_Components.Member.membershipTypeOptions;
import static gym_system.gym_management_system.GymSystem.members;


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

    public static void viewGymClassesList() {
        System.out.print(Administrator.getGymClassesList());
    }


    //  finding/ adding/removing members
    //finding method only used by the other two methods
    public static Member findMember(String national_id) {
        for (Member P : members) {
            if (P.get_national_id().equals(national_id)) {
                return P;
            }

        }
        return null;
    }

    private void addMember() {
        String memberName = "";
        String memberNational_id = "";
        String memberPhoneNumber = "";
        String memberGender = "";
        int membershipTypeIndex;

        Scanner myScanner = new Scanner(System.in);
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
            System.out.println("Choose member's membership, 1 for Pay as you go, 2 for open membership, 3 for Term membership :");
            membershipTypeIndex = myScanner.nextInt();
            members.add(new Member(memberName, memberNational_id, memberGender, memberPhoneNumber, membershipTypeIndex));
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
                    System.out.println("Please member's membership type : ");
                    int membership_index = second_input.nextInt();
                    switch (membership_index) {
                        case (1):
                            edited_member.setMembership_type(1);
                            break;
                        case (2):
                            edited_member.setMembership_type(2);
                            break;
                        case (3):
                            edited_member.setMembership_type(3);
                            break;
                        default:
                            System.out.println("Please enter a valid choice !");

                    }


                    //
                default:
                    System.out.println("Please enter a valid choice !");
            }
        }
    }

    public void deleteMember() {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter member's National_ID");
        String national_id = myScanner.nextLine().toUpperCase(Locale.ROOT);
        for (Member P : members) {
            if (P.get_national_id().equals(national_id)) {
                members.remove(P);
            } else {
                System.out.println(P.get_name() + "Not Found");
            }
        }
    }


    //adding/removing members from gym_classes
    public static void addMemberToClass( Gym_Class gym_class) {
        String national_id;
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please enter the member's national ID");
        national_id = myScanner.nextLine();
         Member tmp = findMember(national_id);
        gym_class.addMemberToClass(tmp);    //findmember returns the member
        tmp.getMemberAttendedClasses().add(gym_class);
    }

    public static void removeMemberFromClass( Gym_Class gym_class) {
        String national_id;
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please enter the member's national ID");
        national_id = myScanner.nextLine();
        Member tmp = findMember(national_id);
        gym_class.EmployeeRemoveClass_members(tmp);
        tmp.getMemberAttendedClasses().remove(gym_class);
    }

    public static void viewMemberClasses(Member memberOfClass) {
        System.out.println(memberOfClass.getMemberAttendedClasses());
    }


    //view all members of a specific membership type
    public void membersOfMembershipType() {
        int index;
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Choose the membership, 1 for Pay as you go, 2 for open membership, 3 for Term membership :");
        index = myScanner.nextInt();
        System.out.println("Members of" + membershipTypeOptions[index - 1] + " membership type:    ");
        for (Member P : members) {
            if (P.getMembershipTypeIndex() == index) {
                System.out.println(P.get_name() + "/n");
            }
        }
    }


    //view all members in a specific gym class
    public void membersInGymClass() {
        System.out.println("Members of the selected membership type:    ");
        for (Member P : GymSystem.members) {
            System.out.println(P.get_name() + "/n");
        }
    }


    //view a member info
    public void viewMemberInfo() {
        String national_id;
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please enter the member's national ID");
        national_id = myScanner.nextLine();
        for (Member P : members) {
            if (P.get_national_id().equals(national_id)) System.out.println(P);
        }
        System.out.println("Not Found");
    }


//
////login to be done
//    public void login () {
//        boolean Sucess=false;
//        while(!Sucess){
//            Scanner Username = new Scanner(System.in);
//            System.out.println("Please Enter Username : ");
//            String user = Username.next();
//
//            Scanner Password = new Scanner(System.in);
//            System.out.println("Please Enter Password : ");
//            String pass = Password.next();
//
//            if (username.equals(user) && password.equals(pass)) {
//                System.out.println("Logged In");
//                Sucess=true;
//            }
//            else {
//                System.out.println("Invalid Username or Password!");
//            }
//        }
//    }




}