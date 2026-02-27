package com.ssafy.day05.b_interface;

public class IronmanTest {
	
	public static void main(String[] args) {
	    IronMan iman = new IronMan();
	    Object obj = iman;
	    Heroable h = iman;
	    Transformable t = iman;
	    Fightable f = iman;
	}
}
