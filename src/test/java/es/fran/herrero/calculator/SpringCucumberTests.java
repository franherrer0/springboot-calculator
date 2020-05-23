package es.fran.herrero.calculator;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import es.fran.herrero.calculator.model.v1.CalcOutputData;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Ignore
public class SpringCucumberTests {
	
	private final String SERVER_URL = "http://localhost";
	private final String ADD_ENDPOINT = "/v1/calc/add";
	private final String SUBTRACT_ENDPOINT = "/v1/calc/subtract";
	private RestTemplate restTemplate;
	
	@LocalServerPort
	protected int port;

	public SpringCucumberTests() {
		this.restTemplate = new RestTemplate();
	}

	private String addEndpoint() {
		return SERVER_URL + ":" + port + ADD_ENDPOINT + "/";
	}
	
	private String subtractEndpoint() {
		return SERVER_URL + ":" + port + SUBTRACT_ENDPOINT + "/";
	}

	CalcOutputData add(double op1, double op2) {
		return restTemplate.getForEntity(addEndpoint() + "/" + op1 + "/" + op2 , CalcOutputData.class).getBody();
	}
	
	CalcOutputData subtract(double op1, double op2) {
		return restTemplate.getForEntity(subtractEndpoint() + "/" + op1 + "/" + op2 , CalcOutputData.class).getBody();
	}

	void clean() {	}
}