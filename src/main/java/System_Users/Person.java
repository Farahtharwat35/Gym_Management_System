package System_Users;

public class Person {
    private String name;
    private String national_id;
    private String gender;
    private String phone_number;

    public Person (String name,String national_id,String gender,String phone_number){
        this.name=name;
        this.national_id=national_id;
        this.gender=gender;
        this.phone_number=phone_number;
    }
    public Person (){}

    public String get_name () {
        return this.name;
    }

    public String get_national_id () {
        return this.national_id;
    }

    public String get_gender () {
        return this.gender;
    }

    public String get_mobile_hone () {
        return this.phone_number;
    }

    public void set_name (String name) {
        this.name=name;
    }

    public void set_national_id (String national_id) {
        this.national_id=national_id;
    }

    public void set_gender (String gender) {
        this.gender=gender;
    }
    public void set_phone_number (String phone_number) {
        this.phone_number=phone_number;
    }
}
