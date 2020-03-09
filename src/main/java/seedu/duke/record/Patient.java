package seedu.duke.record;

public class Patient {
    private String name;
    private int age;
    private String address;
    private String contactNumber;


/**
 * This part is implemented for the UpdateCommand class by Duc
 */

    /**
     * Update the name if it is not null
     *
     * @param name name that needs to be updated
     */
    public void setName(String name) {
        if(name != null) {
            this.name = name;
        }
    }

    /**
     * Update the age if it is a positive integer
     *
     * @param age age that needs to be updated
     */
    public void setAge(int age) {
        if(age >= 0) {
            this.age = age;
        }
    }

    /**
     * Update the address if it is not null
     *
     * @param address address that needs to be updated
     */
    public void setAddress(String address) {
        if(address != null) {
            this.address = address;
        }
    }

    /**
     * Update the contact number if it is not null
     *
     * @param contactNumber contact number that needs to be updated
     */
    public void setContactNumber(String contactNumber) {
        if(contactNumber != null) {
            this.contactNumber = contactNumber;
        }
    }

    /**
     * Method to update all the patient's information
     *
     * @param name name that needs to be updated
     * @param age age that needs to be updated
     * @param address address that needs to be updated
     * @param contactNumber contact number that needs to be updated
     */
    public void setPatientInfo(String name, int age, String address, String contactNumber) {
        setName(name);
        setAge(age);
        setAddress(address);
        setContactNumber(contactNumber);
    }

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

