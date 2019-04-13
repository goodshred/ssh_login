package LJVM;

public class Parser {
	private Lexer lexer;
	//用数组来模拟栈的操作。=====这是一个8为的随机寄存器，用堆栈存储寄存器，===依次出栈，运算完后依次入栈
	//可带表1，2，3，+，*，（，），，，，，t0，t1是寄存器的名字
	String[] names = {"t0", "t1", "t2", "t3", "t4", "t5", "t6", "t7"};
	private int nameP = 0;
	
	private String newName() {    //调用寄存器，就从栈中寄存器弹出来
	    if (nameP >= names.length) {        //nameP数组下标，相当于栈指针
	    	System.out.println("Expression too complex: " + lexer.yylineno);
	    	System.exit(1);
	    }
	    
	    String reg = names[nameP];
	    nameP++;
	    
	    return reg;
	}
	
	private void freeNames(String s) {
		if (nameP > 0) {
			names[nameP] = s;
			nameP--;
		}
		else {
			System.out.println("(Internal error) Name stack underflow: " + lexer.yylineno);;
		}
	}
	
    public Parser(Lexer lexer) {
    	this.lexer = lexer;
    }
    
    public void statements() {           //父节点分配寄存器策略
    	String tempvar = newName();
    	expression(tempvar); 
    	
    	while (lexer.match(Lexer.EOI) != false) {
    		expression (tempvar);
    		freeNames(tempvar);
    		
    		if (lexer.match(Lexer.SEMI)) {
    			lexer.advance();
    		}
    		else {
    			System.out.println("Inserting missing semicolon: " + lexer.yylineno);
    		}
    	}
    }
    
    private void expression(String tempVar) {
    	String tempVar2;
    	term(tempVar);
    	while (lexer.match(Lexer.PLUS)) {
    		lexer.advance();
    		tempVar2 = newName();
    		term(tempVar2);
    		System.out.println(tempVar + " += " + tempVar2);
    		freeNames(tempVar2);
    	}
    }
    
   
    
    private void term(String tempVar) {         //寄存器的名字tempVar
    	String tempVar2;
    	
    	factor (tempVar);
    	while (lexer.match(Lexer.TIMES)) {
    		lexer.advance();
    		tempVar2 = newName();
    		factor(tempVar2);           //tempVar和tempVar2都是从寄存器取出的值，寄存器的调用也是通过二叉树来实现的
    		System.out.println(tempVar + " *= " + tempVar2);
    		freeNames(tempVar2);            //回收寄存器
    	}
    	
    }
    
  
    
    private void factor(String tempVar) {
    	if (lexer.match(Lexer.NUM_OR_ID)) {
    		System.out.println(tempVar + " = " + lexer.yytext);
    		lexer.advance();
    	}
    	else if (lexer.match(Lexer.LP)) {
    		lexer.advance();
    		expression(tempVar);
    		if (lexer.match(Lexer.RP)) {
    			lexer.advance();
    		}
    		else {
    			System.out.println("Missmatched parenthesis: " + lexer.yylineno);
    		}
    	}
    	else {
    		System.out.println("Number or identifier expected: " + lexer.yylineno);
    	}
    }
}
