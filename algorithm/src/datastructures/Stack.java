package datastructures;

public class Stack<T> {
	private T[] data;
	private int Top;
	public Stack(T[] d) {
		//empty stack
		//the length have been already set  
		data = d;
		Top = -1;
	}
	public void Push(T t) {
		if(IsFull()){
			System.out.println("Full");
		}else{
			data[++Top] = t; 
		}
	}
	public T Pop() {
		T t;
		if(IsEmpty()){
			System.out.println("Empty");
			t = null;
		}else{
			t = data[Top];
			data[Top--] = null;
		}
		return t;
	}
	public T Top() {
		T t;
		if(IsEmpty()){
			System.out.println("Empty");
			t = null;
		}else{
			t = data[Top];
		}
		return t;
	}
	public boolean IsFull() {
		return (data.length-1==Top)?true:false;	
	}
	public boolean IsEmpty() {
		return (Top==-1)?true:false;
	}
}
