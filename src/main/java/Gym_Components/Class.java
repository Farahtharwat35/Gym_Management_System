package Gym_Components;

import java.util.List;

public class Class {
    private String type;
    private String description;
    private Trainer trainer;
    private int members_limited_number;
    private int members_count;
    //private List<Member> members;
    private String day;
    private String time;

    public Class (String type,String description,Trainer trainer,int members_limited_number,int members_count,
     String day, String time) {
         this.type=type;
         this.description=description;
         this.trainer=trainer;
         this.members_limited_number=members_limited_number;
         this.members_count=members_count;
         //this.members=members;
         this.day=day;
         this.time=time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public int getMembers_limited_number() {
        return members_limited_number;
    }

    public void setMembers_limited_number(int members_limited_number) {
        this.members_limited_number = members_limited_number;
    }

    public int getMembers_count() {
        return members_count;
    }

    public void setMembers_count(int members_count) {
        this.members_count = members_count;
    }

    //public List<Member> getMembers() {
        //return members;
    //}

    //public void setMembers(List<Member> members) {
        //this.members = members;
    //}

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}

