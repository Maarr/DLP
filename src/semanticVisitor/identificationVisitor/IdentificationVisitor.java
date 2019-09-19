package semanticVisitor.identificationVisitor;

import ast.definitions.Definition;
import ast.definitions.FuncDefinition;
import ast.definitions.VarDefinition;
import ast.expressions.Variable;
import ast.statements.Statement;
import ast.types.ErrorType;
import semanticVisitor.AbstractVisitor;

public class IdentificationVisitor extends AbstractVisitor{
	
	private SymbolTable table;
	
	public IdentificationVisitor() {
		this.table=new SymbolTable();
	}
	
	@Override
	public Object visit(VarDefinition node, Object params) {
		if(!table.insert(node))
			new ErrorType(node.getLine(),node.getColumn(),"Error IdentificationVisitor: variable "+node.getName()+" ya definida");
		
		node.getType().accept(this, params);
		return null;
	}
	
	@Override
	public Object visit(FuncDefinition node, Object params) {
		if(!table.insert(node))
			new ErrorType(node.getLine(),node.getColumn(),"Error IdentificationVisitor: variable "+node.getName()+" ya definida");
		table.set();
		node.getType().accept(this, params);
		for(Definition d: node.getVarDefinitions())
			d.accept(this, params);
		for(Statement s: node.getStatements())
			s.accept(this, params);
		table.reset();
		return null;
	}
	
	@Override
	public Object visit(Variable node, Object params) {
		Definition def=table.find(node.getName());
		if(def==null) {
			node.setDefinition(new VarDefinition(node.getLine(),node.getColumn(),node.getName(),new ErrorType(node.getLine(),node.getColumn(),"Error IdentificationVisitor: variable "+node.getName()+" no definida")));	
		}else
			node.setDefinition(def);
		return null;
	}
	
	

}
