package es.fran.herrero.calculator.model.v1;

public class CalcInputData {

    private double op1;
    private String operator;
    private double op2;
    
	public CalcInputData() {
		super();
	}    
    
 	public CalcInputData(double op1, double op2) {
		super();
		this.op1 = op1;
		this.op2 = op2;
	}
 	
 	public CalcInputData(double op1, String operator, double op2) {
		super();
		this.op1 = op1;
		this.op2 = op2;
		this.operator = operator;
	}
 	
	public double getOp1() {
		return op1;
	}

	public void setOp1(double op1) {
		this.op1 = op1;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public double getOp2() {
		return op2;
	}

	public void setOp2(double op2) {
		this.op2 = op2;
	}

	@Override
	public String toString() {
		return  op1 + " " + operator + " " + op2;
	}
}
