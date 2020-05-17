package es.fran.herrero.calculator.model.v1;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author fherrero
 * Input data (request object) for POST method
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CalcInputData {

    @Schema(description = "First operand", example = "9.08", required = true)
    private double op1;
    @Schema(description = "Operator", example = "+", required = true)
    private String operator;
    @Schema(description = "Second operand", example = "36.95", required = true)
    private double op2;
    
 	public CalcInputData(double op1, double op2) {
		super();
		this.op1 = op1;
		this.op2 = op2;
	}

	@Override
	public String toString() {
		return  op1 + " " + operator + " " + op2;
	}
}
