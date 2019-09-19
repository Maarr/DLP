grammar Pmm;	

@header{
	import ast.*;
	import ast.expressions.*;
	import ast.statements.*;
	import ast.types.*;
	import ast.definitions.*;
	import errors.*;
}

program returns [Program ast]:  
		{List<Definition> defs=new ArrayList<Definition>();} definitions {defs.addAll($definitions.ast);} (main_def {defs.add($main_def.ast);})
		{$ast=new Program($definitions.start.getLine(),$definitions.start.getCharPositionInLine()+1,defs);} 
       ;

definitions returns [List<Definition> ast=new ArrayList<Definition>()]: 
	(var_def ';' {$ast.addAll($var_def.ast);} | func_def {$ast.add($func_def.ast);})*
	;
       
/***Expressions***/
expression returns [Expression ast]:
			'(' e1=expression ')' {$ast = $e1.ast;}
			| e1=expression '[' e2=expression ']' {$ast=new ArrayAccess($e1.start.getLine(),$e1.start.getCharPositionInLine()+1,$e1.ast, $e2.ast);}
			| e1=expression'.'ID {$ast=new FieldAccess($e1.start.getLine(),$e1.start.getCharPositionInLine()+1,$ID.text,$e1.ast);}
			| '(' t=type ')' e1=expression {$ast=new Cast($type.start.getLine(),$type.start.getCharPositionInLine()+1,$t.ast,$e1.ast);}
			| '-' e1=expression {$ast=new UnaryMinus($e1.start.getLine(),$e1.start.getCharPositionInLine()+1,$e1.ast);}
			| '!' e1=expression {$ast=new Not($e1.start.getLine(),$e1.start.getCharPositionInLine()+1,$e1.ast);}
			| e1=expression op=('/'|'*'|'%') e2=expression	{$ast=new Arithmetic($e1.start.getLine(),$e1.start.getCharPositionInLine()+1,$e1.ast, $op.text, $e2.ast);}
			| e1=expression op=('+'|'-') e2=expression {$ast=new Arithmetic($e1.start.getLine(),$e1.start.getCharPositionInLine()+1,$e1.ast, $op.text, $e2.ast);}
			| e1=expression op=('>'|'>='|'<'|'<='|'!='|'==') e2=expression {$ast=new Comparison($e1.start.getLine(),$e1.start.getCharPositionInLine()+1,$e1.ast, $e2.ast, $op.text);}
			| e1=expression op=('&&'|'||') e2=expression {$ast=new Logic($e1.start.getLine(),$e1.start.getCharPositionInLine()+1,$e1.ast, $e2.ast, $op.text);}
			| f=function_call_exp {$ast=$f.ast;}
			| ID { $ast= new Variable($ID.getLine(), $ID.getCharPositionInLine()+1,$ID.text);}
			| INT_CONSTANT	{ $ast= new IntLiteral($INT_CONSTANT.getLine(), $INT_CONSTANT.getCharPositionInLine()+1,LexerHelper.lexemeToInt($INT_CONSTANT.text));}
			| REAL_CONSTANT { $ast= new DoubleLiteral($REAL_CONSTANT.getLine(), $REAL_CONSTANT.getCharPositionInLine()+1,LexerHelper.lexemeToReal($REAL_CONSTANT.text));}
			| CHAR_CONSTANT { $ast= new CharLiteral($CHAR_CONSTANT.getLine(), $CHAR_CONSTANT.getCharPositionInLine()+1,LexerHelper.lexemeToChar($CHAR_CONSTANT.text));}
			;
			
function_call_exp returns [Expression ast]:
	 ID a=arguments {$ast=new FunctionCall($ID.getLine(),$ID.getCharPositionInLine()+1,new Variable($ID.getLine(), $ID.getCharPositionInLine()+1,$ID.text),$a.ast);}
	;
		
		
expressions returns [List<Expression> ast= new ArrayList<Expression>()]: e1=expression {$ast.add($e1.ast);} (',' e2=expression {$ast.add($e2.ast);})* 
		;

