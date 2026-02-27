import java.io.*;
import java.util.*;

public class Solution_D1_2072_홀수만더하기_서울_8반_박민주 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//제출할땐 systemin지우기
		
	System.setIn(new FileInputStream("res/input_d1_2072"));
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = null;
	StringBuilder sb = new StringBuilder();
	int T = Integer.parseInt(br.readLine());
	for(int tc=1; tc<=T; tc++) {
		int sum = 0;
		st = new StringTokenizer(br.readLine()," "); //공백으로만 자르겠다.
		for(int i=0; i<10; i++) {
			int n= Integer.parseInt(st.nextToken());
			if (n%2== 1) sum += n;
			
		}
		sb.append("#").append(tc).append(" ").append(sum).append("\n");
		
		
	}
	//
	System.out.println(sb.toString());

	br.close();
	}

}
