package postfix;

import stack.LinkedListStack;
import stack.Stack;
import stack.Underflow;

public class Postfix {

	public String infixToPostfix(String infix) {
		// TODO Auto-generated method stub
		return null;
	}

	public double evaluate(String inputString) throws Underflow {
		// TODO Auto-generated method stub
		Stack<Character> stack = new LinkedListStack<Character>();
		
		
		for(int i=0; i<inputString.length(); i++){
			
			//nextToken
			//String t = String.valueOf(inputString.charAt(i));
			char t = inputString.charAt(i);
			
			if(t>=48&&t<=57){
				stack.push(t);//hier gleich in int umwandeln
				//42*  43+  45-  47 /
			}else if(t==43||t==42||t==45||t==47){
				try{
				int rhs = (int) (stack.pop().getData()-48);
				int lhs = (int) (stack.pop().getData()-48);
				
				int result=0;
				switch(t){
				  case 42: result = lhs*rhs;
				  case 43: result = lhs+rhs;
				  case 45: result = lhs-rhs;
				  case 47: result = lhs/rhs;
				}
				stack.push((char)(result+48));
				
				}catch(Exception e){}
				//int lhs = Integer.valueOf(String.valueOf(stack.pop()));
				
				
			}	
		}
		double finalResult = (double)(stack.pop().getData());
		return finalResult;
	}

}
