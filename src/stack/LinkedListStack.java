package stack;

public class LinkedListStack<E> implements Stack<E> {

	private Node<E> head = null;
	// private Node<E> tail = null;
	private int size = 0;

	public int getSize() {
		return size;
	}

	@Override
	public String toString() {
		// StringBuilder sb = new StringBuilder();
		// for (int i = 0; i < this.size; i++){
		//// sb.append(head.getData())
		// sb.append(head.getData());
		// }
		// return sb.toString();

		StringBuilder sb = new StringBuilder();
		sb.append(head.getData());
		while (head.getNext() != null) {
			head = head.getNext();
			sb.append(head.getData());
		}
		String result = sb.toString();
		return result;
	}
	

	@Override
	public boolean isEmpty() {
		if (head != null) {
			return false;
		}
		return true;
	}

	@Override
	public E top() throws Underflow {
		return head.getData();
	}

	@Override
	public void push(E element) {
		if (this.isEmpty()) {
			Node<E> newHead = new Node<E>(element);
			head = newHead;
			size++;
		} else {
			Node<E> newHead = new Node<E>(element);
			newHead.setNext(head);
			head = newHead;
			// head.setNext(newHead);
			// newHead.setLast(head);
			// head = newHead;
			size++;
		}
	}

	@Override
	public Node<E> pop() throws Underflow {
		// TODO Auto-generated method stub
		if (size != 1)
		 head = head.getNext();
		size--;
		return head;
	}
}
