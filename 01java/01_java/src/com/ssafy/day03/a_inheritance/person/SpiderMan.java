package com.ssafy.day03.a_inheritance.person;

public class SpiderMan extends Person{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Spider spider;
		boolean isSpider = true;
		public SpiderMan(Spider spider, boolean isSpider)
		{
			this.spider = spider;
			this.isSpider = isSpider;
					
		}
		void fireWeb() {
			if(this.isSpider) {
			spider.fireWeb();
			else {
				System.out.println("ㄴㄴ");	}
			}
		//재정의
		void jump() {
			if(this.isSpider) {
				spider.jump();
				
			}else {
				System.out.println("폴짝");
			}
			
		}
		
	}

}
