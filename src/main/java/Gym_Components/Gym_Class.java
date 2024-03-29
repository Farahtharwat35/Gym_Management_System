package Gym_Components;
import java.time.Instant;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.*;
import java.util.List;
import java.util.Locale;

public class Gym_Class {
    private String type;
    private String description;
    private Trainer trainer;
    private int members_limited_number;
    private LocalTime start_time;
    private LocalTime end_time;

    private String day;
    private static List<Member> class_members;
    public Gym_Class(String type, String description, String day,int members_limited_number, LocalTime start_time, LocalTime end_time) {
        this.type=type.toUpperCase(Locale.ROOT);
        this.description=description;
        this.members_limited_number=members_limited_number;
        this.start_time=start_time;
        this.end_time=end_time;
        this.day=day;
        this.class_members = new ArrayList<>();
    }

    public String getDay() {
        return day;
    }
    public void setDay(String day) {
        this.day = day;
    }

    public String getType() {
        return type.toUpperCase(Locale.ROOT);
    }
    public void setType(String type) {
        this.type = type.toUpperCase(Locale.ROOT);
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }
    public void setMembers_limited_number(int members_limited_number) {
        this.members_limited_number = members_limited_number;
    }
    public int getMembers_limited_number(){return members_limited_number;}
    public LocalTime getStart_time() {
        return start_time;
    }
    public void setStart_time(LocalTime start_time) {
        this.start_time = start_time;
    }
    public void addMemberToClass(Member member){
        class_members.add(member);
    }
    @Override
    public String toString (){
        return "Class: " +getDescription()+ " type: " + getType()+ "\n";
    }
    public LocalTime getEnd_time() {
        return end_time;
    }
    public void setEnd_time(LocalTime end_time) {
        this.end_time = end_time;
    }
    public static List<Member> getClass_members() {
        return class_members;
    }
    public void EmployeeRemoveClass_members(Member member) {
        class_members.remove(member);
    }
    static public Instant get_instant (String date, String time) {
//        String date=null;
//        String time;
//        Scanner input= new Scanner(System.in); ;
//        System.out.println("Please Enter date , example : YYYY-MM-DD ");
//        date= input.next();
//        System.out.println("Please Enter start time , example : HH:MM ");
//        time= input.next();
        return (Instant.parse(date+"T"+time+":00.00Z"));
    }
    static public Instant get_instant (Instant mydate) {
        String date=mydate.toString().substring(0,10);
        String time;
        Scanner input= new Scanner(System.in); ;
        System.out.println("Please Enter end time , example : HH:MM ");
        time= input.next();
        return (Instant.parse(date+"T"+time+":00.00Z"));
    }
}
