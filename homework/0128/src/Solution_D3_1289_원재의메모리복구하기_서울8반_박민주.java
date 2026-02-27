package src;
import java.io.*;

public class Sollution_D3_1289_원재의메모리복구하기_서울8반_박민주 {

	public static void main(String[] args) throws IOException {
		// 파일 입력 (제출 시에는 주석 처리)
		System.setIn(new FileInputStream("res/input_d3_1289"));
		
		// BufferedReader로 빠른 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			String memory = br.readLine().trim();
			
			int count = 0;
			char current = '0';  // 현재 상태 (처음엔 모두 0)
			
			for (int i = 0; i < memory.length(); i++) {
				char bit = memory.charAt(i);
				
				// 현재 상태와 목표 bit가 다르면 수정 필요
				if (current != bit) {
					count++;
					current = bit;  // 이 위치부터 끝까지 bit 값으로 덮어씌워짐
				}
			}
			
			sb.append("#").append(tc).append(" ").append(count).append("\n");
		}
		
		// 한 번에 출력
		System.out.print(sb);
		br.close();
	}
}