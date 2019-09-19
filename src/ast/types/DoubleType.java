package ast.types;

import semanticVisitor.Visitor;

public class DoubleType extends AbstractType {
	
	private static DoubleType instance;

	private DoubleType(int line, int column) {
		super(line,column);
	}

	/**
	 * Patrón Singleton
	 * 
	 * @return
	 */
	public static DoubleType getInstance(int line, int column) {
		if (instance == null)
			instance = new DoubleType(line,column);
		return instance;
	}
	
	@Override
	public String toString() {
		return "DoubleType";
	}
	
	@Override
	public Object accept(Visitor v, Object params) {
		return v.visit(this,params);
	}
	
	@Override
	public Type arithmetic(Type other) {
		if(this.equals(other))
			return this;
		else if(other instanceof ErrorType)
			return other;
		else
			return null;
	}
	
	@Override
	public Type arithmetic() {
		return this;
	}
	
	@Override
	public Type comparison(Type other) {
		if(this.equals(other))
			return IntType.getInstance(getLine(), getColumn());
		else if(other instanceof ErrorType)
			return other;
		else
			return null;
	}
	
	@Override
	public boolean isBuiltintType() {
		return true;
	}
	
	@Override
	public Type cast(Type type) {
		if(type.isBuiltintType())
			return this;
		else if(type instanceof ErrorType)
			return type;
		else
			return null;
	}
	
	@Override
	public Type promotesTo(Type type) {
		if(this.equals(type))
			return this;
		else if(type instanceof ErrorType)
			return type;
		else
			return null;
	}

	@Override
	public int getSize() {
		return 4;
	}
	
	@Override
	public String suffix() {
		return "F";
	}

}
