import io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.Assert;

public class MyStepdefs {
    @cucumber.api.java.zh_cn.假设("如果这个是测试{int}")
    public void 如果这个是测试(int arg0) {
        Assert.assertEquals(arg0,2);
    }

    @cucumber.api.java.zh_cn.当("测试{int}是测试{int}时")
    public void 测试是测试时(int arg0, int arg1) {
        Assert.assertEquals(arg0,arg1);
    }

    @cucumber.api.java.zh_cn.那么("打印测试{int}")
    public void 打印测试(int arg0) {
        Assert.assertEquals(arg0,1);
    }
}
