package es.fran.herrero.calculator;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.hamcrest.Matchers;


/**
 * @author fran
 * Integration tests (they run in compilation time)
 */
@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = CalculatorApplication.class)
public class CalcRestAssuredTest {

@LocalServerPort
private int port;

    @BeforeAll
    public void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;
    }

    @Test
    public void testAdd200() {
    get("/v1/calc/add/1/5").then().statusCode(200);
    }

    @Test
    public void testAddResultOK() {
        get("/v1/calc/add/1/2").then().statusCode(200)
                .assertThat().body("result",
                Matchers.equalTo(3f),"opDesc",
                equalTo("1.0 + 2.0"));
    }

    @Test
    public void testSubtract200() {
        get("/v1/calc/subtract/1/5").then().statusCode(200);
    }

    @Test
    public void testSusbractResultOK() {
        get("/v1/calc/subtract/1/2").then().statusCode(200)
                .assertThat().body("result",
                Matchers.equalTo(-1.0f),"opDesc",
                equalTo("1.0 - 2.0"));
    }
   
   
    private static String payload = "{\n" +
            "  \"op1\": 5.2,\n" +
            "  \"op2\": 3.0,\n" +
            "  \"operator\": \"*\"\n" +
            "}";
       
    @Test
    public void testMultiplyResultOK() {
        given()
        .contentType(ContentType.JSON)
        .body(payload).post("/v1/calc")
        .then().statusCode(200)
        .assertThat().body("result",
                Matchers.equalTo(15.6f),"opDesc",
                equalTo("5.2 * 3.0"));
    }
   
}