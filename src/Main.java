import postfix.Postfix;
import postfix.WrongInputFormatException;
import stack.LinkedListStack;
import stack.Underflow;

/**
 * Created by Dennis on 16.05.2017.
 */
public class Main {

	private static LinkedListStack<Object> stack = new LinkedListStack<Object>();
	private static Postfix postfix = new Postfix();

	public static void main(String[] args) throws Underflow {
		System.out.println(stack.isEmpty());

		stack.push("String 1");
		stack.push(2);
		stack.push("String 3");
		
		try {
			System.out.println(postfix.infixToPostfix("1+2"));
		} catch (WrongInputFormatException e) {
			e.printStackTrace();
		}
		
//		stack.pop();
//		stack.pop();
		
//		System.out.println(stack.top());
		//System.out.println(stack.toString());

	}
}
