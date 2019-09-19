package ast.expressions;

import semanticVisitor.Visitor;

public class UnaryMinus extends AbstractExpression{
	
private Expression expression;
	
	public UnaryMinus(int line, int column, Expression expression) {
		super(line,column);
		this.expression = expression;
	}

	public Expression getExpression() {
		return expression;
	}	
	
	@Override
	public Object accept(Visitor v, Object params) {
		return v.visit(this,params);
	}
	
}
