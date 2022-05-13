package Gym_Components;
import System_Users.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;


public class Member extends Person {

  public static final String[] membershipTypeOptions = {"PAY AS YOU GO","OPEN","TERM" } ;
    private String membership_type ;

    private static int serialNumber =5000;;

    private List<Gym_Class> memberAttendedClasses = new ArrayList<Gym_Class>();

    private Trainer trainer;

    public Member() { }
    public Member(String name, String national_id, String gender, String phone_number, String membership_type) {
        super(name, national_id, gender, phone_number);
        this.membership_type=membership_type.toUpperCase(Locale.ROOT);
        serialNumber ++;
        this.trainer=null;
    }
    public static int getSerialNumber() {
        return serialNumber;
    }

    public String getMembership_type() {
        return membership_type.toUpperCase(Locale.ROOT);
    }

    public void setMembership_type(String type) {
        this.membership_type =type.toUpperCase(Locale.ROOT) ;
    }

    public List<Gym_Class> getMemberAttendedClasses() {
        return this.memberAttendedClasses=memberAttendedClasses;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setMemberAttendedClasses(List<Gym_Class> memberAttendedClasses) {
        this.memberAttendedClasses = memberAttendedClasses;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }
    @Override
    public String toString (){
        return "  "+ "Member's name: " + get_name()+ " Gender: " + get_gender()+" phone: " + getPhone_number()+
                " national ID: "+get_national_id() +" membership: " + getMembership_type();
    }
}


