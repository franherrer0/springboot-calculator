package es.fran.herrero.calculator;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

//https://examples.javacodegeeks.com/enterprise-java/spring/boot/spring-boot-cucumber-tests-example/
//https://github.com/bcarun/cucumber-samples/blob/master/hello-springboot-cucumber/src/test/java/com/arun/cucumber/hello/bdd/CucumberSpringContextConfiguration.java
//https://dzone.com/articles/spring-boot-rest-service-integration-testing-using
//https://github.com/cucumber/cucumber-jvm/blob/master/examples/java8-calculator/src/test/java/io/cucumber/examples/java8/RpnCalculatorSteps.java

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/calculator.feature", plugin = {"pretty", "html:target/cucumber"})
public class CalcCucumberTest {
}