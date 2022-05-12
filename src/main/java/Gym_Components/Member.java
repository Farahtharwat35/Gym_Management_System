package Gym_Components;
import System_Users.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Member extends Person {

    public static final String[] membershipTypeOptions = {"Pay as You go","Open","Term" } ;
    private String membership_type ;
//    private int membershipTypeIndex;
    private static int serialNumber =5000;;

    private List<Gym_Class> memberAttendedClasses = new ArrayList<Gym_Class>();





    private Trainer trainer;
    //constructors

    public Member() { }
    public Member(String name, String national_id, String gender, String phone_number, String membership_type) {
        super(name, national_id, gender, phone_number);
        serialNumber ++;
        this.trainer=null;
        this.membership_type=membership_type;
    }


    //getters&setters

    public static int getSerialNumber() {
        return serialNumber;
    }

    public String getMembership_type() {
        return membership_type;
    }



    public void setMembership_type(String type) {
        this.membership_type =type ;
    }

    public List<Gym_Class> getAttendedClasses() {
        return memberAttendedClasses;
    }
    public void setMemberClasses(List<Gym_Class> memberClasses) {
        this.memberAttendedClasses = memberClasses;
    }

    public List<Gym_Class> getMemberAttendedClasses() {
        return memberAttendedClasses;
    }

    public Trainer getTrainer() {
        return trainer;
    }


    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }




    //showing all object's info
    //overriding tostring method
    @Override
    public String toString (){
        return "  "+ "Member's name: " + get_name()+ " Gender: " + get_gender()+" phone: " + getPhone_number()+
                " national ID: "+get_national_id() +" membership: " + getMembership_type();
    }




}


