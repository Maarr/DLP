package ast.expressions;

import ast.definitions.Definition;
import semanticVisitor.Visitor;

public class Variable extends AbstractExpression{
	
	private String name;
	private Definition definition;
	
	public Variable(int line, int column, String name) {
		super(line,column);
		this.name=name;
	}
	
	public String getName() {
		return name;
	}
	
	public Definition getDefinition() {
		return definition;
	}

	public void setDefinition(Definition definition) {
		this.definition = definition;
	}

	@Override
	public Object accept(Visitor v, Object params) {
		return v.visit(this,params);
	}
	

}
