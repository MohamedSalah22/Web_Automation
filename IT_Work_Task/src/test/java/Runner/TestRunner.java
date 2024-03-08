package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src\\test\\java\\Web_Automation\\IT_Work_Education\\Feature"
		,glue={"Web_Automation.IT_Work_Education.Steps"})

public class TestRunner {

}