/***Statements***/

statement returns [Statement ast]: 
		f=function_call_sta ';' {$ast=$f.ast;}
		| ifs=if_sta {$ast=$ifs.ast;}
		| rtn=return_sta {$ast=$rtn.ast;}
		| in=input {$ast=$in.ast;}
		| p=print {$ast=$p.ast;}
		| w=while_sta {$ast=$w.ast;}
		| a=assignation {$ast=$a.ast;}
		;

function_call_sta returns [Statement ast]:
	 ID a=arguments {$ast=new FunctionCall($ID.getLine(),$ID.getCharPositionInLine()+1,new Variable($ID.getLine(), $ID.getCharPositionInLine()+1,$ID.text),$a.ast);}
	;
	
arguments returns [List<Expression> ast=new ArrayList<Expression>()]: '('')'
		| '(' es=expressions ')' {$ast=$es.ast;}
		;
			
if_sta returns [Statement ast]: 
	'if' e1=expression ':' body=conditional_body {Conditional cond=new Conditional($e1.start.getLine(),$e1.start.getCharPositionInLine()+1,$e1.ast,$body.ast,new ArrayList<Statement>());} (es=else_sta {cond.setElseBody($es.ast);})? {$ast=cond;}

	;
	
else_sta returns [List<Statement> ast]: 'else' body=conditional_body {$ast=$body.ast;}
	;

conditional_body returns [List<Statement> ast=new ArrayList<Statement>()]:
	 sta=statement {$ast.add($sta.ast);}
	| '{' (sta=statement {$ast.add($sta.ast);})+ '}'
	;

return_sta returns [Statement ast]: 'return' e1=expression ';' {$ast=new Return($e1.start.getLine(),$e1.start.getCharPositionInLine()+1,$e1.ast);}
	;
		
input returns [Statement ast]: 'input' es=expressions ';' {$ast=new Input($es.start.getLine(),$es.start.getCharPositionInLine()+1,$es.ast);}
	;
		
print returns [Statement ast]:
	 'print' es=expressions ';' {$ast=new Print($es.start.getLine(),$es.start.getCharPositionInLine()+1,$es.ast);}
	;

while_sta returns [Statement ast]:
	 'while' e1=expression ':' body=conditional_body
	 {$ast=new While($e1.start.getLine(),$e1.start.getCharPositionInLine()+1,$e1.ast,$body.ast);}
	;

assignation returns [Statement ast]: 
	e1=expression '=' e2=expression ';' {$ast=new Assignation($e1.start.getLine(),$e1.start.getCharPositionInLine()+1,$e1.ast,$e2.ast);}
	;
			
/***Types***/	
type returns [Type ast]: 
	t='char' {$ast = CharType.getInstance($t.getLine(),$t.getCharPositionInLine()+1);}
	| t='int' {$ast = IntType.getInstance($t.getLine(),$t.getCharPositionInLine()+1);}
	| t='double' {$ast = DoubleType.getInstance($t.getLine(),$t.getCharPositionInLine()+1);}
	| t='struct' '{' f=fields '}' {$ast=new StructType($t.getLine(),$t.getCharPositionInLine()+1,$f.ast);}
	| '[' INT_CONSTANT ']' type {$ast = new ArrayType($INT_CONSTANT.getLine(),$INT_CONSTANT.getCharPositionInLine()+1,$type.ast, LexerHelper.lexemeToInt($INT_CONSTANT.text) );}
	; 

fields returns [List<FieldDefinition> ast = new ArrayList<FieldDefinition>()]:
	 (id1=ID {if($ast.contains(new FieldDefinition($id1.text,null))){new ErrorType($id1.getLine(), $id1.getCharPositionInLine()+1, "Duplicate field error: " + $id1.text);}else {$ast.add(new FieldDefinition($id1.text,null));}}
	 (','id2=ID {if($ast.contains(new FieldDefinition($id2.text,null))){new ErrorType($id2.getLine(), $id2.getCharPositionInLine()+1, "Duplicate field error: " + $id2.text);}else {$ast.add(new FieldDefinition($id2.text,null));}})* ':' type ';' {for(FieldDefinition d: $ast){if(d.getType()==null)d.setType($type.ast);}})*
	;
	
