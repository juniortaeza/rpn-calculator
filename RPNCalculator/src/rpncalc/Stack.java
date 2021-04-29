package rpncalc;

public class Stack<T> extends DLL<T> {
	final static int max = 100;
	
	public Stack() {Head = null; Tail = null;}
	
	public boolean empty() {
		return Head == null;
	}
	
	public boolean full() {
		return count == max;
	}
	
	public boolean push(T data) {
		if(full())
			return false;
		addTE(data);
		return true;
	}
	
	public T pop() {
		if(empty())
			return null;
		T data = peek();
		deleteEnd();
		
		return data;
	}

	public T peek() {
		return Tail.Data;
	}
}
