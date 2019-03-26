# ICAO Dependency (wrapper)
A Java wrapper built to expose Python based validation-api functions to JAVA project

# SPECIFICATIONS & LIBRARIES
- JAVA 8
- Java Embedded Python (JEP)

# How to set up your Environment for the Library
* Download and install Python 
* Download the requirements.txt from the root of this project
* Cd to the path of the requirements.txt
* Run this command to install all required Python packages: pip install -r requirements.txt
* Add the icao-wrapper dependency to your pom.xml

# Dependency (Maven)


# How to use the Icao-Wrapper Library
```java
        ICAOValidator validator = null;
        try {
            validator = new ICAOValidator("path/to/.ini");
            ImageDecision decision = validator.icaoValidate("path/to/image");
            Map<String, ImageDecision.Property> map = decision.getPropertyMap();
            ImageDecision.Property property = map.get("ImageDecision propert key");
            System.out.println(property.getIsValid());
            System.out.println(property.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
```
