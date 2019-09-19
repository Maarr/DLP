package errors;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import ast.types.ErrorType;

public class ErrorHandler {
	
	
	private List<ErrorType> errors=new ArrayList<ErrorType>(); 
	
	private static ErrorHandler instance = new ErrorHandler();

	private ErrorHandler() {}

	/**
	 * Patrón Singleton
	 * @return
	 */
	public static ErrorHandler getInstance() {
		if (instance == null)
			instance = new ErrorHandler();
		return instance;
	}
	
	public boolean anyError() {
		if(errors.isEmpty())
			return false;
		else
			return true;
	}
	
	public void addError(ErrorType error) {
		errors.add(error);
	}
	
	public void showErrors(PrintStream p) {	
		for(ErrorType e:errors)
			p.println(e);
	}

}
