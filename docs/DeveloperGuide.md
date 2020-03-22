# Developer Guide

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
|Stupendously AwesoMe (SAM) **records**|?| 
|BRillant Ahead of its time Neat Dainty OrigiNal (BRANDON) **storage**|?|
|Amazing & Dazzling (A&D) Commands|?|
|Parser|Parses the user input for command execution|

#### 2.2.1 SAM record module
#### 2.2.2 BRANDON storage module
#### 2.2.3 A&D command module 

The command module consist of 11 different classes, where each class does a different command by itself. 
These classes allows the patients and appointments to be added into HAMS, allows the updating of patient and 
appointment details, allows the admin to delete patients and appointment information and allows of listing of the 
different patients and the appointments in HAMS. In addition, the classes also deals with displaying the list of 
commands and as well as to allowing HAMS to exit.

All of these command classes inherits from the abstract Command class. Likewise, the execute function of each command 
class is also inherited from the abstract Command class's execute function too. Every command class (other than the 
ExitCommand and HelpCommand) are actually façade classes that creates the connection from the Main class to the other 
classes required such as Storage class, PatientList class and the Appointment class to name a few. 

To add a patient, the AddPatientCommand class is used. For this AddPatientCommand class, it serves as the façade class 
for the Main, Patient , PatientList and the  Storage class to interact with one another. The AddPatientCommand class 
object will first be created by the Parser object, where the information regarding the patient to be added will be 
stored in the AddPatientCommand class object. When the execute command is called, the AddPatientCommand would first 
make use of the Patient class constructor to create a new Patient object. After which, it would then call the 
PatientList’s getPatientList() command to get the List patient list object such that the patient object created 
beforehand can directly be inserted into the patient list. After adding the patient into the patient list object, the 
Storage’s savePatientList() function will be called next so that the newly update list of patient is saved as offline 
data.  When this operation is successful, it will call upon the Ui class’ showPatientAddSuccess() function to display 
the success of adding the Patient object into the patient list.

If the supplied patient age is a word or is missing, the age will be set to -1. This value is chosen to indicate that 
there isn’t a valid age set. Thus, when displaying the age, if -1 is encountered, show age as an empty string instead.

To add an appointment, the AddAppointmentCommand class is used. For this AddAppointmentCommand class, it serves as a 
façade class for the Main, Appoinment, AppointmentList and the Storage class to interact with one another. Like 
the AddPatientCommand class, the AddAppointmentCommand object is first created by the Parser object, where the 
information of the appointment is again stored in the AddAppoinmentCommand object. When the Main calls execute, the 
AddAppoinmentCommand class would call upon the Appoinment class to make an Appointment Object. After which, the 
AddAppoinmentCommand object will call upon the AppointmentList object to obtain the list of Appointments (get the List 
object that represents the list of appointments by AppointmentList’s getAppointmentList() command) so that it can 
directly add the new Appointment object into the appointment list. Finally, it will call upon the Storage class’s 
saveAppoinmentList() function to save the updated appointment list. Upon successfully adding the Appointment object 
into the appointment list, it will call upon the Ui class’ showAppointmentAddSuccess() function to display the success 
of adding the appointmet into the appointment list.

To display the list of patient, the ListPatientCommand class is called. This class serves as a façade class of Main and 
Ui. This class is first created by the Parser class, where it is then returned to the Main class to have its execute 
function be called. When the Main class calls the execute function, ListPatientCommand will call upon the Ui’s 
showEntirePatientList() function to display the list of patients.

To display the list of appointment, the ListAppointmentCommand class is called. This class serves as a façade 
class of Main and Ui. This class is first created by the Parser class, where it is then returned to the Main class to 
have its execute function be called. When the Main class calls the execute function, ListAppointmentCommand will call 
upon the Ui’s showEntireAppointmentList() function to display the list of appointments.

   
#### 2.2.4 Parser module
**TODO**
{Describe the design and implementation of the product. Use UML diagrams and short code snippets where applicable.}


## 3. User Stories

|Version| As a ... | I want to ... | So that I can ...|
|--------|----------|---------------|------------------|
|v1.0|new admin assistant|see usage instructions|refer to them when I forget how to use the application|
|v1.0|admin assistant|add upcoming appoitnments|set the patient's future appointments|
|v1.0|admin assistant|obtain upcoming appointments|remind patients of their appointment|
|v1.0|admin assistant|reschedule appointments|help the patient change his appointment dates|
|v1.0|admin assistant|add and delete patient's address|update the information in the system|
|v1.0|admin assistant|add and delete telephone number|contact the patient directly|
|v1.0|admin assistant|have an interface|easily update the patient's personal information|
|v1.0|admin assistant|register new patient's medical information|so that it can be stored and accessed whenever needed|
|v1.0|admin assistant|save my data on shutdown|continue my work the next day|
|v2.0|user|find a to-do item by name|locate a to-do without having to go through the entire list|

## 4. Non-Functional Requirements
* HAMS should be usable with minimal training, all commands should be self-explanatory and viewing the in-application
help menu should be sufficient for basic usage. 

* HAMS should be resistant to software crashes and if a crash does happens, the latest patient and 
appointment list should be saved. In addition, user should be able to manually save their work. 

* Each function of HAMS can be executed in a single line.

* 

**TODO**
{Give non-functional requirements}


## 5. Instructions for Manual Testing

**TODO**
{Give instructions on how to do a manual product testing e.g., how to load sample data to be used for testing}
