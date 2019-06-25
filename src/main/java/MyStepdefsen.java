import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyStepdefsen {
    @When("test{int}is")
    public void testIs(int arg0) {
    }

    @Then("test{int}is test{int}")
    public void testIsTest(int arg0, int arg1) {
    }
}
