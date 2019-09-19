import parser.*;
import semanticVisitor.LValueVisitor;
import semanticVisitor.OffsetVisitor;
import semanticVisitor.TypeCheckingVisitor;
import semanticVisitor.identificationVisitor.IdentificationVisitor;

import org.antlr.v4.runtime.*;
import ast.Program;
import codeGenerator.CodeGenerator;
import codeGenerator.ExecuteCGVisitor;
import errors.ErrorHandler;
import introspector.model.IntrospectorModel;
import introspector.view.IntrospectorTree;

public class Main {
	
	public static void main(String... args) throws Exception {
		   if (args.length<2) {
		        System.err.println("Please, pass me the input and output files.");
		        return;
		    }
		   		 			
		 // create a lexer that feeds off of input CharStream
		CharStream input = CharStreams.fromFileName(args[0]);
		PmmLexer lexer = new PmmLexer(input);

		// create a parser that feeds off the tokens buffer
		CommonTokenStream tokens = new CommonTokenStream(lexer); 
		PmmParser parser = new PmmParser(tokens);	
		Program ast = parser.program().ast;
		
		//Visitor
		ast.accept(new IdentificationVisitor(), null);
		ast.accept(new LValueVisitor(), null);
		ast.accept(new TypeCheckingVisitor(), null);
		ast.accept(new OffsetVisitor(), null);
		ast.accept(new ExecuteCGVisitor(new CodeGenerator(args[1],args[0])), null);
		
		if(ErrorHandler.getInstance().anyError())
			ErrorHandler.getInstance().showErrors(System.err);
		else {
			// * The AST is shown
			IntrospectorModel model=new IntrospectorModel("Program", ast);
			new IntrospectorTree("Introspector", model);
		}
	}
}
