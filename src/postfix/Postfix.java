package postfix;


import stack.LinkedListStack;
import java.util.*;
import stack.Underflow;

public class Postfix {

    public String infixToPostfix(String infix) throws Underflow, WrongInputFormatException {
        //check if the input isnt wrong
        char endChar = infix.charAt(infix.length() - 1);//it would be postfix
        char startChar = infix.charAt(0); // it would be infix
        if (infix.length() < 3 || endChar == '*' || endChar == '-' || endChar == '/' || endChar == '+' || startChar == '*' || startChar == '-' || startChar == '/' || startChar == '+') {
            throw new WrongInputFormatException();
        }

//        Stack<Character> stack = new Stack<Character>();
        LinkedListStack<Character> stack = new LinkedListStack<Character>();
        StringBuilder sb = new StringBuilder();
        String outputString ="";

        for (int i = 0; i < infix.length(); i++) {
            //nextToken
            char t = infix.charAt(i);
 
            //if between 0 and 9 append to outputString
            if (t >= 48 && t <= 57) {
            	sb.append(t);
//                outputString += t;
            } else if (t == '(') {
                stack.push(t);
            } else if (t == '*' || t == '+' || t == '-' || t == '/') {
                if (stack.isEmpty()) {
                    stack.push(t);
                } else {
                    //if top has higher precedence
                    while (stack.getSize()>0) {
                        if ((t == '-' || t == '+') && (stack.top() == '/' || stack.top() == '*')) {
                            //pop & append top output
//                            outputString += stack.pop();
                            sb.append(stack.pop().getData());
                        }else{
                        	break;
                        }  
                    }
                    stack.push(t);
                }
            } else if (t == ')') {
                while (!stack.isEmpty() && stack.top() != '(') {
//                    outputString += stack.pop();
                    sb.append(stack.pop().getData());
                }
                stack.pop();//popping out the left brace
            }
        }
        //if there is any input in the Stack - pop & append to output String
        while (stack.getSize() >= 1) {
            sb.append(stack.pop().getData());
        }
        outputString = sb.toString();
        return outputString;
    }

    public int evaluate(String inputString) throws Underflow {
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < inputString.length(); i++) {
            //nextToken
            //String t = String.valueOf(inputString.charAt(i));
            char t = inputString.charAt(i);

            if (t >= 48 && t <= 57) {
                stack.push(t);
                //42*  43+  45-  47 /
            } else if (t == '*' || t == '-' || t == '/' || t == '+') {
                try {
                    int rhs = (int) (stack.pop() - 48);
                    int lhs = (int) (stack.pop()- 48);

                    int result = 0;
                    switch (t) {
                        case 42:
                            result = lhs * rhs;
                            break;
                        case 43:
                            result = lhs + rhs;
                            break;
                        case 45:
                            result = lhs - rhs;
                            break;
                        case 47:
                            result = lhs / rhs;
                            break;
                    }
                    stack.push((char) (result + 48));

                } catch (Exception e) { System.out.println("Error");
                }
            }
        }
        int finalResult = ((int) (stack.pop()) - 48);
        return finalResult;
    }
}
