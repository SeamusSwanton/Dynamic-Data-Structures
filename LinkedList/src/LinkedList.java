
public class LinkedList {

public Node head = null;
public Node tail = null;
	
	
	public void add(String element) {
		Node newNode = new Node(element,null,null);
		if (head == null) {
			 
			 head = tail = newNode;
		}
		else {
			tail.next = newNode;
			newNode.previous = tail;
			
		}
		
	}

	public void add(int index, String element) {
//		Node newNode = new Node(element, newNode, newNode);
		
	}

	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String get(int index) {
		
		return null;
	}

	public void remove(int index) {
		// TODO Auto-generated method stub
		
	}
		
	public void set(int index, String element) {
		// TODO Auto-generated method stub
		
	}	

	public void clear() {
		// TODO Auto-generated method stub
		
	}

}
