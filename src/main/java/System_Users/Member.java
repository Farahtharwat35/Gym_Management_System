package System_Users;
import java.util.ArrayList;
import java.util.List;

public class Member extends Person {

/* enum to be fixed
   enum membership_type {  PAYG, OPEN, TERM;}  //membership type
  */
    private double serial_number;
    private int classes_attended;   //n of classes attended or names of the classes???
    //Not sure
    //private static List<Member> members = new ArrayList();
    private static List<Member> members = new ArrayList<Member>();



    //constructor

    public Member() { }

    public Member(String name, String national_id, String gender, String phone_number  /*, enum membership_type*/) {
        super(name, national_id, gender, phone_number);
        //this.membership_type = membership_type;
        this.serial_number = (((int) (Math.random() * (5000 - 1000))) + 1000);  //random number between 1000 and 5000
        this.classes_attended = 0;
    }


    //getters
    public double getSerial_number() {
        return serial_number;
    }

    public int getClasses_attended() {
        return classes_attended;
    }

    public static List<Member> getMembers() {
//        System.out.println(members);
        return members;
    }
//adding member to arraylist
    public void addMemberToList(Member addedMember) {
        members.add(addedMember);
    }
//deleting member
    public void deleteMember(Member removedMember) {
        members.remove(removedMember);
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
                " national ID: "+get_national_id() +" membership: "/* + getmembership*/ ;
    }




}


