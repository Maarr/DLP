package ast.types;

import semanticVisitor.Visitor;

public class CharType extends AbstractType {

	private static CharType instance;

	private CharType(int line, int column) {
		super(line,column);
	}

	/**
	 * Patrón Singleton
	 * 
	 * @return
	 */
	public static CharType getInstance(int line, int column) {
		if (instance == null)
			instance = new CharType(line,column);
		return instance;
	}
	
	@Override
	public String toString() {
		return "CharType";
	}

	@Override
	public Object accept(Visitor v, Object params) {
		return v.visit(this,params);
	}
	
	@Override
	public Type arithmetic(Type other) {
		if(this.equals(other))
			return IntType.getInstance(getLine(), getColumn());
		else if(other instanceof ErrorType)
			return other;
		else
			return null;
	}
	
	@Override
	public Type arithmetic() {
		return IntType.getInstance(getLine(), getColumn());
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
		return 1;
	}
	
	@Override
	public String suffix() {
		return "B";
	}

}
