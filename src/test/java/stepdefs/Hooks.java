package stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.CommonMethods;
import utilities.ConfigReader;
import utilities.DriverUtilities;

public class Hooks {

    @Before
    //We are adding the cucumber Scenario parameter which will hold the data for the scenario which is currently running
    public void setUp(Scenario scenario){
        //Here we are initializing the properties object inside of the ConfigReader class we created
        ConfigReader.initializeProperties();
        DriverUtilities.createDriver(scenario);
    }

    @After
    public void tearDown(Scenario scenario){
        //Here we are using the scenario.attach() method in order to attach our screenshot to the scenario
        //The parameters we are passing is the byte[] array screenshot which is generated by the takeScreenshot method
        //The media type image/png since this is an image of png type
        //and the name of the scenario as the name of the image
        if(scenario.isFailed()) {
            scenario.attach(CommonMethods.takeScreenshot(), "image/png", scenario.getName());
        }
        CommonMethods.takeScreenshot(scenario);


        DriverUtilities.quitDriver(scenario);
    }
}
