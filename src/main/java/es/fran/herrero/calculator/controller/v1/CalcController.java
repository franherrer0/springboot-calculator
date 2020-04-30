package es.fran.herrero.calculator.controller.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.fran.herrero.calculator.exception.CalcException;
import es.fran.herrero.calculator.model.v1.CalcInputData;
import es.fran.herrero.calculator.model.v1.CalcOutputData;
import es.fran.herrero.calculator.service.v1.CalcService;
import lombok.extern.slf4j.Slf4j;


/**
 * @author fran
 * Controller of the service: implemented v1 (to manage new versions in the future)
 */
@Slf4j
@RestController
@RequestMapping("/v1")
public class CalcController {

	    @Autowired private CalcService calcService;

	    @GetMapping("/calc/add/{op1}/{op2}")
	    CalcOutputData add(@PathVariable double op1, @PathVariable double op2) {
	    	CalcInputData inputData = new CalcInputData(op1,op2);
	    	inputData.setOperator("+");
	    	log.info("add:: " + inputData);
	    	return new CalcOutputData(inputData.toString(), calcService.add(inputData));
	    }

	    @GetMapping("/calc/subtract/{op1}/{op2}")
	    CalcOutputData subtract(@PathVariable double op1, @PathVariable double op2) {
	    	CalcInputData inputData = new CalcInputData(op1,op2);
	    	inputData.setOperator("-");
	    	log.info("subtract:: " + inputData);
	    	return new CalcOutputData(inputData.toString(), calcService.subtract(inputData));
	    }
	    
	    @RequestMapping(value="/calc" , method = RequestMethod.POST)
	    public CalcOutputData calc(@RequestBody CalcInputData input)
	    throws CalcException {
	    	log.info("calc:: " + input);
	        return new CalcOutputData(input.toString(), calcService.calculate(input));
	    }
}
