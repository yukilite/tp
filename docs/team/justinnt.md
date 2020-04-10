# Tan Zheng Fu Justin -Project Portfolio

## Overview
Hospital Administrative Management System (HAMS) is a CLI-based medical facility administration system that is used for 
maintaining medical records. It is written in Java.

### Summary of Contributions

- **Major Enhancement 1**: implemented the logic for `Parser`.

    - What it does: Interprets the User's input so that the correct command can be executed. It also functions
    as the first line to sanitize user input.
   
    - Justification: As the backbone of the program, it potentially interacts with all of the commands. As such, the correct
    format and values should be given to these commands for execution.
    
    - Highlights: 
    
        - The current implementation allows Users to input the format in any order, as long as it is an accepted format.
          For Example, for the valid command: `addp` and accepted formats `\name` and `\age`, both commands below will 
          yield the same outcome.
      
          Command 1: `addp \name Justin \age 24`
          
          Command 2: `addp \age 24 \Justin`
          
        - There is a need to analysis and think in terms of User behaviour as there is no telling what the User will input 
          into the command line. This aspect makes it challenging, as various circumstances from the user's point of view
          needs to be considered. 
          
          For example, what if the users did not provide any formats? What if the users provide the formats but did not
          give any values? What is the index provided is not an integer? These questions then have to be converted into
          codes and custom exceptions for each situation has to be created. 
          
        - Ease of maintainability and upgrade. The Parser has a modular design, all different commands are handled in
          different methods. This allows separation of work and makes it easy for any future developers to modify anything.
          
          In addition, with regards to future upgrades, additional formats might be introduced, such as `\bloodtype` 
          when adding a patient. It is extremely easy to add new formats into the Parser class due to its modularity. 
          Simply add the requires field into the correct enum, and the Parser will loop through the enum to find the 
          required formats inside. 
     
- **Major Enhancement 2**: implemented the `DukeExceptions` for error checking.
    
    - What it does: `DukeExceptions` acts like a public class with methods to call to check the parameters for correctness.
    
    - Justifications: It abstracts out lengthy checks for classes that class `DukeExceptions's` methods. This reduces code 
    duplication and increases abstraction.
    
    - Highlights: 
     