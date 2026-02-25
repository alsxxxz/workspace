package day07;

class Book implements Comparable<Book>{
    ////Comparable<Book> 적어둔 다음에 정렬하고 싶으면 람다소트 파일
    String isbn;
    String title;
    int price;

    public Book(String isbn, String title, int price) {
        this.isbn = isbn; this.title = title; this.price = price;
    }

    @Override
    public String toString() {
        return isbn + "/" + title + "/" + price;
    }

	@Override //이게 생김
	public int compareTo(Book o) {
		// TODO Auto-generated method stub
		return isbn.compareTo(o.isbn); //시험문제**
		//return -isbn.compareTo(o.isbn); //오름차순 내림차순 -isbn.
		
		//return Integer.compare(price, o.price); //오름차순
		//return -Integer.compare(price, o.price);
		
		//compare은 기본형, compareto는 나머지 형!
		//기본적으로 오름차순. 두개만 기억하기
	}
}

