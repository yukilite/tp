package seedu.duke.record;

public class Patient {
    private String name;
    private int age;
    private String address;
    private String contactNumber;


    public Patient (String name, int age, String address, String contactNumber) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.contactNumber = contactNumber;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    @Override
    public String toString() {
        return "{" + "[Name]:"+ " " + getName() + " " + "|" + " " + "[Age]:" + " " + getAge() + " " + "|"
                + " " + "[Address]:" + " " +  getAddress() + " " + "|" + " " + "[Contact Number]:" + " "
                + getContactNumber() + "}";
    }

}

