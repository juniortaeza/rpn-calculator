package rpncalc;

public class RPN {
	private Stack<Double> stack = new Stack<Double>();
	private String postFix = new String();
	
	public RPN() {}
	
	public RPN(String str) {
		setExpression(str);
	}
	
	public void setExpression(String str) {
		postFix = str;
		stack =  new Stack<Double>();
	}

	public double calculate() {
		for(int i = 0; i < postFix.length(); i++) {
			char c = postFix.charAt(i);
			if(Character.isDigit(c))
				stack.push((double) Character.getNumericValue(c));
			else if (c == '+' || c == '-' || c == '*' || c == '/')
				operator(c);
		}
		return stack.peek();
	}
	
	public void operator(char c) {
		double num1 = stack.pop();
		double num2 = stack.pop();
		
		switch(c) 
		{
		case '+':
		{
			stack.push(num1 + num2);
			break;
		}
		case '-':
		{
			stack.push(num1 - num2);
			break;
		}
		case '*':
		{
			stack.push(num1 * num2);
			break;
		}
		case '/':
		{
			stack.push(num1 / num2);
			break;
		}
		default:
			break;
		}
	}
}