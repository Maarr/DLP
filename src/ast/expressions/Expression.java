package ast.expressions;

import ast.ASTNode;
import ast.types.Type;

public interface Expression extends ASTNode{
	
	//M�todos Visitor LValue
	public boolean getLValue();
	public void setLValue(boolean value);
	
	//M�todoo Visitor TypeChecking
	public Type getType();
	public void setType(Type type);

}
