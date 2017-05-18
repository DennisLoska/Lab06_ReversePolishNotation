package stack;

public interface Stack<E> {

	public boolean isEmpty();

	//return this
	public E top() throws Underflow;

	//return this
	public void push(E element);

	public Node<E> pop() throws Underflow;

}
