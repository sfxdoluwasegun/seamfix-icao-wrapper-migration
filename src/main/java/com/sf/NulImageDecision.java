package com.sf;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Biose, Nonso Emmanuel
 * @since 26-03-2019
 * This class is a Null implementation for the com.sf.ImageDecision class
 */
public class NulImageDecision extends ImageDecision {

    public NulImageDecision(String json) {
        super(json);
    }

    @Override
    public Map<String, ImageDecision.Property> getPropertyMap() {
        return new HashMap<>();
    }
}
