package es.fran.herrero.calculator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class CalcBadRequestAdvice {

  @ResponseBody
  @ExceptionHandler(CalcException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  String exceptionHandler(CalcException ex) {
    return ex.getMessage();
  }
}