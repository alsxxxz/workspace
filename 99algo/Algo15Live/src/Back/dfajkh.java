import java.io.InputStreamReader;
import java.io.*;

public class dfajkh {
public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String S = br.readLine();
    int N = Integer.parseInt(br.readLine());
    
    System.out.println(S.charAt(N-1));
}
}
