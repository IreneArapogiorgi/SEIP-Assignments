# SEIP-Assignments
This repository contains assignments delivered for Software Engineering in Practice course. The course is part of the curriculum of the [Department of Management Science & Technology](https://www.dept.aueb.gr/en/dmst) from the Athens University of Economics and Business and the project is assigned by [Diomidis Spinellis](https://github.com/dspinellis) and [Antonis Gkortzis](https://github.com/AntonisGkortzis).

## Project Structure
This repository's main folder seip2020_practical_assignments contains the following assignment:

[Histogram Generator](gradeshistogram) - creates a histogram from a given file of student's grades
The first assignment consists of a parent Maven project named *seip2020_practical_assignments* and one sub-project (module) named *gradeshistogram*, which handles the dependencies in a different way.

Execute the following command in the repository root directory in order to build all modules. 
```
mvn package
```
This command generates a seperate jar file in module's corresponding target (```module/target```) directory.

### Histogram Generator
This module requires one runtime dependency which is packaged in the main jar (fat-jar). To create a fat-jar you need to use the ```maven-assembly-plugin``` plugin and also define the class that is the main entry point of the system (the class that contains the main method). 
```
<plugin>
	<artifactId>maven-assembly-plugin</artifactId>
	<configuration>
		<archive>
			<manifest>
			  <mainClass>gradeshistogram.HistogramGenerator</mainClass> 
			</manifest>
		</archive>
		<descriptorRefs>
			<descriptorRef>jar-with-dependencies</descriptorRef>
		</descriptorRefs>
	</configuration>
	<executions>
		<execution>
			<id>make-assembly</id>
			<phase>package</phase>
			<goals>
				<goal>single</goal>
			</goals>
		</execution>
	</executions>
</plugin>
```

The produced jar is located in the target directory and can be executed as following:
```
java -jar gradeshistogram/target/gradeshistogram-0.0.1-SNAPSHOT-jar-with-dependencies.jar
```
Note that the gradeshistogram-0.0.1-SNAPSHOT.jar is not executable. 

## How to...
1) Setup Maven in Windows - [tutorial](https://mkyong.com/maven/how-to-install-maven-in-windows/)
2) Setup Maven in Linux. Execute ```sudo apt update && sudo apt install maven``` in a terminal.

## Authors

* [Irene Arapogiorgi](https://gr.linkedin.com/in/irene-arapogiorgi)