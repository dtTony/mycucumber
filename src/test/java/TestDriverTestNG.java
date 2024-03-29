import cucumber.api.CucumberOptions;
import indi.tony.auto.base.BaseTest;
import org.testng.annotations.Test;

@CucumberOptions(features = "src/test/resources/features", plugin = {"html:target/cucumber-html-report", "json:target/cucumber-json-report.json"})
public class TestDriverTestNG extends BaseTest {
    @Test
    public void main() {
        System.out.println(super.features_value);
    }
}
