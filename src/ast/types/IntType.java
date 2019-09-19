package ast.types;

import semanticVisitor.Visitor;

public class IntType extends AbstractType{
	
	private static IntType instance;
	
	private IntType(int line, int column) {
		super(line,column);
	}
	
	/**
	 * Patrón Singleton
	 * @return
	 */
	public static IntType getInstance(int line, int column) {
		if (instance == null)
			instance = new IntType(line,column);
		return instance;
	}
	
	@Override
	public String toString() {
		return "IntType";
	}
	
	@Override
	public Object accept(Visitor v, Object params) {
		return v.visit(this,params);
	}
	
	@Override
	public boolean isLogical() {
		return true;
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
			return this;
		else if(other instanceof ErrorType)
			return other;
		else
			return null;
	}
	
	@Override
	public Type logical(Type other) {
		if(this.equals(other))
			return this;
		else if(other instanceof ErrorType)
			return other;
		else
			return null;
	}
	
	@Override
	public Type logical() {
		return this;
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
		return 2;
	}

}
