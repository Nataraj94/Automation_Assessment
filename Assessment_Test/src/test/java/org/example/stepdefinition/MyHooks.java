package org.example.stepdefinition;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import reuseable.BaseClass;


public class MyHooks extends BaseClass {



    @Before
    public void preCondition(){

        String path = System.getProperty("user.dir") + "/src/test/resources/log4j.properties";
        PropertyConfigurator.configure(path);

    }

    @AfterStep
    public void captureScreenshot(Scenario sc){

        String scenarioName = sc.getName().replaceAll(" ","_");
        byte[] screenshot =   ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        sc.attach(screenshot,"image/png",scenarioName);

    }
    @After
    public void TearDown(){

        driver.quit();
    }
}
