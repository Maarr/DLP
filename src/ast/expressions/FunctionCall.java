package ast.expressions;

import java.util.List;

import ast.statements.Statement;
import semanticVisitor.Visitor;

public class FunctionCall extends AbstractExpression implements Statement, Expression{
	
	private Variable name;
	private List<Expression> arguments;

	public FunctionCall(int line, int column, Variable name, List<Expression> arguments) {
		super(line,column);
		this.name=name;
		this.arguments=arguments;
	}

	public Variable getName() {
		return name;
	}

	public List<Expression> getArguments() {
		return arguments;
	}
	
	@Override
	public Object accept(Visitor v, Object params) {
		return v.visit(this,params);
	}
	

}
