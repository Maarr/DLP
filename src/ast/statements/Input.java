package ast.statements;

import java.util.List;

import ast.expressions.Expression;
import semanticVisitor.Visitor;

public class Input extends AbstractStatement{
	
	private List<Expression> expressions;

	public Input(int line, int column, List<Expression> expressions) {
		super(line,column);
		this.expressions = expressions;
	}

	public List<Expression> getExpressions() {
		return expressions;
	}
	
	@Override
	public Object accept(Visitor v, Object params) {
		return v.visit(this,params);
	}

}
