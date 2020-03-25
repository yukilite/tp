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
#### 2.2.4 Parser module
**TODO**
{Describe the design and implementation of the product. Use UML diagrams and short code snippets where applicable.}


## 3. User Stories

|Version| As a ... | I want to ... | So that I can ...|
|--------|----------|---------------|------------------|
|v1.0|new admin assistant|see usage instructions|refer to them when I forget how to use the application|
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

**TODO**
{Give non-functional requirements}


## 5. Instructions for Manual Testing

**TODO**
{Give instructions on how to do a manual product testing e.g., how to load sample data to be used for testing}
