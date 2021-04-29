package rpncalc;

public class Queue<T> extends DLL<T> {
	final static int max = 100;
	
	public Queue() {Head = null; Tail = null;}
	
	public boolean empty() {
		return Head == null;
	}
	
	public boolean full() {
		return count == max;
	}
	
	public boolean enqueue(T data) {
		if(full())
			return false;
		addTE(data);
		return true;
	}
	
	public T dequeue() {
		if(empty())
			return null;
		T data = peek();
		deleteFront();
		
		return data;
	}
	
	public T peek() {
		return Head.Data;
	}
}