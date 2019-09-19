package ast.expressions;

import semanticVisitor.Visitor;

public class Logic extends AbstractExpression {
	
	private Expression left, right;
	private String operator;
	
	public Logic(int line, int column, Expression left, Expression right, String operator) {
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
