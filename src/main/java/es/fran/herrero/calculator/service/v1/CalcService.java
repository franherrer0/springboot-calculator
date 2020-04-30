package es.fran.herrero.calculator.service.v1;

import org.springframework.stereotype.Service;

import es.fran.herrero.calculator.model.v1.CalcInputData;
import io.corp.calculator.TracerImpl;

@Service
public class CalcService {

	TracerImpl tracer = new TracerImpl();
	
    public double add(CalcInputData data){
    	if(null==data.getOperator() || data.getOperator().isEmpty()) data.setOperator("+");
        return calculate(data);
    }

    public double subtract(CalcInputData data){
    	if(null==data.getOperator() || data.getOperator().isEmpty()) data.setOperator("-");
        return calculate(data);
    }

    public double calculate(CalcInputData data) {
    	
        double result = 0;

        switch(data.getOperator()) {
            case "+":
                result = data.getOp1() + data.getOp2();
                break;
            case "-":
                result = data.getOp1() - data.getOp2();
                break;
            case "*":
                result = data.getOp1() * data.getOp2();
                break;
            case "/":
                result = data.getOp1() / data.getOp2();
                break;
            case "^":
                result = Math.pow(data.getOp1(),data.getOp2());
                break;
            default:
            	result =0;
        }
    	
        tracer.trace(result);
		return result;
        
    }
}