package es.fran.herrero.calculator.model.v1;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CalcOutputData {

	private String opDesc;
	private double result;
}
