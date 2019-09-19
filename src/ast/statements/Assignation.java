package ast.statements;

import ast.expressions.Expression;
import semanticVisitor.Visitor;

public class Assignation extends AbstractStatement {
	
	private Expression left, right;
	
	public Assignation(int line, int column, Expression left, Expression right) {
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
