package day02;

public class OverloadTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//add(1.1F, 2.2f);
		
		add(11d, 22d);
	}
	
	public static void add(int i, int j) {
		System.out.println("public static void add(int " +i+", int "+j+")="+(i+j));
		
	}
	protected static void add(long i, long j) {
		System.out.println("public static void add(long " +i+", long "+j+")="+(i+j));
	}
	protected static void add(Double i, Double j) {
		System.out.println("public static void add(Double " +i+", Double "+j+")="+(i+j));
	}
}
