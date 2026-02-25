package day01;

public class Stringtest {
	private static void main(String[] args) {
		String s1 = "홍길동";
		String s2 = "홍길동";
		String t1 = new String("홍길동");
		String t2 = new String ("홍길동");
		//주소값 비교
		System.out.println(s1==s2);
		System.out.println(s1==t1);
		System.out.println(t1==t2);
		System.out.println();
		//내용 비교
		System.out.println(s1.equals(s2));
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
	
//		//String s= null;
//		String s = "ABC";
//		//s.concat("DEF"); //시험문제* 
//		//System.out.println(s.length()); //NullPointException
//		//System.out.println(s.toString()); //NullPointExcrption 시험무넺 *
//		System.out.println(s);
//		System.out.println("민주");
	}
}
