package es.fran.herrero.calculator.model.v1;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author fran
 * Output data for POST method
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CalcOutputData {

	@Schema(description = "Operation Description", example = "9.08 + 36.95", required = true)
	private String opDesc;
	@Schema(description = "Total result", example = "46.03", required = true)
	private double result;
}
