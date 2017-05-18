package stack;

public class Node<E> {

	private Node<E> next;
	private Node<E> last;
	private E data;
	
	public Node(E data) {
		this.data = data;
		next = null;
	}

	public Node<E> getNext() {
		return next;
	}

	public void setNext(Node<E> next) {
		this.next = next;
	}

	public E getData() {
		return data;
	}

	public Node<E> getLast() {
		return last;
	}

	public void setLast(Node<E> last) {
		this.last = last;
	}	

}
