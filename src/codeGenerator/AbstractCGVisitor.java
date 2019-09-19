package codeGenerator;

import ast.Program;
import ast.definitions.*;
import ast.expressions.*;
import ast.statements.*;
import ast.types.*;
import semanticVisitor.Visitor;

public abstract class AbstractCGVisitor implements Visitor{
	
/*
	 * Tenemos q pedir en el Main el fichero d entrada q ya pediamos y ahora un fichero de salida.
	 * Usar un FileWriter	
	 *Hay q arreglar el main ojo
 */
	@Override
	public Object visit(Program node, Object params) {
		throw new IllegalStateException("Code generation template \"Program\" not defined for the code function "+this.getClass().getName());
	}
	
	//------------------DEFINITIONS

	@Override
	public Object visit(FieldDefinition node, Object params) {
		throw new IllegalStateException("Code generation template \"FieldDefinition\" not defined for the code function "+this.getClass().getName());
	}

	@Override
	public Object visit(FuncDefinition node, Object params) {
		throw new IllegalStateException("Code generation template \"FuncDefinition\" not defined for the code function "+this.getClass().getName());
	}

	@Override
	public Object visit(VarDefinition node, Object params) {
		throw new IllegalStateException("Code generation template \"VarDefinition\" not defined for the code function "+this.getClass().getName());
	}
	
	//------------------EXPRESSIONS

	@Override
	public Object visit(Arithmetic node, Object params) {
		throw new IllegalStateException("Code generation template \"Arithmetic\" not defined for the code function "+this.getClass().getName());
	}

	@Override
	public Object visit(ArrayAccess node, Object params) {
		throw new IllegalStateException("Code generation template \"ArrayAccess\" not defined for the code function "+this.getClass().getName());
	}

	@Override
	public Object visit(Cast node, Object params) {
		throw new IllegalStateException("Code generation template \"Cast\" not defined for the code function "+this.getClass().getName());
	}

	@Override
	public Object visit(CharLiteral node, Object params) {
		throw new IllegalStateException("Code generation template \"CharLiteral\" not defined for the code function "+this.getClass().getName());
	}

	@Override
	public Object visit(Comparison node, Object params) {
		throw new IllegalStateException("Code generation template \"Comparison\" not defined for the code function "+this.getClass().getName());
	}

	@Override
	public Object visit(DoubleLiteral node, Object params) {
		throw new IllegalStateException("Code generation template \"DoubleLiteral\" not defined for the code function "+this.getClass().getName());
	}

	@Override
	public Object visit(FieldAccess node, Object params) {
		throw new IllegalStateException("Code generation template \"Field Access\" not defined for the code function "+this.getClass().getName());
	}

	@Override
	public Object visit(FunctionCall node, Object params) {
		throw new IllegalStateException("Code generation template \"FunctionCall\" not defined for the code function "+this.getClass().getName());
	}

	@Override
	public Object visit(IntLiteral node, Object params) {
		throw new IllegalStateException("Code generation template \"IntLiteral\" not defined for the code function "+this.getClass().getName());
	}

	@Override
	public Object visit(Logic node, Object params) {
		throw new IllegalStateException("Code generation template \"Logic\" not defined for the code function "+this.getClass().getName());
	}

	@Override
	public Object visit(Not node, Object params) {
		throw new IllegalStateException("Code generation template \"Not\" not defined for the code function "+this.getClass().getName());
	}

	@Override
	public Object visit(UnaryMinus node, Object params) {
		throw new IllegalStateException("Code generation template \"UnaryMinus\" not defined for the code function "+this.getClass().getName());
	}

	@Override
	public Object visit(Variable node, Object params) {
		throw new IllegalStateException("Code generation template \"Variable\" not defined for the code function "+this.getClass().getName());
	}
	
	//------------------STATEMENTS

	@Override
	public Object visit(Assignation node, Object params) {
		throw new IllegalStateException("Code generation template \"Assignation\" not defined for the code function "+this.getClass().getName());
	}

	@Override
	public Object visit(Conditional node, Object params) {
		throw new IllegalStateException("Code generation template \"Conditional\" not defined for the code function "+this.getClass().getName());
	}

	@Override
	public Object visit(Input node, Object params) {
		throw new IllegalStateException("Code generation template \"Input\" not defined for the code function "+this.getClass().getName());
	}

	@Override
	public Object visit(Print node, Object params) {
		throw new IllegalStateException("Code generation template \"Print\" not defined for the code function "+this.getClass().getName());
	}

	@Override
	public Object visit(Return node, Object params) {
		throw new IllegalStateException("Code generation template \"Return\" not defined for the code function "+this.getClass().getName());
	}

	@Override
	public Object visit(While node, Object params) {
		throw new IllegalStateException("Code generation template \"While\" not defined for the code function "+this.getClass().getName());
	}
	
	//------------------TYPES

	@Override
	public Object visit(ArrayType node, Object params) {
		throw new IllegalStateException("Code generation template \"While\" not defined for the code function "+this.getClass().getName());
	}

	@Override
	public Object visit(CharType node, Object params) {
		throw new IllegalStateException("Code generation template \"CharType\" not defined for the code function "+this.getClass().getName());
	}

	@Override
	public Object visit(DoubleType node, Object params) {
		throw new IllegalStateException("Code generation template \"DoubleType\" not defined for the code function "+this.getClass().getName());
	}

	@Override
	public Object visit(FunctionType node, Object params) {
		throw new IllegalStateException("Code generation template \"FunctionType\" not defined for the code function "+this.getClass().getName());
	}

	@Override
	public Object visit(IntType node, Object params) {
		throw new IllegalStateException("Code generation template \"IntType\" not defined for the code function "+this.getClass().getName());
	}

	@Override
	public Object visit(StructType node, Object params) {
		throw new IllegalStateException("Code generation template \"StructType\" not defined for the code function "+this.getClass().getName());
	}

	@Override
	public Object visit(VoidType node, Object params) {
		throw new IllegalStateException("Code generation template \"VoidType\" not defined for the code function "+this.getClass().getName());
	}

	@Override
	public Object visit(ErrorType node, Object params) {
		throw new IllegalStateException("Code generation template \"ErrorType\" not defined for the code function "+this.getClass().getName());
	}

}
