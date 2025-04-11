package datastructures;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import sorting.Way;

public class Graph<T> {
	public final static int m = 1024*1024;
	private int[][] data;
	private Object[] value;
	private int n;
	public Graph(int[][] d,Object[] v) {
		data = d;
		value = v;
		n = d.length;
	}
	
	public void traverse(List<T> l) {
		boolean[] v = new boolean[n];
		int i;
		for(i = 0;i<n;i++) if(!v[i]) dfs(l,v,i);
	}
	@SuppressWarnings("unchecked")
	private void dfs(List<T> l,boolean[] v,int i) {
		v[i] = true;
		l.add((T)value[i]);
		int j;
		for(j = 0;j<n;j++) if((!v[j])&&((data[i][j]!=0))&&(data[i][j]<m)){
			dfs(l,v,j);
		}
	}
	
	public int[][] FloyedWarshall() {
		int[][] distance = data;
		int i,j,k;
		for(k = 0;k<n;k++)
			for(i = 0;i<n;i++)
				for(j = 0;j<n;j++)
					if((distance[i][j]>distance[i][k]+distance[k][j]))
						distance[i][j] = distance[i][k]+distance[k][j];
		return distance;
	}
	public int Dijkstra(int s,int e) {
		int[] c = data[s];
		boolean[] b = new boolean[n];
		int i,min,k,j;
		for(i = 0;i<n-1;i++) {
			//fictionalize a point
			min = m;
			k = -1;
			for(j = 0;j<n;j++) if((!b[j])&&c[j]<min) {
				min = c[j];
				k = j;
			}
			if(k==-1) break;
			b[k] = true;
			for(j = 0;j<n;j++) 
				if(c[k]+data[k][j]<c[j]) c[j] = c[k]+data[k][j];
		}
		return c[e];
	}
	
	public int[] Prim() {
		int[] r = new int[n];
		int i,k,j;
		int[] c = new int[n];
		for(i = 0;i<n;i++) c[i] = m;
		c[0] = 0;
		boolean[] b = new boolean[n];
		for(i = 0;i<n;i++) {
			k = 0;
			while(b[k]) k++;
			for(j = 0;j<n;j++) if((!b[j])&&(c[j]<c[k])) k = j;
			b[k] = true;
			r[i] = k;
			for(j = 0;j<n;j++) if((!b[j])&&(c[j]>data[k][j])) c[j] = data[k][j];
		}
		return r;
	}
	/* union-find set 
	 * 三大操作 Make Union Find
	 * 是定义在所有元素之上的一个分划 
	 * 动态合并不同集合 
	 */
	private int[] father;
	private int sf(int k) {
		int r;
		if(father[k]==k){
			r = k;
		}else{
			r = sf(father[k]);
		}
		return r;
	}
	private int union(int x,int y){
		int a = sf(x);
		int b = sf(y);
		father[a] = b;
		return b;
	}
	private boolean ifSame(int x,int y){
		int a = sf(x);
		int b = sf(y);
		if(a==b) return true;
		return false;
	}
	public int[][] Kruskal() {
		father = new int[n];
		int[][] r = new int[n][2];
		int i,j,k,ei;
		for(i = 0;i<n;i++) father[i] = i;
		int[] edge = new int[n*n];
	
		for(i = 0;i<n;i++)
			for(j = 0;j<n;j++){
				edge[i*n+j] = m;
				if(j>=i) edge[i*n+j] = data[i][j];
			}
		ei = 0;
		k = 0;
		boolean f;
		Way.quicksort(edge, 0, n*n-1);
		while(k<n) {
			f = true;
			for(i = 0;i<n;i++) {
				for(j = 0;j<n;j++) {
					if( (data[i][j]==edge[ei])&&f ){
						ei++;
						if(ifSame(i,j)) continue;
						union(i,j);
						r[k][0] = i;
						r[k][1] = j;
						f = false;
					}
				}
			}
			k++;
		}
		return r;
	}
	
	public static void main(String[] args) {
		int[][] d = {
			{0,1,1},
			{0,0,1},
			{0,1,0}
		};
		int i,j;
		Integer[] I = {8,6,7};
		Graph<Integer> G = new Graph<Integer>(d,I);
		List<Integer> l = new ArrayList<Integer>();
		G.traverse(l);
		Iterator<Integer> it = l.iterator();
		for(;it.hasNext();) System.out.println(it.next());
		
		int[][] d2 = {
			{Graph.m,5,8,Graph.m,3},
			{5,Graph.m,2,Graph.m,6},
			{8,2,Graph.m,10,4},
			{Graph.m,Graph.m,10,Graph.m,11},
			{3,6,4,11,Graph.m}
		};
		Integer[] I2 = {1,2,3,4,5};
		Graph<Integer> G2 = new Graph<Integer>(d2,I2);
		/*
		int[][] dis = G2.FloyedWarshall();
		for(i = 0;i<d2.length;i++) {
			for(j = 0;j<d2.length;j++) System.out.print(dis[i][j]+" ");
			System.out.println();
		}
		for(i = 0;i<d2.length;i++) {
			for(j = 0;j<d2.length;j++) System.out.print(G2.Dijkstra(i, j)+" ");
			System.out.println();
		}
		*/
		int[] a = G2.Prim();
		for(i = 0;i<a.length;i++) System.out.print(a[i]+" ");
		System.out.println();
		int[][] b = G2.Kruskal();
		for(i = 0;i<b.length;i++) System.out.println(b[i][0]+" "+b[i][1]);
	}
}
