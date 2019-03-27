package com.sf;

import org.json.JSONObject;

import java.util.Collections;
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

            JSONObject property = jsonObject.optJSONObject(IcaoValidatorConstants.IMAGE_DECISION_KEYS.IMAGE_DIMENSION.name());
            String name = IcaoValidatorConstants.IMAGE_DECISION_KEYS.IMAGE_DIMENSION.name();
            String message = property.optString(IcaoValidatorConstants.IMAGE_DECISION_PROPERTIES.MESSAGE.name());
            boolean isValid = property.optBoolean(IcaoValidatorConstants.IMAGE_DECISION_PROPERTIES.VALID.name());
            String value = property.optString(IcaoValidatorConstants.IMAGE_DECISION_PROPERTIES.VALUE.name());
            Property newProperty = new Property(name, message, isValid, value);
            propertyMap.put(name, newProperty);

            property = jsonObject.optJSONObject(IcaoValidatorConstants.IMAGE_DECISION_KEYS.BRIGHTNESS_CONTRAST.name());
            name = IcaoValidatorConstants.IMAGE_DECISION_KEYS.BRIGHTNESS_CONTRAST.name();
            message = property.optString(IcaoValidatorConstants.IMAGE_DECISION_PROPERTIES.MESSAGE.name());
            isValid = property.optBoolean(IcaoValidatorConstants.IMAGE_DECISION_PROPERTIES.VALID.name());
            value = property.optString(IcaoValidatorConstants.IMAGE_DECISION_PROPERTIES.VALUE.name());
            newProperty = new Property(name, message, isValid, value);
            propertyMap.put(name, newProperty);

            property = jsonObject.optJSONObject(IcaoValidatorConstants.IMAGE_DECISION_KEYS.FACE_BLUR.name());
            name = IcaoValidatorConstants.IMAGE_DECISION_KEYS.FACE_BLUR.name();
            message = property.optString(IcaoValidatorConstants.IMAGE_DECISION_PROPERTIES.MESSAGE.name());
            isValid = property.optBoolean(IcaoValidatorConstants.IMAGE_DECISION_PROPERTIES.VALID.name());
            value = property.optString(IcaoValidatorConstants.IMAGE_DECISION_PROPERTIES.VALUE.name());
            newProperty = new Property(name, message, isValid, value);
            propertyMap.put(name, newProperty);

            property = jsonObject.optJSONObject(IcaoValidatorConstants.IMAGE_DECISION_KEYS.SKIN_TONE.name());
            name = IcaoValidatorConstants.IMAGE_DECISION_KEYS.SKIN_TONE.name();
            message = property.optString(IcaoValidatorConstants.IMAGE_DECISION_PROPERTIES.MESSAGE.name());
            isValid = property.optBoolean(IcaoValidatorConstants.IMAGE_DECISION_PROPERTIES.VALID.name());
            value = property.optString(IcaoValidatorConstants.IMAGE_DECISION_PROPERTIES.VALUE.name());
            newProperty = new Property(name, message, isValid, value);
            propertyMap.put(name, newProperty);

            property = jsonObject.optJSONObject(IcaoValidatorConstants.IMAGE_DECISION_KEYS.FACE_ALIGNED.name());
            name = IcaoValidatorConstants.IMAGE_DECISION_KEYS.FACE_ALIGNED.name();
            message = property.optString(IcaoValidatorConstants.IMAGE_DECISION_PROPERTIES.MESSAGE.name());
            isValid = property.optBoolean(IcaoValidatorConstants.IMAGE_DECISION_PROPERTIES.VALID.name());
            value = property.optString(IcaoValidatorConstants.IMAGE_DECISION_PROPERTIES.VALUE.name());
            newProperty = new Property(name, message, isValid, value);
            propertyMap.put(name, newProperty);

            property = jsonObject.optJSONObject(IcaoValidatorConstants.IMAGE_DECISION_KEYS.SHOULDER_CHECK.name());
            name = IcaoValidatorConstants.IMAGE_DECISION_KEYS.SHOULDER_CHECK.name();
            message = property.optString(IcaoValidatorConstants.IMAGE_DECISION_PROPERTIES.MESSAGE.name());
            isValid = property.optBoolean(IcaoValidatorConstants.IMAGE_DECISION_PROPERTIES.VALID.name());
            value = property.optString(IcaoValidatorConstants.IMAGE_DECISION_PROPERTIES.VALUE.name());
            newProperty = new Property(name, message, isValid, value);
            propertyMap.put(name, newProperty);

            property = jsonObject.optJSONObject(IcaoValidatorConstants.IMAGE_DECISION_KEYS.SHADOW_DETECTION.name());
            name = IcaoValidatorConstants.IMAGE_DECISION_KEYS.SHADOW_DETECTION.name();
            message = property.optString(IcaoValidatorConstants.IMAGE_DECISION_PROPERTIES.MESSAGE.name());
            isValid = property.optBoolean(IcaoValidatorConstants.IMAGE_DECISION_PROPERTIES.VALID.name());
            value = property.optString(IcaoValidatorConstants.IMAGE_DECISION_PROPERTIES.VALUE.name());
            newProperty = new Property(name, message, isValid, value);
            propertyMap.put(name, newProperty);

            property = jsonObject.optJSONObject(IcaoValidatorConstants.IMAGE_DECISION_KEYS.FACE_CENTERED.name());
            name = IcaoValidatorConstants.IMAGE_DECISION_KEYS.FACE_CENTERED.name();
            message = property.optString(IcaoValidatorConstants.IMAGE_DECISION_PROPERTIES.MESSAGE.name());
            isValid = property.optBoolean(IcaoValidatorConstants.IMAGE_DECISION_PROPERTIES.VALID.name());
            value = property.optString(IcaoValidatorConstants.IMAGE_DECISION_PROPERTIES.VALUE.name());
            newProperty = new Property(name, message, isValid, value);
            propertyMap.put(name, newProperty);

            property = jsonObject.optJSONObject(IcaoValidatorConstants.IMAGE_DECISION_KEYS.EYE_IN_GLASSES.name());
            name = IcaoValidatorConstants.IMAGE_DECISION_KEYS.EYE_IN_GLASSES.name();
            message = property.optString(IcaoValidatorConstants.IMAGE_DECISION_PROPERTIES.MESSAGE.name());
            isValid = property.optBoolean(IcaoValidatorConstants.IMAGE_DECISION_PROPERTIES.VALID.name());
            value = property.optString(IcaoValidatorConstants.IMAGE_DECISION_PROPERTIES.VALUE.name());
            newProperty = new Property(name, message, isValid, value);
            propertyMap.put(name, newProperty);

            property = jsonObject.optJSONObject(IcaoValidatorConstants.IMAGE_DECISION_KEYS.FACE_COVERED.name());
            name = IcaoValidatorConstants.IMAGE_DECISION_KEYS.FACE_COVERED.name();
            message = property.optString(IcaoValidatorConstants.IMAGE_DECISION_PROPERTIES.MESSAGE.name());
            isValid = property.optBoolean(IcaoValidatorConstants.IMAGE_DECISION_PROPERTIES.VALID.name());
            value = property.optString(IcaoValidatorConstants.IMAGE_DECISION_PROPERTIES.VALUE.name());
            newProperty = new Property(name, message, isValid, value);
            propertyMap.put(name, newProperty);

            property = jsonObject.optJSONObject(IcaoValidatorConstants.IMAGE_DECISION_KEYS.FACE_COUNT.name());
            name = IcaoValidatorConstants.IMAGE_DECISION_KEYS.FACE_COUNT.name();
            message = property.optString(IcaoValidatorConstants.IMAGE_DECISION_PROPERTIES.MESSAGE.name());
            isValid = property.optBoolean(IcaoValidatorConstants.IMAGE_DECISION_PROPERTIES.VALID.name());
            value = property.optString(IcaoValidatorConstants.IMAGE_DECISION_PROPERTIES.VALUE.name());
            newProperty = new Property(name, message, isValid, value);
            propertyMap.put(name, newProperty);

            property = jsonObject.optJSONObject(IcaoValidatorConstants.IMAGE_DECISION_KEYS.RED_EYE_CHECK.name());
            name = IcaoValidatorConstants.IMAGE_DECISION_KEYS.RED_EYE_CHECK.name();
            message = property.optString(IcaoValidatorConstants.IMAGE_DECISION_PROPERTIES.MESSAGE.name());
            isValid = property.optBoolean(IcaoValidatorConstants.IMAGE_DECISION_PROPERTIES.VALID.name());
            value = property.optString(IcaoValidatorConstants.IMAGE_DECISION_PROPERTIES.VALUE.name());
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
        return Collections.unmodifiableMap(propertyMap);
    }
}
