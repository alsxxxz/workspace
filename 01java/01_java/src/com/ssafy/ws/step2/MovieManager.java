package com.ssafy.ws.step2;

/**
 * 영화리스트를 배열로 관리하는 클래스
 * 
 * @author
 *
 *///영화 리스트를 배열로관리할 Movie Manager class
public class MovieManager {
		//상수정의
		public static final int SIZE = 100;

		private Movie[] movieList; //영화보관함 100칸짜리 배열
		private int size; //현재 몇 개 들어있는지 세는 숫자

		//생성자
		public MovieManager(){
			movieList = new Movie[SIZE];
			size = 0; //아직 0개
		}
		//100개가 넘어가면 안 되니까 영화보관함 사이즈, 현재 보관숫자 정의 필요
	

	//영화정보를 등록하는 add 메소드
	public void add(Movie movie){

		//copy of기억하라고함. 이코드 중요
		if (size<SIZE) {
		movieList[size] = movie; // size번 칸에 영화 넣기
		size ++; //다음칸으로 이동
		}
	}

	//영화리스트를 반환하는 getList메소드
	public Movie[] getList(){
		Movie[] result = new Movie[size];
		for(int i=0; i<size; i++) {
			result[i] = movieList[i];

		}
		return result;
	}
	
	public Movie searchByTitle(String title){
		for(int i =0; i< size; i++) {
			if (movieList[i].getTitle().equals(title)){
				return movieList[i];
			}
		}
		
		return null;
	}
	
	//영화제목으로 영화정보를 반환하는 searchByTitle 메소드

}
