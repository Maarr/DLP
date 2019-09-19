package ast.types;

import java.util.List;

import ast.definitions.FieldDefinition;
import semanticVisitor.Visitor;

public class StructType extends AbstractType{
	
	private List<FieldDefinition> fields;

	public StructType(int line, int column, List<FieldDefinition> fields) {
		super(line,column);
		this.fields = fields;
	}

	public List<FieldDefinition> getFields() {
		return fields;
	}
	
	@Override
	public String toString() {
		return "StructType";
	}

	@Override
	public Object accept(Visitor v, Object params) {
		return v.visit(this,params);
	}
	
	@Override
	public Type dot(String field) {
		for(FieldDefinition f:fields) 
			if(f.getName().equals(field))
				return f.getType();		
	
		return null;
	}
	
	@Override
	public int getSize() {
		int tamañoCampos=0;
		for(FieldDefinition f:fields)
			tamañoCampos+=f.getType().getSize();
		return tamañoCampos;
	}
	
	@Override
	public FieldDefinition getFieldDefinition(String name) {
		for(FieldDefinition f:fields) {
			if(name.equals(f.getName()))
				return f;
		}
		return null;
	}

}
