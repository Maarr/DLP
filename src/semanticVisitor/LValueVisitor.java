package semanticVisitor;

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
import ast.statements.Input;
import ast.types.ErrorType;

public class LValueVisitor extends AbstractVisitor{
	
	
	@Override
	public Object visit(Assignation node, Object params) {
		node.getLeft().accept(this, params);
		if(!node.getLeft().getLValue())
			new ErrorType(node.getLine(),node.getColumn(),"Error LValue Assignation: se esperaba una variable a la izquierda de la asignación");
		node.getRight().accept(this, params);
		return null;
	}
	
	@Override
	public Object visit(Input node, Object params) {
		boolean correctInput=true;
		for(Expression e:node.getExpressions()) {
			e.accept(this, params);
			if(!e.getLValue())
				correctInput=false;
		}
		if(!correctInput)
			new ErrorType(node.getLine(),node.getColumn(),"Error LValue Input: se esperaban variables como entrada del input");
		return null;
	}
	
	@Override
	public Object visit(Arithmetic node, Object params) {
		node.setLValue(false);
		node.getLeft().accept(this, params);
		node.getRight().accept(this, params);
		return null;
	}

	@Override
	public Object visit(ArrayAccess node, Object params) {
		node.setLValue(true);
		node.getLeft().accept(this, params);
		node.getRight().accept(this, params);
		return null;
	}

	@Override
	public Object visit(Cast node, Object params) {
		node.setLValue(false);
		node.getType().accept(this, params);
		node.getExpression().accept(this, params);
		return null;
	}

	@Override
	public Object visit(CharLiteral node, Object params) {
		node.setLValue(false);
		return null;
	}

	@Override
	public Object visit(Comparison node, Object params) {
		node.setLValue(false);
		node.getLeft().accept(this, params);
		node.getRight().accept(this, params);
		return null;
	}

	@Override
	public Object visit(DoubleLiteral node, Object params) {
		node.setLValue(false);
		return null;
	}

	@Override
	public Object visit(FieldAccess node, Object params) {
		node.setLValue(true);
		node.getExpression().accept(this, params);
		return null;
	}

	@Override
	public Object visit(FunctionCall node, Object params) {
		node.setLValue(false);
		node.getName().accept(this,params);
		for(Expression e:node.getArguments())
			e.accept(this,params);
		return null;
	}

	@Override
	public Object visit(IntLiteral node, Object params) {
		node.setLValue(false);
		return null;
	}

	@Override
	public Object visit(Logic node, Object params) {
		node.setLValue(false);
		node.getLeft().accept(this, params);
		node.getRight().accept(this, params);
		return null;
	}

	@Override
	public Object visit(Not node, Object params) {
		node.setLValue(false);
		node.getExpression().accept(this, params);
		return null;
	}

	@Override
	public Object visit(UnaryMinus node, Object params) {
		node.setLValue(false);
		node.getExpression().accept(this, params);
		return null;
	}

	@Override
	public Object visit(Variable node, Object params) {
		node.setLValue(true);
		return null;
	}

}
