package ast.types;

import errors.ErrorHandler;
import semanticVisitor.Visitor;

public class ErrorType extends AbstractType{
	
	private String message;
	
	public ErrorType(int line, int column, String message) {
		super(line,column);
		this.message=message;
		ErrorHandler.getInstance().addError(this);		
	}

	@Override
	public String toString() {
		return "ErrorType [ line: "+this.getLine()+" - column: "+this.getColumn()+" -->" + message + "]";
	}
	
	@Override
	public Object accept(Visitor v, Object params) {
		return v.visit(this,params);
	}
	
	@Override
	public int getSize() {
		return 0;
	}

}
