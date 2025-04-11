package datastructures;

public class Queue<T> {
	private T[] data;
	private int Front;
	private int Rear;
	public Queue(T[] d) {
		data = d;
		Front = -1;// !_|_|
		Rear = -1;// |_!
	}
	public void Enqueue(T t) {
		if(IsFull()) {
			System.out.println("Full");
		}else{
			data[++Rear] = t;
		}
	}
	public T Dequeue() {
		T t;
		if(IsEmpty()) {
			System.out.println("Empty");
			t = null;
		}else{
			t = data[Front+1];
			data[++Front] = null;
		}
		return t;
	}
	public boolean IsFull() {
		return (data.length-1==Rear)?true:false;	
	}
	public boolean IsEmpty() {
		return (Front==Rear)?true:false;
	}
}
