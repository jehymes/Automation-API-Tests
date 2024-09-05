package runners.controller;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty" }, 
		features = "src/test/java/features/controller/SimulacaoController.feature", 
		monochrome = true, 
		glue = {"steps" }, 
		tags = "@Simulacoes"
)
public class SimulacaoRunner {

}
