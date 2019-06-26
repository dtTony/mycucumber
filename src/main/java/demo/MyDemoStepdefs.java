package demo;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class MyDemoStepdefs {
    @cucumber.api.java.zh_cn.假如("求{int}+{int}的和")
    public void 求的和(int arg0, int arg1) {
        System.out.println("求" + String.valueOf(arg0) + "+" + String.valueOf(arg1) + "的和");
    }

    @cucumber.api.java.zh_cn.当("输入{int}+{int}时")
    public int 输入时(int arg0, int arg1) {
        return arg0+arg1;
    }

    @cucumber.api.java.zh_cn.那么("和等于{int}")
    public void 和等于(int arg0) {
        Assert.assertEquals(arg0, 输入时(1,1));
    }

    @Given("the count of {int} add {int}")
    public void theCountOfAdd(int arg0, int arg1) {
        System.out.println("get count of" + String.valueOf(arg0) + "add" + String.valueOf(arg1));
    }

    @When("{int} add {int}")
    public int add(int arg0, int arg1) {
        return arg0+arg1;
    }

    @Then("the count is {int}")
    public void theCountIs(int arg0) {
        Assert.assertEquals(arg0, add(1,1));
    }
}
