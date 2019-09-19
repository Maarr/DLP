package codeGenerator;

import ast.definitions.FieldDefinition;
import ast.expressions.ArrayAccess;
import ast.expressions.FieldAccess;
import ast.expressions.Variable;
import ast.types.IntType;

/**
 * Se accede a la direcci�n de los LValues (Variable, ArrayAccess y FieldAccess)
 */
public class AddressCGVisitor extends AbstractCGVisitor{
	
	private ValueCGVisitor valueVisitor;
	private CodeGenerator cg;
	
	public AddressCGVisitor(CodeGenerator cg, ValueCGVisitor valueVisitor) {
		this.cg=cg;
		this.valueVisitor=valueVisitor;
		valueVisitor.setAddressVisitor(this);
	}
	
	@Override
	public Object visit(Variable var, Object params) {
		//�Es global?
		if(var.getDefinition().getScope()==0) {
			cg.pusha(var.getDefinition().getOffSet());
		}else {
			cg.pushbp();
			cg.push(var.getDefinition().getOffSet());
			cg.add(IntType.getInstance(var.getLine(), var.getColumn()));
		}
		
		return null;
	}
	
	@Override
	public Object visit(ArrayAccess arrayAccess, Object params) {
		arrayAccess.getLeft().accept(this, params);
		arrayAccess.getRight().accept(valueVisitor, params); //Calculo el valor del �ndice
		cg.push(arrayAccess.getType().getSize()); //Tama�o del tipo del array
		cg.mul(IntType.getInstance(arrayAccess.getLine(), arrayAccess.getColumn()));
		cg.add(IntType.getInstance(arrayAccess.getLine(), arrayAccess.getColumn()));
		return null;
	}
	
	@Override
	public Object visit(FieldAccess fieldAccess, Object params) {
		fieldAccess.getExpression().accept(this, params);
		FieldDefinition field=fieldAccess.getExpression().getType().getFieldDefinition(fieldAccess.getName());
		cg.push(field.getOffset()); //Direcci�n del field
		cg.add(IntType.getInstance(fieldAccess.getLine(), fieldAccess.getColumn()));
		return null;
	}

}
