package seedu.duke.storage;


import seedu.duke.record.Patient;
import seedu.duke.storage.PatientList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Storage {

    private String appointmentListSaveLocation;
    private String patientListSaveLocation;
    private static PatientList patientList;
    private static AppointmentList appointmentList;

    private static final String SAVE_DIRECTORY = "saves";
    private static final String APPOINTMENT_LIST_SAVE_FILEPATH = "saves/appointments.txt";
    private static final String PATIENT_LIST_SAVE_FILEPATH = "saves/patients.txt";

    public Storage() {
        this.appointmentListSaveLocation = APPOINTMENT_LIST_SAVE_FILEPATH;
        this.patientListSaveLocation = PATIENT_LIST_SAVE_FILEPATH;
    }

    //load save file for Appointments list
    public List<Appointment> loadSavedAppointments() throws FileNotFoundException {
        File appointmentSave = new File(this.appointmentListSaveLocation);
        if (!appointmentSave.exists()) {
            File newDirectory = new File(SAVE_DIRECTORY);
            boolean isNewDirectoryCreated = newDirectory.mkdir();
            if (isNewDirectoryCreated) {
                File newFile = new File(APPOINTMENT_LIST_SAVE_FILEPATH);
                try {
                    newFile.createNewFile();
                } catch (IOException e) {
                    System.out.println("Failed to create file in new directory");
                }

            } else {
                System.out.println("Failed to create directory");
            }
            throw new FileNotFoundException();
        }
        //TODO: parse the text file, return List of Appointments
        List<Appointment> appointmentListToReturn = new ArrayList<>();
        Scanner s = new Scanner(appointmentSave);
        while (s.hasNext()) {
            //TODO: parse savefile substring, update Appointment constructor
            //process each line, construct new Appointment object
            String taskString = s.nextLine();
            //......: parse substring into different fields. update a String array whose fields initialized to null
            Appointment newAppointmentToLoad = new Appointment();
            appointmentListToReturn.add(newAppointmentToLoad);

        }

        return appointmentListToReturn;
    }

    //load save file for Patients list
    public List<Patient> loadSavedPatients() throws FileNotFoundException {
        File patientSave = new File(this.patientListSaveLocation);
        if (!patientSave.exists()) {
            File newDirectory = new File(SAVE_DIRECTORY);
            boolean isNewDirectoryCreated = newDirectory.mkdir();
            if (isNewDirectoryCreated) {
                File newFile = new File(PATIENT_LIST_SAVE_FILEPATH);
                try {
                    newFile.createNewFile();
                } catch (IOException e) {
                    System.out.println("Failed to create file in new directory");
                }

            } else {
                System.out.println("Failed to create directory");
            }
            throw new FileNotFoundException();

        }
        //TODO: parse the text file, return List of Patients
        List<Patient> patientListToReturn = new ArrayList<>();
        Scanner s = new Scanner(patientSave);
        while (s.hasNext()) {
            //TODO: parse savefile substring, update Patient constructor
            //process each line, construct new Appointment object
            String taskString = s.nextLine();
            //......
            Patient newAppointmentToLoad = new Patient();
            patientListToReturn.add(newAppointmentToLoad);

        }

        return patientListToReturn;
    }

    public void saveAppointmentsList(AppointmentList appointmentListToSave) throws IOException {
        FileWriter fwAppointmentSave;
        try {
            fwAppointmentSave = new FileWriter(this.appointmentListSaveLocation);
        } catch (IOException e) {
            throw new IOException();
        }
        String newAppointmentString = null;

        for (int i=0; i < appointmentList.getTotalAppointments(); i++) {
            Appointment newAppointmentData = appointmentList.getAppointmentRecord(i);
            //....: add different fields to newPatientData with pipe string as separator
            fwAppointmentSave.write(newAppointmentString);

        }

        fwAppointmentSave.close();
    }

    public void savePatientList(PatientList patientListToSave) throws IOException {

        FileWriter fwPatientSave;
        try {
            fwPatientSave = new FileWriter(this.appointmentListSaveLocation);
        } catch (IOException e) {
            throw new IOException();
        }
        String newPatientString = null;

        for (int i=0; i < patientList.getTotalPatients(); i++) {
            Patient newPatientData = patientList.getPatientRecord(i);
            //....: add different fields to newPatientData with pipe string as separator
            fwPatientSave.write(newPatientString);

        }

        fwPatientSave.close();
    }

}
