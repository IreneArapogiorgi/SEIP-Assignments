# Unit Testing
The second assignment evaluates unit testing on the following math related classes:
1. MyMath.java - implementing the *factorial* method.
2. ArithmeticOperations.java - implementing methods *divide* and *multiply*.

## Getting Started
1. Fork this repository to your GitHub account.
2. Clone the forked repository to your local machine using ```git clone link-of-forked-repository```.
3. Create a new working branch with ```git branch new-branch```.
4. Change to your new branch with ```git checkout new-branch```.

Make sure [JUnit](https://mvnrepository.com/artifact/junit/junit) is included in pom.xml as a dependency.
```
<dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.12</version>
    <scope>test</scope>
</dependency>
```

## Build
Execute the following command in the repository root directory in order to build the project.
```
mvn clean install
```

## Test
To simply run the unit tests of the project, execute the following command:
```
mvn test
```
Note that only classes with a ```Test``` suffix located in the ```src/test``` will be executed and reported as tests.
You can also run each test independently using Eclipse by right-clicking on the preferred test and choose Run as -> Junit Test.

## Authors
[Irene Arapogiorgi](https://gr.linkedin.com/in/irene-arapogiorgi)

## Acknowledgments
[Antonis Gkortzis](https://github.com/AntonisGkortzis) for the assignment template and instructions.