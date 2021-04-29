package rpncalc;

class Node<T> {
	T Data;
	Node<T> Next;
	Node<T> Prev;
	
	Node(T data) {Data = data; Next = null; Prev = null;}
	Node(T data, Node<T> n, Node<T> p) {Data = data; Next = n; Prev = p;}
}

public class DLL<T> {
	Node<T> Head, Tail;
	int count = 0;
	DLL() {Head = null; Tail = null; count = 0;}
	
	public void addTF(T data) {
		if(Head == null) {
			Head = new Node<T>(data);
			Head.Next = null;
			Head.Prev = null;
		} else {
			Node<T> node = new Node<T>(data);
			node.Next = Head;
			node.Prev = null;
			Head.Prev = node;
			Head = node;
		}
		count++;
	}
	
	public void addTE(T data) {
		if(Head == null) {
			Head = new Node<T>(data);
			Head.Next = null;
			Head.Prev = null;
		} else {
			Node<T> ptr = Head;
			while(ptr.Next != null) {
				ptr = ptr.Next;
			}
			Node<T> node = new Node<T>(data);
			node.Prev = ptr;
			node.Next = null;
			ptr.Next = node;
			Tail = node;
		}
		count++;
	}
	
	public void insertBefore(T search, T data) {
		Node<T> ptr = Head;
		if(ptr.Data.equals(search)) {
			addTF(data);
		} else {
			while(!ptr.Data.equals(search)) {
				ptr = ptr.Next;
			}
			Node<T> node = new Node<T>(data);
			node.Next = ptr;
			node.Prev = ptr.Prev;
			ptr.Prev = node;
			node.Prev.Next = node;
			
			count++;
		}
	}
	
	public void insertAfter(T search, T data) {
		Node<T> ptr = Head;
		while(!ptr.Data.equals(search)) {
			ptr = ptr.Next;
			if(ptr.Next == null)
				break;
		}
		if(ptr.Next == null)
			addTE(data);
		else {
			Node<T> node = new Node<T>(data);
			node.Next = ptr.Next;
			node.Prev = ptr;
			ptr.Next = node;
			node.Next.Prev = node;
			
			count++;
		}
	}
	
	public void deleteFront() {
		if(this.count == 1) {
			Head = Tail;
			Head.Next = Tail;
		} else {
			Head = Head.Next;
			Head.Prev.Next = null;
			Head.Prev = null;
		}
		count--;
	}

	public void deleteEnd() {
		if(this.count == 1) {
			Head = Tail;
			Head.Next = null;
		} else {
			Tail = Tail.Prev;
			Tail.Next.Prev = null;
			Tail.Next = null;
		}
		count--;
	}
	
	public void delete(T search) {
		Node<T> ptr = Head;
		if(ptr.Data.equals(search))
			deleteFront();
		else {
			while(!ptr.Next.Data.equals(search)) {
				ptr = ptr.Next;
			}
			if(ptr.Next == Tail)
				deleteEnd();
			else {
				ptr.Next = ptr.Next.Next;
				ptr.Next.Prev = ptr;
				
				count--;
			}
		}
	}
	
	public T find(T search) {
		Node<T> ptr = Head;
		while(ptr != null) {
			if(ptr.Data.equals(search))
				return ptr.Data;
			ptr = ptr.Next;
		}
		return null;
	}
	
	public void printF() {
		Node<T> ptr = Head;
		while(ptr != null){
			System.out.println(ptr.Data);
			ptr = ptr.Next;
		}
	}
	
	public void printB() {
		Node<T> ptr = Tail;
		while(ptr != null) {
			System.out.println(ptr.Data);
			ptr = ptr.Prev;
		}
	}
	
	public int size() {
		return count;
	}
}