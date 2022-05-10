package Gym_Components;
import System_Users.Person;

import java.util.ArrayList;
import java.util.List;


public class Member extends Person {

    public static final String[] membershipTypeOptions = {"Pay as You go","Open","Term" } ;
    private String membership_type ;
    private int membershipTypeIndex;
    private double serial_number;

    private List<Gym_Class> memberAttendedClasses = new ArrayList<Gym_Class>();





    private Trainer trainer;
    //constructors

    public Member() { }
    public Member(String name, String national_id, String gender, String phone_number, int membershipTypeIndex) {
        super(name, national_id, gender, phone_number);
        //rand n generation, may change it later
        this.serial_number = (((int) (Math.random() * (5000 - 1000))) + 1000);  //random number between 1000 and 5000
        this.membership_type=membershipTypeOptions[membershipTypeIndex-1];
        this.trainer=null;
    }


    //getters&setters
    public double getSerial_number() {
        return serial_number;
    }
    public String getMembership_type() {
        return membership_type;
    }
    public int getMembershipTypeIndex() {
        return membershipTypeIndex;
    }

    public void setMembership_type(int index) {
        this.membership_type = membershipTypeOptions[index-1] ;
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
        return "\n"+ "Member's name: " + get_name()+ " Gender: " + get_gender()+" phone: " + getPhone_number()+
                " national ID: "+get_national_id() +" membership: " + membership_type +"\n";
    }




}


