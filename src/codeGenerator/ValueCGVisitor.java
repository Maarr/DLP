package codeGenerator;

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
import ast.types.IntType;

/**
 * Se evaluan las expresiones
 */
public class ValueCGVisitor extends AbstractCGVisitor {
	private CodeGenerator cg;
	
	private AddressCGVisitor addressVisitor;

	public ValueCGVisitor(CodeGenerator cg) {
		this.cg=cg;
	}
	
	public void setAddressVisitor(AddressCGVisitor addressVisitor) {
		this.addressVisitor=addressVisitor;
	}

	// ------------------EXPRESSIONS

	@Override
	public Object visit(Arithmetic arithmetic, Object params) {
		arithmetic.getLeft().accept(this, params); //VALUE[[left]]
		cg.convertTo(arithmetic.getLeft().getType(), arithmetic.getType());
		arithmetic.getRight().accept(this, params); //VALUE[[right]]
		cg.convertTo(arithmetic.getRight().getType(), arithmetic.getType());
		cg.arithmetic(arithmetic.getOperator(), arithmetic.getLeft().getType());
		return null;
	}

	@Override
	public Object visit(ArrayAccess arrayAccess, Object params) {
		arrayAccess.accept(addressVisitor, params);//ADDRESS[[arrayAccess]]
		cg.load(arrayAccess.getType());
		return null;
	}

	@Override
	public Object visit(Cast cast, Object params) {
		cast.getExpression().accept(this, params);//VALUE[[expr]]
		cg.convertTo(cast.getExpression().getType(),cast.getType());
		return null;
	}

	@Override
	public Object visit(CharLiteral charLiteral, Object params) {
		cg.push(charLiteral.getValue());
		return null;
	}

	@Override
	public Object visit(Comparison comparison, Object params) {
		comparison.getLeft().accept(this, params); //VALUE[[left]]
		cg.convertTo(comparison.getLeft().getType(), comparison.getType());
		comparison.getRight().accept(this, params); //VALUE[[right]]
		cg.convertTo(comparison.getRight().getType(), comparison.getType());
		cg.comparison(comparison.getOperator(), comparison.getLeft().getType());
		return null;
	}

	@Override
	public Object visit(DoubleLiteral doubleLiteral, Object params) {
		cg.push(doubleLiteral.getValue());
		return null;
	}

	@Override
	public Object visit(FieldAccess fieldAccess, Object params) {
		fieldAccess.accept(addressVisitor, params);
		cg.load(fieldAccess.getType());
		return null;
	}

	@Override
	public Object visit(FunctionCall functionCall, Object params) {
		for(Expression e:functionCall.getArguments())
			e.accept(this, params); //VALUE[[expr*]]
		cg.call(functionCall.getName().getName());
		return null;
	}

	@Override
	public Object visit(IntLiteral intLiteral, Object params) {
		cg.push(intLiteral.getValue());
		return null;
	}

	@Override
	public Object visit(Logic logic, Object params) {
		logic.getLeft().accept(this, params); //VALUE[[left]]
		cg.convertTo(logic.getLeft().getType(), logic.getType());
		logic.getRight().accept(this, params); //VALUE[[right]]
		cg.convertTo(logic.getRight().getType(), logic.getType());
		cg.logic(logic.getOperator());
		return null;
	}

	@Override
	public Object visit(Not not, Object params) {
		not.getExpression().accept(this, params); //VALUE[[expr]]
		cg.not();
		return null;
	}

	@Override
	public Object visit(UnaryMinus unaryMinus, Object params) {
		unaryMinus.getExpression().accept(this, params); //VALUE[[expr]]
		cg.push(-1);
		cg.convertTo(IntType.getInstance(unaryMinus.getLine(), unaryMinus.getColumn()), unaryMinus.getExpression().getType());
		cg.mul(unaryMinus.getExpression().getType());
		return null;
	}

	@Override
	public Object visit(Variable var, Object params) {
		var.accept(addressVisitor, params);
		cg.load(var.getType());
		return null;
	}



}
