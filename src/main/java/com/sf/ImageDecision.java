package com.sf;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Biose, Nonso Emmanuel
 * @since 26-03-2019
 * This class models the Json object returned from the icaoValidation
 */
public class ImageDecision {

    /**
     * This holds all the properties of the com.sf.ImageDecision
     */
    private Map<String, Property> propertyMap;

    public ImageDecision (String json) {

        if(!json.isEmpty()) {

            this.propertyMap = new HashMap<>();

            System.out.println(json);
            JSONObject jsonObject = new JSONObject(json);

            JSONObject property = jsonObject.optJSONObject("IMAGE_DIMENSION");
            String name = property.optString("PROPERTY");
            String message = property.optString("MESSAGE");
            boolean isValid = property.optBoolean("VALID");
            String value = property.optString("VALUE");
            Property newProperty = new Property(name, message, isValid, value);
            propertyMap.put(name, newProperty);

            property = jsonObject.optJSONObject("BRIGHTNESS_CONTRAST");
            name = property.optString("PROPERTY");
            message = property.optString("MESSAGE");
            isValid = property.optBoolean("VALID");
            value = property.optString("VALUE");
            newProperty = new Property(name, message, isValid, value);
            propertyMap.put(name, newProperty);

            property = jsonObject.optJSONObject("FACE_BLUR");
            name = property.optString("PROPERTY");
            message = property.optString("MESSAGE");
            isValid = property.optBoolean("VALID");
            value = property.optString("VALUE");
            newProperty = new Property(name, message, isValid, value);
            propertyMap.put(name, newProperty);

            property = jsonObject.optJSONObject("SKIN_TONE");
            name = property.optString("PROPERTY");
            message = property.optString("MESSAGE");
            isValid = property.optBoolean("VALID");
            value = property.getString("VALUE");
            newProperty = new Property(name, message, isValid, value);
            propertyMap.put(name, newProperty);

            property = jsonObject.optJSONObject("FACE_ALIGNED");
            name = property.optString("PROPERTY");
            message = property.optString("MESSAGE");
            isValid = property.optBoolean("VALID");
            value = property.optString("VALUE");
            newProperty = new Property(name, message, isValid, value);
            propertyMap.put(name, newProperty);

            property = jsonObject.optJSONObject("SHOULDER_EXISTS");
            name = property.optString("PROPERTY");
            message = property.optString("MESSAGE");
            isValid = property.optBoolean("VALID");
            value = property.optString("VALUE");
            newProperty = new Property(name, message, isValid, value);
            propertyMap.put(name, newProperty);

            property = jsonObject.optJSONObject("FACE_CENTERED");
            name = property.optString("PROPERTY");
            message = property.optString("MESSAGE");
            isValid = property.optBoolean("VALID");
            value = property.optString("VALUE");
            newProperty = new Property(name, message, isValid, value);
            propertyMap.put(name, newProperty);

//            property = jsonObject.optJSONObject("EYE_GLASS");
//            name = property.getString("PROPERTY");
//            message = property.getString("MESSAGE");
//            isValid = property.getBoolean("VALID");
//            value = property.getString("VALUE");
//            newProperty = new Property(name, message, isValid, value);
//            propertyMap.put(name, newProperty);

            property = jsonObject.optJSONObject("FACE_COVERED");
            name = property.optString("PROPERTY");
            message = property.optString("MESSAGE");
            isValid = property.optBoolean("VALID");
            value = property.optString("VALUE");
            newProperty = new Property(name, message, isValid, value);
            propertyMap.put(name, newProperty);

            property = jsonObject.optJSONObject("FACE_COUNT");
            name = property.optString("PROPERTY");
            message = property.optString("MESSAGE");
            isValid = property.optBoolean("VALID");
            value = property.optString("VALUE");
            newProperty = new Property(name, message, isValid, value);
            propertyMap.put(name, newProperty);
        }
    }

    /**
     *
     */
    public class Property {

        /**
         * Name of the property
         */
        String name;

        /**
         * Decision of the property
         */
        String message;

        /**
         * if the property is valid
         */
        boolean isValid;

        /**
         * value of the property
         */
        String value;

        private Property(String name, String message, boolean isValid, String value) {
            this.name = name;
            this.isValid = isValid;
            this.message = message;
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public boolean getIsValid() {
            return isValid;
        }

        public String getMessage() {
            return message;
        }

        public String getValue() {
            return value;
        }
    }

    public Map<String, Property> getPropertyMap() {
        return propertyMap;
    }
}
