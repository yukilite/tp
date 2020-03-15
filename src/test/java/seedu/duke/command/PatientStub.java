package seedu.duke.command;

/**
 * Stub class for fake patient class
 */
public class PatientStub {
    private String name;
    private int age;
    private String address;
    private String contactNumber;

    public PatientStub(String name, int age, String address, String contactNumber) {
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
        String newToString = "{" + "[Name]:" + " " + getName() + " " + "|" + " " + "[Age]:" + " " + getAge() + " " + "|"
                + " " + "[Address]:" + " " + getAddress() + " " + "|" + " " + "[Contact Number]:" + " "
                + getContactNumber() + "}";
        return newToString;
    }
}
