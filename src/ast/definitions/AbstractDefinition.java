package ast.definitions;

import ast.AbstractASTNode;

public abstract class AbstractDefinition extends AbstractASTNode implements Definition{

	public AbstractDefinition(int line, int column) {
		super(line, column);
	}
	
	/**
	 * Implementaci�n por defecto para las definici�n de funciones
	 */
	@Override
	public void setOffSet(int offSet) {
		
	}
	
	@Override
	public int getOffSet() {
		return -1;
	}

}
