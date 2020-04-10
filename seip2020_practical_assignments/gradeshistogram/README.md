# Histogram Generator
The first assignment evaluates a Java application (.jar file) which receives as input a text file containing students' grades and produces its histogram.

## Getting Started
1. Fork this repository to your GitHub account.
2. Clone the forked repository to your local machine using ```git clone link-of-forked-repository```.
3. Create a new working branch with ```git branch new-branch```.
4. Change to your new branch with ```git checkout new-branch```.

Make sure [JFreeChart](https://mvnrepository.com/artifact/org.jfree/jfreechart) is included in pom.xml as a dependency.
```
<dependency>
    <groupId>org.jfree</groupId>
    <artifactId>jfreechart</artifactId>
    <version>1.5.0</version>
</dependency>
```

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

## Build
Execute the following command in the repository root directory in order to build all modules.
```mvn package```
This command generates a seperate jar file in module's corresponding target (```module/target```) directory.

## Authors
* [Irene Arapogiorgi](https://gr.linkedin.com/in/irene-arapogiorgi)

## Acknowledgments
* [Antonis Gkortzis](https://github.com/AntonisGkortzis) for the assignment template and instructions.