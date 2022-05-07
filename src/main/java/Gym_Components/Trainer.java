package Gym_Components;
import System_Users.Person;

public class Trainer extends Person {
    private Gym_Class[] gymClasses;
    private Member [] members;
    private boolean available;

    public Trainer (String name,String national_id,String gender,String phone_number, Gym_Class[] gymClasses,Member [] members){
        super(name,national_id,gender,phone_number);
        available=true;
        gymClasses=this.gymClasses;
        members=this.members;
    }

    public Gym_Class[] getClasses() {
        return gymClasses;
    }

    public void setClasses(Gym_Class[] gymClasses) {
        this.gymClasses = gymClasses;
    }

    public Member[] getMembers() {
        return members;
    }

    public void setMembers(Member[] members) {
        this.members = members;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
