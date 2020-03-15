package seedu.duke.record;

import java.io.IOException;

/**
 * This class contains the patient information such as name, age, address and contact number.
 * @author yukilite
 */

public class Patient {
    private String name;
    private int age;
    private String address;
    private String contactNumber;

    /**
     * This method stores the patient information when the user enters an input.
     * @param name the name of the patient
     * @param age the age of the patient
     * @param address the address of the patient
     * @param contactNumber the phone number of the patient
     */
    public Patient(String name, int age, String address, String contactNumber) {
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

    /**
     * Overrides the default toString command so that the patient information can be printed
     * in a specific string format.
     * @return newToString The formatted string
     */
    @Override
    public String toString() {
        String newToString = "{" + "[Name]:" + " " + getName() + " " + "|" + " " + "[Age]:" + " " + getAge() + " " + "|"
                + " " + "[Address]:" + " " +  getAddress() + " " + "|" + " " + "[Contact Number]:" + " "
                + getContactNumber() + "}";
        return newToString;
    }

    /**
     * This part is implemented for the UpdatePatientCommand class by Duc.
     */

    /**
     * Update the name if it is not null.
     *
     * @param name name that needs to be updated
     */
    public void setName(String name) {
        if (!name.isBlank()) {
            this.name = name;
        }
    }

    /**
     * Update the age if it is a positive integer.
     *
     * @param age age that needs to be updated
     */
    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        }
    }

    /**
     * Update the address if it is not null.
     *
     * @param address address that needs to be updated
     */
    public void setAddress(String address) {
        if (!address.isBlank()) {
            this.address = address;
        }
    }

    /**
     * Update the contact number if it is not null.
     *
     * @param contactNumber contact number that needs to be updated
     */
    public void setContactNumber(String contactNumber) {
        if (!contactNumber.isBlank()) {
            this.contactNumber = contactNumber;
        }
    }

    /**
     * Method to update all the patient's information.
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
}

