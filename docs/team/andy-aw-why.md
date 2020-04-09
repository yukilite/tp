# Andy Aw Bo Yang - Project Portfolio Page

## Overview
Hospital Administrative Management System (HAMS) is a CLI-based medical facility administration system that is used for 
maintaining medical records. It is written in Java

### Summary of Contributions
- **Major enhancement 1:** Added the command classes for add patient (```addPatientCommandClass```), add appointment
 (```addAppointmentCommandClass```), list patient (```listPatientCommandClass```) and list appointment
  (```listAppointmnetCommandClass```).
    - What it does: Serves as a facade class to allow different classes to be able to interact with one another so
     as to be able to execute the adding of commands, appointments as well as listing of patients and appointments
      successfully.
    - Justification: Each of the other classes are very highly cohesive and isolated from one another. The command
     classes, which acts as facade classes, make use of the other classes methods and properties such that the other
      classes can interact with one another to actually execute the user commands.
    - Highlights: The add patient and add appointment class has its own checks as well to catch other errors that the
     parser might has missed out on. The implementation for the commands classes is surprisingly challenging because
      not only do I have to understand how every other classes works, what the classes can do and what their
       intricacies (be it obvious or hidden) are, I also have to figure out how to carefully stitch the different
        functionalities present in the other
        classes too so as to execute the user's commands. 

- **Major enhancement 2:**  Added a patient id manager to manage the different patient id.
    - What it does: Able to manage the different patient's patient id such as giving new patients a unique patient id
     (be it creating a new patient id or finding and reusing a patient id from a deleted patient) and checking to see if
      a patient id is currently being used by an existing patient.
    - Justification: The patient id uniquely identifies all the patients (serves as a key for the patients). It
     also ensures that patients are linked to appointments.
     - Highlights: Implementation of this class is challenging as both major functions (first function being the
      creating of
      new patient
      id by either creating a new unique id or to find and reuse patient id of deleted patients and the second
       function being the finding and checking of
       patient id that actually exist) has to be quick (preferably in O(1) time) and correct (especially for the solution
        created for the first function as it is quite difficult to prove the correctness of the solution). I managed
         to come up with O(1) solutions for both functions.
     
- **Minor enhancement:** Helped in the creation of the abstract command class that all commands inherits from. Also
 fixed bugs in other classes so that it not only interact correctly with the facade class but also the other classes
  too.
