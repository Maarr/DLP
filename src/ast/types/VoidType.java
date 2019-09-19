package ast.types;

import semanticVisitor.Visitor;

public class VoidType extends AbstractType {
	
	private static VoidType instance;

	private VoidType(int line, int column) {
		super(line,column);
	}

	/**
	 * Patrón Singleton
	 * 
	 * @return
	 */
	public static VoidType getInstance(int line, int column) {
		if (instance == null)
			instance = new VoidType(line, column);
		return instance;
	}
	
	@Override
	public String toString() {
		return "VoidType";
	}
	
	@Override
	public Object accept(Visitor v, Object params) {
		return v.visit(this,params);
	}

	@Override
	public int getSize() {
		return 0;
	}

}
