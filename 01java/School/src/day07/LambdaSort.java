package day07;

import java.util.*;

public class LambdaSort {
	public static void main(String[] args) {
		Book[] ba = {
				new Book("123", "자바", 2000),
				new Book("123", "알고", 2000),
				new Book("123", "가곡", 2000)
		};
		System.out.println(Arrays.toString(ba));
		Arrays.sort(ba);
		System.out.println(Arrays.toString(ba));
		
		//제목을 기준으로 정렬하고 싶은 경우************
		Arrays.sort(ba,(a,b)->a.title.compareTo(b.title));
		//Arrays.sort(ba,(a,b)->-a.title.compareTo(b.title));//내림차순

		////Price로 정렬하고 싶다면***********************
		///
		//Arrays. sort(ba, (a,b)->a.title. compareTo(b. title) ) ;//ja
		Arrays.sort(ba, (a,b)->Integer. compare(a.price,b.price));
		////
		System.out.println(Arrays.toString(ba));
		System.out.println();
		
		
		List<Book> bl = new ArrayList<>();
		bl.add(new Book("123", "자바", 2000));
	    bl.add(	new Book("123", "알고", 2000));
		bl.add(	new Book("123", "가곡", 2000));
		System.out.println(bl);
		Collections.sort(bl);
		System.out.println();
		bl.add(new Book("777", "자바", 1500));
		Collections.sort(bl,(a,b) ->a.title.compareTo(b.title)==0?
				Integer.compare(a.price, b.price):a.title.compareTo(b.title));
		System.out.println(bl);
		}
}