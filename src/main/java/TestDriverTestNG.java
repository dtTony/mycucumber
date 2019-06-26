import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


@CucumberOptions(features = "src/main/resources/features",plugin = {"html:target/cucumber-html-report", "json:target/cucumber-json-report.json"})
public class TestDriverTestNG extends AbstractTestNGCucumberTests {
    @AfterSuite
    public static void afterTest(){
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
