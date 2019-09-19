package codeGenerator;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import ast.definitions.VarDefinition;
import ast.types.CharType;
import ast.types.DoubleType;
import ast.types.IntType;
import ast.types.Type;

public class CodeGenerator {
	
	private PrintWriter out;
	private int labels;
	
	public CodeGenerator(String outputFilename,String sourceFilename) {
		try {
			this.out=new PrintWriter(new File(outputFilename));
			this.labels= 0;
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	//un metdo royo source y load pa cada instruccion
	//-------MANEJO PILA---------
	
	public void pushbp() {
		out.println( "\tPUSH BP");
		out.flush();
	}
	
	public void pusha(int dir) {
		out.println( "\tPUSHA "+dir);
		out.flush();
	}
	
	public void push(int valor) {
		out.println( "\tPUSH "+valor);
		out.flush();
	}
	
	public void push(double valor) {
		out.println( "\tPUSHF "+valor);
		out.flush();
	}
	
	public void push(char valor) {
		out.println( "\tPUSHB "+(int)valor);
		out.flush();
	}
	
	public void load(Type type) {
		out.println("\tLOAD"+type.suffix());
		out.flush();
	}
	
	public void store(Type type) {
		out.println("\tSTORE"+type.suffix());
		out.flush();
	}
	
	public void pop(Type type) {
		out.println("\tPOP"+type.suffix());
		out.flush();
	}
	
	/**
	 * Vuelve a meter en la pila el valor que está (lo duplica)
	 * @param type
	 */
	public void dup(Type type) {
		out.println("\tDUP"+type.suffix());
		out.flush();
	}
	
	//-----ARITMETICAS--------
	
	public void arithmetic(String operator, Type type) {
		if (operator.equals("+")) {
			add(type);
		}

		if (operator.equals("-")) {
			sub(type);
		}

		if (operator.equals("*")) {
			mul(type);
		}

		if (operator.equals("/")) {
			div(type);
		}

		if (operator.equals("%")) {
			mod();
		}
	}
	
	public void add(Type type) {
		out.println( "\tADD" + type.suffix() );
		out.flush();
	}

	public void sub( Type type ) {
		out.println( "\tSUB" + type.suffix() );
		out.flush();
	}

	public void mul( Type type ) {
		out.println( "\tMUL" + type.suffix() );
		out.flush();
	}

	public void div(Type type) {
		out.println("\tDIV" + type.suffix());
		out.flush();
	}
	
	public void mod() {
		out.println("\tMOD");
		out.flush();
	}
	
	//-----LOGICAS--------
	
	public void logic(String operator) {
		if (operator.equals("&&")) {
			and();
		}

		if (operator.equals("||")) {
			or();
		}
	}
	
	public void and() {
		out.println("\tAND");
		out.flush();
	}
	
	public void or() {
		out.println("\tOR");
		out.flush();
	}
	
	public void not() {
		out.println("\tNOT");
		out.flush();
	}
	
	//-----COMPARACION--------
	
	public void comparison(String operator, Type type) {
		String instr = "";
		if (operator.equals(">")) {
			instr = "\tGT";
		}

		if (operator.equals("<")) {
			instr = "\tLT";
		}

		if (operator.equals(">=")) {
			instr = "\tGE";
		}

		if (operator.equals("<=")) {
			instr = "\tLE";
		}

		if (operator.equals("==")) {
			instr = "\tEQ";
		}
		
		if (operator.equals("!=")) {
			instr = "\tNE";
		}
		
		out.println(instr+""+type.suffix());
		out.flush();
	}
	
	//------SALTO------------
	
	public void jmp(int label) {
		out.println("\tJMP label"+label);
		out.flush();
	}
	
	public void jz(int label) {
		out.println("\tJZ label"+label);
		out.flush();
	}
	
	public void jnz(int label) {
		out.println("\tJNZ label"+label);
		out.flush();
	}
	
	//------I/O--------------
	public void out(Type type) {
		out.println("\tOUT"+type.suffix());
		out.flush();
	}
	
	public void in(Type type) {
		out.println("\tIN"+type.suffix());
		out.flush();
	}
	
	//-----CONVERSIONES-------
	
	public void convertTo(Type originalType, Type finalType) {
		if(originalType.equals(finalType))
			return;		
		
		if(originalType.equals(IntType.getInstance(originalType.getLine(), originalType.getColumn()))) {
			if(finalType.equals(DoubleType.getInstance(finalType.getLine(), finalType.getColumn())))
				i2f();
			if(finalType.equals(CharType.getInstance(finalType.getLine(), finalType.getColumn())))
				i2b();
		}
		
		if(originalType.equals(DoubleType.getInstance(originalType.getLine(), originalType.getColumn()))) {
			if(finalType.equals(IntType.getInstance(finalType.getLine(), finalType.getColumn())))
				f2i();
			if(finalType.equals(CharType.getInstance(finalType.getLine(), finalType.getColumn()))) {
				f2i();
				i2b();
			}
		}
		
		if(originalType.equals(CharType.getInstance(originalType.getLine(), originalType.getColumn()))) {
			if(finalType.equals(IntType.getInstance(finalType.getLine(), finalType.getColumn())))
				b2i();
			if(finalType.equals(DoubleType.getInstance(finalType.getLine(), finalType.getColumn()))) {
				b2i();
				i2f();
			}
		}
	}
	
	public void b2i() {
		out.println("\tB2I");
		out.flush();
	}

	public void i2f() {
		out.println("\tI2F");
		out.flush();
	}

	public void f2i() {
		out.println("\tF2I");
		out.flush();
	}

	public void i2b() {
		out.println("\tI2B");
		out.flush();
	}
	
	//-----FUNCIONES----------
	
	public void call(String function) {
		out.println("\tCALL "+function);
		out.flush();
	}
	
	public void ret(int retBytes, int localsBytes, int paramsBytes) {
		out.println("\tret " + retBytes + "," + localsBytes + "," + paramsBytes);
		out.flush();
	}
	
	public void enter( int locals ) {
		out.println("\tenter " + locals);
		out.flush();
	}
	
	public void halt() {
		out.println("\tHALT");
		out.flush();
	}
	
	public void label(String name) {
		out.println(" "+name+":");
		out.flush();
	}
	
	public void callMain() {
		comment("Invocation to the main function");
		call("main");
		halt();
	}
	
	//-----ETIQUETAS----------
	
	public void label(int label) {
		out.println("\tlabel"+label+" :");
		out.flush();
	}
	
	/**
	 * Devuelve las que hay y reserva n etiquetas
	 * @param n etiquetas a reservar
	 * @return
	 */
	public int getLabels(int n) {
		int old=labels;
		labels=labels+n;
		return old;
	}
	
	//-----COMENTARIOS--------
	public void comment(String text) {
		out.println( "\t' * "+text);
		out.flush();
	}
	
	public void varComment(VarDefinition varDef) {
		out.println( "\t' * " + varDef.toString());
		out.flush();
	}
	
	public void println() {
		out.println();
	}

}
