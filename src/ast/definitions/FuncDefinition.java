package ast.definitions;

import java.util.List;

import ast.statements.Statement;
import ast.types.Type;
import semanticVisitor.Visitor;
import ast.types.FunctionType;

public class FuncDefinition extends AbstractDefinition{
	
	private String name;
	private Type functionType;
	private int scope;
	
	private List<Definition> varDefinitions;
	private List<Statement> statements;
	
	private int bytesLocals;

	public FuncDefinition(int line, int column, String name, Type functionType,List<Definition> varDefinitions ,List<Statement> statements) {
		super(line,column);
		this.name = name;
		this.functionType = functionType;
		this.scope = 0;
		this.statements = statements;
		this.varDefinitions=varDefinitions;
	}
	
	public List<Statement> getStatements() {
		return statements;
	}
	
	public List<Definition> getVarDefinitions() {
		return varDefinitions;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Type getType() {
		return functionType;
	}
	
	@Override
	public void setType(Type type) {
		this.functionType=type;
	}

	@Override
	public int getScope() {
		return scope;
	}
	
	@Override
	public Object accept(Visitor v, Object params) {
		return v.visit(this,params);
	}

	@Override
	public void setScope(int scope) {
		this.scope=scope;
	}
	
	public void setBytesLocals(int bytesLocals) {
		this.bytesLocals=bytesLocals;
	}
	
	public int getBytesLocals() {
		return bytesLocals;
	}
	
	public int getBytesParams() {
		return ((FunctionType)functionType).getBytesParams();
	}
	

}