- **Code contributed:** [[tP Code Dashboard]](https://nus-cs2113-ay1920s2.github.io/tp-dashboard/#breakdown=true&search=andy-aw-why&sort=groupTitle&sortWithin=title&since=2020-03-01&timeframe=commit&mergegroup=false&groupSelect=groupByRepos)

- **Other contribution:** 
    - Wrote extensive tests for my commands classes despite being facade classes
    - Correct minor typos and formatting issues in the user and developer guide

### Contributions to the User Guide
```
Given below are sections I contributed to the User Guide. They showcase my ability to write documentation targeting end-users.
```

# Table of content
<!-- TOC -->

* [1. Introduction](#1-introduction)
    + [1.1. Starting HAMS](#11-starting-hams)
* [2. Features](#2-features)
* [3. Command Format](#3-command-format)
* [4. Command Usage](#4-command-usage)
    + [4.1. Patient Commands](#41-patient-commands)
        + [4.1.1 Add new patient record](#411-add-a-new-patient-record)
        + [4.1.2 List all existing patient records](#412-list-all-existing-patients)
        + [4.1.3 Delete existing patient record](#413-delete-an-existing-patient)
        + [4.1.4 Edit existing patient record](#414-edit-an-existing-patient)
        + [4.1.5 Find existing patient record](#415-find-an-existing-patient)
        + [4.1.6 Clear all patient records](#416-clear-patient-records)
    + [4.2. Appointment Commands](#42-appointment-commands)
        + [4.2.1 Add new appointment record](#421-add-a-new-appointment-record)
        + [4.2.2 List all existing appointment records](#422-list-all-existing-appointments)
        + [4.2.3 Delete existing appointment record](#423-delete-an-existing-appointment)
        + [4.2.4 Edit existing appointment record](#424-edit-an-existing-appointment)
        + [4.2.5 Find existing appointment record](#425-find-an-existing-appointment)
        + [4.2.6 Clear all appointment records](#426-clear-appointment-records)
    + [4.3 Clear all records](#43-clear-all-records)
    + [4.4. Viewing help](#44-view-help)
    + [4.5. Exiting the program](#45-exit-hams-program)
* [5. Command Summary](#5-command-summary)  
* [6. FAQ](#6-faq)  

<!-- /TOC -->

This document serves as a user guide for HAMS. It teaches the user how to install HAMS, describes the features of HAMS, 
explains how HAMS can be used and finally answer some frequently asked questions about HAMS.
 
    
5. In Command Prompt, change your current working directory to the folder containing the .jar using $ `cd <Path of folder containing .jar>`


This command exits the HAMS program and saves the current Patient/Appointment data into separate local save files (in
 `/saves/appointments.txt` and `/saves/patients.txt` respectively. Also, the patient id state will also be saved in
  `/saves/patientId.txt`). These files will be loaded to the program when it is run again subsequently.
  
  **Q**: Why does my patient list does not display any value in the age field?
   
  * `{[Name]: Tommy | [Age]:  | [Address]:  | [Contact Number]: 92331234}`
   
  **A**: The age supplied might not be in the correct format (eg age given is a negative number or as a string).
  
  
### Back to top &#x2191;

- My contribution are mostly fixes in typos and aesthetics (such as adding a ```back to top``` link). This is because
 the user guide for HAMS is actually my DUKE ip's user guide only slightly modified to fit HAMS. In a sense
 , I technically created the user guide while my teammates modified it to fit HAMS.
 
 ### Contributions to the Developer Guide
 ```
 Provided below are sections I contributed to the Developer Guide. They demonstrate my ability to communicate my 
 technical contributions to the project and rationale for technical implementation.
 ```

# Table of content
<!-- TOC -->
* [1. Introduction](#1-introduction)
    + [1.1. Purpose](#11-purpose)
    + [1.2. Product Scope](#12-product-scope)
        - [1.2.1. Target User Profile](#121-target-user-profile)
        - [1.2.2. Value Proposition](#122-value-proposition)
    + [1.3. Definitions](#13-definitions)
* [2. Design & Implementation](#2-design--implementation)
* [3. User Stories](#3-user-stories)
* [4. Non-functional requirements](#4-non-functional-requirements)
* [5. Instructions for manual testing](#5-instructions-for-manual-testing)



#### 2.2.4 A&D command module 

The command module consist of 11 different classes, where each class does a different command by itself. 
These classes allows the patients and appointments to be added into HAMS, allows the updating of patient and 
appointment details, allows the admin to delete patients and appointment information and allows of listing of the 
different patients and the appointments in HAMS. In addition, the classes also deals with displaying the list of 
commands and as well as to allowing HAMS to exit.

![](../images/Command%20class%20diagram.png)

All of these command classes inherits from the abstract ```Command``` class. Likewise, the execute function of each 
command  class is also inherited from the abstract ```Command``` class's ```execute(Ui ui, Storage storage)``` function 
too. Every command class (other than the  ```ExitCommand``` and ```HelpCommand```) are actually façade classes that 
creates the connection from the ```Main``` class to the other classes required such as ```Storage``` class,
```PatientList``` class and the ```Appointment``` class to name a few. 

##### 2.2.4.1 AddPatientCommand Class

To add a patient, the ```AddPatientCommand``` class is used. For this ```AddPatientCommand``` class, it serves as the 
façade class for the ```Main```, ```Patient``` , ```PatientList``` and the ```Storage``` class to interact with one 
another. Also, to uniquely identify a patient, an unique patientId number is assigned to each patient when they are first added into the patient list.

![](../images/AddPatientDiagram.png)

1. The ```AddPatientCommand``` class object will first be created by the ```Parser``` object, where the information 
regarding the patient to be added will be stored in a Map, where the ```AddPatientCommand``` class object would read the Map content and store the information about the patient in said ```AddPatientCommand``` class object. 
For the patient Id number, it will call upon the static class ```patientIdManager``` to get its unique patient id number. This unique Id number will be used later in the ```Patient``` object creation too.

2. When the 
```execute(Ui ui, Storage storage)``` command is called, the  ```AddPatientCommand``` would first make use of the 
```Patient``` class constructor to create a new ```Patient``` object based on the information stored back in step 1. 

3. After which, it would then call the 
```PatientList```’s ```getPatientList()``` command to get the ```List``` patient list object such that the ```Patient``` 
object created beforehand can directly be inserted into the patient list. 

4. After adding the patient into the patient list 
object, the ```Storage```’s ```savePatientList()``` function will be called next so that the newly update list of 
```patient``` is saved as offline data.  

5. When the above operation is successful, it will call upon the ```Ui``` class’ 
```showPatientAddSuccess()``` function to display the success of adding the ```Patient``` object into the patient list.

If the supplied patient age is a word or is missing, the age will be set to ```-1```. This value is chosen to indicate 
that there isn’t a valid age set. Thus, when displaying the age, if ```-1``` is encountered, show age as an empty string 
instead.

Below shows the sequence diagram for ```AddPatientCommand``` class

![](../images/AddPatientCommandSequence.png)

![](../images/AddPatientCommandSequenceAddIntoPatientList.png)

![](../images/AddPatientCommandSequenceAutoSavePatientList.png)
 

##### 2.2.4.2 AddAppointmentCommand Class

To add an appointment, the ```AddAppointmentCommand``` class is used. For this ```AddAppointmentCommand``` class, it 
serves as a façade class for the ```Main```, ```Appointment```, ```AppointmentList``` and the ```Storage``` class to 
interact with one another. 

![](../images/AddAppointmentDiagram.png)

1. Like the ```AddPatientCommand``` class, the ```AddAppointmentCommand``` object is first created by the ```Parser``` 
object, where the information of the appointment is again stored in a Map that the ```AddAppoinmentCommand``` object would read from. 
Said information will be stored in the ```AddAppoinmentCommand``` object

2. When 
the ```Main``` calls ```execute(Ui ui, Storage storage)```, the ```AddAppointmentCommand``` class would call upon the 
```Appointment``` class to make an ```Appointment``` Object. Note that in the the constructor of ```AddAppointment``` it also checks to see if the patient id is a patient id that actually exist (as in a patient has that patient id
). This check is done by calling the ```checkPatientIdUsed``` method of ```PatientIdManager``` class. If the patient id
 supplied with the appointment detail does not belong to any of the present patients, the ```AddAppointmentCommand``` 
 constructor will **not** create the ```Appointment```  and will show an error instead. The ```Appointment``` object
  will only be created if the patient id that is supplied exists (as in one of the patient has said patient id).

3. After which, the ```AddAppoinmentCommand``` object will 
call upon the ```AppointmentList``` object to obtain the list of ```Appointments``` (get the ```List``` object that 
represents the list of appointments by ```AppointmentList```’s ```getAppointmentList()``` command) so that it can 
directly add the new ```Appointment``` object into the appointment list. 

4. Finally, it will call upon the ```Storage``` 
class’s ```saveAppoinmentList()``` function to save the updated appointment list. 

5. Upon successfully adding the 
```Appointment``` object into the appointment list, it will call upon the ```Ui``` class’ 
```showAppointmentAddSuccess()``` function to display the success of adding the ```appointment``` into the appointment 
list.

Below shows the sequence diagram for ```AddAppointmentCommand``` class:

![](../images/AddAppointCommandSequence.png)

![](../images/AddAppointCommandSequenceAddNewAppointment.png)

![](../images/AddAppointCommandSequenceAutoSavingAppointList.png)

##### 2.2.4.3 ListPatientCommand Class

To display the list of patients, the ```ListPatientCommand``` class is called. This class serves as a façade class of 
```Main``` and ```Ui``` to interact with each other. 

![]../images/ListPatientDiagram.png)

1. This class' object is first created by the ```Parser``` class, where it is then returned to the ```Main``` class to have its
```execute(Ui ui, Storage storage)``` function be called. 

2. When the ```Main``` class calls the 
```execute(Ui ui, Storage storage)``` function, ```ListPatientCommand``` will call upon the ```Ui```’s 
```showEntirePatientList()``` function to display the list of patients.

Below shows the sequence diagram for ```ListPatientCommand``` class

![](../images/ListPatientCommandSequence.png)

##### 2.2.4.4 ListAppointmentCommand Class

To display the list of appointments, the ```ListAppointmentCommand``` class is called. This class serves as a façade 
class of ```Main``` and ```Ui``` to interact with each other. 

![](../images/ListAppointmentDiagram.png)

1. This class' object is first created by the ```Parser``` class, where it is then returned to the ```Main``` class to 
have its ```execute(Ui ui, Storage storage)``` function be called. 

2. When the ```Main``` class calls the 
```execute(Ui ui, Storage storage)``` function, ```ListAppointmentCommand``` will call upon the ```Ui```’s 
```showEntireAppointmentList()``` function to display the list of appointments.

Below shows the sequence diagram for ```ListAppointmentCommand``` class

![](../images/ListAppointmentCommandSequence.png)

#### 2.2.4.5 PatientIdManger Class

The ```PatientIdManager``` class manages the patient ids. It helps to generate unique patient ids for each new
 patient. The patient id chosen can either be a new number or a patient id number that is reused from a deleted
  patient. By reusing the patient id number from deleted patients, it allows us to have more patient id to use before
   the patient id number runs out.
   
Not only that, it ia also able to check if a patient id exist (as in is there any patients with a specific
 patient id). This is useful because it prevents the user from adding a new appointment for a non-existing patient.
 
 ![](../images/PatientIdManagerCommandDiagram.png)
 
Other than the getter and the setter methods, the most important methods in ```PatientIdManager``` are
 ```getNextPatientId()```, ```addBackPatientId()```, ```checkPatientIdUsed()``` and ```clearPatientId()```
 
For ```getNextPatientId()```, its purpose is to supply a new patient id for a patient, be it a newly created id or an
 id from a deleted patient (reusing id). This is achieved with a combination of a queue (called the
  ```nextNumberQueueThing```) that serves to store
  the
  list of
  patient ids from deleted patients and an integer that serves to represent the next highest number to use if there
   are no patient ids that can be reused. 
   
To elaborate, whenever a patient is deleted, we want to store its patient id somewhere since it can be reused for a
 new patient (as it will still retain the uniqueness property of the patient id). Hence, a way to store those deleted
  patient's patient id is to store them in a queue such that we can call upon the queue for any reusable patient ids
  . We use a queue because inserting and popping elements in a queue is O(1) time, which makes it fast. If there are
   no elements in the queue (as in we have used up all or there isn't any reusable patient id present), then there
    exist another integer (called ```nextTopNewNumber```) that represents a new patient id that has not been used by
     any patient before. The value of ```nextTopNewNumber``` will be used for the patient id number if the queue is
      empty. After which, the ```nextTopNewNumber``` value get added by 1.

For example, when we just started HAMS and there has not been any deletion of patient thus far, the reusable
 patient id queue is empty. By default, ```nextTopNewNumber``` starts from 0. If we were to add 3 patients, then the
  first patient will get patient id 0 (which is the value of ```nextTopNewNumber```) currently (we use the value of
   ```nextTopNewNumber``` if there isn't any elements present in the resusable patient id queue), while the second
   patient gets the value of current ```nextTopNewNumber``` (which is 0) + 1, making patient number 2 has patient id
    1 and so on and so forth. The third patient will get patient id number 2. However, lets say we deleted patient
     number 2 and added a new patient (patient number 4, then patient number 2's patient id (patient id 1) will be
      stored in the queue. For the new patient added (patient number 4), instead of using the current
       ```nextTopNewNumber``` (which is 2), we will use
       the patient number present in the queue, which is 1. Thus, patient number 4 has the patient id of 1.
       
One property of ```nextTopNewNumber``` is that all patient id numbers in the queue should be lesser than
 ```nextTopNewNumber``` (```nextTopNewNumber``` serves as the current upper-bound of the possible patient id). There
  will never exist a reusable patient id number (or any patient id number for that matter) that is bigger than
   ```nextTopNewNumber```.
       
To summarize ```getNextPatientId()```

1) Check if the reusable patient id queue is empty
2) If it is not empty, we take a patient id from the queue.
3) On the other hand, if it is empty, we use the value of ```nextTopNewNumber``` for the patient id. We then increase
 the value of ```nextTopNewNumber``` by 1.

```getNextPatientId()``` is used by the ```addPatientCommandClass``` when adding a patient to get a unique patient id
 for the new patient.

For ```addBackPatientId()```, its purpose is to save the patient id of deleted patients by storing them in the
 reusable patient id queue.
 
 To summarize ```addBackPatientId()```
 
 1) Get the deleted patient id.
 2) Check to see if the patient id is a valid id. A valid patient id is an id that does not exist in the reusable
  patient id queue and its value cannot be below 0 and (equal and above) ```nextTopNewNumber```.
 3) If the patient id is a valid id, then add it in the reusable patient id queue. Else, ignore it.
 
 ```addBackPatientId()``` is used by the ```deletePatientClass``` when deleting a patient to store the deleted
  patient id number.
   
For ```checkPatientIdUsed()```, its purpose is to see if a patient Id is a currently used patient id (as in there is
 a patient currently that has this patient id). It achieves this using a hash table called ```patientIdMap```, where the
  key is the patient id
  number and its value is either null (this patient id has not been used) or 1 (this patient id has been used
  ). Whenever an appointment is added into HAMS, HAMS needs to ensure that the appointment's patient id corresponds
   to an actual patient in HAMS. This method helps by checking if the patient id supplied in the appointment entry
    belongs to an actual patient by checking the key-value pair in the ```patientIdMap``` and see if the patient id's
     value is 1 in said map
 
 To summarize ```checkPatientIdUsed()```
 
 1) Get the patient id to check.
 2) Let the patient id be the key. See the patient id's value in the ```patientIdMap``` hash table. If it is 1
 , return true (patient currently exist), else return false.
 
 ```checkPatientIdUsed()``` is used by the ```addAppointmentCommand``` class when adding an appointment to check if
  the patient id supplied belongs to a real patient currently in HAMS.
  
Lastly, for ```clearPatientId()```, it resets the value of  ```nextTopNewNumber```, clears the reusable patient id queue
 ```nextNumberQueueThing``` and finally clears the hash table ```patientIdMap```. This method serves to reset the
  ```patientIdManager``` back to its default state.
  
```clearPatientId()``` is used by both ```ClearPatientCommand``` and ```ClearAllCommand``` class to reset the
 ```patientIdManager``` state since both commands clears all the current patients in HAMS, which meant that all the
  patient id in HAMS must be reset as there are no patients left.

### [Back to top &#x2191;](#table-of-content)

##### 2.2.4.6 Design considerations

For the 5 classes listed, there were some other design considerations that was discussed for these 5 classes. Here
, we will discuss the other choices and the pros and cons for them.

###### 2.2.4.6.1 Aspect: Facade classes
+ Alternative 1 (current choice): Making all 4 classes facade classes
   
   * Pros: 
        - Stronger Single Responsibility Principle (SRP) and Separation of Concerns Principle (SoC)
   
   * Cons:
        - Higher dependencies and couplings on the other classes to work.

+ Alternative 2: Put the actual adding logic into the classes

    * Pros:
        - Weaker dependency and couplings on the other classes
    
    * Cons:
        - Lower SRP and (SoC)

###### 2.2.4.6.2 Aspect: Autosaving or no

+ Alternative 1 (current choice): Allow for autosaving after each command execution
    * Pros: 
        - Allow for recovery when crashing
        - Negligible performance effect on higher end computer system
       
    * Cons:
        - Since saving is writing to disk, it may be an expensive process for weaker computer system. Weaker computer system may be slowed down by the constant saving

+ Alternative 2: Save only when exiting HAMS
    * Pros: 
        - Faster, especially for weaker computer systems
       
    * Cons:
        - No recovery (or rather, no recovery for recent information) when HAMS crashes 

###### 2.2.4.6.3 Aspect: Generation of Patient Id

+ Alternative 1 (current choice): Allow the reuse of the patient Id from deleted patients
    * Pros: 
        - Allow for reuse, which prevents the patient Id number from running out.
       
    * Cons:
        - Slightly more complicated implementation. Also it means that there is more information that is required to be saved (such as the list of patient Id to be reused) when HAMS shuts down.

+ Alternative 2: Always pick a new number (don't reuse deleted patient Id number)
    * Pros: 
        - Easier to implement and keep track of. Also, it does not need to save much more information about the patient Id numbers (just need to save the last number assigned).
       
    * Cons:
        - Much more likely to run out of patient id numbers, especially if patients are getting added and deleted from HAMS continuously and consecutively.
        
###### 2.2.4.6.4 Aspect: Deciding how to reuse Patient Id

+ Alternative 1 (current choice): For reusable patient id, just choose the patient id number that have not been
 assigned the longest
    * Pros: 
        - Easy to implement (just use a Queue) and ensures an O(1) time.
    * Cons:
        - Patient id number is not really in sequence (it is possible for a bigger patient id number might be assigned
         first before a smaller patient id number). As a result, the new patient id number is not that predictable
          (unless you are keeping track of which patient id numbers are deleted first).

+ Alternative 2: Sort the reusable patient id first such that the smallest patient id is always reused first 
    * Pros: 
        - Patient id number is in sequence (always assign the smaller patient id number first), which seems to make
         it easier to predict the next patient's patient id number.
    * Cons:
        - Sorting is O(n log n) time, hence making it slightly slower than current implementation.