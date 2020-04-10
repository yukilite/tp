# Brandon Chong - Project Portfolio Page

---

## Overview
### Project: Hospital Management System v2.0
Hospital Administrative Management System - HAMS is a CLI-based medical facility administration system that assists in the maintenance of various medical records. 

HAMS is designed for administrative assistants in medical facilities, like hospitals or polyclinics, that *prefer using
CLI to keep track of various medical records* and *can type fast*.

### Summary of Contributions

- **Major Enhancement 1**: Implemented the `Storage` class.

    - *What it does*: Backs up existing `Patient` and `Appointment` record data, that are stored in the `PatientList` and 
    `AppointmentList` objects respectively, to local .txt save files upon adding/editing of information or upon exiting 
    the program. It also parses the two types of saved record data from the .txt files into the `PatientList` and 
    `AppointmentList` when starting up the program.
   
    - *Justification*: This increases the usability of the program by enabling data to exist beyond the execution lifetime 
    of the program. Previously created `Patient` and `Appointment` records can be easily referenced and accessed through 
    the program without having to manually store the data by oneself. 
    
    - *Highlights*: 
    
        - The current implementation utilises a folder `saves` in the directory where the .jar file of HAMS is located. This 
        folder contains the .txt files that will be used to store the information of existing `Patient` and `Appointment`
        objects separately.
          
        - It is necessary to consider how the `saves` folder contents may be affected by external factors, which may cause it to 
        deviate from its intended behaviour. For instance, the files could have been deleted, or simply not exist (if the user
        is running HAMS for the first time). Moreover, malicious entities may render the files unreadable, for example by manually 
        removing from the file the separators that the methods in `Storage` uses to parse the data. 
        
          The `loadSavedPatients` or `loadSavedAppointments` methods which are involved in converting the .txt file data
          to `Patient`/`Appointment` records in the program itself and invoked on program startup thus utilise exceptions
          and clause checks to ensure the program can continue to run smoothly. If the file does not exist, the methods will create them 
          on startup. If the file is corrupted, the methods will delete the file and recreate it.
          
        - Ultimately, the aforementioned methods allow `Storage` to convert individual lines from the .txt files, each
        representing a different record, to `Patient`/`Appointment` objects and add them to `PatientList`/`AppointmentList`
        respectively so that after startup, the list of current Patients and Appointments are available for the user
        to peruse.

     
- **Minor Enhancement 1**: Implemented find commands for both Patients `(findp)` and Appointments `(finda)`.

&nbsp;

- **Code contributed:** [tP code Dashboard](https://nus-cs2113-ay1920s2.github.io/tp-dashboard/#breakdown=true&search=brandoncjh&sort=groupTitle&sortWithin=title&since=2020-03-01&timeframe=commit&mergegroup=false&groupSelect=groupByRepos)

- **Other contributions:** 
    
    - Project management:
        
        - Managed v1.0 HAMS release on Github
    
    - Documentation:
    
        - Developed User Guide (UG) draft for HAMS v1.0
            - See: [1](https://github.com/AY1920S2-CS2113T-T13-3/tp/pull/39), [2](https://github.com/AY1920S2-CS2113T-T13-3/tp/pull/42)
        - Developed Developer Guide (DG) documentation for Storage and FindPatientCommand/FindAppointmentCommand classes

    - Community:
    
        - Reported bugs and suggestions for other teams in the class 
            - See: [1](https://github.com/brandoncjh/ped/issues), [2](https://github.com/nus-cs2113-AY1920S2/tp/pull/4/files/3c632f30ad42dbc770079d0ea5da26929b52fbed)
        - Engaged in class forum to help answer other classmates' general queries
            - See: [1](https://github.com/nus-cs2113-AY1920S2/forum/issues/78#issuecomment-599041742), [2](https://github.com/nus-cs2113-AY1920S2/forum/issues/81#issuecomment-600406106)
        


## Contributions to the User Guide
```
Given below are sections I contributed to the User Guide. They showcase my ability to write documentation targeting end-users.
```


&nbsp;

***

## Contributions to the Developer Guide
```
 Provided below are sections I contributed to the Developer Guide. They demonstrate my ability to communicate my 
 technical contributions to the project and rationale for technical implementation.
```
