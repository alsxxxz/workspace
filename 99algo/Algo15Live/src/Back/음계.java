

import java.io.*;
import java.util.*;

public class 음계 { 
    	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] arr = new int[8];
        
        for (int i=0; i<8; i++){
            arr[i] = Integer.parseInt(st.nextToken());    
        }

        //3가지로 나누기
        boolean isAscending = true;
        for (int i =1; i<7; i++){
            if(arr[i+1]<arr[i]){
                isAscending = false;
                break;
            }
        }
        boolean isDescending = true;
        for (int i =1; i<7; i++){
            if(arr[i-1]<arr[i]){
                isDescending = false;
                break;
            }
        }       

        if (isAscending)
        {System.out.println("ascending");}
        else if(isDescending)
            {System.out.println("descending"); }
        else {System.out.println("mixed");}
}
}

