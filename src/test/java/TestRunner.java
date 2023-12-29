import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

@CucumberOptions(
        features = "classpath:features",
        tags = "@login"
)
public class TestRunner extends AbstractTestNGCucumberTests {

    @BeforeClass
    public void beforeClass(){
        System.out.println("TEST BASLADI");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("TEST BITDI");
    }

}
