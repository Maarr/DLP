package ast.expressions;

import semanticVisitor.Visitor;

public class IntLiteral extends AbstractExpression{
	
	private int value;
	
	public IntLiteral(int line, int column, int value) {
		super(line,column);
		this.value=value;
	}
	
	public int getValue() {
		return value;
	}
	
	@Override
	public Object accept(Visitor v, Object params) {
		return v.visit(this,params);
	}

}
