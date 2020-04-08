# Developer Guide

# Table of content
<!-- TOC -->
* [1. Introduction](#1-introduction)
    + [1.1. Purpose](#11-purpose)
    + [1.2. Product Scope](#12-product-scope)
        - [1.2.1. Target User Profile](#121-target-user-profile)
        - [1.2.2. Value Proposition](#122-value-proposition)
    + [1.3. Definitions](#13-definitions)
* [2. Design & Implementation](#2-design--implementation)
    * [2.1. Project Overview](#21-project-overview)
        * [2.2. Module Overview](#22-module-overview)
            * [2.2.1. SAM record module ](#221-sam-record-module)
            * [2.2.2. SAM converter module ](#222-converter-module)
            * [2.2.3. BRANDON storage module ](#223-brandon-storage-module)
            * [2.2.4. AD command module ](#224-ad-command-module)
            * [2.2.5. Parser Module ](#225-parser-module)
                * [2.2.5.1. Object creation and input interpretation](#2251-object-creation-and-steps-in-input-interpretation)
                * [2.2.5.2. Design Considerations ](#2252-design-considerations)
* [3. User Stories](#3-user-stories)
* [4. Non-functional requirements](#4-non-functional-requirements)
* [5. Instructions for manual testing](#5-instructions-for-manual-testing)
    + [5.1, Startup, shutdown and restart](#51-startup-shutdown-and-restart-with-saved-list)
    + [5.2. Adding a patient](#52-adding-a-patient)
    + [5.3. Deleting a patient](#53-delete-a-patient)
        
<!-- TOC -->

## 1. Introduction

### 1.1. Purpose
This document specifies the architecture and software designs for 
Hospital Administrative Management System (HAMS).

### 1.2. Product Scope
#### 1.2.1. Target User Profile
The intended audience of this documentation are the developers, designers, software testers,
operators and maintenance engineers. The below table summarizes the purposes of reading for each 
audience.



|Role|Purpose|
|---------|-------|
|Developers & Designers| To understand the architecture and follow the design to build the system|
|Software testers| To understand the internals of the system so as to test more effectively|
|Operators| To improve productivity while using the system on a daily basis|
|Maintenance Engineers| To understand how the system was built in order to perform enhancement or re-engineering work|

#### 1.2.2. Value Proposition
**TODO {Describe the value proposition: what problem does it solve?}**

### 1.3. Definitions
**TODO**
* *HAMS* - Short for Hospital Administrative Management System.
* *SAM* - Short for Stupendously AwsoMe, an acronym to describe the records module.
* *BRANDON* - Short for BRillant Ahead of its time Neat Dainty OrigNal, it is an acronym to describe the custom 
implementation of the save file structure. 
* *A&D* - Short of Amazing & Dazzling, it is an acronym to describe the command module.

### [Back to top &#x2191;](#table-of-content)

## 2. Design & Implementation
### 2.1 Project overview
HAMS is built using java. Under java's write once run anywhere, HAMS can be built on any platform including Windows,
MAC-OS and Linux. When running locally on these system, HAMS uses as custom save configuration called 
BRillant Ahead of its time Neat Dainty OrigiNal (BRANDON) for loading and saving data. This allows HAMS' internal 
list to be modified by operators before and during run time. 

### 2.2 Module Overview
The major code can be broken down into modules. The below table is the breakdown of the module's custom
name and a summarized purpose.

**TODO**

|Module name|Purpose|
|---------|-------|
|Records|Contains and provides access to user information|
|Converter|Formats user input| 
|BRillant Ahead of its time Neat Dainty OrigiNal (BRANDON) **storage**|?|
|Amazing & Dazzling (A&D) Commands|Facade classes that deals with input so that different classes can interact with each other|
|Parser|Parses the user input for command execution|

#### 2.2.1 SAM record module

The record module consists of 2 classes which represent the patients information and appointment details. 
As a reflection of real world objects, the Patient's class purpose is to store the particulars of a person while the 
Appointment's class is to store the date-time data. 
Thus, the rationale of both classes can be grouped as follows:
>
> As a reflection of real world entities, to create, store, and retrieve relevant information about the object.
>
Following the above purpose, both classes consist of only getter and setter methods. This would ensure a contiguous 
flow in logical executions as these methods can be called whenever necessary.

##### 2.2.1.1 Process of Object Creation
Due to the nature of the above classes containing only getter and setter methods, following how the components interact 
with each other would provide more accuracy in understanding how these classes are called and the role of its 
methods. 
To illustrate, the below example is used:
* editp \index 1 \name Justin \age 69 \Pasir Panjang

![](images/SD_Patient.png)

Upon startup, objects from ui, parser and storage are created. Prompted for user input, Duke receives the "editp"
command which is forwarded to the parser to be interpreted respectively. Once the `EditPatientCommand` object is 
created, it retrieves the patient index to edit the existing patient information from the patientList. 
The `Patient` class is called by its setter method, `setPatientInfo()`, to update the fields as provided by the user. 
This ensures that the encapsulated variables such as age, name, contact number and address are not only enforced but
also protected. 

##### 2.2.1.2 Design Considerations
###### Aspect: Data Type for Appointment's Date and Time

+ Alternative 1 (current choice): Store as a String
    * Pros: 
        - Easier implementation
        - Greater user flexibility
    * Cons:
        -  Cannot sort if needed

+ Alternative 2: Store as Date
    * Pros:
        - Has flexibility to parse or format date using existing methods available for use.
    * Cons:
        - Immutable-value classes mean it is not thread-safe (using Java.util.SimpleDateFormat).

### [Back to top &#x2191;](#table-of-content)

#### 2.2.2 Converter Module
The converter module consists of one class which converts the format of date and time using a custom format defined by
special formatting characters (ie. SimpleDateFormat). This class is primarily used to format a user-input date and time
in the `Appointment` class. As illustrated below, its methods are called during the creation of the `Appointment`
object constructor. 

![](images/SD_Converter.png)

### [Back to top &#x2191;](#table-of-content)

#### 2.2.3 BRANDON storage module

The Storage module consists of 3 different classes. 
The PatientList and AppointmentList classes act as data structures to store the records of Patient and Appointment 
objects respectively. They function as ADTs, where various commands from Command objects can manipulate the records within.
The Storage class manages the load and save operations involving the PatientList and PatientList class. 
These operations are usually invoked on startup, whenever changes are made to the ADTs and before exiting the program.
The class diagram for the storage module is as seen below: 


![](images/storageclass.PNG)

&nbsp;

On startup, Duke invokes the loadSavedAppointment() and loadSavedPatient() methods in Storage. This allows the program 
to retrieve previously stored data from a .txt file and convert it into the static AppointmentList and PatientList objects for use
within the program. 

The Storage object creates a Scanner object that will parse individual lines in the .txt file, convert them into
new Appointments, and then add them to an ArrayList called `appointmentListToReturn`. This `appointmentListToReturn` will be passed back to Duke to
construct the static AppointmentList. The sequence diagram is shown below:

![](images/loadsavedappt_seq.PNG)
![](images/loadsavedappt_ref1.PNG)

When the static AppointmentList or PatientList has changes, or the program is exiting, saveAppointmentList() or savePatientList() 
is invoked respectively. This allows the Storage object to back up existing records to a local .txt file.

The Storage object will create a FileWriter object called `fw`. The command will then iterate through the existing AppointmentList
and parse each Appointment within, converting it to a string. `fw` then writes this string to the .txt file.
The sequence diagram is shown below:

![](images/saveapptlist_seq.PNG)

#####2.2.3.1 FindPatient/FindAppointment
Design considerations for findPatient:
- general search
- include multiple fields in search

Design considerations for findAppointment:
- using specified formats for date and time, only allow one to be searched at any time
- general search


### [Back to top &#x2191;](#table-of-content)

#### 2.2.4 A&D command module 

The command module consist of 11 different classes, where each class does a different command by itself. 
These classes allows the patients and appointments to be added into HAMS, allows the updating of patient and 
appointment details, allows the admin to delete patients and appointment information and allows of listing of the 
different patients and the appointments in HAMS. In addition, the classes also deals with displaying the list of 
commands and as well as to allowing HAMS to exit.

![](images/Command%20class%20diagram.png)

All of these command classes inherits from the abstract ```Command``` class. Likewise, the execute function of each 
command  class is also inherited from the abstract ```Command``` class's ```execute(Ui ui, Storage storage)``` function 
too. Every command class (other than the  ```ExitCommand``` and ```HelpCommand```) are actually façade classes that 
creates the connection from the ```Main``` class to the other classes required such as ```Storage``` class,
```PatientList``` class and the ```Appointment``` class to name a few. 

##### 2.2.4.1 AddPatientClass

To add a patient, the ```AddPatientCommand``` class is used. For this ```AddPatientCommand``` class, it serves as the 
façade class for the ```Main```, ```Patient``` , ```PatientList``` and the ```Storage``` class to interact with one 
another. Also, to uniquely identify a patient, an unique patientId number is assigned to each patient when they are first added into the patient list.

![](images/AddPatientDiagram.png)

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

![](images/AddPatientCommandSequence.png)
 

##### 2.2.4.2 AddAppointmentClass

To add an appointment, the ```AddAppointmentCommand``` class is used. For this ```AddAppointmentCommand``` class, it 
serves as a façade class for the ```Main```, ```Appointment```, ```AppointmentList``` and the ```Storage``` class to 
interact with one another. 

![](images/AddAppointmentDiagram.png)

1. Like the ```AddPatientCommand``` class, the ```AddAppointmentCommand``` object is first created by the ```Parser``` 
object, where the information of the appointment is again stored in a Map that the ```AddAppoinmentCommand``` object would read from. 
Said information will be stored in the ```AddAppoinmentCommand``` object

2. When 
the ```Main``` calls ```execute(Ui ui, Storage storage)```, the ```AddAppointmentCommand``` class would call upon the 
```Appointment``` class to make an ```Appointment``` Object. 

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

Below shows the sequence diagram for ```AddAppointmentCommand``` class

![](images/AddAppointCommandSequence.png)

##### 2.2.4.3 ListPatientClass

To display the list of patients, the ```ListPatientCommand``` class is called. This class serves as a façade class of 
```Main``` and ```Ui``` to interact with each other. 

![](images/ListPatientDiagram.png)

1. This class' object is first created by the ```Parser``` class, where it is then returned to the ```Main``` class to have its
```execute(Ui ui, Storage storage)``` function be called. 

2. When the ```Main``` class calls the 
```execute(Ui ui, Storage storage)``` function, ```ListPatientCommand``` will call upon the ```Ui```’s 
```showEntirePatientList()``` function to display the list of patients.

Below shows the sequence diagram for ```ListPatientCommand``` class

![](images/ListPatientCommandSequence.png)

##### 2.2.4.4 ListAppointmentClass

To display the list of appointments, the ```ListAppointmentCommand``` class is called. This class serves as a façade 
class of ```Main``` and ```Ui``` to interact with each other. 

![](images/ListAppointmentDiagram.png)

1. This class' object is first created by the ```Parser``` class, where it is then returned to the ```Main``` class to 
have its ```execute(Ui ui, Storage storage)``` function be called. 

2. When the ```Main``` class calls the 
```execute(Ui ui, Storage storage)``` function, ```ListAppointmentCommand``` will call upon the ```Ui```’s 
```showEntireAppointmentList()``` function to display the list of appointments.

Below shows the sequence diagram for ```ListAppointmentCommand``` class

![](images/ListAppointmentCommandSequence.png)

### [Back to top &#x2191;](#table-of-content)

##### 2.2.4.5 Design considerations

For the 4 classes listed, there were some other design considerations that was discussed for these 4 classes. Here, we will discuss the other choices and the pros and cons for them.

###### 2.2.4.5.1 Aspect: Facade classes
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

###### 2.2.4.5.2 Aspect: Autosaving or no

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

###### 2.2.4.5.3 Aspect: Generation of Patient Id

+ Alternative 1 (current choice): Allow the reuse of the patient Id from deleted 
    * Pros: 
        - Allow for reuse, which prevents the patient Id number from running out.
       
    * Cons:
        - Slightly more complicated implementation. Also it means that there is more information that is required to be saved (such as the list of patient Id to be reused) when HAMS shuts down.

+ Alternative 2: Always pick a new number (don't reuse deleted patient Id number)
    * Pros: 
        - Easier to implement and keep track of. Also, it does not need to save much more information about the patient Id numbers (just need to save the last number assigned).
       
    * Cons:
        - Much more likely to run out of patient id numbers, especially if patients are getting added and deleted from HAMS continuously and consecutively.

#### 2.2.4.6 EditAppointmentClass

To edit an appointment, the ```EditAppointmentCommand``` class is used. For this ```EditAppointmentCommand``` class, it 
serves as a façade class for the ```Main```, ```Appointment```, ```AppointmentList``` and the ```Storage``` class to 
interact with one another. 

1. The ```EditAppointmentCommand``` class is processed by ```Parser```

2. When 
the ```Main``` calls ```execute(Ui ui, Storage storage)```, the ```AddAppointmentCommand``` class would call upon the 
```Appointment``` class to make an ```Appointment``` Object. 

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

Below shows the sequence diagram for ```AddAppointmentCommand``` class


#### 2.2.5 Parser module
This section describes the implementation of Parser class, as well as the design considerations and rational behind the 
current implementation.

The main purpose of the Parser class is as below.
1.  To interpret user inputs so that the correct command can be executed 
2.  Functions as the first line to sanitize user input

As such, the Parser class only has one publicly callable method and that returns the command object for execution. 
To assist the public method, Parser class has multiple private helper methods, as well as access to the Exception handler
to ensure that the user input is formatted correctly. This way, purpose 1 and 2 is satisfied. 

##### 2.2.5.1 Object creation and steps in input interpretation
1.  The `Parser` object is first created in `Duke` class and subsequently used until program termination.
2.  User input is received and handed over to `Parser` object for interpretation.
3. In the `Parser` object, the type of command is first determined via helper method `getCommand(userInput)`.
    + Example: `addp \age 23 \name Justin`, the `addp` command will be determined.
4. The remaining fields will be recorded in a hashMap through either `fillPatientFields(userInput)` or `fillAppointmentFields(userInput)`
depending on the command type in Step 3.
    + The type of category of the command can be determined based on the last alphabet of the first word. 
    + The command `addp` has the last alphabet is `p`, `fillPatientFields()` will be called. 
    Likewise, if it ise `adda`, it will be `fillAppointmentFields()`.
    + Example: `addp \name Sam \age 18`, the method `fillPatientFields(userInput)` will be called. The hashMap will contain
    age -> 23, name -> Sam. 
5. At the end of the execution, a reference to the command object will be returned. 

>![](images/SD_parser/Capture2.JPG)

>![](images/SD_parser/Capture.JPG)

Sequence Diagram when `parseCommand(userInput)` is initially called
![](images/SD_parser/Slide1.JPG)

Sequence Diagram for `addp`
![](images/SD_parser/Slide2.JPG)

Sequence Diagram for `editp`
![](images/SD_parser/Slide3.JPG)

Sequence Diagram for `deletep`
![](images/SD_parser/Slide4.JPG)

Sequence Diagram for `adda`
![](images/SD_parser/Slide5.JPG)

Sequence Diagram for `edita`
![](images/SD_parser/Slide6.JPG)

Sequence Diagram for `deletea`
![](images/SD_parser/Slide7.JPG)

Sequence Diagram when it is an unknown command
![](images/SD_parser/Slide8.JPG)

Sequence Diagram for the creation of the command Object

![](images/SD_parser/Slide9.JPG)

Sequence Diagram for error checking when `DukeExpcetion` is called

![](images/SD_parser/Slide10.JPG)

Sequence Diagram for calling an enum

![](images/SD_parser/Slide11.JPG)

Sequence Diagram for error checking when `DukeExpcetion` is called

![](images/SD_parser/Slide12.JPG)

>![](images/SD_parser/Capture3.JPG)

|Enum|PatientFieldKeys|AppointmentFieldKeys
|--------|-------|------|
|.|INDEX|INDEX|
|.|NAME|DATE|
|.|AGE|TIME|
|.|ADDRESS|.|
|.|CONTACT_NUMBER|.|

>![](images/SD_parser/Capture4.JPG)

|DukeExceptions|checkFieldEmpty|checkIndexValidity
|--------|-------|------|
|.|Based on the above enum table, checks that at least 1 field  is provided. <br><br>Throws NoFieldCommandException if all fields are empty|Check that the index provided is valid. <br><br> If it is less than 0 or not an integer, throw InvalidIndex and IndexNotInteger respectively.|



##### 2.2.5.2 Design considerations
###### Aspect: Symbol for delimiter
+   Alternative 1 (current choice): Backslash `/\` is used. 
    *   Pros: 
    
        -   Backslash is the least used symbol in the english language.
        
    *   Cons: 
    
        - More caution must be exercised to used backslash in computer language as REGEX uses it as a delimiter by
          default.
          
        - Might break the speed at which user type since backslash is located where it would be hard to reach with
          regular typing. 

+   Alternative 2: Slash is `/` used.
    * Pros:
    
        - easier to access when typing
        
    * Cons:
    
        - some people may have a slash in their legal name - `Suresh S/O Ravindran`
     
###### Aspect: Symbol for delimiter
+   Alternative 1 (current choice): Each command will call its own method to parse field. 
    *   Pros: 
    
        -   Decouples commands from method, making the code more modular.
        -   Increases testability, bugs found can be isolated to the individual command and method respectively
        -   Changes to one method will only affect the command calling it and vice-versa.
        
    *   Cons: 
    
        -   Code duplication will increase
 
+   Alternative 2: Every command calls a common method to parse the remaining fields. 
    * Pros:
    
        -   Less code duplication
        
        -   Easier to understand code. 
        
    * Cons:
    
        - Leads to tighter coupling
        
        -   All command depends on this common method to parse fields, if the method changes, it may return the wrong
        result for some commands. 

### [Back to top &#x2191;](#table-of-content)

## 3. User Stories

|Version| As a ... | I want to ... | So that I can ...|
|--------|----------|---------------|------------------|
|v1.0|new admin assistant|see usage instructions|refer to them when I forget how to use the application|
|v1.0|admin assistant|add upcoming appointments|set the patient's future appointments|
|v1.0|admin assistant|obtain upcoming appointments|remind patients of their appointment|
|v1.0|admin assistant|reschedule appointments|help the patient change his appointment dates|
|v1.0|admin assistant|add and delete patient's address|update the information in the system|
|v1.0|admin assistant|add and delete telephone number|contact the patient directly|
|v1.0|admin assistant|have an interface|easily update the patient's personal information|
|v1.0|admin assistant|register new patient's medical information|so that it can be stored and accessed whenever needed|
|v1.0|admin assistant|save my data on shutdown|continue my work the next day|
|v2.0|busy admin assistant|immediately know if the patient is scheduled for today|so I can process them better|
|v2.0|admin assistant|be able to find a specific patient|check their appointment details|
|v2.0|admin assistant|clear my lists|keep my list organized when the appointment is over|

### [Back to top &#x2191;](#table-of-content)

## 4. Non-Functional Requirements
* HAMS should be usable with minimal training, all commands should be self-explanatory and viewing the in-application
help menu should be sufficient for basic usage. 

* HAMS should be resistant to software crashes and if a crash does happens, the latest patient and 
appointment list should be saved. In addition, user should be able to manually save their work. 

* Each function of HAMS can be executed in a single line.

* HAMS should be fast and responsive

**TODO**
{Give non-functional requirements}

### [Back to top &#x2191;](#table-of-content)

## 5. Instructions for Manual Testing

### 5.1 Startup, shutdown and restart with saved list.
1. Initial launch
    1. Download the latest release from [here](https://github.com/AY1920S2-CS2113T-T13-3/tp/releases)
    2. Move the .jar to an empty folder
    3. Open Command Prompt
    4. In Command Prompt, change your current working directory to the folder containing the .jar using $ `cd <Path of folder containing .jar>`
    5. Run the .jar using $ `java -jar hams-2.0.jar`
    
    Expected: Shows a welcome screen for HAMS.

2. Shutdown
    1. Run the .jar file
    2. Test case: `exit`
    
    Expected: Bye message is printed and program closes.
 
3. Restart with saved list
    1. Run the .jar file
    2. Add some patients and appointments.
    3. Restart the program
    4. Test case: `listp`
    
    Expected: Previous saved list should be shown.
    
### 5.2 Adding a patient
1. Successfully adding a patient (All fields)
    1. Run the .jar file.
    2. Test case: `addp \name Justin \age 23 \address Pasir Ris \phone 91234567`
    
    Expected: Success message is printed. To double check, type `listp` and ensure that the test case
    is inside.
    
2. Successfully adding a patient (at least 1 field)
    1. Run the .jar file.
    2. Test case: `addp \name Sam`
    
    Expected: Success message is printed. HAMS accept `addp` as long as 1 field is present. To double check, type `listp` and ensure that the test case
    is inside.

3. Unsuccessful add a patient  (no fields provided)
    1. Run the .jar file.
    2. Test case: `addp`
    
    Expected: Error message is printed. To double check, type `listp` and ensure that the test case
    is **not** inside.

### 5.3 Delete a patient

1. Deleting a patient 
    1. Prerequisites: list all patients using `listp`. Multiple patients in list.
    2. Test case: `deletep \index 1`
    
    Expected: First patient in the list is deleted. 
    

### [Back to top &#x2191;](#table-of-content)
