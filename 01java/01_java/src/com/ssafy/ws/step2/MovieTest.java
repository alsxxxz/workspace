package com.ssafy.ws.step2;

public class MovieTest {

	public static void main(String[] args) {
		//1.영화 두개생성
		//매니저 생성 및 영화출력
		//제목으로 영화 검색
	
		Movie movie1 = new Movie(1, "인셉션", "크리스토퍼", "SF", 120);
		Movie movie2 =  new Movie(2, "인터스텔라", "놀란", "SF", 100);
		// System.out.println(movie1);
		// System.out.println(movie2);

		MovieManager manager = new MovieManager();
		manager.add(movie1);
		manager.add(movie2);

		Movie[] list= manager.getList();
		for (Movie movie : list) {
			System.out.println(movie);
		}
		System.out.println();
		//영화검색
		System.err.println("영화 검색 단계");
		
		Movie found = manager.searchByTitle("인셉션");
		if (found != null){
			System.out.println("검색결과" + found);} else {
				System.out.println("없음");
			}
	


	}
}
