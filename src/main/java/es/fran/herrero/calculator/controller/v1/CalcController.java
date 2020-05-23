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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import lombok.extern.slf4j.Slf4j;


/**
 * @author fran
 * Controller of the service: implemented v1 (to manage new versions in the future)
 */
@Slf4j
@RestController
@RequestMapping("/v1")
@Tag(name = "calc", description = "Calculator API")
public class CalcController {

	    @Autowired private CalcService calcService;

	    @Operation(summary = "Add two operators", description = "Add two values", tags = { "calc" })
	    @ApiResponses(value = {
	            @ApiResponse(responseCode = "200", description = "Successful operation",
	                    content = @Content(schema = @Schema(implementation = CalcOutputData.class))),
	            @ApiResponse(responseCode = "400", description = "Invalid request") })	    
	    @GetMapping(value = "/calc/add/{op1}/{op2}")
	    CalcOutputData add(@Parameter(description="First operand. Cannot be empty.", required=true) @PathVariable double op1, 
	    		@Parameter(description="Second operand. Cannot be empty.", required=true) @PathVariable double op2) {
	    	CalcInputData inputData = new CalcInputData(op1,op2);
	    	inputData.setOperator("+");
	    	log.info("add:: " + inputData);
	    	return new CalcOutputData(inputData.toString(), calcService.add(inputData));
	    }

	    @Operation(summary = "Subtract two operators", description = "Subtract two values", tags = { "calc" })
	    @ApiResponses(value = {
	            @ApiResponse(responseCode = "200", description = "Successful operation",
	                    content = @Content(schema = @Schema(implementation = CalcOutputData.class))),
	            @ApiResponse(responseCode = "400", description = "Invalid request") })	    
	    @GetMapping(value = "/calc/subtract/{op1}/{op2}")
	    CalcOutputData subtract(@Parameter(description="First operand. Cannot be empty.", required=true) @PathVariable double op1, 
	    		@Parameter(description="Second operand. Cannot be empty.", required=true) @PathVariable double op2) {
	    	CalcInputData inputData = new CalcInputData(op1,op2);
	    	inputData.setOperator("-");
	    	log.info("subtract:: " + inputData);
	    	return new CalcOutputData(inputData.toString(), calcService.subtract(inputData));
	    }
	    
	    @Operation(summary = "Generic calc", description = "Generic calculator, input two operands and one operator from list (+ - * / ^)", tags = { "calc" })
	    @ApiResponses(value = {
	            @ApiResponse(responseCode = "200", description = "Successful operation",
	                    content = @Content(schema = @Schema(implementation = CalcOutputData.class))),
	            @ApiResponse(responseCode = "400", description = "Invalid request") })	    	    
	    @RequestMapping(value="/calc" , method = RequestMethod.POST)
	    public CalcOutputData calc(@Parameter(description="First operand, operator, Second operand", required=true, schema=@Schema(implementation = CalcInputData.class)) @RequestBody CalcInputData input)
	    throws CalcException {
	    	log.info("calc:: " + input);
	        return new CalcOutputData(input.toString(), calcService.calculate(input));
	    }
}
