package semanticVisitor;

import ast.definitions.Definition;
import ast.definitions.FieldDefinition;
import ast.definitions.FuncDefinition;
import ast.definitions.VarDefinition;
import ast.statements.Statement;
import ast.types.FunctionType;
import ast.types.StructType;

public class OffsetVisitor extends AbstractVisitor{
	
	private int globalOffset=0;
	private int localOffset=0;
	

	@Override
	public Object visit(VarDefinition node, Object params) {
		node.getType().accept(this, params);
		if(node.getScope()==0) {
			node.setOffSet(globalOffset);
			globalOffset+=node.getType().getSize();
		}else if(node.getScope()==1) {
			localOffset -= node.getType().getSize(); //Ojo que es en negativo
			node.setOffSet(localOffset);
		}
		return null;
	}
	
	@Override
	public Object visit(FuncDefinition node, Object params) {
		localOffset=0;
		node.getType().accept(this, params);
		for(Definition d: node.getVarDefinitions())
			d.accept(this, params);
		for(Statement s: node.getStatements())
			s.accept(this, params);
		node.setBytesLocals(localOffset*-1);
		return null;
	}
	
	@Override
	public Object visit(FunctionType node, Object params) {
		node.getReturnType().accept(this, params);
		int paramOffset=4;
		int bytesParams=0;
		for (int i = node.getParameters().size() - 1; i >= 0; i--) {
			node.getParameters().get(i).setOffSet(paramOffset);
			paramOffset+=node.getParameters().get(i).getType().getSize();
			bytesParams+=node.getParameters().get(i).getType().getSize();
		}
		node.setBytesParams(bytesParams);
		return null;
	}
	
	@Override
	public Object visit(StructType node, Object params) {
		int fieldOffset = 0;
		for(FieldDefinition f:node.getFields()) {
			f.accept(this,params);
			f.setOffSet(fieldOffset);
			fieldOffset+=f.getType().getSize();
		}
		return null;
	}

	
}
