package day08;


class MyException extends Exception{
	
}
public class ExceptionTest {
    public static void main(String[] args) {
        System.out.println("start");
        try {
	        String s = null; //NullPointException >이거 암기
	        //String s -> 이거 시험문제..a
	        System.out.println(s.length()); //> 얘 주석처리하면 잘 됨
	//        //start
	//        Exception in thread "main" java.lang.NullPointerException: Cannot invoke "String.length()" because "s" is null
	//    	at day08.ExceptionTest.main(ExceptionTest.java:8)
	        int i = 10/0; //ArithmeticExcption : Exception in thread "main" java.lang.ArithmeticException: / by zero
	        //이거 unchecked excpetion
	        
	        //체크 예외 1.try~catch~finally 2. throws
	        //	System.in.read();
	        System.out.println("여기는 출력하고 싶다!");
        }catch(NullPointerException e) {
        	System.out.println("NullPointException" + e.getMessage());
        }catch(ArithmeticExcption e) {
        	System.out.println("ArithmeticExcption" + e.getMessage());
        }
        		System.out.println("end");
        
        
    }
}