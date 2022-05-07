package Gym_Components;
import java.time.Instant;

public class Gym_Class {
    private String type;
    private String description;
    private Trainer trainer;
    private int members_limited_number;
    private int members_count;
    //private List<Member> members;
    private Instant start_time;

    private Instant end_time;

    public Instant getStart_time() {
        return start_time;
    }

    public void setStart_time(Instant start_time) {
        this.start_time = start_time;
    }

    public Instant getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Instant end_time) {
        this.end_time = end_time;
    }

    public Gym_Class(String type, String description, Trainer trainer, int members_limited_number, int members_count , Instant start_time, Instant end_time) {
         this.type=type;
         this.description=description;
         this.trainer=trainer;
         this.members_limited_number=members_limited_number;
         this.members_count=members_count;
         this.start_time=start_time;
         this.end_time=end_time;
         //this.members=members
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


}

