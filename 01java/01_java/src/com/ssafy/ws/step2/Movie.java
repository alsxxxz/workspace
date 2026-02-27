package com.ssafy.ws.step2;


final public class Movie {
	//Movie class에 외부에서 필드값을 바꾸지 못하게 접근 지정자 설정

	int id;
	String title;
	String Director;
	String genre;
	int runningTime;
	//기본 생성자
	public Movie(){
	}
	
	public Movie(int id, String title, String Director,String genre,int runningTime )
	{
		this.id = id;
		this.title  = title;
		this.Director = Director;
		this.genre = genre;
		this.runningTime = runningTime;	
	}
	//Getter 메서드들
	public int getid() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getDirector() {
		return Director;
	}
	public String getGenre() {
		return genre;
	}
	public int getrunningTime() {
		return runningTime;
	}
	
	
	//Setter 메서드들
	public void setId(int id) {
		this.id = id;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setDirector(String Director){
		this.Director = Director;
	}
	public void setGenre(String genre){
		this.genre = genre;
	}
	public void setrunningTime(int runningTime){
		this.runningTime = runningTime;
	}

	//Movie Class에 영화 정보를 문자열로 반환하는 toString 메소드 생성
	public String toString() {
		return " Movie" + id + "|"+ title + "|"+ Director + "|" + genre + "|"+ runningTime;
	}
	
}
