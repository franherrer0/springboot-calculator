package es.fran.herrero.calculator;

import static org.junit.Assert.assertEquals;

import cucumber.api.java8.En;

public class CalcCucumberStepDefinitions extends SpringCucumberTests implements En {

	private double r = 0;

	public CalcCucumberStepDefinitions() {

			When("the client calls \\/vx\\/calc\\/add with values {double} and {double}", (Double double1, Double double2) -> {
				r = add(double1.doubleValue(), double2.doubleValue()).getResult();
			});

			Then("the client receives answer as {double}", (Double double1) -> {
				assertEquals(double1.doubleValue(), r, 0);
			});

			When("the client calls \\/vx\\/calc\\/sub with values {double} and {double}", (Double double1, Double double2) -> {
				r = subtract(double1.doubleValue(), double2.doubleValue()).getResult();
			});
	}
}