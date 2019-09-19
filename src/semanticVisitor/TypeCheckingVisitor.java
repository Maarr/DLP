package semanticVisitor;

import java.util.ArrayList;
import java.util.List;

import ast.definitions.Definition;
import ast.definitions.FuncDefinition;
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
import ast.statements.Return;
import ast.statements.Statement;
import ast.statements.While;
import ast.types.*;

public class TypeCheckingVisitor extends AbstractVisitor{
		
	
	//------------------STATEMENTS

		@Override
		public Object visit(Assignation node, Object params) {
			node.getLeft().accept(this, params);
			node.getRight().accept(this, params);
			
			if (node.getLeft().getType() != null && node.getRight().getType() != null) {
				node.getLeft().setType(node.getRight().getType().promotesTo(node.getLeft().getType()));
				if (node.getLeft().getType() == null) {
					node.getLeft().setType( new ErrorType( node.getLeft().getLine(),node.getLeft().getColumn(),"Error TypeChecking Assignation: el tipo a asignar"+node.getRight().getType()+" no es correcto"+node.getLeft().getType()));
				}
			}
			
			
			return null;
		}

		@Override
		public Object visit(Conditional node, Object params) {
			node.getCondition().accept(this, params);
			if(!node.getCondition().getType().isLogical())
				node.getCondition().setType(new ErrorType(node.getCondition().getLine(),node.getCondition().getColumn(),"Error TypeChecking Conditional: se esperaba una condición lógica en el if"));
			for(Statement s:node.getIfBody())
				s.accept(this, params);
			for(Statement s:node.getElseBody())
				s.accept(this, params);
			return null;
		}
		
		@Override
		public Object visit(While node, Object params) {
			node.getCondition().accept(this, params);
			if(!node.getCondition().getType().isLogical())
				node.getCondition().setType(new ErrorType(node.getCondition().getLine(),node.getCondition().getColumn(),"Error TypeChecking While: se esperaba una condición lógica en el while"));
			for(Statement s:node.getBody())
				s.accept(this,params);
			return null;
		}
		
		@Override
		public Object visit(Return node, Object params) {
			Type returnType=((FunctionType)params).getReturnType();
			node.getExpression().accept(this, params);
			if(node.getExpression().getType().promotesTo(returnType)==null)
				new ErrorType(node.getLine(),node.getColumn(),"Error TypeChecking Return: el tipo retornado " + node.getExpression().getType() + " no concuerda con el tipo especificado en la definición de la función" + returnType );
			return null;
		}
	
	
	//--------------EXPRESSIONS
	
	@Override
	public Object visit(Arithmetic node, Object params) {
		node.getLeft().accept(this, params);
		node.getRight().accept(this, params);
		node.setType(node.getLeft().getType().arithmetic(node.getRight().getType()));
		if(node.getType()==null)
			node.setType(new ErrorType(node.getLine(),node.getColumn(),"Error TypeChecking Arithmetic: no se pueden hacer operaciones aritméticas entre "+node.getLeft().getType()+" y "+node.getRight().getType()));
		return null;
	}

	@Override
	public Object visit(ArrayAccess node, Object params) {
		node.getLeft().accept(this, params);
		node.getRight().accept(this, params);
		
		node.setType(node.getLeft().getType().indexing(node.getRight().getType()));
		if(node.getType()==null)
			node.setType(new ErrorType(node.getLine(),node.getColumn(),"Error TypeChecking ArrayAcces: error al indexar"));
		return null;
	}

	@Override
	public Object visit(Cast node, Object params) {
		node.getType().accept(this, params);
		node.getExpression().accept(this, params);
		node.setType(node.getType().cast(node.getExpression().getType()));
		if(node.getType()==null)
			node.setType(new ErrorType(node.getLine(),node.getColumn(),"Error TypeChecking Cast: no se puede hacer cast"));
		return null;
	}

	@Override
	public Object visit(CharLiteral node, Object params) {
		node.setType(CharType.getInstance(node.getLine(), node.getColumn()));
		return null;
	}

	@Override
	public Object visit(Comparison node, Object params) {
		node.getLeft().accept(this, params);
		node.getRight().accept(this, params);
		node.setType(node.getLeft().getType().arithmetic(node.getRight().getType()));
		if(node.getType()==null)
			node.setType(new ErrorType(node.getLine(),node.getColumn(),"Error TypeChecking Comparison: no se pueden hacer operaciones de comparación entre "+node.getLeft().getType()+" y "+node.getRight().getType()));
		return null;
	}

	@Override
	public Object visit(DoubleLiteral node, Object params) {
		node.setType(DoubleType.getInstance(node.getLine(), node.getColumn()));
		return null;
	}

	@Override
	public Object visit(FieldAccess node, Object params) {
		node.getExpression().accept(this, params);
		if(node.getExpression().getType()!=null) {
			node.setType(node.getExpression().getType().dot(node.getName()));
			if(node.getType()==null)
				node.setType(new ErrorType(node.getLine(),node.getColumn(),"Error TypeChecking FieldAccess: imposible acceder al field "+node.getName()));
		}
		return null;
	}

	@Override
	public Object visit(FunctionCall node, Object params) {
		node.getName().accept(this,params);
		
		List<Type> types = new ArrayList<Type>();
		for(Expression e:node.getArguments()) {
			e.accept(this,params);
			types.add(e.getType());
		}
		
		node.setType(node.getName().getType().parenthesis(types));
		if(node.getType()==null)
			node.setType(new ErrorType(node.getLine(),node.getColumn(),"Error TypeChecking FunctionCall: parámetros incorrectos en la invocación a la función "+node.getName().getName()));

		return null;
	}

	@Override
	public Object visit(IntLiteral node, Object params) {
		node.setType(IntType.getInstance(node.getLine(), node.getColumn()));
		return null;
	}

	@Override
	public Object visit(Logic node, Object params) {
		node.getLeft().accept(this, params);
		node.getRight().accept(this, params);
		
		node.setType(node.getLeft().getType().logical(node.getRight().getType()));
		
		if(node.getType()==null)
			node.setType(new ErrorType(node.getLine(),node.getColumn(),"Error TypeChecking Logic: no se pueden hacer operaciones lógicas entre "+node.getLeft().getType()+" y "+node.getRight().getType()));
		return null;
	}

	@Override
	public Object visit(Not node, Object params) {
		node.getExpression().accept(this, params);
		node.setType(node.getExpression().getType().logical());
		if(node.getType()==null)
			node.setType(new ErrorType(node.getLine(),node.getColumn(),"Error TypeChecking Not: NOT no aplicable sobre el tipo "+node.getExpression().getType()));
		return null;
	}

	@Override
	public Object visit(UnaryMinus node, Object params) {
		node.getExpression().accept(this, params);
		node.setType(node.getExpression().getType().arithmetic());
		if(node.getType()==null)
			node.setType(new ErrorType(node.getLine(),node.getColumn(),"Error TypeChecking UnaryMinus: UnaryMinus no aplicable sobre el tipo "+node.getExpression().getType()));
		return null;
	}

	@Override
	public Object visit(Variable node, Object params) {
		node.setType(node.getDefinition().getType());
		return null;
	}
	
	//------------------DEFINITION (para lo del return)
	@Override
	public Object visit(FuncDefinition node, Object params) {
		node.getType().accept(this, params);
		for(Definition d: node.getVarDefinitions())
			d.accept(this, params);
		for(Statement s: node.getStatements())
			s.accept(this, node.getType());
		return null;
	}

}
