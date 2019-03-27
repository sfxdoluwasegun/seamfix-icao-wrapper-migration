package com.sf;

/**
 * @author Biose, Nonso Emmanuel
 * @since 27-03-2019
 * This class holds all constants for the IcaoValidation
 */
public class IcaoValidatorConstants {

    /**
     * keys for each Image decision
     */
    public enum IMAGE_DECISION_KEYS{
        IMAGE_DIMENSION,
        BRIGHTNESS_CONTRAST,
        FACE_BLUR,
        SKIN_TONE,
        FACE_ALIGNED,
        SHOULDER_CHECK,
        SHADOW_DETECTION,
        FACE_CENTERED,
        EYE_IN_GLASSES,
        FACE_COVERED,
        FACE_COUNT,
        RED_EYE_CHECK
    }

    /**
     * Keys for the the Image decision properties
     */
    public enum IMAGE_DECISION_PROPERTIES {
        MESSAGE,
        VALID,
        VALUE
    }

}
