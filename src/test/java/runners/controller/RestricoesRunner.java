package runners.controller;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty" }, 
		features = "src/test/java/features/controller/RestricoesController.feature", 
		monochrome = true, 
		glue = {"steps" }, 
		tags = "@Restricoes"
)
public class RestricoesRunner {

}
