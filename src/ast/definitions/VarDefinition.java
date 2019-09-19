package ast.definitions;

import ast.types.Type;
import semanticVisitor.Visitor;

public class VarDefinition extends AbstractDefinition{
	
	private String name;
	private Type type;
	private int scope;
	private int offSet;
	
	public VarDefinition(int line, int column,String name, Type type) {
		super(line,column);
		this.name=name;
		this.type=type;
		this.scope=0;
		this.offSet=0;
	}
	
	@Override
	public int getOffSet() {
		return offSet;
	}
	
	@Override
	public void setOffSet(int offSet) {
		this.offSet=offSet;
	}

	@Override
	public String getName() {
		return name;
	}

	
	public Type getType() {
		return type;
	}
	
	@Override
	public void setType(Type type) {
		this.type=type;
	}

	@Override
	public int getScope() {
		return scope;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + offSet;
		result = prime * result + scope;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		VarDefinition other = (VarDefinition) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (offSet != other.offSet)
			return false;
		if (scope != other.scope)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	
	@Override
	public Object accept(Visitor v, Object params) {
		return v.visit(this,params);
	}

	@Override
	public void setScope(int scope) {
		this.scope=scope;
	}

	@Override
	public String toString() {
		return type +" "+name+ " [offSet " + offSet + "]";
	}
	

}
