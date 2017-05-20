package postfix;

public class WrongInputFormatException extends Exception {
	
	WrongInputFormatException(){
		super("Please change the input to a different Format");
	}
}