/***Definitions***/

var_def returns [List<Definition> ast = new ArrayList<Definition>()]: 
	simple_var_def {$ast.add($simple_var_def.ast);}
	|  multi_var_def {$ast.addAll($multi_var_def.ast);}
	;
	
simple_var_def returns [Definition ast]: ID ':' type {$ast=new VarDefinition($ID.getLine(), $ID.getCharPositionInLine()+1, $ID.text, $type.ast);}
	;

multi_var_def returns [List<Definition> ast = new ArrayList<Definition>()]: 
	 id1=ID {$ast.add(new VarDefinition($id1.getLine(), $id1.getCharPositionInLine()+1, $id1.text, null));} 
	 (','id2=ID {if($ast.contains(new VarDefinition($id2.getLine(), $id2.getCharPositionInLine()+1, $id2.text, null))){new ErrorType($id2.getLine(), $id2.getCharPositionInLine()+1, "Duplicate variable definition error: " + $id2.text);}else{$ast.add(new VarDefinition($id2.getLine(), $id2.getCharPositionInLine()+1, $id2.text, null));}})+ ':' type {for(Definition d: $ast){d.setType($type.ast);}}
	;

func_def returns [Definition ast]: 'def' ID parameters ':' {Type returnType=VoidType.getInstance($ID.getLine(),$ID.getCharPositionInLine()+1);} (type {returnType=$type.ast;})? '{' {List<Definition> defs=new ArrayList<Definition>();} (var_def {defs.addAll($var_def.ast);} ';')* {List<Statement> sts=new ArrayList<Statement>();}(statement {sts.add($statement.ast);})* '}' 
				{$ast=new FuncDefinition($ID.getLine(),$ID.getCharPositionInLine()+1,$ID.text,new FunctionType($ID.getLine(),$ID.getCharPositionInLine()+1,returnType,$parameters.ast),defs,sts);}
		;
		
main_def returns [Definition ast]:
	 d='def' 'main' '(' ')' ':' '{' {List<Definition> defs=new ArrayList<Definition>();} (var_def {defs.addAll($var_def.ast);} ';')* {List<Statement> sts=new ArrayList<Statement>();}(statement {sts.add($statement.ast);})* '}' EOF 
	 { $ast = new FuncDefinition($start.getLine(), $start.getCharPositionInLine()+1, "main",new FunctionType($d.getLine(),$d.getCharPositionInLine()+1,VoidType.getInstance($d.getLine(),$d.getCharPositionInLine()+1),new ArrayList<Definition>()),defs,sts); }
		;
		
parameters returns [List<Definition> ast = new ArrayList<Definition>()]:
		 '('')'
		| '(' v1=simple_var_def {$ast.add($v1.ast);} (',' v2=simple_var_def {$ast.add($v2.ast);})* ')'
		;



       
/******************LEXER************************/
  		 
INT_CONSTANT: '0'
			| [1-9][0-9]* 
            ;
            
REAL_CONSTANT: INT_CONSTANT?'.'INT_CONSTANT
			|  INT_CONSTANT'.'
			|  INT_CONSTANT ('.' INT_CONSTANT)?[Ee][+-]?INT_CONSTANT
			;
	
CHAR_CONSTANT:['].[']
			| [']'\\'INT_CONSTANT[']
			| [']'\\n'[']
			| [']'\\t'[']
			;

ID: [a-zA-Z_][a-zA-Z0-9_]*
			;

COMMENT1: '#'~[\r\n]*[\r\nEOF]->skip
		;
		
COMMENT2: '"""'.*?'"""'->skip
		;
		
ESPACIO:[ \n\t\r]->skip
		;