package es.fran.herrero.calculator.model.v1;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author fran
 * Output data for POST method
 */
@Data
@AllArgsConstructor
public class CalcOutputData {

	private String opDesc;
	private double result;
}
