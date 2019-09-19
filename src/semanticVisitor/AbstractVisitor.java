package semanticVisitor;

import ast.Program;
import ast.definitions.Definition;
import ast.definitions.FieldDefinition;
import ast.definitions.FuncDefinition;
import ast.definitions.VarDefinition;
import ast.expressions.Arithmetic;
import ast.expressions.ArrayAccess;
import ast.expressions.Cast;
import ast.expressions.CharLiteral;
import ast.expressions.Comparison;
import ast.expressions.DoubleLiteral;
import ast.expressions.Expression;
import ast.expressions.FieldAccess;
import ast.expressions.FunctionCall;
import ast.expressions.IntLiteral;
import ast.expressions.Logic;
import ast.expressions.Not;
import ast.expressions.UnaryMinus;
import ast.expressions.Variable;
import ast.statements.Assignation;
import ast.statements.Conditional;
import ast.statements.Input;
import ast.statements.Print;
import ast.statements.Return;
import ast.statements.Statement;
import ast.statements.While;
import ast.types.ArrayType;
import ast.types.CharType;
import ast.types.DoubleType;
import ast.types.ErrorType;
import ast.types.FunctionType;
import ast.types.IntType;
import ast.types.StructType;
import ast.types.VoidType;

public abstract class AbstractVisitor implements Visitor{

	@Override
	public Object visit(Program node, Object params) {
		for(Definition d: node.getDefinitions())
			d.accept(this, params);
		return null;
	}
	
	//------------------DEFINITIONS

	@Override
	public Object visit(FieldDefinition node, Object params) {
		node.getType().accept(this, params);
		return null;
	}

	@Override
	public Object visit(FuncDefinition node, Object params) {
		node.getType().accept(this, params);
		for(Definition d: node.getVarDefinitions())
			d.accept(this, params);
		for(Statement s: node.getStatements())
			s.accept(this, params);
		return null;
	}

	@Override
	public Object visit(VarDefinition node, Object params) {
		node.getType().accept(this, params);
		return null;
	}
	
	//------------------EXPRESSIONS

	@Override
	public Object visit(Arithmetic node, Object params) {
		node.getLeft().accept(this, params);
		node.getRight().accept(this, params);
		return null;
	}

	@Override
	public Object visit(ArrayAccess node, Object params) {
		node.getLeft().accept(this, params);
		node.getRight().accept(this, params);
		return null;
	}

	@Override
	public Object visit(Cast node, Object params) {
		node.getType().accept(this, params);
		node.getExpression().accept(this, params);
		return null;
	}

	@Override
	public Object visit(CharLiteral node, Object params) {
		return null;
	}

	@Override
	public Object visit(Comparison node, Object params) {
		node.getLeft().accept(this, params);
		node.getRight().accept(this, params);
		return null;
	}

	@Override
	public Object visit(DoubleLiteral node, Object params) {
		return null;
	}

	@Override
	public Object visit(FieldAccess node, Object params) {
		node.getExpression().accept(this, params);
		return null;
	}

	@Override
	public Object visit(FunctionCall node, Object params) {
		node.getName().accept(this,params);
		for(Expression e:node.getArguments())
			e.accept(this,params);
		return null;
	}

	@Override
	public Object visit(IntLiteral node, Object params) {
		return null;
	}

	@Override
	public Object visit(Logic node, Object params) {
		node.getLeft().accept(this, params);
		node.getRight().accept(this, params);
		return null;
	}

	@Override
	public Object visit(Not node, Object params) {
		node.getExpression().accept(this, params);
		return null;
	}

	@Override
	public Object visit(UnaryMinus node, Object params) {
		node.getExpression().accept(this, params);
		return null;
	}

	@Override
	public Object visit(Variable node, Object params) {
		return null;
	}
	
	//------------------STATEMENTS

	@Override
	public Object visit(Assignation node, Object params) {
		node.getLeft().accept(this, params);
		node.getRight().accept(this, params);
		return null;
	}

	@Override
	public Object visit(Conditional node, Object params) {
		node.getCondition().accept(this, params);
		for(Statement s:node.getIfBody())
			s.accept(this, params);
		for(Statement s:node.getElseBody())
			s.accept(this, params);
		return null;
	}

	@Override
	public Object visit(Input node, Object params) {
		for(Expression e:node.getExpressions())
			e.accept(this, params);
		return null;
	}

	@Override
	public Object visit(Print node, Object params) {
		for(Expression e:node.getExpressions())
			e.accept(this, params);
		return null;
	}

	@Override
	public Object visit(Return node, Object params) {
		node.getExpression().accept(this, params);
		return null;
	}

	@Override
	public Object visit(While node, Object params) {
		node.getCondition().accept(this, params);
		for(Statement s:node.getBody())
			s.accept(this,params);
		return null;
	}
	
	//------------------TYPES

	@Override
	public Object visit(ArrayType node, Object params) {
		node.getArrayType().accept(this, params);
		return null;
	}

	@Override
	public Object visit(CharType node, Object params) {
		return null;
	}

	@Override
	public Object visit(DoubleType node, Object params) {
		return null;
	}

	@Override
	public Object visit(FunctionType node, Object params) {
		node.getReturnType().accept(this, params);
		for(Definition d:node.getParameters())
			d.accept(this,params);
		return null;
	}

	@Override
	public Object visit(IntType node, Object params) {
		return null;
	}

	@Override
	public Object visit(StructType node, Object params) {
		for(FieldDefinition f:node.getFields())
			f.accept(this,params);
		return null;
	}

	@Override
	public Object visit(VoidType node, Object params) {
		return null;
	}

	@Override
	public Object visit(ErrorType node, Object params) {
		return null;
	}

}
