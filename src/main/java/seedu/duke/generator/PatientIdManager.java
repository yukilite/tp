package seedu.duke.generator;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;


/**
 * The class to manage patient id numbers. Also allows patient id to be reused if said patient is deleted from HAMS.
 * All done in 0(1) time.
 * @author Andy
 */
public class PatientIdManager {


    private static int nextTopNewNumber = 0; // Patient ID to choose if queue is empty
    private static Queue<Integer> nextNumberQueueThing = new LinkedList<>(); // Queue of patient id numbers from
    // deleted patients
    private static Map<Integer,Integer> patientIdMap = new HashMap<>(); // Map containing all the patientid used thus
    // far

    /**
     * Get nextTopNewNumber value.
     * @return the new nextTopNewNumber.
     */
    public static int getNextTopNewNumber() {
        return nextTopNewNumber;
    }

    /**
     * Setter method for nextTopNewNumber.
     * @param nextTopNewNumber the new top number.
     */
    public static void setNextTopNewNumber(int nextTopNewNumber) {
        PatientIdManager.nextTopNewNumber = nextTopNewNumber;
    }

    /**
     * Getter method to get the queue of reusable patientID numbers.
     * @return the queue containing the reusable patientId numbers.
     */
    public static Queue<Integer> getNextNumberQueueThing() {
        return nextNumberQueueThing;
    }

    /**
     * Get a patient ID number, be it a new one or from a deleted patient.
     * @return the new patient ID number
     */
    public static int getNextPatientId() {
        int returnNumber = 0;
        if (nextNumberQueueThing.isEmpty()) {
            returnNumber = nextTopNewNumber;
            nextTopNewNumber = nextTopNewNumber + 1;
            patientIdMap.put(returnNumber,1);
            return returnNumber;
        }
        returnNumber = nextNumberQueueThing.remove();
        patientIdMap.put(returnNumber,1);
        return returnNumber;
    }

    /**
     * Method called when patient is deleted. Ensure that the deleted patient number can be reused.
     * @param patientID the patient Id from the deleted patient.
     */
    public static void addBackPatientId(int patientID) {
        if (patientID < 0 || patientID >= nextTopNewNumber) {
            return;
        }
        if (nextNumberQueueThing.contains(patientID)) {
            return;
        }

        assert patientID > 0 && patientID < nextTopNewNumber;
        assert !nextNumberQueueThing.contains(patientID);
        nextNumberQueueThing.add(patientID);
        patientIdMap.put(patientID,null);

    }

    public static boolean checkPatientIdUsed(int patientID) {
        Integer number = patientIdMap.get(patientID);
        if (number == null) {
            return false;
        }
        return true;
    }

    /**
     * Called only when the clear all patient command is called.
     * <p>
     *     This reset the patient Id manager state back to the beginning.
     * </p>
     */
    public static void clearPatientId() {
        nextTopNewNumber = 0;
        nextNumberQueueThing.clear();

    }

}
