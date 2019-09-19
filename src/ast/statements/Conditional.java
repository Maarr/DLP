package ast.statements;

import java.util.List;

import ast.expressions.Expression;
import semanticVisitor.Visitor;

public class Conditional extends AbstractStatement{
	
	private Expression condition;
	private List<Statement> ifBody;
	private List<Statement> elseBody;
	
	public Conditional(int line, int column, Expression condition, List<Statement> ifBody, List<Statement> elseBody) {
		super(line,column);
		this.condition = condition;
		this.ifBody = ifBody;
		this.elseBody = elseBody;
	}

	public Expression getCondition() {
		return condition;
	}

	public List<Statement> getIfBody() {
		return ifBody;
	}

	public List<Statement> getElseBody() {
		return elseBody;
	}
	
	public void setElseBody(List<Statement> statements) {
		this.elseBody=statements;
	}
	
	@Override
	public Object accept(Visitor v, Object params) {
		return v.visit(this,params);
	}
	
}
