# SEIP-Assignments
[![Build Status](https://travis-ci.com/IreneArapogiorgi/SEIP-Assignments.svg?token=DbTRNzdsiZ9EWLeNqxpq&branch=development)](https://travis-ci.com/IreneArapogiorgi/SEIP-Assignments)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

## Overview
This repository contains assignments delivered for Software Engineering in Practice course. The course is part of the curriculum of the [Department of Management Science & Technology](https://www.dept.aueb.gr/en/dmst) from the Athens University of Economics and Business and the project is assigned by [Diomidis Spinellis](https://github.com/dspinellis) and [Antonis Gkortzis](https://github.com/AntonisGkortzis).

## Project Structure
This repository's main folder seip2020_practical_assignments contains the following assignments:

[Histogram Generator](seip2020_practical_assignments/gradeshistogram) - creates a histogram from a given file of student's grades.

[Unit Testing](seip2020_practical_assignments/unittesting) - runs multiple unit tests on math related classes.

[Code Analyzer](seip2020_practical_assignments/codeanalyzer) - extracts metrics of a given Java file.

## Getting Started
1. Fork this repository to your GitHub account.
2. Clone the forked repository to your local machine using ```git clone link-of-forked-repository```.
3. Create a new working branch with ```git branch new-branch```.
4. Change to your new branch with ```git checkout new-branch```.
5. Follow the instructions given in each assignment's README.

## Build
Execute the following command in the repository root directory in order to build the project.
```
mvn clean install jacoco:report
```
This command will also generate a report of the code coverage produced by JaCoCo. The report will be located in the following path for each module:
```
target/site/jacoco
```

## Test
To simply run the unit tests of the project, execute the following command:
```
mvn test
```
Note that only classes with a ```Test``` suffix located in the ```src/test``` will be executed and reported as tests.
You can also run each test independently using Eclipse by right-clicking on the preferred test and choose Run as -> Junit Test.

## Generate Test-Coverage Report
To simply run the unit tests of the project, execute the following Maven command:
```
mvn test jacoco:report
```

## Continuous Integration
This projects utilizes [TravisCI](https://docs.travis-ci.com/user/tutorial/) services in other to test and build the application upon each ```git-push``` in the remote repository. There are multiple build environments in which the application will be tested and build. You can check these options under the ```jdk``` tag in the ```.travis.yml``` file.

After each build, the badge is updated with the corresponding build status, green for passes and red for failures.

## Build With
* Eclipse IDE 2020-03
* Java SE Development Kit 8
* Apache Maven 3.6.3

## How To
* [Install Eclipse](https://www.eclipse.org/downloads/)
* [Install Java](https://www.oracle.com/java/technologies/javase-jdk8-downloads.html)
* [Setup Maven in Windows](https://mkyong.com/maven/how-to-install-maven-in-windows/)
* Setup Maven in Linux. Execute ```sudo apt update && sudo apt install maven``` in a terminal.

## Authors
[Irene Arapogiorgi](https://gr.linkedin.com/in/irene-arapogiorgi)

## Acknowledgments
[Antonis Gkortzis](https://github.com/AntonisGkortzis) for the assignment template and instructions.