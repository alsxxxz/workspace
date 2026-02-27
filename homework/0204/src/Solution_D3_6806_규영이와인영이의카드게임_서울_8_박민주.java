import java.io.*;
import java.util.*;
 
public class Solution_D3_6806_규영이와인영이의카드게임_서울_8_박민주 {
static int[] GY = new int[9];
static int[] IY = new int[9];
static boolean[]used = new boolean[19];  //0~18까지 만들어두고 0은 쓰지 말기
static int GY_score=0, IY_score =0;
static int win, lose; //규영이 기준

    static void Perm(int round) {   
        //round가 9가되면  여기서 승패 결정
        if(round == 9){
            for(int i=0; i<9; i++){
                if(IY[i]>GY[i]){IY_score += IY[i] + GY[i];}
                else if(IY[i]<GY[i]){GY_score += IY[i] + GY[i];}
            }

            if(GY_score>IY_score){win++;} 
            else if(GY_score<IY_score){lose++;}

            IY_score = 0;
            GY_score =0;
        }
        //안넘어가면 k는 1부터 18까지 넣어서 보내기         
        for(int k=1; k<19; k++){        //k는 카드번호 1~18
            if(used[k]) continue;
            {
                used[k] = true;
                IY[round] = k; //전체 숫자 목록에서 일치하는 거 넣어주기
                Perm(round+1);          //그 다음 라운드로
                used[k] = false;        
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                                                            //17번줄 st 는nextToken()을 9번 하면, 순서대로 1", "3", "5", "7", "9", "11", ... 를 '문자열'로 반환하므로// for (int i = 0; i < 9; i++) {//     GY[i] = Integer.parseInt(st.nextToken());//                              ^----------- 얘는 문자열임 //         ^------------------------------- 정수로 변환
        int tc = Integer.parseInt(br.readLine()); //테스트 케이스 4
        
        for(int i=1; i<=tc; i++){ //테스트 케이스 1일 때 -> 이 for문안에서 싹다 구현 끝나면 tc = 2시작
            StringTokenizer st = new StringTokenizer(br.readLine());
            //tc 시작할때마다 used, win, lose 초기화 해주기
            for(int f=0; f<19; f++){
                used[f] = false;
            }
            win = 0;
            lose = 0;

            for(int j = 0; j<9; j++){
                GY[j] = Integer.parseInt(st.nextToken());
                used[GY[j]] = true;            
            }
            Perm(0);
            System.out.print("#" + i +" " + win + " " +lose +"\n");            

                }

            }
        }
     
         
        