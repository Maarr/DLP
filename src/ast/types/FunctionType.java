package ast.types;

import java.util.List;
import ast.definitions.Definition;
import semanticVisitor.Visitor;

public class FunctionType extends AbstractType{
	
	private Type returnType;
	private List<Definition> parameters;
	
	private int bytesParams;
	
	public FunctionType(int line, int column,Type returnType, List<Definition> parameters) {
		super(line,column);
		this.returnType = returnType;
		this.parameters = parameters;
	}

	public Type getReturnType() {
		return returnType;
	}

	public List<Definition> getParameters() {
		return parameters;
	}
	
	@Override
	public Object accept(Visitor v, Object params) {
		return v.visit(this,params);
	}
	
	@Override
	public Type parenthesis(List<Type> types) {
		if (types.size() == parameters.size()) {
			for (int i = 0; i < types.size(); i++) {
				if (types.get(i).promotesTo(parameters.get(i).getType()) == null)
					return null;
			}
			
			return returnType;
		}
		return null;
	}

	@Override
	public int getSize() {
		return 0;
	}
	
	public void setBytesParams(int bytesParams) {
		this.bytesParams=bytesParams;
	}
	
	public int getBytesParams() {
		return bytesParams;
	}
	
}
