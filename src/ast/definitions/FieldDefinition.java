package ast.definitions;

import ast.types.Type;
import semanticVisitor.Visitor;

public class FieldDefinition {
	
	private String name;
	private Type type;
	private int offset;
	
	public FieldDefinition(String name, Type type) {
		this.name = name;
		this.type=type;
		this.offset = 0;
	}

	public String getName() {
		return name;
	}
	
	public Type getType() {
		return type;
	}
	
	public void setType(Type type) {
		this.type=type;
	}

	public int getOffset() {
		return offset;
	}
	
	public void setOffSet(int offSet) {
		this.offset=offSet;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FieldDefinition other = (FieldDefinition) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public Object accept(Visitor v, Object params) {
		return v.visit(this,params);
	}
	
	
}
