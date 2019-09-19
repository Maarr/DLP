package ast.expressions;

import semanticVisitor.Visitor;

public class Arithmetic extends AbstractExpression {
	
	private Expression left, right;
	private String operator;
	
	public Arithmetic(int line, int column, Expression left, String operator, Expression right) {
		super(line,column);
		this.left=left;
		this.right=right;
		this.operator=operator;
	}

	public Expression getLeft() {
		return left;
	}

	public Expression getRight() {
		return right;
	}

	public String getOperator() {
		return operator;
	}
	
	@Override
	public Object accept(Visitor v, Object params) {
		return v.visit(this,params);
	}

}
