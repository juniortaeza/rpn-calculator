package rpncalc;

public class Main {

	public static void main(String[] args) {
		RPN rpn = new RPN();
		Infix in = new Infix();
		
		System.out.println("***************************************************");
        System.out.println("TESTING FOR RPN CALCULATOR");
        System.out.println("***************************************************");
        rpn.setExpression("325*+");   
        System.out.println("325*+ calculated is: " + rpn.calculate());
        
        rpn.setExpression("4        6      9  2   */    +");     
        System.out.println("4692*/+ calculated is: " + rpn.calculate());
        
        rpn.setExpression("91-");
        System.out.println("91- calculated is: " + rpn.calculate());  
        
        rpn.setExpression("7654321*+-/*+");
        System.out.println("7654321*+-/*+ calculated is: " + rpn.calculate());  
        
        rpn.setExpression("1999999/**+++");
        System.out.println("1999999/**+++ calculated is: " + rpn.calculate());  
        
        rpn.setExpression("1123456+");
        System.out.println("1123456+ calculated is: " + rpn.calculate());
        
        System.out.println("\n***************************************************");
        System.out.println("TESTING FOR INFIX TO POSTFIX + CALCULATIONS");
        System.out.println("***************************************************");
        System.out.println("Original expression: 5 * ( 3 + 2 * 4 ) + 6");
        String output = in.infixToPostfix("5 * ( 3 + 2 * 4 ) + 6");
        System.out.println("After conversion: " + output);
        rpn.setExpression(output);
        System.out.println("Calculations after Infix to Postfix: " + rpn.calculate());
        
        System.out.println("\nOriginal expression: ( 3 + 4 ) * 5");
        String output2 = in.infixToPostfix("( 3 + 4 ) * 5");
        System.out.println("After conversion: " + output2);
        rpn.setExpression(output2);
        System.out.println("Calculations after Infix to Postfix: " + rpn.calculate());
        
        System.out.println("\nOriginal expression: 4 + ( 3 * 6 * 7 ) * 9");
        String output3 = in.infixToPostfix("4 + ( 3 * 6 * 7 ) * 9");
        System.out.println("After conversion: " + output3);
        rpn.setExpression(output3);
        System.out.println("Calculations after Infix to Postfix: " + rpn.calculate());

        System.out.println("\nOriginal expression: 3 + 5 * ( 5 * 9 )");
        String output4 = in.infixToPostfix("3 + 5 * ( 5 * 9 )");
        System.out.println("After conversion: " + output4);
        rpn.setExpression(output4);
        System.out.println("Calculations after Infix to Postfix: " + rpn.calculate());
	}
}
