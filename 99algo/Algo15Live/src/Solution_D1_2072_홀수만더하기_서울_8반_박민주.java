import java.io.*;
import java.util.*;

public class Solution_D1_2072_홀수만더하기_서울_8반_박민주 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//제출할땐 systemin지우기
		
	System.setIn(new FileInputStream("res/input_d1_2072"));
	//입력을 빠르게 읽기 위한 bufferedReader 생성
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	//문자열을 공백 기준으로 나누기 위한 BufferedReader 생성
	StringTokenizer st = null;
	//출력을 한 번에 모아서 빠르게 출력하기 위한 StringBuilder
	StringBuilder sb = new StringBuilder();
	
	//첫줄: 테스트 개수 읽기
	// br.readLine() 한줄전체를 읽고 parseInt로 문자열 "3"을 int 3으로 변환
	int T = Integer.parseInt(br.readLine());
	//위에서 읽은 T번 for 문으로 반복
	//
	for(int tc=1; tc<=T; tc++) {
		
		int sum = 0;	//홀수의 합 저장할 변수
		st = new StringTokenizer(br.readLine()," "); //한 줄 읽어서 공백으로만 자르겠다.
		for(int i=0; i<10; i++) {
			//토큰을 하나씩 가져와서 정수로 변환
			int n= Integer.parseInt(st.nextToken());
			
			if (n%2== 1) sum += n;
			
		}
		//결과를 StringBuilder에 추가: #테케번호 합계
		sb.append("#").append(tc).append(" ").append(sum).append("\n");
		
		
	}
	//모아둔 결과를 한 번에 출력
	System.out.println(sb.toString());

	br.close();
	}

}
