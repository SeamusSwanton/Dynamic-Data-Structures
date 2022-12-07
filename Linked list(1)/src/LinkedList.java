
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
//			Node newNode = new Node(element, newNode, newNode);

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
//			node.previous.next = null;
		}
		else {
			node.previous.next = node.next;
		}
		//makes the next node's pointer refer to the previous node
		if (node.next == null) {
			node.next.previous = null;
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
		Node node = head.next;
		String output =  "[" + head.value;

		while (node.next != null) {
			output = output + ", " + node.value;
			node = node.next;
		}
		
		output = output + ", " + tail.value + "]";
		
		return output;	
	}
}
