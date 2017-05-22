package stack;

public class LinkedListStack<E> implements Stack<E> {

	private Node<E> head = null;
	private int size = 0;

	public int getSize() {
		return size;
	}

	@Override
	public String toString() {
		String result = "";

		try {
			if (this.isEmpty()) {
				throw new Underflow();
			} else {
				StringBuilder sb = new StringBuilder();
				sb.append(head.getData());
				while (head.getNext() != null) {
					head = head.getNext();
					sb.append(", " + head.getData());
				}
				result = sb.toString();
			}
			// return result;
		} catch (Underflow e) {
			System.out.println("The Stack is empty!");
		}
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
		if (this.isEmpty()) {
			throw new Underflow();
		} else {
			return head.getData();
		}
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
			size++;
		}
	}

	@Override
	public Node<E> pop() throws Underflow {
		if (this.isEmpty()) {
			throw new Underflow();
		}
		Node<E> nodeToPop = head;
		head = head.getNext();
		size--;

		return nodeToPop;
	}
}
