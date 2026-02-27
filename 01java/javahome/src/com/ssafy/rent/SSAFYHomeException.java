package com.ssafy.rent;

public class SSAFYHomeException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public SSAFYHomeException() {
		super("데이타를 처리 중 오류 발생");
	}
	public SSAFYHomeException(String msg) {
		super(msg);
	}
	
}
