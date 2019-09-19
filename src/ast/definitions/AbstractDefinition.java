package ast.definitions;

import ast.AbstractASTNode;

public abstract class AbstractDefinition extends AbstractASTNode implements Definition{

	public AbstractDefinition(int line, int column) {
		super(line, column);
	}
	
	/**
	 * Implementación por defecto para las definición de funciones
	 */
	@Override
	public void setOffSet(int offSet) {
		
	}
	
	@Override
	public int getOffSet() {
		return -1;
	}

}
