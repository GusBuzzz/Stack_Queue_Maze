
public class QueueL<T> {

	// Attributes *****************************************************************
	private Node<T> head;
	private Node<T> tail;	
	private int size;
	
    // Constructors ****************************************************************
	public QueueL() {}
	
	public QueueL(Node<T> N) {
		head = N;
		tail = N;
		size = 1;
	}

	// Getters and Setters *********************************************************
	/**
	 * @return the head
	 */
	public Node<T> getHead() {
		return head;
	}

	/**
	 * @param head the head to set
	 */
	public void setHead(Node<T> head) {
		this.head = head;
	}

	/**
	 * @return the tail
	 */
	public Node<T> getTail() {
		return tail;
	}

	/**
	 * @param tail the tail to set
	 */
	public void setTail(Node<T> tail) {
		this.tail = tail;
	}

	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}

	// Other methods, specific to Stacks *******************************************
	// peek, dequeue, enqueue, isEmpty
	
	/**
     * TODO 1.2.1: Complete the body of the method below
	 * This method returns the head of the queue and leaves it in the queue.
	 * @return
	 */
	public Node<T> peek() {
        // YOUR CODE GOES HERE
		return head;
    }
	
	/**
     * TODO 1.2.2: Complete the body of the method below
	 * This method removes and returns the head if the queue is not empty.
	 */
	public Node<T> dequeue() {
        // YOUR CODE GOES HERE
		if(isEmpty()){
			return null;
		}
		else {
			Node<T> temp = head;
			if(size == 1){
				head = null;
				tail = null;
				size = 0;
			}
			else {
				head = head.getNext();
				size--;
			}
			return temp;
		}
	}
	
	/**
     * TODO 1.2.3: Complete the body of the method below
	 * This methods adds a node that contains data at the end of the queue.
	 * @param data
	 */
	public void enqueue(T data) {
        // YOUR CODE GOES HERE
		if(isEmpty()){
			Node<T> newElement = new Node<T>(data);
			head = newElement;
			tail = newElement;
			size = 1;
		}
		else {
			Node<T> newElement = new Node<T>(data);
			tail.setNext(newElement);
			tail = newElement;
			size++;
		}
	}
	
	/**
     * TODO 1.2.4: Complete the body of the method below
	 * This method returns true if the queue is empty, false otherwise
	 * @return
	 */
	public boolean isEmpty() {
        // YOUR CODE GOES HERE
		if(head == null){
			return true;
		}
		else {
			return false;
		}
	}

}
