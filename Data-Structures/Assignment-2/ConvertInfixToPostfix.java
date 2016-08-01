import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;


public class ConvertInfixToPostfix {
	
	/**
	 * a utility method
	 * checks whether the input is a number or not
	 * */
    static boolean isNumber(String str) {
        try{
            Double.valueOf(str);
            return true;
        } catch(Exception e){
            return false;
        }
    }
 
    /**
     * main method to convert infix to postfix notation
     * @return queue having postfix expression
     * */
    Queue<String> convertInfixToRPN(String[] infixNotation) {
        
    	/*
         * using map to get precedence for operators
         */
    	Map<String, Integer> prededence = new HashMap<>();
        prededence.put("/", 5);
        prededence.put("*", 5);
        prededence.put("+", 4);
        prededence.put("-", 4);
        prededence.put("(", 0);
 
        //queue for the ouput postfix expression
        Queue<String> Q = new LinkedList<>();
        //stack 
        Stack<String> S = new Stack<>();
 
        //reading tokens
        for (String token : infixNotation) {
            //if the token is left brace
        	if ("(".equals(token)) {
                S.push(token);
                continue;
            }
        	
        	// right brace
            if (")".equals(token)) {
                while ( !"(".equals( S.peek() ) ) {
                    Q.add( S.pop() );
                }
                S.pop();
                continue;
            }
            
            // an operator
            if ( prededence.containsKey(token) ) {
                while (!S.empty() && prededence.get(token) <= prededence.get(S.peek())) {
                    Q.add(S.pop());
                }
                S.push(token);
                continue;
            }
            
            // a number
            if ( isNumber(token) ) {
                Q.add(token);
                continue;
            }
 
            //else case 
            throw new IllegalArgumentException("Invalid input");
        }
        // at the end, pop all the elements in S to Q
        while ( !S.isEmpty() ) {
            Q.add(S.pop());
        }
        //returning queue
        return Q;
    }
 
    
    public static void main(String[] args) {
    	
        String[] infixNotation = {"33", "+", "23"};
        System.out.println(new ConvertInfixToPostfix().convertInfixToRPN(infixNotation));
 
        String[] infixNotation2 = {"2", "*", "(", "3", "+", "4", "/", "2", ")"};
        System.out.println(new ConvertInfixToPostfix().convertInfixToRPN(infixNotation2));
 
    }
}