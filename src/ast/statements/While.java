package ast.statements;

import java.util.List;

import ast.expressions.Expression;
import semanticVisitor.Visitor;

public class While extends AbstractStatement{
	
	private Expression condition;
	private List<Statement> body;
	
	public While(int line, int column, Expression condition, List<Statement> body) {
		super(line,column);
		this.condition = condition;
		this.body = body;
	}

	public Expression getCondition() {
		return condition;
	}

	public List<Statement> getBody() {
		return body;
	}	
	
	@Override
	public Object accept(Visitor v, Object params) {
		return v.visit(this,params);
	}

}
