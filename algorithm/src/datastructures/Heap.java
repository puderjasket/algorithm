package datastructures;

public class Heap {
	//asc int
	private int[] data;
	private int size;
	public Heap(int[] d) {
		data = d;
		size = 0;
		d[size] = -1024;
	}
	public void insert(int d) {
		int i;
		int t;
		data[i=++size] = d;
		while(data[i]<data[i/2]){
			t = data[i];
			data[i] = data[i/2];
			data[i/2] = t;
			i /= 2;
		}
	}
	public int delete() {
		int i;
		int t;
		t = data[size];
		data[size] = data[1];
		data[1] = t;
		i = 1;
		while( ( (data[i]>data[2*i])||(data[i]>data[2*i+1]) )&&(i<size)&&(2*i<size)&&(2*i+1<size) ){
			if(data[2*i]<=data[2*i+1]) {
				t = data[i];
				data[i] = data[2*i];
				data[2*i] = t;
				i *= 2;
			}else {
				t = data[i];
				data[i] = data[2*i+1];
				data[2*i+1] = t;
				i = 2*i+1;
			}
		}
		if((2*i<size)&&(2*i+1>=size)) {
			if(data[i]>data[2*i]) {
				t = data[i];
				data[i] = data[2*i];
				data[2*i] = t;
				i *= 2;
			}
		}
		return data[size--];
	}
}