package ast.types;

import semanticVisitor.Visitor;

public class ArrayType extends AbstractType{
	
	private Type arrayType;
	private int arraySize;
	
	public ArrayType(int line, int column,Type arrayType, int arraySize) {
		super(line,column);
		this.arrayType = arrayType;
		this.arraySize = arraySize;
	}

	public Type getArrayType() {
		return arrayType;
	}

	public int getArraySize() {
		return arraySize;
	}
	
	@Override
	public String toString() {
		return "ArrayType [arrayType=" + arrayType + ", size=" + arraySize + "]";
	}

	@Override
	public Object accept(Visitor v, Object params) {
		return v.visit(this,params);
	}
	
	@Override
	public Type indexing(Type type) {
		if(type.equals(IntType.getInstance(getLine(), getColumn())))
			return this.getArrayType();
		else if(type instanceof ErrorType)
			return type;
		else
			return null;
	}
	
	@Override
	public int getSize() {
		return arraySize*arrayType.getSize();
	}

}
