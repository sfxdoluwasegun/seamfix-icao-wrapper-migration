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
     * This method performs the ICAO Validation
     *
     * @param path to the Image for Icao Validation
     * @return String json
     * @throws IOException
     */
    public String validate(String path) throws IOException {

        if (new File(path).exists()) {
            try {
                JEP.eval("validation = CoreValidation(classifierConfig)");
                JEP.eval("icao_validation = validation.icao_validate(r'" + path + "')");
                JEP.eval("jsonString = json.dumps(icao_validation)");
                return String.valueOf(JEP.getValue("jsonString"));
            } catch (JepException e) {
                e.printStackTrace();
                throw new IOException(e.getMessage());
            }
        } else {
            throw new IOException("Please pass in a valid Image path");
        }
    }
}
