package sorting;

import java.io.IOException;

import datastructures.Heap; 

public class Way {
	//asc
	public static int i;
	public static int j;
	public static void main(String[] args) throws IOException {
		int n = getData.getInt();
		int[] a = new int[n];
		for(i = 0;i<n;i++) a[i] = getData.getInt();
		sort(a,6);
		for(i = 0;i<n;i++) System.out.print(a[i]+" ");
	}
	public static void sort(int[] a,int type) {
		switch (type) {
			case 0:
				choosesort(a);
				break;
			case 1:
				bubblesort(a);
				break;
			case 2:
				insertsort(a);
				break;
			case 3:
				countsort(a);
				break;
			case 4:
				quicksort(a,0,a.length-1);
				break;
			case 5:
				mergesort(a,0,a.length-1);
				break;
			case 6:
				heapsort(a);
				break;
		}
	}
	public static void choosesort(int[] a) {
		int n = a.length;
		int t;
		//-> can proof this -1
		for(i = 0;i<n-1;i++) 
			for(j = i+1;j<n;j++) 
				if(a[i]>a[j]) {
					t = a[i];
					a[i] = a[j];
					a[j] = t;
				}
	}
	public static void bubblesort(int[] a) {
		int n = a.length;
		int t;
		//<- i represents how many elements have been sorted
		for(i = 0;i<n-1;i++)
			for(j = 0;j<n-i-1;j++)
				if(a[j]>a[j+1]) {
					//if no change is conducted we can break
					t = a[j];
					a[j] = a[j+1];
					a[j+1] = t;					
				}
		
	}
	public static void insertsort(int[] a) {
		int n = a.length;
		int t;
		for(i = 1;i<n;i++) {
			// 0~i-1 comprises the sorted area
			j = i-1;
			t = a[i];
			while(t<a[j]){
				a[j+1] = a[j];
				j--;
			}
			//when the while is completed 
			//j points to the element who should be placed before t(or a[i])
			a[j+1] = t;
		}
	}
 	public static void countsort(int[] a) {
		int n = a.length;
		//means it can accept the numbers whose upperbound is 1024
		int[] s = new int[1024];
		for(i = 0;i<n;i++) s[a[i]]++;
		i = 0;//for s[i]
		j = 0;//for a[j]
		while(i<1024) {
			if(s[i]==0) {
				i++;
			}else{
				a[j++] = i;
				s[i]--;
			}
		}
		
	}
	public static void quicksort(int[] a,int l,int r) {
		if(l>=r) return;
		//choose a[r] as pivot
		i = l;
		j = r-1;
		int t;
		while(i<=j) {
			// the first element whose value is not smaller(larger) than pivot
			while((i<=j)&&(a[i]<a[r])) i++;
			while((i<=j)&&(a[j]>a[r])) j--;
			if(i<=j) {
				t = a[i];
				a[i++] = a[j];
				a[j--] = t;//for example 1 6 8 6 6
			}
		}
		// different from above (<=)(!=>)!
		t = a[i];
		a[i] = a[r];
		a[r] = t;
		quicksort(a,l,i-1);
		quicksort(a,i+1,r);
	}
	public static void mergesort(int[] a,int l,int r) {
		//  .   .   .  
		//  m-1 m   m+1
		if(l>=r) return;
		int m = (l+r)/2;
		mergesort(a,l,m);
		mergesort(a,m+1,r);
		int[] b = new int[r-l+1];// |_|_|
		int k = 0;
		i = l;
		j = m+1;
		//the cursor can go to m,r so +1
		while((i<m+1)&&(j<r+1)) if(a[i]<a[j]) {
			b[k++] = a[i++];
		}else{
			b[k++] = a[j++];
		}
		while(i<m+1) b[k++] = a[i++];
		while(j<r+1) b[k++] = a[j++];
		for(i = l;i<r+1;i++) a[i] = b[i-l];
 	}
	public static void heapsort(int[] a) {
		Heap h = new Heap(new int[1024]);
		for(i = 0;i<a.length;i++) h.insert(a[i]);
		for(i = 0;i<a.length;i++) a[i] = h.delete();
	}
}
