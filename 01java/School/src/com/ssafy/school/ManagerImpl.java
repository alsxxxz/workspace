package com.ssafy.school;

import java.util.Arrays;

public class ManagerImpl {
	private Person[] pa;
	private int index;
	
	
	
	private static ManagerImpl instance = new ManagerImpl();
	//1
	private ManagerImpl(int size) {
		pa = new Person[size];
		
	}
	private ManagerImpl() {
		this(10);
	}
	//3
	public static ManagerImpl getInstance() {
		return instance;
	}
	public void add (Person p) {
		pa[index ++]= p;
	}
	public Person[] search() {
		return Arrays.copyOf(pa, index);
	}
	public Person search(String name) {
		for(int i=0; i<index; i+=) {
			if(pa[i].getname().eauals(name)) {
				return pa[i];
			}
			return null;
		}
	public void update(Person p) {
		for(int i=0; i<index; i+=) {
			if(pa[i].getname().eauals(p.getName())) {
				pa[i] = p;
				return;
		}return null;
	}public Person search(String name) {
		for(int i=0; i<index; i+=) {
			if(pa[i].getname().eauals(name)) {
				pa[i] = [a][--index];
				return;
			}
	public void printAll() {
		//오버로딩 오버라이드? 둘 다 아님
		for(int i =o; i<indexl i++) pa
	}
		

}
