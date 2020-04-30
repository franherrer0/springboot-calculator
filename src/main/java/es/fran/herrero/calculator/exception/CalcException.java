package es.fran.herrero.calculator.exception;

public class CalcException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CalcException(String message) {
		super("Calc operation exception:: " + message);
	}
}
