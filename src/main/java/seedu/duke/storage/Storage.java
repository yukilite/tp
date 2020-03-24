package seedu.duke.storage;


import seedu.duke.record.Appointment;
import seedu.duke.record.Patient;
import seedu.duke.ui.Ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Storage {

    private static final String SAVE_DIRECTORY = "saves";
    private static final String APPOINTMENT_LIST_SAVE_FILEPATH = "saves/appointments.txt";
    private static final String PATIENT_LIST_SAVE_FILEPATH = "saves/patients.txt";
    private static final String PIPE_DELIMITER = " | ";
    private static final String LS = System.lineSeparator();
    private static PatientList patientList;
    private static AppointmentList appointmentList;
    private String appointmentListSaveLocation;
    private String patientListSaveLocation;

    public Storage() {
        this.appointmentListSaveLocation = APPOINTMENT_LIST_SAVE_FILEPATH;
        this.patientListSaveLocation = PATIENT_LIST_SAVE_FILEPATH;
    }

    /**
     * load save file for Appointments list.
     *
     * @return appointmentListToReturn returns the appointment list in the save file
     * @throws FileNotFoundException this exception occurs when a file is not found
     */
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
                    Ui.showFailedToCreateFile();
                }
            } else {
                Ui.showFailedToCreateDirectory();
            }
            throw new FileNotFoundException();
        }
        List<Appointment> appointmentListToReturn = new ArrayList<>();
        Scanner s = new Scanner(appointmentSave);
        while (s.hasNext()) {
            //process each line, construct new Appointment object
            String appointmentString = s.nextLine();
            String[] patientFields = appointmentString.split(" \\| ", 2);
            assert patientFields.length == 2 : "not enough fields in this line:" + appointmentString;
            for (String field : patientFields) {
                if (field.trim().isEmpty()) {
                    field = null;
                }
            }
            Appointment newAppointmentToLoad = new Appointment(patientFields[0], patientFields[1]);
            appointmentListToReturn.add(newAppointmentToLoad);
        }

        return appointmentListToReturn;
    }

    /**
     * load save file for Patients list.
     *
     * @return patientListToReturn the patient list for the save file.
     * @throws FileNotFoundException this exception occurs if a file is not found.
     */
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
                    Ui.showFailedToCreateFile();
                }

            } else {
                Ui.showFailedToCreateDirectory();
            }
            throw new FileNotFoundException();

        }
        List<Patient> patientListToReturn = new ArrayList<>();
        Scanner s = new Scanner(patientSave);
        while (s.hasNext()) {
            //process each line, construct new Appointment object
            String patientString = s.nextLine();
            String[] patientFields = patientString.split(" \\| ", 4);
            assert patientFields.length == 4 : "not enough fields in this line:" + patientString;
            for (String field : patientFields) {
                if (field.trim().isEmpty()) {
                    field = null;
                }
            }
            if (patientFields[1].isEmpty()) {
                patientFields[1] = "-1";
            }
            Patient newPatientToLoad = new Patient(patientFields[0], Integer.parseInt(patientFields[1]),
                    patientFields[2], patientFields[3]);
            patientListToReturn.add(newPatientToLoad);

        }

        return patientListToReturn;
    }

    /**
     * This method saves the patient's appointment details from the AppointmentList into the local save file.
     *
     * @throws IOException this exception occurs if the patient's appointment details are unable to be written
     *                     to the local save file.
     */
    public void saveAppointmentsList() throws IOException {
        FileWriter fwAppointmentSave;
        try {
            fwAppointmentSave = new FileWriter(this.appointmentListSaveLocation);
        } catch (IOException e) {
            throw new IOException();
        }
        String newAppointmentString = null;

        for (int i = 0; i < AppointmentList.getTotalAppointments(); i++) {
            Appointment newAppointmentData = AppointmentList.getAppointmentRecord(i);
            newAppointmentString = newAppointmentData.getDate() + PIPE_DELIMITER + newAppointmentData.getTime() + LS;
            fwAppointmentSave.write(newAppointmentString);

        }

        fwAppointmentSave.close();
    }

    /**
     * This method saves the patient list into the local save file.
     *
     * @throws IOException this exception occurs if the patient data was unable to be written to the local save file.
     */
    public void savePatientList() throws IOException {

        FileWriter fwPatientSave;
        try {
            fwPatientSave = new FileWriter(this.patientListSaveLocation);
        } catch (IOException e) {
            throw new IOException();
        }
        String newPatientString = null;

        for (int i = 0; i < PatientList.getTotalPatients(); i++) {
            Patient newPatientData = PatientList.getPatientRecord(i);
            newPatientString = newPatientData.getName() + PIPE_DELIMITER
                    + newPatientData.getAge() + PIPE_DELIMITER
                    + newPatientData.getAddress() + PIPE_DELIMITER
                    + newPatientData.getContactNumber() + LS;
            fwPatientSave.write(newPatientString);

        }

        fwPatientSave.close();
    }

}
