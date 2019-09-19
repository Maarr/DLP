package ast.types;

import java.util.List;

import ast.AbstractASTNode;
import ast.definitions.FieldDefinition;

public abstract class AbstractType extends AbstractASTNode implements Type{
	
	public AbstractType(int line, int column) {
		super(line, column);
	}
	
	@Override
	public boolean isLogical() {
		return false;
	}
	
	@Override
	public Type arithmetic(Type other) {
		if(other instanceof ErrorType)
			return other;
		return null;
	}
	
	@Override
	public Type arithmetic() {
		return null;
	}
	
	@Override
	public Type comparison(Type other) {
		if(other instanceof ErrorType)
			return other;
		return null;
	}
	
	@Override
	public Type logical(Type other) {
		if(other instanceof ErrorType)
			return other;
		return null;
	}
	
	@Override
	public Type logical() {
		return null;
	}
	
	@Override
	public Type dot(String field) {
		return null;
	}
	
	@Override
	public Type indexing(Type type) {
		if(type instanceof ErrorType)
			return type;
		return null;
	}
	
	@Override
	public boolean isBuiltintType() {
		return false;
	}
	
	@Override
	public Type cast(Type type) {
		if(type instanceof ErrorType)
			return type;
		return null;
	}
	
	@Override
	public Type parenthesis(List<Type> types) {
		return null;
	}
	
	@Override
	public Type promotesTo(Type type) {
		if(type instanceof ErrorType)
			return type;
		return null;
	}
	
	@Override
	public String suffix() {
		return "";
	}
	
	@Override
	public FieldDefinition getFieldDefinition(String name) {
		return null;
	}

}
