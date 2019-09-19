package ast.types;

import java.util.List;

import ast.ASTNode;
import ast.definitions.FieldDefinition;

public interface Type extends ASTNode{
	
	/**
	 * ¿Funcionas como un boolean?
	 */
	public boolean isLogical();
	
	/**
	 * ¿Puedes hacer operaciones aritméticas con este otro Tipo?
	 */
	public Type arithmetic(Type other);
	
	/**
	 * ¿Puedes hacer operaciones aritméticas contigo mismo?
	 */
	public Type arithmetic();
	
	/**
	 * ¿Puedes compararte con este otro Tipo?
	 */
	public Type comparison(Type other);
	
	/**
	 * ¿Puedes hacer operaciones lógicas con este otro Tipo?
	 */
	public Type logical(Type other);
	
	/**
	 * ¿Puedes hacer operaciones lógicas contigo mismo?
	 */
	public Type logical();
	
	/**
	 * Como Struct, ¿tienes este Field definido?
	 */
	public Type dot(String field);
	
	/**
	 * Como Array, ¿puedes indexarte con este Tipo?
	 * El index en el acceso a un Array debería ser un IntType
	 */
	public Type indexing(Type type);
	
	/**
	 * ¿Eres tipo primitivo?
	 */
	public boolean isBuiltintType();
	
	/**
	 * ¿Puedes castearte?
	 */
	public Type cast(Type type);
	
	/**
	 * ¿Puedes invocarte y son correctos los tipos de los parámetros?
	 */
	public Type parenthesis(List<Type> types);
	
	/**
	 * 
	 */
	public Type promotesTo(Type type);
	
	/**
	 * Devuelve el tamaño(número de bytes) según el tipo
	 * @return
	 */
	public int getSize();
	
	/**
	 * Devuelve un caracter según el tipo
	 * @return
	 */
	public String suffix();
	
	/**
	 * Devuelve el FieldDefinition de un Struct según el nombre dado
	 * @param name nombre del field
	 * @return
	 */
	public FieldDefinition getFieldDefinition(String name);

}
