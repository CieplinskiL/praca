import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/Features", monochrome = true, plugin = {"pretty", "html:target/HTMLReports"}, tags = "@apiary")
public class RunCucumberTest {



}
