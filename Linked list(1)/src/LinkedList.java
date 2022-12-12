import java.util.ListIterator;

public class LinkedList implements ListIterator{
	public Node head = null;
	public Node tail = null;


	public void add(String element) {
		Node newNode = new Node(element,null,null);
		if (head == null) {

			head = tail = newNode;
			head.previous = null;
			tail.next = null;
		}
		else {
			tail.next = newNode;
			newNode.previous = tail;
			tail = newNode;
			tail.next = null;
		}

	}

	public void add(int index, String element) {
		if(index <= size() && index >=0) {
			Node node = head;
			Node newNode = new Node(element, null, null);

			int i = 0;
			while (i < index-1) {
				i++;
				node = node.next;
			}

			if (index == 0) {
				if (head == null) {
					head = newNode;
				}
				else {
					newNode.next = head;
					head.previous = newNode;
					head = newNode;
				}
			}

			else if(index == size()){
				if (tail == null) {
					tail = newNode;
					tail.previous = node;
					tail.previous.next = newNode;
				}
				else {
					tail.next = newNode;
					newNode.previous = tail;
					tail = newNode;
					tail.next = null;
				}
			}
			else {
				//pointers for the new node
				newNode.next = node.next;
				newNode.previous = node;

				//pointers for nodes around new node
				newNode.next.previous = newNode;
				newNode.previous.next = newNode;
			}
		}
		else {
			throw new IndexOutOfBoundsException();
		}
	}

	public int size() {


		int i = 1;
		if (head == null ) {
			return 0;
		}
		Node node = head;
		while (node.next != null) {
			i++;
			node = node.next;
		}
		return i;
	}

	public String get(int index) {
		Node node = head;

		if(index >= 0) {
			int i = 0;
			while (i < index) {
				i++;
				node = node.next;
			}
			return node.value;
		}
		else {
			return null;
		}
	}

	public void remove(int index) {
		Node node = head;
		int i = 0;
		while (i < index) {
			i++;
			node = node.next;
		}


		//makes the previous node's pointer refer to the next node 
		if (node == head) {
			node.next.previous = null;
			head = node.next;
		}
		else {
			node.previous.next = node.next;
		}
		//makes the next node's pointer refer to the previous node
		if (node.next == null) {
			node.previous.next = null;
			tail = node.previous;
		}
		else {
			node.next.previous = node.previous;
		}

	}

	public void set(int index, String element) {
		Node node = head;
		int i = 0;
		while (i < index) {
			i++;
			node = node.next;
		}
		
		node.value = element;

	}	

	public void clear() {
		Node node = head;
		int i = 0;


		while (i < size()) {
			i++;
			remove(i);

		}

		head = null;
		tail = null;
	}

	public String toString() {
		if (head == null){
			return "[]";
		}

		else if (head.next != null) {
			Node node = head.next;
			String output =  "[" + head.value;

			while (node.next != null) {
				output = output + ", " + node.value;
				node = node.next;
			}

			output = output + ", " + tail.value + "]";

			return output;	
		}

		else {
			if (head.value == null) {
				return "[]";
			}
			else {
				return "[" + head.value + "]";
			}
		}
	}

	
	
	public ListIterator listIterator() {
		Node current = head;
//		return current;
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String next() {
		
//		return node.value;
	}

	@Override
	public boolean hasPrevious() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String previous() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int nextIndex() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int previousIndex() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void set(Object e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void add(Object e) {
		// TODO Auto-generated method stub
		
	}
}
