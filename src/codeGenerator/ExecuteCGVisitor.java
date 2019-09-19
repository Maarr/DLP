package codeGenerator;

import ast.Program;
import ast.definitions.Definition;
import ast.definitions.FuncDefinition;
import ast.definitions.VarDefinition;
import ast.expressions.Expression;
import ast.expressions.FunctionCall;
import ast.statements.*;
import ast.types.FunctionType;
import ast.types.Type;
import ast.types.VoidType;

/**
 * Se evaluan los Statements
 * Y alguna cosilla más como los comentarios
 */
public class ExecuteCGVisitor extends AbstractCGVisitor{
	
	private ValueCGVisitor valueVisitor;
	private AddressCGVisitor addressVisitor;
	
	private CodeGenerator cg;
	
	public ExecuteCGVisitor(CodeGenerator cg) {
		this.cg=cg;
		this.valueVisitor=new ValueCGVisitor(cg);
		this.addressVisitor=new AddressCGVisitor(cg,valueVisitor);
	}
	
	@Override
	public Object visit(Program program,Object params) {
		//Comentarios de las definiciones de variables globales
		cg.comment("#Global vars:");
		for(Definition def:program.getDefinitions()) {
			if(def instanceof VarDefinition)
				def.accept(this, params);
		}
		cg.println();
		
		cg.callMain();//CALL main y HALT
	
		cg.println();
		//Genero código de las funciones
		for(Definition def:program.getDefinitions()) {
			if(def instanceof FuncDefinition)
				def.accept(this, params); //EXECUTE[[FuncDef]]
		}
		return null;	
	}
	
	//------------------DEFINITIONS
	
	@Override
	public Object visit(FuncDefinition node, Object params) {
		cg.comment("Function "+node.getName());
		cg.label(node.getName());
		
		//----COMENTARIOS
		FunctionType functionType = (FunctionType)node.getType();
		cg.comment("#Params:");
		for(Definition def: functionType.getParameters()) {
			def.accept(this, params);
		}
		cg.println();
		
		cg.comment("#Local vars:");
		for(Definition def: node.getVarDefinitions()) {
			def.accept(this, params);
		}
		cg.println();
		//-------------
		
		cg.enter(node.getBytesLocals());
		for(Statement stmnt:node.getStatements()) {
			stmnt.accept(this, node); //EXECUTE[[stmnt]] //Le paso la definicion de funcion para la plantilla del return
		}
		//Si el tipo de retorno es void hago ya el ret
		Type returnType = functionType.getReturnType();
		if(returnType.equals(VoidType.getInstance(returnType.getLine(), returnType.getColumn())))
			cg.ret(0, node.getBytesLocals(), node.getBytesParams());
		cg.println();
		return null;
	}
	
	//------------------STATEMENTS
	
	@Override
	public Object visit(Assignation assig, Object params) {
		cg.comment("Assignation --> line:"+assig.getLine());
		assig.getLeft().accept(addressVisitor, params);//ADDRESS[[left]]
		assig.getRight().accept(valueVisitor, params);//VALUE[[right]]
		cg.convertTo(assig.getRight().getType(), assig.getLeft().getType());
		cg.store(assig.getLeft().getType());
		return null;
	}

	/**
	 * EXECUTE[[if:sta->expr sta1* sta2*]]()=
	 * int label=cg.getlabels(2);
	 * VALUE[[expr]]
	 * JZ label
	 * fot(sta s:sta1*)
	 * 	EXECUTE[[s]]
	 * JMP label+1
	 * label:
	 * fot(sta s:sta2*)
	 * 	EXECUTE[[s]]
	 * label+1:
	 */
	@Override
	public Object visit(Conditional node, Object params) {
		cg.comment("If-Else --> line:"+node.getLine());
		//label es el else y label+1 el final
		int label=cg.getLabels(2);
		node.getCondition().accept(valueVisitor, params);
		cg.jz(label);
		for(Statement sta:node.getIfBody())
			sta.accept(this, params);
		cg.jmp(label+1);
		cg.label(label);
		for(Statement sta:node.getElseBody())
			sta.accept(this, params);
		cg.label(label+1);
		return null;
	}
	
	@Override
	public Object visit(FunctionCall functionCall, Object params) {
		functionCall.accept(valueVisitor, params); //VALUE[[(Expression)Stm]]
		if(!functionCall.getType().equals(VoidType.getInstance(functionCall.getLine(), functionCall.getColumn())))
			cg.pop(functionCall.getType()); //Es el returnType del tipo función, pero como ya está inferido lo pillo así
		
		return null;
	}
	
	@Override
	public Object visit(Input input,Object params) {
		for(Expression expr: input.getExpressions()) {
			cg.comment("Input --> line:"+input.getLine());
			expr.accept(addressVisitor, params);//ADDRESS[[expr]]
			cg.in(expr.getType());
			cg.store(expr.getType());
		}
		return null;
	}
	
	@Override
	public Object visit(Print print,Object params) {
		for(Expression expr: print.getExpressions()) {
			cg.comment("Print --> line:"+print.getLine());
			expr.accept(valueVisitor, params);//VALUE[[expr]]
			cg.out(expr.getType());
		}
		return null;
	}
	
	@Override
	public Object visit(Return retrn, Object params) {
		cg.comment("Return --> line:"+retrn.getLine());
		retrn.getExpression().accept(valueVisitor, params); //VALUE[[expr]]
		int bytesRetorno=retrn.getExpression().getType().getSize();
		int bytesLocales=((FuncDefinition)params).getBytesLocals();
		int bytesParams=((FuncDefinition)params).getBytesParams();
		cg.ret(bytesRetorno, bytesLocales, bytesParams);
		return null;
	}

	/**
	 * EXECUTE[[while:Sta->expr sta*]]()=
	 * int label=cg.getLabels(2);
	 * label:
	 * VALUE[[expr]]
	 * JZ label+1
	 * for(Sta s:stat*)
	 * 	EXECUTE[[s]]
	 * JPM label
	 * label+1:
	 */
	@Override
	public Object visit(While whl, Object params) {
		cg.comment("While --> line:"+whl.getLine());
		//label es la etiqueta condicion y label+1 la etiqueta fin
		int label=cg.getLabels(2);
		cg.label(label);
		whl.getCondition().accept(valueVisitor, params);//VALUE[[expr]]
		cg.jz(label+1);
		cg.comment("While body");
		for(Statement sta:whl.getBody())
			sta.accept(this, params);//EXECUTE[[sta]]
		cg.jmp(label);
		cg.label(label+1);
		return null;
	}

	@Override
	public Object visit(VarDefinition var,Object params) {
		cg.varComment(var);
		return null;	
	}
	
}
