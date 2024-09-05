package runners;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty"}, 
		features = "src/test/java/features/controller", 
		monochrome = true, 
		glue = {"steps"}, 
		tags = "@Restricoes or @Simulacoes"
)
public class AutomationApiRunner {

	@Before
	public static void init() {
		System.out.println("Suite de Automação - Iniciado");
	}
	
	@After
	public static void finish() {
		System.out.println("Suite de Automação - Finalizado");
	}
	
}
