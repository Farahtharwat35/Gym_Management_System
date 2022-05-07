package System_Users;
import java.util.ArrayList;
import java.util.List;

public class Member extends Person {

    public String[] membership_type = {"PAYG","OPEN","TERM" } ;
    private int membershipTypeIndex;
    private double serial_number;
    private int classes_attended;   //to be modified into an arraylist
    private static List<Member> memberList = new ArrayList<Member>();



    //constructors

    public Member() { }

    public Member(String name, String national_id, String gender, String phone_number, int membershipTypeIndex) {
        super(name, national_id, gender, phone_number);
        this.serial_number = (((int) (Math.random() * (5000 - 1000))) + 1000);  //random number between 1000 and 5000
        this.classes_attended = 0;
        this.membershipTypeIndex=membershipTypeIndex;
        this.membership_type[membershipTypeIndex]=membership_type[membershipTypeIndex];

    }


    //getters
    public double getSerial_number() {
        return serial_number;
    }

    public int getClasses_attended() {
        return classes_attended;
    }

    public static List<Member> getMemberList() {
        return memberList;
    }
//adding member to arraylist
    public void addMemberToList(Member addedMember) {
        memberList.add(addedMember);
    }
//deleting member
    public void deleteMember(Member removedMember) {
        memberList.remove(removedMember);
    }



    //setters
    public void setClasses_attended(int classes_attended) {
        this.classes_attended = classes_attended;
    }


    //showing all object's info
    //overriding tostring method
    @Override
    public String toString (){
        return "Member's name: " + get_name()+ " Gender: " + get_gender()+" phone: " + getPhone_number()+
                " national ID: "+get_national_id() +" membership: " + membership_type[membershipTypeIndex] ;
    }




}


