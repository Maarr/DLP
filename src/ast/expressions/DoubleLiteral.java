package ast.expressions;

import semanticVisitor.Visitor;

public class DoubleLiteral extends AbstractExpression {
	
	private double value;
	
	public DoubleLiteral(int line, int column, double value) {
		super(line,column);
		this.value=value;
	}
	
	public double getValue() {
		return value;
	}
	
	@Override
	public Object accept(Visitor v, Object params) {
		return v.visit(this,params);
	}

}
