package postfix;

import stack.LinkedListStack;
import stack.Stack;
import stack.Underflow;

public class Postfix {

	public String infixToPostfix(String infix) throws Underflow, WrongInputFormatException  {
		//check if the input isnt wrong
		char endChar = infix.charAt(infix.length()-1);//it would be postfix
		char startChar = infix.charAt(0); // it would be infix
		if(infix.length()<3||endChar=='*'||endChar=='-'||endChar=='/'||endChar=='+'||startChar=='*'||startChar=='-'||startChar=='/'||startChar=='+'){
			throw new WrongInputFormatException();
		}
		
		
		Stack<Character> stack = new LinkedListStack<Character>();
		String outputString = "";
		
		for(int i=0; i<infix.length(); i++){
			//nextToken
			char t = infix.charAt(i);
			
			//if between 0 and 9 append to outputString
			if(t>=48&&t<=57){
				outputString += t;
			}else if(t=='('){
				stack.push(t);
			}else if (t=='*'||t=='+'||t=='-'||t=='/'){
				if(stack.isEmpty()){
					stack.push(t);
				}else{
					//if top has higher precedence
					while(true){
					if(t=='-'||t=='+'&&stack.top()=='/'||stack.top()=='*'){
						//pop & append top output
						outputString += stack.pop().getData();
					}else break;
					stack.push(t);	
				}
			}
			}else if(t==')'){
				while(!stack.isEmpty()&&stack.top()!='('){
					outputString += stack.pop().getData();
				}
				stack.pop();//popping out the left brace
			}
		}
		//if there is any input in the Stack - pop & append to output String
		while (!stack.isEmpty()){
			outputString += stack.pop().getData();
		}
		return outputString;
	}

	public int evaluate(String inputString) throws Underflow {
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
			}	
		}
		int finalResult = ((int)(stack.pop().getData())-48);
		return finalResult;
	}
	
	

}
