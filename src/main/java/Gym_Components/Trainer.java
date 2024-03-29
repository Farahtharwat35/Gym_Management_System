package Gym_Components;
import System_Users.Person;
import java.util.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Trainer extends Person {
    private List<Gym_Class> gymClasses;
    private List<Member> assigned_members;
    public Trainer(String name, String national_id, String gender, String phone_number) {
        super(name.toUpperCase(Locale.ROOT), national_id, gender, phone_number);
        this.gymClasses = new ArrayList();
        this.assigned_members= new ArrayList();
    }
    public List<Gym_Class> getGymClasses() {
        return gymClasses;
    }
    public List<Member> getMembers() {
        return assigned_members;
    }
}