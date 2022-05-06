package System_Users;
import java.util.List;
import java.util.Random;

public class Member extends Person {

/* enum to be fixed
   enum membership_type {  PAYG, OPEN, TERM;}  //membership type
  */
    private final double serial_number;
    private int classes_attended;   //n of classes attended or names of the classes???
    private static List<Member> members;


    //constructor
    public Member(String name, String national_id, String gender, String phone_number, Member new_member /*, enum membership_type*/) {
        super(name, national_id, gender, phone_number);
        //this.membership_type = membership_type;
        this.serial_number = (((int) (Math.random() * (5000 - 1000))) + 1000);  //random number between 1000 and 5000
        this.classes_attended = 0;
        members.add(new_member);
    }

    //getters
    public double getSerial_number() {
        return serial_number;
    }

    public int getClasses_attended() {
        return classes_attended;
    }

    public static List<Member> getMembers() {
        return members;
    }

    //setters
    public void setClasses_attended(int classes_attended) {
        this.classes_attended = classes_attended;
    }


    //showing all object's info
    @Override
    public String toString (){
        return "Member's name: " + get_name()+ " Gender: " + get_gender()+" phone: " + getPhone_number()+
                " national ID: "+get_national_id() +" membership: "/* + getmembership*/ ;
    }




}


