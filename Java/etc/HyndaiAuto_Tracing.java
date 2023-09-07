package etc;

import java.util.*;
import java.io.*;

public class HyndaiAuto_Tracing {
    static char[][] array;
    static int N,K;

    static void input(){
        FastReader scan = new FastReader();
        N = scan.nextInt();
        K = scan.nextInt();
        array = new char[N][N];
        for(int i=0; i<N; i++){
            String row = scan.next();
            for(int j=0; j<N;j++){
                array[i][j] = row.charAt(j);
            }
        }
    }

    static void answer(){
        int maxScore = 0;
        int currentScore = 0;
        int[] a_cnt = new int[N];
        int[] b_cnt = new int[N];

        //초기 값 세팅: 0~K-1까지의 개수 계산, 개수 차이 저장, 최대 값 설정
        for (int date = 0; date < K; date++) {
            for (int track = 0; track < N; track++) {
                if(array[date][track]=='a') a_cnt[track]++;
                else b_cnt[track]++;
            }
        }
        for (int track = 0; track < N; track++) {
            currentScore += Math.abs(a_cnt[track]-b_cnt[track]);
        }
        maxScore = Math.max(currentScore,maxScore);

        //슬라이딩 윈도우로 점수 계산
        for (int date = K; date < N; date++) {
            //이전 시작 행 삭제
            for (int track = 0; track < N; track++) {
                if(array[date-K][track]=='a') a_cnt[track]--;
                else b_cnt[track]--;
            }
            //다음 행 추가
            for (int track = 0; track < N; track++) {
                if(array[date][track]=='a') a_cnt[track]++;
                else b_cnt[track]++;
            }
            currentScore = 0;
            for (int track = 0; track < N; track++) {
                currentScore += Math.abs(a_cnt[track]-b_cnt[track]);
            }
            maxScore = Math.max(currentScore,maxScore);
        }

        System.out.println(maxScore);
    }

    public static void main(String args[]){
        input();
        answer();
    }
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next(){
            while(st==null||!st.hasMoreElements()){
                try{
                    st = new StringTokenizer(br.readLine());
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt(){
            return Integer.parseInt(next());
        }
    }
}
