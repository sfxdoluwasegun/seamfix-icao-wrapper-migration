# ICAO Dependency (wrapper)
A Java wrapper built to expose Python based validation-api functions to JAVA project

# SPECIFICATIONS & LIBRARIES
- JAVA 8
- Java Embedded Python (JEP)

# How to set up your Environment for the Library
* Download and install Microsoft Visual Build Tools for Visual Studio 2015
* Download and install [Python 3.6.+](https://www.python.org/downloads/)
* Download and install [CMake](https://cmake.org/download/)
* Download the classifier_xml directory
* Download the jep.dll file and place it in the System32 directory of your computer
* Download the requirements.txt from the root of this project
* Cd to the path of the requirements.txt
* Run this command to install all required Python packages: ```pip install -r requirements.txt```
* Add the icao-wrapper dependency to your pom.xml

# Dependency (Maven)
```xml
    <dependency>
        <groupId>com.sf</groupId>
        <artifactId>icao-validation-java-bridge</artifactId>
        <version>1.0.0-SNAPSHOT</version>
    </dependency>
        
    <repositories>
        <repository>
            <id>nexus</id>
            <snapshots>
                <enabled>true</enabled>
            </snapshots>
            <releases>
                <enabled>true</enabled>
            </releases>
            <url>https://nexus.seamfix.com/nexus/content/groups/public</url>
        </repository>
    </repositories>
```
# Dependency (Gradle)
```groovy
    implementation 'com.sf:icao-validation-java-bridge:1.0.0-SNAPSHOT'
```

# How to use the Icao-Wrapper Library
```java
    ICAOValidator validator = null;
    try {
        validator = new ICAOValidator("path/to/.ini/in the classifier_xml"); // Download this from the root of this repository
        String json = validator.validate("path/to/image");
        System.out.println(json);
    } catch (IOException e) {
        e.printStackTrace();
    }
```

# Sample Icao validation response
```json

```
**Json Keys for the returned Json validation result**

key | Value
--- | ---
validations | The list of validations
name | Name of the Icao validation
message | The message describing the result of the validation
isValid | Boolean value that represents the state of the result
value | The returned value that can be used to make decisions on the threshold used

