package org.example.runnerfile;



import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(

        features = {"src/test/resources/com.example.featurefile"},
        glue = {"/org/example/stepdefinition"},
        publish = true,
        monochrome = true,
        tags = "@Add,@Edit,@Delete",
        plugin ={"pretty","html:target/CucumberReports/CucumberReport.html",
                "json:test-output/jsonReport.json",
                "junit:test-output/junitReport.xml",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}

)


public class CucumberRunner {
}
