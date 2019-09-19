package semanticVisitor;

import ast.Program;
import ast.definitions.FieldDefinition;
import ast.definitions.FuncDefinition;
import ast.definitions.VarDefinition;
import ast.expressions.Arithmetic;
import ast.expressions.ArrayAccess;
import ast.expressions.Cast;
import ast.expressions.CharLiteral;
import ast.expressions.Comparison;
import ast.expressions.DoubleLiteral;
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
import ast.statements.While;
import ast.types.ArrayType;
import ast.types.CharType;
import ast.types.DoubleType;
import ast.types.ErrorType;
import ast.types.FunctionType;
import ast.types.IntType;
import ast.types.StructType;
import ast.types.VoidType;

public interface Visitor {
	
	public Object visit(Program node,Object params);	
	
	public Object visit(FieldDefinition node,Object params);
	public Object visit(FuncDefinition node,Object params);
	public Object visit(VarDefinition node,Object params);
	
	public Object visit(Arithmetic node,Object params);
	public Object visit(ArrayAccess node,Object params);
	public Object visit(Cast node,Object params);
	public Object visit(CharLiteral node,Object params);
	public Object visit(Comparison node,Object params);
	public Object visit(DoubleLiteral node,Object params);
	public Object visit(FieldAccess node,Object params);
	public Object visit(FunctionCall node,Object params);
	public Object visit(IntLiteral node,Object params);
	public Object visit(Logic node,Object params);
	public Object visit(Not node,Object params);
	public Object visit(UnaryMinus node,Object params);
	public Object visit(Variable node,Object params);
	
	public Object visit(Assignation node,Object params);
	public Object visit(Conditional node,Object params);
	public Object visit(Input node,Object params);
	public Object visit(Print node,Object params);
	public Object visit(Return node,Object params);
	public Object visit(While node,Object params);
	
	public Object visit(ArrayType node,Object params);
	public Object visit(CharType node,Object params);
	public Object visit(DoubleType node,Object params);
	public Object visit(FunctionType node,Object params);
	public Object visit(IntType node,Object params);
	public Object visit(StructType node,Object params);
	public Object visit(VoidType node,Object params);
	public Object visit(ErrorType node,Object params);














}
