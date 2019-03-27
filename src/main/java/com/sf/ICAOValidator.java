package com.sf;

import jep.Jep;
import jep.JepException;

import java.io.File;
import java.io.IOException;

/**
 * @author Biose, Nonso Emmanuel
 * @since 25-03-2019
 * This class wraps around the Icao Validation Python Library to optimize the time taken load the packages, and resource files
 */
public class ICAOValidator {

    /**
     * This is an instance of the Jep Library used to interpret Python codes
     */
    private Jep JEP;


    public ICAOValidator(String path) throws IOException {
        initializeValidator(path);
    }

    /**
     * This method, initializes the Jep Object, imports all required python packages, classifiers anf resource files as well as set the threshold
     * values
     *
     * @param path to the .ini config file
     * @throws IOException
     */
    private void initializeValidator(String path) throws IOException {
        if (JEP == null) {
            try {
                JEP = new Jep();
                importPythonPackages();
                loadClassifierAndResources(path);
                setFeatureThreshold();
            } catch (JepException e) {
                throw new IOException(e.getMessage());
            }
        }
    }

    /**
     * This method, imports all required python packages
     *
     * @throws IOException
     */
    private void importPythonPackages() throws IOException {
        try {
            JEP.eval("from icaoengine.pojo import FeatureThreshold");
            JEP.eval("from icaoengine.pojo import ValidateRectangles");
            JEP.eval("from icaoengine.CVUtils import CVUtils");
            JEP.eval("from icaoengine.icao_pojo.bc_check import IcaoValidatorEngine");
            JEP.eval("from icaoengine.core import CoreValidation");
            JEP.eval("from icaoengine.resources import load_classifier_config");
            JEP.eval("from icaoengine.resources import load_resources");
            JEP.eval("import json");
            JEP.eval("import cv2");
        } catch (JepException e) {
            throw new IOException(e.getMessage());
        }
    }

    /**
     * This method, loads the classifiers and resource files
     *
     * @param path to the .ini config file that has the path to the classifiers and the resource files
     * @throws IOException
     */
    private void loadClassifierAndResources(String path) throws IOException {
        if (!new File(path).exists()) {
            throw new IOException("Please specify a path to the .ini file");
        }

        try {
            JEP.eval("classifierConfig = load_classifier_config(r'" + path + "')");
        } catch (JepException e) {
            throw new IOException(e.getMessage());
        }
    }

    /**
     * This method sets all the threshold values needed for ICAO Validation
     *
     * @throws IOException
     */
    private void setFeatureThreshold() throws IOException {
        try {
            JEP.eval("loader = FeatureThreshold.FeatureThreshold()");
            JEP.eval("faceThreshold = loader.makeThreshold(1.1, 2, 2, 96, 96, 0, 0, True)");
            JEP.eval("eyeThreshold = loader.makeThreshold(1.1, 5, 2, 70, 70, 96, 96, True)");
            JEP.eval("noseThreshold = loader.makeThreshold(1.1, 5, 2, 64, 64, 100, 100, True)");
            JEP.eval("clusterThreshold = loader.makeClutterThreshold(50, 500, 90, 40, 40)");
        } catch (JepException e) {
            throw new IOException(e.getMessage());
        }
    }

    /**
     * This method performs the ICAO Validation
     *
     * @param path to the Image for Icao Validation
     * @return com.sf.ImageDecision
     * @throws IOException
     */
    public ImageDecision icaoValidate(String path) throws IOException {
        try {
            if (new File(path).exists()) {
                JEP.eval("image = cv2.imread(r'" + path + "')");
                JEP.eval("validation = CoreValidation(image, classifierConfig, faceThreshold=faceThreshold, backgroundThreshold=clusterThreshold)");
                JEP.eval("icao_validation = validation.icao_validate(r'" + path + "')");
                JEP.eval("jsonString = json.dumps(icao_validation)");
                String json = String.valueOf(JEP.getValue("jsonString"));
                return new ImageDecision(json);
            }
        } catch (JepException e) {
            throw new IOException(e.getMessage());
        }
        return new NulImageDecision("");
    }
}
