package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.DataInputStream;
public class getData {
	//get data from the console
	private static BufferedReader BR = 
		new BufferedReader(new InputStreamReader(System.in));
	private getData() {
	
	}
	public static String getString() {
		String result = null;
		try {
			result = BR.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public static int getInt() {
		return Integer.valueOf(getString());
	}
	public static double getDouble() {
		return Double.valueOf(getString());
	}
	
}


class ScannerREAD{
	private static String readLine(){
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}
	public static String getLine(){
		String s = readLine();
		return s;
	}
	private static int readInt(){
		Scanner scanner = new Scanner(System.in);
		return scanner.nextInt();
	}
	public static int getInt(){
	    int  i = readInt();
		return i;
	}
	private static double readDouble(){
		Scanner scanner = new Scanner(System.in);
		return scanner.nextDouble();
	}
	public static double getDouble(){
		double d = readDouble();
		return d;
	}
}



class ReadType {
	public static BufferedReader BR;
	public static DataInputStream DIS;
	static{
		BR = new BufferedReader(new InputStreamReader(System.in));
		DIS  = new DataInputStream(System.in);
	}
	private ReadType() {}
	public static String Read() throws IOException {
		return BR.readLine();
	}
	
	public static double getDouble() throws IOException {
		return DIS.readDouble();
	}
	
	public static char getChar() throws IOException {
		return DIS.readChar();
	}
	
	public static String getUTF() throws IOException {
		return DIS.readUTF();
	}
	
	public static int getInt() throws IOException {
		return DIS.readInt();
	}
}

