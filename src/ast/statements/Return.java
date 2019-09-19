package ast.statements;

import ast.expressions.Expression;
import semanticVisitor.Visitor;

public class Return extends AbstractStatement{
	
	private Expression expression;

	public Return(int line, int column, Expression expression) {
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
