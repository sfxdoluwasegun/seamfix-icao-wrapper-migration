# ICAO Dependency (wrapper)
A Java wrapper built to expose Python based validation-api functions to JAVA project

# SPECIFICATIONS & LIBRARIES
- JAVA 8
- Java Embedded Python (JEP)

# How to set up your Environment for the Library
* Download and install [Microsoft Visual Build Tools for Visual Studio 2015](https://www.microsoft.com/en-us/download/details.aspx?id=48159)
* Download and install [Visual C++ Redistributable for Visual Studio 2015](https://www.microsoft.com/en-us/download/details.aspx?id=48145)
* Download and install [Python](https://www.python.org/downloads/)
* Download and install [CMake](https://cmake.org/download/)
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
```
# Dependency (Maven)
```groovy
        implementation 'com.sf:icao-validation-java-bridge:1.0.0-SNAPSHOT'
```

# How to use the Icao-Wrapper Library
```java
        ICAOValidator validator = null;
        try {
            validator = new ICAOValidator("path/to/.ini"); // Download this from the root of this repository
            ImageDecision decision = validator.icaoValidate("path/to/image");
            Map<String, ImageDecision.Property> map = decision.getPropertyMap();
            ImageDecision.Property property = map.get("ImageDecision property key");
            System.out.println(property.getIsValid());
            System.out.println(property.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
```

# ImageDecision property keys
* BACKGROUND_LIGHT
* BRIGHTNESS_CONTRAST
* EYE_GLASS
* FACE_ALIGNED
* FACE_BLUR
* FACE_CENTERED
* FACE_COVERED
* IMAGE_DIMENSION
* RED_EYE_DETECT
* SHADOW_DETECTION
* SHOULDER_EXISTS
* SKIN_TONE
