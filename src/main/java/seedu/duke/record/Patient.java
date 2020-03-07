package seedu.duke.record;

public class Patient {
    private String name;
    private String address;
    private String contactNumber;


    public Patient (String name, String address, String contactNumber) {
        this.name = name;
        this.address = address;
        this.contactNumber = contactNumber;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    @Override
    public String toString() {
        return "{" + "[Name]:"+ " " + getName() + " "+ "|" + " " + "[Address]:"
                + " " +  getAddress() + " " + "|" + " " + "[Contact Number]:" + " " + getContactNumber() + "}";
    }

}

