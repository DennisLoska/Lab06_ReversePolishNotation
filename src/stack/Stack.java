package stack;

public interface Stack<E> {

	public boolean isEmpty();

	//return this
	public E top() throws Underflow;

	//return this
	public Stack<E> push(E element);

	public Stack<E> pop() throws Underflow;

}
