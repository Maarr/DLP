package ast.expressions;

import semanticVisitor.Visitor;

public class ArrayAccess extends AbstractExpression{
	
	private Expression left, right;
	
	public ArrayAccess(int line, int column,Expression left, Expression right) {
		super(line,column);
		this.left=left;
		this.right=right;
	}

	public Expression getLeft() {
		return left;
	}

	public Expression getRight() {
		return right;
	}
	
	@Override
	public Object accept(Visitor v, Object params) {
		return v.visit(this,params);
	}
	

}
