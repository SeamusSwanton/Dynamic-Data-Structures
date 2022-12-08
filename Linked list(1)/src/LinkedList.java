
public class LinkedList {
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

			//pointers for the new node
			newNode.next = node.next;
			newNode.previous = node;

			//pointers for nodes around new node
			newNode.next.previous = newNode;
			newNode.previous.next = newNode;
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

		node.value = null;
		//makes the previous node's pointer refer to the next node 
		if (node.previous == null) {
			node.next.previous = null;
			head = node.next;
		}
		else {
			node.previous.next = node.next;
		}
		//makes the next node's pointer refer to the previous node
		if (node.next == null) {
			node.previous.next = null;
			tail = node.next;
		}
		else {
			node.next.previous = node.previous;
		}

	}

	public void set(int index, String element) {
		// TODO Auto-generated method stub

	}	

	public void clear() {
		// TODO Auto-generated method stub
	}

	public String toString() {
		if (head.next != null) {
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
			return "[" + head.value + "]";
		}
	}
}
