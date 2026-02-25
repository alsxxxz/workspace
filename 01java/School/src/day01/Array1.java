package day01;

import java.io.IOException;
import java.util.Arrays;

//public class Array1 {
//	public static void main(String[] args)  {
//	//1선언	
//	//int [] ia;
//	//2생성
//	//ia = new int[3];
//	//1+2
//	//int[] ia=new int[3];
//	//3사용
//	//ia[-1] = -1;
////	ia[0] = 10;
////	ia[1] = 11;
////	ia[2]= 12; 
//	//System.out.println(ia);
//	
//	//배열만들때 주로 1 2 3 한꺼번에
//	int[] ia= {10,20,30};
//	System.out.println(Arrays.toString(ia));
//	System.out.println(ia.length);
//	for(int v:ia) System.out.println();
//	
//	}
//	
//}

public class Array1 {
	public static void main(String[] args)  {
	int [][] ia = {{3,3,3},{1,1,1},{2,2,2}};
	for(int[] a:ia) 
		{for(int v:a) {
			System.out.println(v+"  ");
		}
		
	System.out.println(Arrays.toString(a));}
}
}