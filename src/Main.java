import java.util.Scanner;

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

    public static void main(String[] args) throws Underflow, WrongInputFormatException {
        System.out.println(stack.isEmpty());

        stack.push("String 1");
        stack.push(2);
        stack.push("String 3");

        System.out.println(postfix.infixToPostfix("1+2"));
        System.out.println(postfix.evaluate(postfix.infixToPostfix("(2*(6-5)+1*9+1)/6")));

        calculator();

    }

    private static void calculator() throws Underflow, WrongInputFormatException {
        System.out.println("//******The Great Calculator*******\\");
        System.out.println("please enter in infix Format:, write quit to quit");

        String inputString = "";
        while (!inputString.equals("quit")) {
            Scanner reader = new Scanner(System.in);
            inputString = reader.nextLine();
            System.out.println(postfix.evaluate(postfix.infixToPostfix(inputString)));
            reader.close();
        }
        
    }
}
