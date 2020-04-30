package es.fran.herrero.calculator.model.v1;

public class CalcOutputData {

	private String opDesc;
	private double result;
	
	public CalcOutputData(String opDesc, double result) {
		super();
		this.opDesc = opDesc;
		this.result = result;
	}

	public String getOpDesc() {
		return opDesc;
	}

	public void setOpDesc(String opDesc) {
		this.opDesc = opDesc;
	}

	public double getResult() {
		return result;
	}

	public void setResult(double result) {
		this.result = result;
	}
	
}
