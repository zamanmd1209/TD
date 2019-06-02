package runner;





import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features ="./com.TDTest/srcBDDCucumber/Features/login.feature"
		,glue= {"stepDefination"}
//		format= {"pretty","html:test-output"}
					
		)
	
public class TestRunner {

	
	
	
	
	
	
	
	
	
	
}
