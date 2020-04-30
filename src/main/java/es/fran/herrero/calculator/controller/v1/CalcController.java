package es.fran.herrero.calculator.controller.v1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.fran.herrero.calculator.exception.CalcException;
import es.fran.herrero.calculator.model.v1.CalcInputData;
import es.fran.herrero.calculator.model.v1.CalcOutputData;

@RestController
@RequestMapping("/v1")
public class CalcController {

	    @GetMapping("/calc/add/{op1}/{op2}")
	    CalcOutputData add(@PathVariable double op1, @PathVariable double op2) {
	    	return null;
	    }

	    @GetMapping("/calc/subtract/{op1}/{op2}")
	    CalcOutputData subtract(@PathVariable double op1, @PathVariable double op2) {
	    	return null;
	    }
	    
	    @RequestMapping(value="/calc" , method = RequestMethod.POST)
	    public CalcOutputData calc(@RequestBody CalcInputData input)
	    throws CalcException {
	    	return null;
	    }
}
