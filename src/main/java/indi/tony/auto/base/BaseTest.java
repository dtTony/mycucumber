package indi.tony.auto.base;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class BaseTest extends AbstractTestNGCucumberTests {
    protected String features_value;

    @BeforeSuite
    public void beforeTest(){
        features_value = "src/test/resources/features";
    }
    @AfterSuite
    public void afterTest(){
        File reportOutputDirectory = new File("target");
        List<String> jsonFiles = new ArrayList<String>();
        jsonFiles.add("target/cucumber-json-report.json");

        String buildNumber = "1";
        String projectName = "cucumberProject";
//        boolean runWithJenkins = false;

        Configuration configuration = new Configuration(reportOutputDirectory, projectName);
// optional configuration - check javadoc
//        configuration.setRunWithJenkins(runWithJenkins);
        configuration.setBuildNumber(buildNumber);
// addidtional metadata presented on main page
        configuration.addClassifications("Platform", "Windows");
        configuration.addClassifications("Browser", "Firefox");
        configuration.addClassifications("Branch", "release/1.0");

// optionally add metadata presented on main page via properties file
//        List<String> classificationFiles = new ArrayList<String>();
//        classificationFiles.add("properties-1.properties");
//        configuration.addClassificationFiles(classificationFiles);

        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        Reportable result = reportBuilder.generateReports();
    }
}
