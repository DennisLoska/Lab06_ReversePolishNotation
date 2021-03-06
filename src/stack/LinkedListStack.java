package stack;

public class LinkedListStack<E> implements Stack<E> {

	private Node<E> head = null;
	private int size = 0;

	public int getSize() {
		return size;
	}

	@Override
	public String toString() {
		String result;
		StringBuilder sb = new StringBuilder();
		
		if (!this.isEmpty()){
			sb.append(head.getData());
			Node<E> nextNode = head.getNext();
			while(nextNode != null){
				sb.append(", " + nextNode.getData());
				nextNode = nextNode.getNext();
			}
		}

		result = sb.toString();
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
