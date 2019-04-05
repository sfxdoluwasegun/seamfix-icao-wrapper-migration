import com.sf.ICAOValidator;
import com.sf.IcaoValidatorConstants;
import com.sf.ImageDecision;
import com.sun.prism.Image;
import jep.Jep;
import jep.JepException;
import java.io.IOException;
import java.util.*;
import java.io.File;

public class Main {

    public static void main(String[] args) throws JepException {

//        try(Jep jep = new Jep()) {
//
//            jep.eval("from icaoengine.pojo import FeatureThreshold");
//            jep.eval("from icaoengine.pojo import ValidateRectangles");
//            jep.eval("from icaoengine.CVUtils import CVUtils");
//            jep.eval("from icaoengine.icao_pojo.bc_check import IcaoValidatorEngine");
//            jep.eval("from icaoengine.core import CoreValidation");
//            jep.eval("from icaoengine.resources import load_classifier_config");
//            jep.eval("from icaoengine.resources import load_resources");
//
//            jep.eval("import cv2");
//
//            File configFile = new File("C:\\Users\\DAWUZI\\Pictures\\threshold_config.ini");
//            jep.eval("classifierConfig = load_classifier_config(r'" + configFile.getAbsolutePath() + "')");
//            //jep.eval("config = load_resources(config=classifierConfig)");
//
//            jep.eval("loader = FeatureThreshold.FeatureThreshold()");
//            jep.eval("faceThreshold = loader.makeThreshold(1.1, 2, 2, 96, 96, 0, 0, True)");
//            jep.eval("eyeThreshold = loader.makeThreshold(1.1, 5, 2, 70, 70, 96, 96, True)");
//            jep.eval("noseThreshold = loader.makeThreshold(1.1, 5, 2, 64, 64, 100, 100, True)");
//            jep.eval("clusterThreshold = loader.makeClutterThreshold(50, 500, 90, 40, 40)");
//
//            File image = new File("C:\\Users\\DAWUZI\\Downloads\\covered_eye_3.jpg");
//            jep.eval("image = cv2.imread(r'" + image.getAbsolutePath() + "')");
//
//            jep.eval("validation = CoreValidation(image, classifierConfig, faceThreshold=faceThreshold, backgroundThreshold=clusterThreshold)");
//
//            jep.eval("icao_validation = validation.icao_validate(r'" + image.getAbsolutePath() + "')");
//
//            jep.eval("print(icao_validation)");
//
//        }

        ICAOValidator validator = null;
        try {
            validator = new ICAOValidator("C:\\Users\\DAWUZI\\Pictures\\classifier_xml\\threshold_config.ini");
            ImageDecision decision = validator.icaoValidate("C:\\Users\\DAWUZI\\Downloads\\covered_eye_3.jpg");
            Map<String, ImageDecision.Property> map = decision.getPropertiesMap();
            ImageDecision.Property property = map.get(IcaoValidatorConstants.ImageDecisionKeys.EYE_IN_GLASSES.name());
            System.out.println(property.getIsValid());
            System.out.println(property.getName());
            System.out.println(property.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
