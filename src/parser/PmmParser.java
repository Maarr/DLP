// Generated from src/parser/Pmm.g4 by ANTLR 4.7
package parser;

	import ast.*;
	import ast.expressions.*;
	import ast.statements.*;
	import ast.types.*;
	import ast.definitions.*;
	import errors.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PmmParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, INT_CONSTANT=38, 
		REAL_CONSTANT=39, CHAR_CONSTANT=40, ID=41, COMMENT1=42, COMMENT2=43, ESPACIO=44;
	public static final int
		RULE_program = 0, RULE_definitions = 1, RULE_expression = 2, RULE_function_call_exp = 3, 
		RULE_expressions = 4, RULE_statement = 5, RULE_function_call_sta = 6, 
		RULE_arguments = 7, RULE_if_sta = 8, RULE_else_sta = 9, RULE_conditional_body = 10, 
		RULE_return_sta = 11, RULE_input = 12, RULE_print = 13, RULE_while_sta = 14, 
		RULE_assignation = 15, RULE_type = 16, RULE_fields = 17, RULE_var_def = 18, 
		RULE_simple_var_def = 19, RULE_multi_var_def = 20, RULE_func_def = 21, 
		RULE_main_def = 22, RULE_parameters = 23;
	public static final String[] ruleNames = {
		"program", "definitions", "expression", "function_call_exp", "expressions", 
		"statement", "function_call_sta", "arguments", "if_sta", "else_sta", "conditional_body", 
		"return_sta", "input", "print", "while_sta", "assignation", "type", "fields", 
		"var_def", "simple_var_def", "multi_var_def", "func_def", "main_def", 
		"parameters"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "'('", "')'", "'['", "']'", "'.'", "'-'", "'!'", "'/'", "'*'", 
		"'%'", "'+'", "'>'", "'>='", "'<'", "'<='", "'!='", "'=='", "'&&'", "'||'", 
		"','", "'if'", "':'", "'else'", "'{'", "'}'", "'return'", "'input'", "'print'", 
		"'while'", "'='", "'char'", "'int'", "'double'", "'struct'", "'def'", 
		"'main'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, "INT_CONSTANT", "REAL_CONSTANT", "CHAR_CONSTANT", "ID", "COMMENT1", 
		"COMMENT2", "ESPACIO"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Pmm.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PmmParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public Program ast;
		public DefinitionsContext definitions;
		public Main_defContext main_def;
		public DefinitionsContext definitions() {
			return getRuleContext(DefinitionsContext.class,0);
		}
		public Main_defContext main_def() {
			return getRuleContext(Main_defContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			List<Definition> defs=new ArrayList<Definition>();
			setState(49);
			((ProgramContext)_localctx).definitions = definitions();
			defs.addAll(((ProgramContext)_localctx).definitions.ast);
			{
			setState(51);
			((ProgramContext)_localctx).main_def = main_def();
			defs.add(((ProgramContext)_localctx).main_def.ast);
			}
			((ProgramContext)_localctx).ast = new Program((((ProgramContext)_localctx).definitions!=null?(((ProgramContext)_localctx).definitions.start):null).getLine(),(((ProgramContext)_localctx).definitions!=null?(((ProgramContext)_localctx).definitions.start):null).getCharPositionInLine()+1,defs);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefinitionsContext extends ParserRuleContext {
		public List<Definition> ast = new ArrayList<Definition>();
		public Var_defContext var_def;
		public Func_defContext func_def;
		public List<Var_defContext> var_def() {
			return getRuleContexts(Var_defContext.class);
		}
		public Var_defContext var_def(int i) {
			return getRuleContext(Var_defContext.class,i);
		}
		public List<Func_defContext> func_def() {
			return getRuleContexts(Func_defContext.class);
		}
		public Func_defContext func_def(int i) {
			return getRuleContext(Func_defContext.class,i);
		}
		public DefinitionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definitions; }
	}

	public final DefinitionsContext definitions() throws RecognitionException {
		DefinitionsContext _localctx = new DefinitionsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_definitions);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(63);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case ID:
						{
						setState(56);
						((DefinitionsContext)_localctx).var_def = var_def();
						setState(57);
						match(T__0);
						_localctx.ast.addAll(((DefinitionsContext)_localctx).var_def.ast);
						}
						break;
					case T__35:
						{
						setState(60);
						((DefinitionsContext)_localctx).func_def = func_def();
						_localctx.ast.add(((DefinitionsContext)_localctx).func_def.ast);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(67);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public Expression ast;
		public ExpressionContext e1;
		public TypeContext t;
		public TypeContext type;
		public Function_call_expContext f;
		public Token ID;
		public Token INT_CONSTANT;
		public Token REAL_CONSTANT;
		public Token CHAR_CONSTANT;
		public Token op;
		public ExpressionContext e2;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public Function_call_expContext function_call_exp() {
			return getRuleContext(Function_call_expContext.class,0);
		}
		public TerminalNode ID() { return getToken(PmmParser.ID, 0); }
		public TerminalNode INT_CONSTANT() { return getToken(PmmParser.INT_CONSTANT, 0); }
		public TerminalNode REAL_CONSTANT() { return getToken(PmmParser.REAL_CONSTANT, 0); }
		public TerminalNode CHAR_CONSTANT() { return getToken(PmmParser.CHAR_CONSTANT, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(69);
				match(T__1);
				setState(70);
				((ExpressionContext)_localctx).e1 = expression(0);
				setState(71);
				match(T__2);
				((ExpressionContext)_localctx).ast =  ((ExpressionContext)_localctx).e1.ast;
				}
				break;
			case 2:
				{
				setState(74);
				match(T__1);
				setState(75);
				((ExpressionContext)_localctx).t = ((ExpressionContext)_localctx).type = type();
				setState(76);
				match(T__2);
				setState(77);
				((ExpressionContext)_localctx).e1 = expression(12);
				((ExpressionContext)_localctx).ast = new Cast((((ExpressionContext)_localctx).type!=null?(((ExpressionContext)_localctx).type.start):null).getLine(),(((ExpressionContext)_localctx).type!=null?(((ExpressionContext)_localctx).type.start):null).getCharPositionInLine()+1,((ExpressionContext)_localctx).t.ast,((ExpressionContext)_localctx).e1.ast);
				}
				break;
			case 3:
				{
				setState(80);
				match(T__6);
				setState(81);
				((ExpressionContext)_localctx).e1 = expression(11);
				((ExpressionContext)_localctx).ast = new UnaryMinus((((ExpressionContext)_localctx).e1!=null?(((ExpressionContext)_localctx).e1.start):null).getLine(),(((ExpressionContext)_localctx).e1!=null?(((ExpressionContext)_localctx).e1.start):null).getCharPositionInLine()+1,((ExpressionContext)_localctx).e1.ast);
				}
				break;
			case 4:
				{
				setState(84);
				match(T__7);
				setState(85);
				((ExpressionContext)_localctx).e1 = expression(10);
				((ExpressionContext)_localctx).ast = new Not((((ExpressionContext)_localctx).e1!=null?(((ExpressionContext)_localctx).e1.start):null).getLine(),(((ExpressionContext)_localctx).e1!=null?(((ExpressionContext)_localctx).e1.start):null).getCharPositionInLine()+1,((ExpressionContext)_localctx).e1.ast);
				}
				break;
			case 5:
				{
				setState(88);
				((ExpressionContext)_localctx).f = function_call_exp();
				((ExpressionContext)_localctx).ast = ((ExpressionContext)_localctx).f.ast;
				}
				break;
			case 6:
				{
				setState(91);
				((ExpressionContext)_localctx).ID = match(ID);
				 ((ExpressionContext)_localctx).ast =  new Variable(((ExpressionContext)_localctx).ID.getLine(), ((ExpressionContext)_localctx).ID.getCharPositionInLine()+1,(((ExpressionContext)_localctx).ID!=null?((ExpressionContext)_localctx).ID.getText():null));
				}
				break;
			case 7:
				{
				setState(93);
				((ExpressionContext)_localctx).INT_CONSTANT = match(INT_CONSTANT);
				 ((ExpressionContext)_localctx).ast =  new IntLiteral(((ExpressionContext)_localctx).INT_CONSTANT.getLine(), ((ExpressionContext)_localctx).INT_CONSTANT.getCharPositionInLine()+1,LexerHelper.lexemeToInt((((ExpressionContext)_localctx).INT_CONSTANT!=null?((ExpressionContext)_localctx).INT_CONSTANT.getText():null)));
				}
				break;
			case 8:
				{
				setState(95);
				((ExpressionContext)_localctx).REAL_CONSTANT = match(REAL_CONSTANT);
				 ((ExpressionContext)_localctx).ast =  new DoubleLiteral(((ExpressionContext)_localctx).REAL_CONSTANT.getLine(), ((ExpressionContext)_localctx).REAL_CONSTANT.getCharPositionInLine()+1,LexerHelper.lexemeToReal((((ExpressionContext)_localctx).REAL_CONSTANT!=null?((ExpressionContext)_localctx).REAL_CONSTANT.getText():null)));
				}
				break;
			case 9:
				{
				setState(97);
				((ExpressionContext)_localctx).CHAR_CONSTANT = match(CHAR_CONSTANT);
				 ((ExpressionContext)_localctx).ast =  new CharLiteral(((ExpressionContext)_localctx).CHAR_CONSTANT.getLine(), ((ExpressionContext)_localctx).CHAR_CONSTANT.getCharPositionInLine()+1,LexerHelper.lexemeToChar((((ExpressionContext)_localctx).CHAR_CONSTANT!=null?((ExpressionContext)_localctx).CHAR_CONSTANT.getText():null)));
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(133);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(131);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(101);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(102);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10))) != 0)) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(103);
						((ExpressionContext)_localctx).e2 = expression(10);
						((ExpressionContext)_localctx).ast = new Arithmetic((((ExpressionContext)_localctx).e1!=null?(((ExpressionContext)_localctx).e1.start):null).getLine(),(((ExpressionContext)_localctx).e1!=null?(((ExpressionContext)_localctx).e1.start):null).getCharPositionInLine()+1,((ExpressionContext)_localctx).e1.ast, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null), ((ExpressionContext)_localctx).e2.ast);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(106);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(107);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__6 || _la==T__11) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(108);
						((ExpressionContext)_localctx).e2 = expression(9);
						((ExpressionContext)_localctx).ast = new Arithmetic((((ExpressionContext)_localctx).e1!=null?(((ExpressionContext)_localctx).e1.start):null).getLine(),(((ExpressionContext)_localctx).e1!=null?(((ExpressionContext)_localctx).e1.start):null).getCharPositionInLine()+1,((ExpressionContext)_localctx).e1.ast, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null), ((ExpressionContext)_localctx).e2.ast);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(111);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(112);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17))) != 0)) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(113);
						((ExpressionContext)_localctx).e2 = expression(8);
						((ExpressionContext)_localctx).ast = new Comparison((((ExpressionContext)_localctx).e1!=null?(((ExpressionContext)_localctx).e1.start):null).getLine(),(((ExpressionContext)_localctx).e1!=null?(((ExpressionContext)_localctx).e1.start):null).getCharPositionInLine()+1,((ExpressionContext)_localctx).e1.ast, ((ExpressionContext)_localctx).e2.ast, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null));
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(116);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(117);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__18 || _la==T__19) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(118);
						((ExpressionContext)_localctx).e2 = expression(7);
						((ExpressionContext)_localctx).ast = new Logic((((ExpressionContext)_localctx).e1!=null?(((ExpressionContext)_localctx).e1.start):null).getLine(),(((ExpressionContext)_localctx).e1!=null?(((ExpressionContext)_localctx).e1.start):null).getCharPositionInLine()+1,((ExpressionContext)_localctx).e1.ast, ((ExpressionContext)_localctx).e2.ast, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null));
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(121);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(122);
						match(T__3);
						setState(123);
						((ExpressionContext)_localctx).e2 = expression(0);
						setState(124);
						match(T__4);
						((ExpressionContext)_localctx).ast = new ArrayAccess((((ExpressionContext)_localctx).e1!=null?(((ExpressionContext)_localctx).e1.start):null).getLine(),(((ExpressionContext)_localctx).e1!=null?(((ExpressionContext)_localctx).e1.start):null).getCharPositionInLine()+1,((ExpressionContext)_localctx).e1.ast, ((ExpressionContext)_localctx).e2.ast);
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(127);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(128);
						match(T__5);
						setState(129);
						((ExpressionContext)_localctx).ID = match(ID);
						((ExpressionContext)_localctx).ast = new FieldAccess((((ExpressionContext)_localctx).e1!=null?(((ExpressionContext)_localctx).e1.start):null).getLine(),(((ExpressionContext)_localctx).e1!=null?(((ExpressionContext)_localctx).e1.start):null).getCharPositionInLine()+1,(((ExpressionContext)_localctx).ID!=null?((ExpressionContext)_localctx).ID.getText():null),((ExpressionContext)_localctx).e1.ast);
						}
						break;
					}
					} 
				}
				setState(135);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Function_call_expContext extends ParserRuleContext {
		public Expression ast;
		public Token ID;
		public ArgumentsContext a;
		public TerminalNode ID() { return getToken(PmmParser.ID, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public Function_call_expContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_call_exp; }
	}

	public final Function_call_expContext function_call_exp() throws RecognitionException {
		Function_call_expContext _localctx = new Function_call_expContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_function_call_exp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			((Function_call_expContext)_localctx).ID = match(ID);
			setState(137);
			((Function_call_expContext)_localctx).a = arguments();
			((Function_call_expContext)_localctx).ast = new FunctionCall(((Function_call_expContext)_localctx).ID.getLine(),((Function_call_expContext)_localctx).ID.getCharPositionInLine()+1,new Variable(((Function_call_expContext)_localctx).ID.getLine(), ((Function_call_expContext)_localctx).ID.getCharPositionInLine()+1,(((Function_call_expContext)_localctx).ID!=null?((Function_call_expContext)_localctx).ID.getText():null)),((Function_call_expContext)_localctx).a.ast);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionsContext extends ParserRuleContext {
		public List<Expression> ast = new ArrayList<Expression>();
		public ExpressionContext e1;
		public ExpressionContext e2;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpressionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressions; }
	}

	public final ExpressionsContext expressions() throws RecognitionException {
		ExpressionsContext _localctx = new ExpressionsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_expressions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			((ExpressionsContext)_localctx).e1 = expression(0);
			_localctx.ast.add(((ExpressionsContext)_localctx).e1.ast);
			setState(148);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__20) {
				{
				{
				setState(142);
				match(T__20);
				setState(143);
				((ExpressionsContext)_localctx).e2 = expression(0);
				_localctx.ast.add(((ExpressionsContext)_localctx).e2.ast);
				}
				}
				setState(150);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public Statement ast;
		public Function_call_staContext f;
		public If_staContext ifs;
		public Return_staContext rtn;
		public InputContext in;
		public PrintContext p;
		public While_staContext w;
		public AssignationContext a;
		public Function_call_staContext function_call_sta() {
			return getRuleContext(Function_call_staContext.class,0);
		}
		public If_staContext if_sta() {
			return getRuleContext(If_staContext.class,0);
		}
		public Return_staContext return_sta() {
			return getRuleContext(Return_staContext.class,0);
		}
		public InputContext input() {
			return getRuleContext(InputContext.class,0);
		}
		public PrintContext print() {
			return getRuleContext(PrintContext.class,0);
		}
		public While_staContext while_sta() {
			return getRuleContext(While_staContext.class,0);
		}
		public AssignationContext assignation() {
			return getRuleContext(AssignationContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_statement);
		try {
			setState(173);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(151);
				((StatementContext)_localctx).f = function_call_sta();
				setState(152);
				match(T__0);
				((StatementContext)_localctx).ast = ((StatementContext)_localctx).f.ast;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(155);
				((StatementContext)_localctx).ifs = if_sta();
				((StatementContext)_localctx).ast = ((StatementContext)_localctx).ifs.ast;
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(158);
				((StatementContext)_localctx).rtn = return_sta();
				((StatementContext)_localctx).ast = ((StatementContext)_localctx).rtn.ast;
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(161);
				((StatementContext)_localctx).in = input();
				((StatementContext)_localctx).ast = ((StatementContext)_localctx).in.ast;
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(164);
				((StatementContext)_localctx).p = print();
				((StatementContext)_localctx).ast = ((StatementContext)_localctx).p.ast;
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(167);
				((StatementContext)_localctx).w = while_sta();
				((StatementContext)_localctx).ast = ((StatementContext)_localctx).w.ast;
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(170);
				((StatementContext)_localctx).a = assignation();
				((StatementContext)_localctx).ast = ((StatementContext)_localctx).a.ast;
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Function_call_staContext extends ParserRuleContext {
		public Statement ast;
		public Token ID;
		public ArgumentsContext a;
		public TerminalNode ID() { return getToken(PmmParser.ID, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public Function_call_staContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_call_sta; }
	}

	public final Function_call_staContext function_call_sta() throws RecognitionException {
		Function_call_staContext _localctx = new Function_call_staContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_function_call_sta);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			((Function_call_staContext)_localctx).ID = match(ID);
			setState(176);
			((Function_call_staContext)_localctx).a = arguments();
			((Function_call_staContext)_localctx).ast = new FunctionCall(((Function_call_staContext)_localctx).ID.getLine(),((Function_call_staContext)_localctx).ID.getCharPositionInLine()+1,new Variable(((Function_call_staContext)_localctx).ID.getLine(), ((Function_call_staContext)_localctx).ID.getCharPositionInLine()+1,(((Function_call_staContext)_localctx).ID!=null?((Function_call_staContext)_localctx).ID.getText():null)),((Function_call_staContext)_localctx).a.ast);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgumentsContext extends ParserRuleContext {
		public List<Expression> ast = new ArrayList<Expression>();
		public ExpressionsContext es;
		public ExpressionsContext expressions() {
			return getRuleContext(ExpressionsContext.class,0);
		}
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_arguments);
		try {
			setState(186);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(179);
				match(T__1);
				setState(180);
				match(T__2);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(181);
				match(T__1);
				setState(182);
				((ArgumentsContext)_localctx).es = expressions();
				setState(183);
				match(T__2);
				((ArgumentsContext)_localctx).ast = ((ArgumentsContext)_localctx).es.ast;
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class If_staContext extends ParserRuleContext {
		public Statement ast;
		public ExpressionContext e1;
		public Conditional_bodyContext body;
		public Else_staContext es;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Conditional_bodyContext conditional_body() {
			return getRuleContext(Conditional_bodyContext.class,0);
		}
		public Else_staContext else_sta() {
			return getRuleContext(Else_staContext.class,0);
		}
		public If_staContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_sta; }
	}

	public final If_staContext if_sta() throws RecognitionException {
		If_staContext _localctx = new If_staContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_if_sta);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			match(T__21);
			setState(189);
			((If_staContext)_localctx).e1 = expression(0);
			setState(190);
			match(T__22);
			setState(191);
			((If_staContext)_localctx).body = conditional_body();
			Conditional cond=new Conditional((((If_staContext)_localctx).e1!=null?(((If_staContext)_localctx).e1.start):null).getLine(),(((If_staContext)_localctx).e1!=null?(((If_staContext)_localctx).e1.start):null).getCharPositionInLine()+1,((If_staContext)_localctx).e1.ast,((If_staContext)_localctx).body.ast,new ArrayList<Statement>());
			setState(196);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(193);
				((If_staContext)_localctx).es = else_sta();
				cond.setElseBody(((If_staContext)_localctx).es.ast);
				}
				break;
			}
			((If_staContext)_localctx).ast = cond;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Else_staContext extends ParserRuleContext {
		public List<Statement> ast;
		public Conditional_bodyContext body;
		public Conditional_bodyContext conditional_body() {
			return getRuleContext(Conditional_bodyContext.class,0);
		}
		public Else_staContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_else_sta; }
	}

	public final Else_staContext else_sta() throws RecognitionException {
		Else_staContext _localctx = new Else_staContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_else_sta);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			match(T__23);
			setState(201);
			((Else_staContext)_localctx).body = conditional_body();
			((Else_staContext)_localctx).ast = ((Else_staContext)_localctx).body.ast;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Conditional_bodyContext extends ParserRuleContext {
		public List<Statement> ast = new ArrayList<Statement>();
		public StatementContext sta;
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public Conditional_bodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditional_body; }
	}

	public final Conditional_bodyContext conditional_body() throws RecognitionException {
		Conditional_bodyContext _localctx = new Conditional_bodyContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_conditional_body);
		int _la;
		try {
			setState(217);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
			case T__6:
			case T__7:
			case T__21:
			case T__26:
			case T__27:
			case T__28:
			case T__29:
			case INT_CONSTANT:
			case REAL_CONSTANT:
			case CHAR_CONSTANT:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(204);
				((Conditional_bodyContext)_localctx).sta = statement();
				_localctx.ast.add(((Conditional_bodyContext)_localctx).sta.ast);
				}
				break;
			case T__24:
				enterOuterAlt(_localctx, 2);
				{
				setState(207);
				match(T__24);
				setState(211); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(208);
					((Conditional_bodyContext)_localctx).sta = statement();
					_localctx.ast.add(((Conditional_bodyContext)_localctx).sta.ast);
					}
					}
					setState(213); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__6) | (1L << T__7) | (1L << T__21) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << CHAR_CONSTANT) | (1L << ID))) != 0) );
				setState(215);
				match(T__25);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Return_staContext extends ParserRuleContext {
		public Statement ast;
		public ExpressionContext e1;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Return_staContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_sta; }
	}

	public final Return_staContext return_sta() throws RecognitionException {
		Return_staContext _localctx = new Return_staContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_return_sta);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
			match(T__26);
			setState(220);
			((Return_staContext)_localctx).e1 = expression(0);
			setState(221);
			match(T__0);
			((Return_staContext)_localctx).ast = new Return((((Return_staContext)_localctx).e1!=null?(((Return_staContext)_localctx).e1.start):null).getLine(),(((Return_staContext)_localctx).e1!=null?(((Return_staContext)_localctx).e1.start):null).getCharPositionInLine()+1,((Return_staContext)_localctx).e1.ast);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InputContext extends ParserRuleContext {
		public Statement ast;
		public ExpressionsContext es;
		public ExpressionsContext expressions() {
			return getRuleContext(ExpressionsContext.class,0);
		}
		public InputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_input; }
	}

	public final InputContext input() throws RecognitionException {
		InputContext _localctx = new InputContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_input);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(224);
			match(T__27);
			setState(225);
			((InputContext)_localctx).es = expressions();
			setState(226);
			match(T__0);
			((InputContext)_localctx).ast = new Input((((InputContext)_localctx).es!=null?(((InputContext)_localctx).es.start):null).getLine(),(((InputContext)_localctx).es!=null?(((InputContext)_localctx).es.start):null).getCharPositionInLine()+1,((InputContext)_localctx).es.ast);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrintContext extends ParserRuleContext {
		public Statement ast;
		public ExpressionsContext es;
		public ExpressionsContext expressions() {
			return getRuleContext(ExpressionsContext.class,0);
		}
		public PrintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_print; }
	}

	public final PrintContext print() throws RecognitionException {
		PrintContext _localctx = new PrintContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_print);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(229);
			match(T__28);
			setState(230);
			((PrintContext)_localctx).es = expressions();
			setState(231);
			match(T__0);
			((PrintContext)_localctx).ast = new Print((((PrintContext)_localctx).es!=null?(((PrintContext)_localctx).es.start):null).getLine(),(((PrintContext)_localctx).es!=null?(((PrintContext)_localctx).es.start):null).getCharPositionInLine()+1,((PrintContext)_localctx).es.ast);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class While_staContext extends ParserRuleContext {
		public Statement ast;
		public ExpressionContext e1;
		public Conditional_bodyContext body;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Conditional_bodyContext conditional_body() {
			return getRuleContext(Conditional_bodyContext.class,0);
		}
		public While_staContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while_sta; }
	}

	public final While_staContext while_sta() throws RecognitionException {
		While_staContext _localctx = new While_staContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_while_sta);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			match(T__29);
			setState(235);
			((While_staContext)_localctx).e1 = expression(0);
			setState(236);
			match(T__22);
			setState(237);
			((While_staContext)_localctx).body = conditional_body();
			((While_staContext)_localctx).ast = new While((((While_staContext)_localctx).e1!=null?(((While_staContext)_localctx).e1.start):null).getLine(),(((While_staContext)_localctx).e1!=null?(((While_staContext)_localctx).e1.start):null).getCharPositionInLine()+1,((While_staContext)_localctx).e1.ast,((While_staContext)_localctx).body.ast);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignationContext extends ParserRuleContext {
		public Statement ast;
		public ExpressionContext e1;
		public ExpressionContext e2;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public AssignationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignation; }
	}

	public final AssignationContext assignation() throws RecognitionException {
		AssignationContext _localctx = new AssignationContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_assignation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(240);
			((AssignationContext)_localctx).e1 = expression(0);
			setState(241);
			match(T__30);
			setState(242);
			((AssignationContext)_localctx).e2 = expression(0);
			setState(243);
			match(T__0);
			((AssignationContext)_localctx).ast = new Assignation((((AssignationContext)_localctx).e1!=null?(((AssignationContext)_localctx).e1.start):null).getLine(),(((AssignationContext)_localctx).e1!=null?(((AssignationContext)_localctx).e1.start):null).getCharPositionInLine()+1,((AssignationContext)_localctx).e1.ast,((AssignationContext)_localctx).e2.ast);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public Type ast;
		public Token t;
		public FieldsContext f;
		public Token INT_CONSTANT;
		public TypeContext type;
		public FieldsContext fields() {
			return getRuleContext(FieldsContext.class,0);
		}
		public TerminalNode INT_CONSTANT() { return getToken(PmmParser.INT_CONSTANT, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_type);
		try {
			setState(264);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__31:
				enterOuterAlt(_localctx, 1);
				{
				setState(246);
				((TypeContext)_localctx).t = match(T__31);
				((TypeContext)_localctx).ast =  CharType.getInstance(((TypeContext)_localctx).t.getLine(),((TypeContext)_localctx).t.getCharPositionInLine()+1);
				}
				break;
			case T__32:
				enterOuterAlt(_localctx, 2);
				{
				setState(248);
				((TypeContext)_localctx).t = match(T__32);
				((TypeContext)_localctx).ast =  IntType.getInstance(((TypeContext)_localctx).t.getLine(),((TypeContext)_localctx).t.getCharPositionInLine()+1);
				}
				break;
			case T__33:
				enterOuterAlt(_localctx, 3);
				{
				setState(250);
				((TypeContext)_localctx).t = match(T__33);
				((TypeContext)_localctx).ast =  DoubleType.getInstance(((TypeContext)_localctx).t.getLine(),((TypeContext)_localctx).t.getCharPositionInLine()+1);
				}
				break;
			case T__34:
				enterOuterAlt(_localctx, 4);
				{
				setState(252);
				((TypeContext)_localctx).t = match(T__34);
				setState(253);
				match(T__24);
				setState(254);
				((TypeContext)_localctx).f = fields();
				setState(255);
				match(T__25);
				((TypeContext)_localctx).ast = new StructType(((TypeContext)_localctx).t.getLine(),((TypeContext)_localctx).t.getCharPositionInLine()+1,((TypeContext)_localctx).f.ast);
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 5);
				{
				setState(258);
				match(T__3);
				setState(259);
				((TypeContext)_localctx).INT_CONSTANT = match(INT_CONSTANT);
				setState(260);
				match(T__4);
				setState(261);
				((TypeContext)_localctx).type = type();
				((TypeContext)_localctx).ast =  new ArrayType(((TypeContext)_localctx).INT_CONSTANT.getLine(),((TypeContext)_localctx).INT_CONSTANT.getCharPositionInLine()+1,((TypeContext)_localctx).type.ast, LexerHelper.lexemeToInt((((TypeContext)_localctx).INT_CONSTANT!=null?((TypeContext)_localctx).INT_CONSTANT.getText():null)) );
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldsContext extends ParserRuleContext {
		public List<FieldDefinition> ast = new ArrayList<FieldDefinition>();
		public Token id1;
		public Token id2;
		public TypeContext type;
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TerminalNode> ID() { return getTokens(PmmParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PmmParser.ID, i);
		}
		public FieldsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fields; }
	}

	public final FieldsContext fields() throws RecognitionException {
		FieldsContext _localctx = new FieldsContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_fields);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(283);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(266);
				((FieldsContext)_localctx).id1 = match(ID);
				if(_localctx.ast.contains(new FieldDefinition((((FieldsContext)_localctx).id1!=null?((FieldsContext)_localctx).id1.getText():null),null))){new ErrorType(((FieldsContext)_localctx).id1.getLine(), ((FieldsContext)_localctx).id1.getCharPositionInLine()+1, "Duplicate field error: " + (((FieldsContext)_localctx).id1!=null?((FieldsContext)_localctx).id1.getText():null));}else {_localctx.ast.add(new FieldDefinition((((FieldsContext)_localctx).id1!=null?((FieldsContext)_localctx).id1.getText():null),null));}
				setState(273);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__20) {
					{
					{
					setState(268);
					match(T__20);
					setState(269);
					((FieldsContext)_localctx).id2 = match(ID);
					if(_localctx.ast.contains(new FieldDefinition((((FieldsContext)_localctx).id2!=null?((FieldsContext)_localctx).id2.getText():null),null))){new ErrorType(((FieldsContext)_localctx).id2.getLine(), ((FieldsContext)_localctx).id2.getCharPositionInLine()+1, "Duplicate field error: " + (((FieldsContext)_localctx).id2!=null?((FieldsContext)_localctx).id2.getText():null));}else {_localctx.ast.add(new FieldDefinition((((FieldsContext)_localctx).id2!=null?((FieldsContext)_localctx).id2.getText():null),null));}
					}
					}
					setState(275);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(276);
				match(T__22);
				setState(277);
				((FieldsContext)_localctx).type = type();
				setState(278);
				match(T__0);
				for(FieldDefinition d: _localctx.ast){if(d.getType()==null)d.setType(((FieldsContext)_localctx).type.ast);}
				}
				}
				setState(285);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Var_defContext extends ParserRuleContext {
		public List<Definition> ast = new ArrayList<Definition>();
		public Simple_var_defContext simple_var_def;
		public Multi_var_defContext multi_var_def;
		public Simple_var_defContext simple_var_def() {
			return getRuleContext(Simple_var_defContext.class,0);
		}
		public Multi_var_defContext multi_var_def() {
			return getRuleContext(Multi_var_defContext.class,0);
		}
		public Var_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_def; }
	}

	public final Var_defContext var_def() throws RecognitionException {
		Var_defContext _localctx = new Var_defContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_var_def);
		try {
			setState(292);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(286);
				((Var_defContext)_localctx).simple_var_def = simple_var_def();
				_localctx.ast.add(((Var_defContext)_localctx).simple_var_def.ast);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(289);
				((Var_defContext)_localctx).multi_var_def = multi_var_def();
				_localctx.ast.addAll(((Var_defContext)_localctx).multi_var_def.ast);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Simple_var_defContext extends ParserRuleContext {
		public Definition ast;
		public Token ID;
		public TypeContext type;
		public TerminalNode ID() { return getToken(PmmParser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public Simple_var_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple_var_def; }
	}

	public final Simple_var_defContext simple_var_def() throws RecognitionException {
		Simple_var_defContext _localctx = new Simple_var_defContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_simple_var_def);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(294);
			((Simple_var_defContext)_localctx).ID = match(ID);
			setState(295);
			match(T__22);
			setState(296);
			((Simple_var_defContext)_localctx).type = type();
			((Simple_var_defContext)_localctx).ast = new VarDefinition(((Simple_var_defContext)_localctx).ID.getLine(), ((Simple_var_defContext)_localctx).ID.getCharPositionInLine()+1, (((Simple_var_defContext)_localctx).ID!=null?((Simple_var_defContext)_localctx).ID.getText():null), ((Simple_var_defContext)_localctx).type.ast);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Multi_var_defContext extends ParserRuleContext {
		public List<Definition> ast = new ArrayList<Definition>();
		public Token id1;
		public Token id2;
		public TypeContext type;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(PmmParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PmmParser.ID, i);
		}
		public Multi_var_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multi_var_def; }
	}

	public final Multi_var_defContext multi_var_def() throws RecognitionException {
		Multi_var_defContext _localctx = new Multi_var_defContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_multi_var_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(299);
			((Multi_var_defContext)_localctx).id1 = match(ID);
			_localctx.ast.add(new VarDefinition(((Multi_var_defContext)_localctx).id1.getLine(), ((Multi_var_defContext)_localctx).id1.getCharPositionInLine()+1, (((Multi_var_defContext)_localctx).id1!=null?((Multi_var_defContext)_localctx).id1.getText():null), null));
			setState(304); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(301);
				match(T__20);
				setState(302);
				((Multi_var_defContext)_localctx).id2 = match(ID);
				if(_localctx.ast.contains(new VarDefinition(((Multi_var_defContext)_localctx).id2.getLine(), ((Multi_var_defContext)_localctx).id2.getCharPositionInLine()+1, (((Multi_var_defContext)_localctx).id2!=null?((Multi_var_defContext)_localctx).id2.getText():null), null))){new ErrorType(((Multi_var_defContext)_localctx).id2.getLine(), ((Multi_var_defContext)_localctx).id2.getCharPositionInLine()+1, "Duplicate variable definition error: " + (((Multi_var_defContext)_localctx).id2!=null?((Multi_var_defContext)_localctx).id2.getText():null));}else{_localctx.ast.add(new VarDefinition(((Multi_var_defContext)_localctx).id2.getLine(), ((Multi_var_defContext)_localctx).id2.getCharPositionInLine()+1, (((Multi_var_defContext)_localctx).id2!=null?((Multi_var_defContext)_localctx).id2.getText():null), null));}
				}
				}
				setState(306); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__20 );
			setState(308);
			match(T__22);
			setState(309);
			((Multi_var_defContext)_localctx).type = type();
			for(Definition d: _localctx.ast){d.setType(((Multi_var_defContext)_localctx).type.ast);}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Func_defContext extends ParserRuleContext {
		public Definition ast;
		public Token ID;
		public ParametersContext parameters;
		public TypeContext type;
		public Var_defContext var_def;
		public StatementContext statement;
		public TerminalNode ID() { return getToken(PmmParser.ID, 0); }
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<Var_defContext> var_def() {
			return getRuleContexts(Var_defContext.class);
		}
		public Var_defContext var_def(int i) {
			return getRuleContext(Var_defContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public Func_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_def; }
	}

	public final Func_defContext func_def() throws RecognitionException {
		Func_defContext _localctx = new Func_defContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_func_def);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(312);
			match(T__35);
			setState(313);
			((Func_defContext)_localctx).ID = match(ID);
			setState(314);
			((Func_defContext)_localctx).parameters = parameters();
			setState(315);
			match(T__22);
			Type returnType=VoidType.getInstance(((Func_defContext)_localctx).ID.getLine(),((Func_defContext)_localctx).ID.getCharPositionInLine()+1);
			setState(320);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34))) != 0)) {
				{
				setState(317);
				((Func_defContext)_localctx).type = type();
				returnType=((Func_defContext)_localctx).type.ast;
				}
			}

			setState(322);
			match(T__24);
			List<Definition> defs=new ArrayList<Definition>();
			setState(330);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(324);
					((Func_defContext)_localctx).var_def = var_def();
					defs.addAll(((Func_defContext)_localctx).var_def.ast);
					setState(326);
					match(T__0);
					}
					} 
				}
				setState(332);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			}
			List<Statement> sts=new ArrayList<Statement>();
			setState(339);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__6) | (1L << T__7) | (1L << T__21) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << CHAR_CONSTANT) | (1L << ID))) != 0)) {
				{
				{
				setState(334);
				((Func_defContext)_localctx).statement = statement();
				sts.add(((Func_defContext)_localctx).statement.ast);
				}
				}
				setState(341);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(342);
			match(T__25);
			((Func_defContext)_localctx).ast = new FuncDefinition(((Func_defContext)_localctx).ID.getLine(),((Func_defContext)_localctx).ID.getCharPositionInLine()+1,(((Func_defContext)_localctx).ID!=null?((Func_defContext)_localctx).ID.getText():null),new FunctionType(((Func_defContext)_localctx).ID.getLine(),((Func_defContext)_localctx).ID.getCharPositionInLine()+1,returnType,((Func_defContext)_localctx).parameters.ast),defs,sts);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Main_defContext extends ParserRuleContext {
		public Definition ast;
		public Token d;
		public Var_defContext var_def;
		public StatementContext statement;
		public TerminalNode EOF() { return getToken(PmmParser.EOF, 0); }
		public List<Var_defContext> var_def() {
			return getRuleContexts(Var_defContext.class);
		}
		public Var_defContext var_def(int i) {
			return getRuleContext(Var_defContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public Main_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main_def; }
	}

	public final Main_defContext main_def() throws RecognitionException {
		Main_defContext _localctx = new Main_defContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_main_def);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(345);
			((Main_defContext)_localctx).d = match(T__35);
			setState(346);
			match(T__36);
			setState(347);
			match(T__1);
			setState(348);
			match(T__2);
			setState(349);
			match(T__22);
			setState(350);
			match(T__24);
			List<Definition> defs=new ArrayList<Definition>();
			setState(358);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(352);
					((Main_defContext)_localctx).var_def = var_def();
					defs.addAll(((Main_defContext)_localctx).var_def.ast);
					setState(354);
					match(T__0);
					}
					} 
				}
				setState(360);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			}
			List<Statement> sts=new ArrayList<Statement>();
			setState(367);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__6) | (1L << T__7) | (1L << T__21) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << CHAR_CONSTANT) | (1L << ID))) != 0)) {
				{
				{
				setState(362);
				((Main_defContext)_localctx).statement = statement();
				sts.add(((Main_defContext)_localctx).statement.ast);
				}
				}
				setState(369);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(370);
			match(T__25);
			setState(371);
			match(EOF);
			 ((Main_defContext)_localctx).ast =  new FuncDefinition(_localctx.start.getLine(), _localctx.start.getCharPositionInLine()+1, "main",new FunctionType(((Main_defContext)_localctx).d.getLine(),((Main_defContext)_localctx).d.getCharPositionInLine()+1,VoidType.getInstance(((Main_defContext)_localctx).d.getLine(),((Main_defContext)_localctx).d.getCharPositionInLine()+1),new ArrayList<Definition>()),defs,sts); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParametersContext extends ParserRuleContext {
		public List<Definition> ast = new ArrayList<Definition>();
		public Simple_var_defContext v1;
		public Simple_var_defContext v2;
		public List<Simple_var_defContext> simple_var_def() {
			return getRuleContexts(Simple_var_defContext.class);
		}
		public Simple_var_defContext simple_var_def(int i) {
			return getRuleContext(Simple_var_defContext.class,i);
		}
		public ParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameters; }
	}

	public final ParametersContext parameters() throws RecognitionException {
		ParametersContext _localctx = new ParametersContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_parameters);
		int _la;
		try {
			setState(390);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(374);
				match(T__1);
				setState(375);
				match(T__2);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(376);
				match(T__1);
				setState(377);
				((ParametersContext)_localctx).v1 = simple_var_def();
				_localctx.ast.add(((ParametersContext)_localctx).v1.ast);
				setState(385);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__20) {
					{
					{
					setState(379);
					match(T__20);
					setState(380);
					((ParametersContext)_localctx).v2 = simple_var_def();
					_localctx.ast.add(((ParametersContext)_localctx).v2.ast);
					}
					}
					setState(387);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(388);
				match(T__2);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 2:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 9);
		case 1:
			return precpred(_ctx, 8);
		case 2:
			return precpred(_ctx, 7);
		case 3:
			return precpred(_ctx, 6);
		case 4:
			return precpred(_ctx, 14);
		case 5:
			return precpred(_ctx, 13);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3.\u018b\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3B\n\3"+
		"\f\3\16\3E\13\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\5\4f\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4\u0086"+
		"\n\4\f\4\16\4\u0089\13\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\7\6\u0095"+
		"\n\6\f\6\16\6\u0098\13\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u00b0\n\7\3\b\3\b\3\b\3"+
		"\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u00bd\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\5\n\u00c7\n\n\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\6\f\u00d6\n\f\r\f\16\f\u00d7\3\f\3\f\5\f\u00dc\n\f\3\r\3\r\3\r"+
		"\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3"+
		"\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3"+
		"\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5"+
		"\22\u010b\n\22\3\23\3\23\3\23\3\23\3\23\7\23\u0112\n\23\f\23\16\23\u0115"+
		"\13\23\3\23\3\23\3\23\3\23\3\23\7\23\u011c\n\23\f\23\16\23\u011f\13\23"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u0127\n\24\3\25\3\25\3\25\3\25\3\25"+
		"\3\26\3\26\3\26\3\26\3\26\6\26\u0133\n\26\r\26\16\26\u0134\3\26\3\26\3"+
		"\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u0143\n\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\7\27\u014b\n\27\f\27\16\27\u014e\13\27\3\27"+
		"\3\27\3\27\3\27\7\27\u0154\n\27\f\27\16\27\u0157\13\27\3\27\3\27\3\27"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\7\30\u0167\n\30"+
		"\f\30\16\30\u016a\13\30\3\30\3\30\3\30\3\30\7\30\u0170\n\30\f\30\16\30"+
		"\u0173\13\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3"+
		"\31\3\31\7\31\u0182\n\31\f\31\16\31\u0185\13\31\3\31\3\31\5\31\u0189\n"+
		"\31\3\31\2\3\6\32\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\2"+
		"\6\3\2\13\r\4\2\t\t\16\16\3\2\17\24\3\2\25\26\2\u019c\2\62\3\2\2\2\4C"+
		"\3\2\2\2\6e\3\2\2\2\b\u008a\3\2\2\2\n\u008e\3\2\2\2\f\u00af\3\2\2\2\16"+
		"\u00b1\3\2\2\2\20\u00bc\3\2\2\2\22\u00be\3\2\2\2\24\u00ca\3\2\2\2\26\u00db"+
		"\3\2\2\2\30\u00dd\3\2\2\2\32\u00e2\3\2\2\2\34\u00e7\3\2\2\2\36\u00ec\3"+
		"\2\2\2 \u00f2\3\2\2\2\"\u010a\3\2\2\2$\u011d\3\2\2\2&\u0126\3\2\2\2(\u0128"+
		"\3\2\2\2*\u012d\3\2\2\2,\u013a\3\2\2\2.\u015b\3\2\2\2\60\u0188\3\2\2\2"+
		"\62\63\b\2\1\2\63\64\5\4\3\2\64\65\b\2\1\2\65\66\5.\30\2\66\67\b\2\1\2"+
		"\678\3\2\2\289\b\2\1\29\3\3\2\2\2:;\5&\24\2;<\7\3\2\2<=\b\3\1\2=B\3\2"+
		"\2\2>?\5,\27\2?@\b\3\1\2@B\3\2\2\2A:\3\2\2\2A>\3\2\2\2BE\3\2\2\2CA\3\2"+
		"\2\2CD\3\2\2\2D\5\3\2\2\2EC\3\2\2\2FG\b\4\1\2GH\7\4\2\2HI\5\6\4\2IJ\7"+
		"\5\2\2JK\b\4\1\2Kf\3\2\2\2LM\7\4\2\2MN\5\"\22\2NO\7\5\2\2OP\5\6\4\16P"+
		"Q\b\4\1\2Qf\3\2\2\2RS\7\t\2\2ST\5\6\4\rTU\b\4\1\2Uf\3\2\2\2VW\7\n\2\2"+
		"WX\5\6\4\fXY\b\4\1\2Yf\3\2\2\2Z[\5\b\5\2[\\\b\4\1\2\\f\3\2\2\2]^\7+\2"+
		"\2^f\b\4\1\2_`\7(\2\2`f\b\4\1\2ab\7)\2\2bf\b\4\1\2cd\7*\2\2df\b\4\1\2"+
		"eF\3\2\2\2eL\3\2\2\2eR\3\2\2\2eV\3\2\2\2eZ\3\2\2\2e]\3\2\2\2e_\3\2\2\2"+
		"ea\3\2\2\2ec\3\2\2\2f\u0087\3\2\2\2gh\f\13\2\2hi\t\2\2\2ij\5\6\4\fjk\b"+
		"\4\1\2k\u0086\3\2\2\2lm\f\n\2\2mn\t\3\2\2no\5\6\4\13op\b\4\1\2p\u0086"+
		"\3\2\2\2qr\f\t\2\2rs\t\4\2\2st\5\6\4\ntu\b\4\1\2u\u0086\3\2\2\2vw\f\b"+
		"\2\2wx\t\5\2\2xy\5\6\4\tyz\b\4\1\2z\u0086\3\2\2\2{|\f\20\2\2|}\7\6\2\2"+
		"}~\5\6\4\2~\177\7\7\2\2\177\u0080\b\4\1\2\u0080\u0086\3\2\2\2\u0081\u0082"+
		"\f\17\2\2\u0082\u0083\7\b\2\2\u0083\u0084\7+\2\2\u0084\u0086\b\4\1\2\u0085"+
		"g\3\2\2\2\u0085l\3\2\2\2\u0085q\3\2\2\2\u0085v\3\2\2\2\u0085{\3\2\2\2"+
		"\u0085\u0081\3\2\2\2\u0086\u0089\3\2\2\2\u0087\u0085\3\2\2\2\u0087\u0088"+
		"\3\2\2\2\u0088\7\3\2\2\2\u0089\u0087\3\2\2\2\u008a\u008b\7+\2\2\u008b"+
		"\u008c\5\20\t\2\u008c\u008d\b\5\1\2\u008d\t\3\2\2\2\u008e\u008f\5\6\4"+
		"\2\u008f\u0096\b\6\1\2\u0090\u0091\7\27\2\2\u0091\u0092\5\6\4\2\u0092"+
		"\u0093\b\6\1\2\u0093\u0095\3\2\2\2\u0094\u0090\3\2\2\2\u0095\u0098\3\2"+
		"\2\2\u0096\u0094\3\2\2\2\u0096\u0097\3\2\2\2\u0097\13\3\2\2\2\u0098\u0096"+
		"\3\2\2\2\u0099\u009a\5\16\b\2\u009a\u009b\7\3\2\2\u009b\u009c\b\7\1\2"+
		"\u009c\u00b0\3\2\2\2\u009d\u009e\5\22\n\2\u009e\u009f\b\7\1\2\u009f\u00b0"+
		"\3\2\2\2\u00a0\u00a1\5\30\r\2\u00a1\u00a2\b\7\1\2\u00a2\u00b0\3\2\2\2"+
		"\u00a3\u00a4\5\32\16\2\u00a4\u00a5\b\7\1\2\u00a5\u00b0\3\2\2\2\u00a6\u00a7"+
		"\5\34\17\2\u00a7\u00a8\b\7\1\2\u00a8\u00b0\3\2\2\2\u00a9\u00aa\5\36\20"+
		"\2\u00aa\u00ab\b\7\1\2\u00ab\u00b0\3\2\2\2\u00ac\u00ad\5 \21\2\u00ad\u00ae"+
		"\b\7\1\2\u00ae\u00b0\3\2\2\2\u00af\u0099\3\2\2\2\u00af\u009d\3\2\2\2\u00af"+
		"\u00a0\3\2\2\2\u00af\u00a3\3\2\2\2\u00af\u00a6\3\2\2\2\u00af\u00a9\3\2"+
		"\2\2\u00af\u00ac\3\2\2\2\u00b0\r\3\2\2\2\u00b1\u00b2\7+\2\2\u00b2\u00b3"+
		"\5\20\t\2\u00b3\u00b4\b\b\1\2\u00b4\17\3\2\2\2\u00b5\u00b6\7\4\2\2\u00b6"+
		"\u00bd\7\5\2\2\u00b7\u00b8\7\4\2\2\u00b8\u00b9\5\n\6\2\u00b9\u00ba\7\5"+
		"\2\2\u00ba\u00bb\b\t\1\2\u00bb\u00bd\3\2\2\2\u00bc\u00b5\3\2\2\2\u00bc"+
		"\u00b7\3\2\2\2\u00bd\21\3\2\2\2\u00be\u00bf\7\30\2\2\u00bf\u00c0\5\6\4"+
		"\2\u00c0\u00c1\7\31\2\2\u00c1\u00c2\5\26\f\2\u00c2\u00c6\b\n\1\2\u00c3"+
		"\u00c4\5\24\13\2\u00c4\u00c5\b\n\1\2\u00c5\u00c7\3\2\2\2\u00c6\u00c3\3"+
		"\2\2\2\u00c6\u00c7\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00c9\b\n\1\2\u00c9"+
		"\23\3\2\2\2\u00ca\u00cb\7\32\2\2\u00cb\u00cc\5\26\f\2\u00cc\u00cd\b\13"+
		"\1\2\u00cd\25\3\2\2\2\u00ce\u00cf\5\f\7\2\u00cf\u00d0\b\f\1\2\u00d0\u00dc"+
		"\3\2\2\2\u00d1\u00d5\7\33\2\2\u00d2\u00d3\5\f\7\2\u00d3\u00d4\b\f\1\2"+
		"\u00d4\u00d6\3\2\2\2\u00d5\u00d2\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00d5"+
		"\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9\u00da\7\34\2\2"+
		"\u00da\u00dc\3\2\2\2\u00db\u00ce\3\2\2\2\u00db\u00d1\3\2\2\2\u00dc\27"+
		"\3\2\2\2\u00dd\u00de\7\35\2\2\u00de\u00df\5\6\4\2\u00df\u00e0\7\3\2\2"+
		"\u00e0\u00e1\b\r\1\2\u00e1\31\3\2\2\2\u00e2\u00e3\7\36\2\2\u00e3\u00e4"+
		"\5\n\6\2\u00e4\u00e5\7\3\2\2\u00e5\u00e6\b\16\1\2\u00e6\33\3\2\2\2\u00e7"+
		"\u00e8\7\37\2\2\u00e8\u00e9\5\n\6\2\u00e9\u00ea\7\3\2\2\u00ea\u00eb\b"+
		"\17\1\2\u00eb\35\3\2\2\2\u00ec\u00ed\7 \2\2\u00ed\u00ee\5\6\4\2\u00ee"+
		"\u00ef\7\31\2\2\u00ef\u00f0\5\26\f\2\u00f0\u00f1\b\20\1\2\u00f1\37\3\2"+
		"\2\2\u00f2\u00f3\5\6\4\2\u00f3\u00f4\7!\2\2\u00f4\u00f5\5\6\4\2\u00f5"+
		"\u00f6\7\3\2\2\u00f6\u00f7\b\21\1\2\u00f7!\3\2\2\2\u00f8\u00f9\7\"\2\2"+
		"\u00f9\u010b\b\22\1\2\u00fa\u00fb\7#\2\2\u00fb\u010b\b\22\1\2\u00fc\u00fd"+
		"\7$\2\2\u00fd\u010b\b\22\1\2\u00fe\u00ff\7%\2\2\u00ff\u0100\7\33\2\2\u0100"+
		"\u0101\5$\23\2\u0101\u0102\7\34\2\2\u0102\u0103\b\22\1\2\u0103\u010b\3"+
		"\2\2\2\u0104\u0105\7\6\2\2\u0105\u0106\7(\2\2\u0106\u0107\7\7\2\2\u0107"+
		"\u0108\5\"\22\2\u0108\u0109\b\22\1\2\u0109\u010b\3\2\2\2\u010a\u00f8\3"+
		"\2\2\2\u010a\u00fa\3\2\2\2\u010a\u00fc\3\2\2\2\u010a\u00fe\3\2\2\2\u010a"+
		"\u0104\3\2\2\2\u010b#\3\2\2\2\u010c\u010d\7+\2\2\u010d\u0113\b\23\1\2"+
		"\u010e\u010f\7\27\2\2\u010f\u0110\7+\2\2\u0110\u0112\b\23\1\2\u0111\u010e"+
		"\3\2\2\2\u0112\u0115\3\2\2\2\u0113\u0111\3\2\2\2\u0113\u0114\3\2\2\2\u0114"+
		"\u0116\3\2\2\2\u0115\u0113\3\2\2\2\u0116\u0117\7\31\2\2\u0117\u0118\5"+
		"\"\22\2\u0118\u0119\7\3\2\2\u0119\u011a\b\23\1\2\u011a\u011c\3\2\2\2\u011b"+
		"\u010c\3\2\2\2\u011c\u011f\3\2\2\2\u011d\u011b\3\2\2\2\u011d\u011e\3\2"+
		"\2\2\u011e%\3\2\2\2\u011f\u011d\3\2\2\2\u0120\u0121\5(\25\2\u0121\u0122"+
		"\b\24\1\2\u0122\u0127\3\2\2\2\u0123\u0124\5*\26\2\u0124\u0125\b\24\1\2"+
		"\u0125\u0127\3\2\2\2\u0126\u0120\3\2\2\2\u0126\u0123\3\2\2\2\u0127\'\3"+
		"\2\2\2\u0128\u0129\7+\2\2\u0129\u012a\7\31\2\2\u012a\u012b\5\"\22\2\u012b"+
		"\u012c\b\25\1\2\u012c)\3\2\2\2\u012d\u012e\7+\2\2\u012e\u0132\b\26\1\2"+
		"\u012f\u0130\7\27\2\2\u0130\u0131\7+\2\2\u0131\u0133\b\26\1\2\u0132\u012f"+
		"\3\2\2\2\u0133\u0134\3\2\2\2\u0134\u0132\3\2\2\2\u0134\u0135\3\2\2\2\u0135"+
		"\u0136\3\2\2\2\u0136\u0137\7\31\2\2\u0137\u0138\5\"\22\2\u0138\u0139\b"+
		"\26\1\2\u0139+\3\2\2\2\u013a\u013b\7&\2\2\u013b\u013c\7+\2\2\u013c\u013d"+
		"\5\60\31\2\u013d\u013e\7\31\2\2\u013e\u0142\b\27\1\2\u013f\u0140\5\"\22"+
		"\2\u0140\u0141\b\27\1\2\u0141\u0143\3\2\2\2\u0142\u013f\3\2\2\2\u0142"+
		"\u0143\3\2\2\2\u0143\u0144\3\2\2\2\u0144\u0145\7\33\2\2\u0145\u014c\b"+
		"\27\1\2\u0146\u0147\5&\24\2\u0147\u0148\b\27\1\2\u0148\u0149\7\3\2\2\u0149"+
		"\u014b\3\2\2\2\u014a\u0146\3\2\2\2\u014b\u014e\3\2\2\2\u014c\u014a\3\2"+
		"\2\2\u014c\u014d\3\2\2\2\u014d\u014f\3\2\2\2\u014e\u014c\3\2\2\2\u014f"+
		"\u0155\b\27\1\2\u0150\u0151\5\f\7\2\u0151\u0152\b\27\1\2\u0152\u0154\3"+
		"\2\2\2\u0153\u0150\3\2\2\2\u0154\u0157\3\2\2\2\u0155\u0153\3\2\2\2\u0155"+
		"\u0156\3\2\2\2\u0156\u0158\3\2\2\2\u0157\u0155\3\2\2\2\u0158\u0159\7\34"+
		"\2\2\u0159\u015a\b\27\1\2\u015a-\3\2\2\2\u015b\u015c\7&\2\2\u015c\u015d"+
		"\7\'\2\2\u015d\u015e\7\4\2\2\u015e\u015f\7\5\2\2\u015f\u0160\7\31\2\2"+
		"\u0160\u0161\7\33\2\2\u0161\u0168\b\30\1\2\u0162\u0163\5&\24\2\u0163\u0164"+
		"\b\30\1\2\u0164\u0165\7\3\2\2\u0165\u0167\3\2\2\2\u0166\u0162\3\2\2\2"+
		"\u0167\u016a\3\2\2\2\u0168\u0166\3\2\2\2\u0168\u0169\3\2\2\2\u0169\u016b"+
		"\3\2\2\2\u016a\u0168\3\2\2\2\u016b\u0171\b\30\1\2\u016c\u016d\5\f\7\2"+
		"\u016d\u016e\b\30\1\2\u016e\u0170\3\2\2\2\u016f\u016c\3\2\2\2\u0170\u0173"+
		"\3\2\2\2\u0171\u016f\3\2\2\2\u0171\u0172\3\2\2\2\u0172\u0174\3\2\2\2\u0173"+
		"\u0171\3\2\2\2\u0174\u0175\7\34\2\2\u0175\u0176\7\2\2\3\u0176\u0177\b"+
		"\30\1\2\u0177/\3\2\2\2\u0178\u0179\7\4\2\2\u0179\u0189\7\5\2\2\u017a\u017b"+
		"\7\4\2\2\u017b\u017c\5(\25\2\u017c\u0183\b\31\1\2\u017d\u017e\7\27\2\2"+
		"\u017e\u017f\5(\25\2\u017f\u0180\b\31\1\2\u0180\u0182\3\2\2\2\u0181\u017d"+
		"\3\2\2\2\u0182\u0185\3\2\2\2\u0183\u0181\3\2\2\2\u0183\u0184\3\2\2\2\u0184"+
		"\u0186\3\2\2\2\u0185\u0183\3\2\2\2\u0186\u0187\7\5\2\2\u0187\u0189\3\2"+
		"\2\2\u0188\u0178\3\2\2\2\u0188\u017a\3\2\2\2\u0189\61\3\2\2\2\31ACe\u0085"+
		"\u0087\u0096\u00af\u00bc\u00c6\u00d7\u00db\u010a\u0113\u011d\u0126\u0134"+
		"\u0142\u014c\u0155\u0168\u0171\u0183\u0188";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}