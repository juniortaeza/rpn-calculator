package rpncalc;

public class Infix extends RPN {
	Stack<String> stack = new Stack<String>();
	
	public String infixToPostfix(String expression) {
		String postfix = " ";
		String[] tokens = expression.split(postfix);
		for(String token : tokens) {
			if(isOperand(token))
				postfix += token + " ";
			else if(token.equals("("))
				stack.push(token);
			else if(token.equals(")")) {
				String topToken = stack.pop();
				while(!topToken.equals("(")) {
					postfix += topToken + " ";
					topToken = stack.pop();
				}
			} else {
				while(stack.count > 0 && precedence(stack.peek()) >= precedence(token)) {
					postfix += stack.pop() + " ";
				}
				stack.push(token);
			}
		}
		while(stack.count > 0) {
			postfix += stack.pop() + " ";
		}
		return postfix;
	}
	
	public int precedence(String x) {
		if(x.equals("+") || x.equals("-"))
			return 1;
		if(x.equals("*") || x.equals("/") || x.equals("%"))
			return 2;
		if(x.equals("^"))
			return 3;
		return -1;
	}
	
	private boolean isOperator(String c) {
		return c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/") || c.equals("^") ||
				c.equals("(") || c.equals(")");
	}

	private boolean isOperand(String s) {
		if(!isOperator(s) && !s.equals(")") && !s.equals("("))
			return true;
		else
			return false;
	}
}
