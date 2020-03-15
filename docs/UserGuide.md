# User Guide For Hospital Management System v1.0

# Table of content
<!-- TOC -->
- [Introduction](#introduction)
- [Prerequisites](#prerequisites)
- [Features](#features)
    - [Add appointment](#add-appointment)
    - [Add patient](#add-patient)
    - [List appointment](#list-appointment)
    - [List patient](#list-patient)
    - [Delete appointment](#delete-appointment)
    - [Delete patient](#delete-patient)
    - [Edit appointment](#edit-appointment)
    - [Edit patient](#edit-patient)
    - [Help manual](#help-manual)
    - [Exit the program](#exit-the-program)
- [Usage](#usage)
    - [`adda \date [date] \time [time]` - Adds date and time of an appointment](#adda-date-date-time-time---adds-date-and-time-of-an-appointment)
    - [`addp \name [name] \age [age] \address [address] \phone [phone]` - Adds name, age, address, and contact number of patient](#addp-name-name-age-age-address-address-phone-phone---adds-name-age-address-and-contact-number-of-patient)
    - [`lista` - List all the appointments from the appointment's liste](#lista---list-all-the-appointments-from-the-appointments-list)
    - [`listp` - List all the patients from the patient's list](#listp---list-all-the-patients-from-the-patients-list)
    - [`deletea \index [appointment number in list]` - Delete an appointment by the list's appointment number](#deletea-index-appointment-number-in-list---delete-an-appointment-by-the-lists-appointment-number)
    - [`deletep \index [patient number in list]` - Delete a patient by the list's patient number](#deletep-index-patient-number-in-list---delete-a-patient-by-the-lists-patient-number)
    - [`edita \index [appointmentNumber] \date [date] \time [time]` - Edit date or time of an appointment by the list's appointment number](#edita-index-appointmentnumber-date-date-time-time---edit-date-or-time-of-an-appointment-by-the-lists-appointment-number)
    - [`editp \index [patientNumber] \name [name] \age [age] \address [address] \phone [phone]` - Edit name / age / address / contact number of an appointment by the list's patient number](#editp-index-patientnumber-name-name-age-age-address-address-phone-phone---edit-name--age--address--contact-number-of-an-appointment-by-the-lists-patient-number)
    - [`help` - Give you a manual on a list of valid commands and their usage](#help---give-you-a-manual-on-a-list-of-valid-commands-and-their-usage)
    - [`exit` - Exit the program and save the task into an offline data file (in `/saves/appointments.txt` or `/saves/patients.txt`)](#exit---exit-the-program-and-save-the-task-into-an-offline-data-file-in-savesappointmentstxt-or-savespatientstxt)
<!-- /TOC -->

## Introduction

`//Insert welcome message of program here`

Our hospital administration system is to aid the management of the administrator of the whole hospital. Regularly,
records and appointments of patients have to be keep track by the doctors, and our system is to save, load, and write 
the data that you want to save. Its functionality has some resemblance to the Duke ChatBot, a CS2113 individual project.

When Duke starts, it loads the 2 list of record, an appointment list from `saves\appointments.txt` and a patient list 
from `saves\patients.txt` if one of them exists. After each of the user's input, the data given is auto saved to the data
files mentioned above.
 
Duke uses UTF-8 unicode characters, which some command prompt might not support. If your command prompt supports 
UTF-8 natively, to run duke, type this into command prompt

`$ java -jar hms-1.0.jar`

`//Insert image here`
    
## Prerequisites
Duke's system requirements
1. JDK 11
2. Able to output unicode characters in command prompt


## Features

### Add appointment 
Adds date and time of an appointment

### Add patient
Adds name, age, address, and contact number of patient

### List appointment
List all the appointments from the appointment's list

### List patient
List all the patients from the patient's list

### Delete appointment
Delete an appointment based on its index 

### Delete patient
Delete a patient based on its index

### Edit appointment
Edit appointment's information in some fields

### Edit patient
Edit patient's information in some field

### Help manual
Give you a manual on a list of valid commands and their usage

### Exit the program
Exit the program and save the task into an offline data file (in `/saves/appointments.txt` or `/saves/patients.txt`)

## Usage

### `adda \date [date] \time [time]` - Adds date and time of an appointment

The program supports adding an appointment to an appointment's list. The command contains:
1. the `adda` keyword
2. the date of the appointment is inputted after `\date`
3. the time of the appointment is inputted after `\time`
(Both date and time are currently in string so they will be further developed later)

Format: `adda \date [date] \time [time]`

#### Example of usage: 
- `adda \date 14-03-2020 \time 10am`

##### Expected outcome:
`//Insert UI here`

#### Example of wrong usage (missing description): 
`//Insert UI here`

##### Expected error outcome:
`//Insert UI here`

### `addp \name [name] \age [age] \address [address] \phone [phone]` - Adds name, age, address, and contact number of patient

The program supports adding a patient to the patient's list. The command contains:
1. the `addp` keyword
2. the name of the patient is inputted after `\name`
3. the age of the patient is inputted after `\age`
4. the address of the patient is inputted after `\address`
5. the contact number of the patient is inputted after `\phone`
(All these fields will be developed so that later on they have certain limit and validation of the text or number inputted)

Format: `addp \name [name] \age [age] \address [address] \phone [phone]`

#### Example of usage: 
- `addp \name Justin \address Pasir Ris \age 20 \phone 98889888`

##### Expected outcome:

#### Example of usage: 

##### Expected outcome:

#### Example of wrong usage  

##### Expected error outcome:

### `lista` - List all the appointments from the appointment's list

The command simply contains the 'lista' keyword

Format: `lista`

#### Example of usage: 
`lista`

##### Expected outcome:

#### Example of wrong usage : 

##### Expected error outcome:

### `listp` - List all the patients from the patient's list

The command simply contains the 'listp' keyword

Format: `listp`
#### Example of usage: 
`listp`

##### Expected outcome 

### `deletea \index [appointment number in list]` - Delete an appointment by the list's appointment number

The program supports the deletion of appointments by the appointment's number in the list. The command contains:
1. the `deletea` keyword
2. the appointment number of the appointment to be deleted 

Format: `deletea \index [appointment number in list]`

#### Example of usage: 
- `deletea \index 3`

##### Expected outcome:

#### Example of wrong usage : 

##### Expected error outcome:

### `deletep \index [patient number in list]` - Delete a patient by the list's patient number

The program supports the deletion of patients by the patient's number in the list. The command contains:
1. the `deletep` keyword
2. the patient number of the patient to be deleted 

Format: `deletep \index [patient number in list]`

#### Example of usage: 
`deletep \index 5`

##### Expected outcome:

#### Example of wrong usage:

##### Expected error outcome:

### `edita \index [appointmentNumber] \date [date] \time [time]` - Edit date or time of an appointment by the list's appointment number

The program supports the editing of appointments by the appointment's number in the list. The command contains:
1. the `edita` keyword
2. appointment's number in the list followed by `\index`
3. the date of the appointment followed by `\date` 
4. the time of the appointment followed by `\time`
Note that users do not need to include any single field that needs to be modified in the command.
Illustration will be later shown in the command's format and usage

Format: `edita \index [appointmentNumber] \date [date] \time [time]`

#### Example of usage: 
`edita \index 3 \date 20-05-2021 \time 11pm`

##### Expected outcome:

#### Example of usage: 
`edita \index 3 \time 11pm \date 20-05-2021`

##### Expected outcome:

#### Example of usage: 
`edita \index 5 \time 11:30am`

##### Expected outcome:

### `editp \index [patientNumber] \name [name] \age [age] \address [address] \phone [phone]` - Edit name / age / address / contact number of an appointment by the list's patient number

The program supports the editing of patients by the patient's number in the list. The command contains:
1. the `editp` keyword
2. patient's number in the list followed by `\index`
3. the name of the patient followed by `\name` 
4. the age of the patient followed by `\age`
4. the address of the patient followed by `\address`
4. the contact number of the patient followed by `\phone`
Note that users do not need to include any single field that needs to be modified in the command.
Illustration will be later shown in the command's format and usage

Format: `editp \index [patientNumber] \name [name] \age [age] \address [address] \phone [phone]`

#### Example of usage: 
`editp \index 5  \name Justin \age 23 \address Clementi \phone 83487846`

##### Expected outcome:

#### Example of usage: 
`editp \age 23 \address Clementi \phone 83487846 \name Justin \index 5`

##### Expected outcome:

#### Example of usage: 
`editp \index 10 \address Paris Ris \phone 93489678`

##### Expected outcome:

### `help` - Give you a manual on a list of valid commands and their usage

The command simply contains the 'help' keyword

Format: `help`
#### Example of usage: 
`help`

##### Expected outcome 

### `exit` - Exit the program and save the task into an offline data file (in `/saves/appointments.txt` or `/saves/patients.txt`)

The command simply contains the 'exit' keyword

Format: `exit`
#### Example of usage: 
`exit`

##### Expected outcome: 

## FAQ

**Q**: Why do I have to learn CS2106? 

**A**: Because you will learn a lot of "C" programming.

## Command Summary
* `adda \date [date] \time [time]` Adds date and time of an appointment
* `addp \name [name] \age [age] \address [address] \phone [phone]` Adds name, age, address, and contact number of patient
* `lista` List all the appointments from the appointment's list
* `listp` List all the patients from the patient's list
* `deletea \index [appointment number in list]` Delete an appointment by the list's appointment number
* `deletep \index [patient number in list]` Delete a patient by the list's patient number
* `edita \index [appointmentNumber] \date [date] \time [time]` Edit date or time of an appointment by the list's appointment number
* `editp \index [patientNumber] \name [name] \age [age] \address [address] \phone [phone]` Edit date or time of an appointment by the list's appointment number
* `help` Give you a manual on a list of valid commands and their usage
* `exit` Exit the program and save the task into an offline data file (in `/saves/appointments.txt` or `/saves/patients.txt`)



