package LJVM;

public class BasicParser {
	/**
	 * 语法分析采用了二叉树的结构
	 * 对于输入的句子：从左往右的将每个单词依次放入二叉树的节点上
	 */
    private Lexer lexer;
    private boolean isLegalStatement = true;
    
    public BasicParser(Lexer lexer) {
    	this.lexer = lexer;            //词法解析
    }
    
    public void statements() {     //语法解析树
    	/*
    	 * statements -> expression ; | expression ; statements
    	 */
    	
    	expression();    //表达式
    	
    	if (lexer.match(Lexer.SEMI)) {
    		/*
    		 * look ahead 读取下一个字符，如果下一个字符不是 EOI
    		 * 那就采用右边解析规则
    		 */
    		lexer.advance(); 
    	}
    	else {
    		/*
    		 *  如果算术表达式不以分号结束，那就是语法错误
    		 */
    		isLegalStatement = false;
    		System.out.println("line: " + lexer.yylineno + " Missing semicolon");
    		return;
    	}
    	
    	if (lexer.match(Lexer.EOI) != true) {
    		/*
    		 * 分号后还有字符，继续解析
    		 */
    		statements();          //这里是通过循环实现的，它会脱宕程序的性能=====优化策略======改为循环
    	}
    	
    	if (isLegalStatement) {
    		System.out.println("The statement is legal");
    	}
    }
    
    private void expression() {
    	/*
    	 * expression -> term expression'
    	 */
    	term();
    	expr_prime(); //expression'
    }
    
    private void expr_prime() {
    	/*
    	 * expression' -> PLUS term expression' | '空'
    	 */
    	if (lexer.match(Lexer.PLUS)) {
    		lexer.advance();
    		term();
    		expr_prime();
    	}
    	else if (lexer.match(Lexer.UNKNOWN_SYMBOL)) {
    		isLegalStatement = false;
    		System.out.println("unknow symbol: " + lexer.yytext);
    		return;
    	}
    	else {
    		/*
    		 * "空" 就是不再解析，直接返回
    		 */
    		return;
    	}
    }
    
    private void term() {
    	/*
    	 * term -> factor term'
    	 */
    	factor();
    	term_prime(); //term'
    }
    
    private void term_prime() {
    	/*
    	 * term' -> * factor term' | '空'
    	 */
    	if (lexer.match(Lexer.TIMES)) {
    		lexer.advance();
    		factor();
    		term_prime();
    	}
    	else {            //右边不是乘号，就结束左边的分支的运算，接着遍历右子树
    		/*
    		 * 如果不是以 * 开头， 那么执行 '空' 
    		 * 也就是不再做进一步解析，直接返回
    		 */
    		return;
    	}
    }
    
    private void factor() {
    	/*
    	 * factor -> NUM_OR_ID | LP expression RP
    	 */
    	
    	if (lexer.match(Lexer.NUM_OR_ID)) {
    		lexer.advance();              //是数字，就解析下一个字符
    	}
    	else if (lexer.match(Lexer.LP)){     //左括号，就解析右边的整个表达式，而不是直接解析下一个字符
    		lexer.advance();
    		expression();
    		if (lexer.match(Lexer.RP)) {
    			lexer.advance();
    		}
    		else {
    			/*
    			 * 有左括号但没有右括号，错误
    			 */
    			isLegalStatement = false;
    			System.out.println("line: " + lexer.yylineno + " Missing )");
    			return;
    		}
    	}
    	else {
    		/*
    		 * 这里不是数字，解析出错
    		 */
    		isLegalStatement = false;
    		System.out.println("illegal statements");
    		return;
    	}
    }
}
