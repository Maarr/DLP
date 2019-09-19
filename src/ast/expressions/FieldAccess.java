package ast.expressions;

import semanticVisitor.Visitor;

public class FieldAccess extends AbstractExpression {

	private String name;
	private Expression expression;

	public FieldAccess(int line, int column, String name, Expression expression) {
		super(line,column);
		this.name = name;
		this.expression=expression;
	}

	public String getName() {
		return name;
	}
	
	public Expression getExpression() {
		return expression;
	}
	
	@Override
	public Object accept(Visitor v, Object params) {
		return v.visit(this,params);
	}

}
