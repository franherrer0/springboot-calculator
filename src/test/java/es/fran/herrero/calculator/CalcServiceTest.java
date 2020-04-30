package es.fran.herrero.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import es.fran.herrero.calculator.model.v1.CalcInputData;
import es.fran.herrero.calculator.service.v1.CalcService;

public class CalcServiceTest {
   
	CalcService calcService = new CalcService();

    @Test
    void add() {
        assertEquals(5.2, calcService.add(new CalcInputData(3, 2.2)));
    }
    
    @Test
    void subtract() {
        assertEquals(32.8, calcService.subtract(new CalcInputData(65, 32.2)));
    }
    
    @Test
    void multiply() {
        assertEquals(6.8, calcService.calculate(new CalcInputData(3.4, "*" ,2)));
    }
}
