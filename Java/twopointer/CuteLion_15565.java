package twopointer;

import java.util.*;
import java.io.*;

public class CuteLion_15565 {
    static int N,K;
    static int[] a;

    static void input(){
        FastReader scan = new FastReader();
        N = scan.nextInt();
        K = scan.nextInt();
        a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = scan.nextInt();
        }
    }
    static void answer(){
        //cnt,right을 바깥에서 선언 후 안에서는 계속 누적해서 사용해야 함!
        //안 쪽 반복문도 계속 돌고 cnt 누적을 바깥에서 해야 함
        int ans = N, cnt = 0, right=-1;
        for (int left = 0; left < N; left++) {
            while(right+1<N && cnt < K){
                right++;
                if(a[right]==1) cnt++;
            }
            if(cnt==K){
                ans = Math.min(ans, right-left+1);
            }
            //이게 투 포인터(값이 아닐 때 반복문 넘기지 않고-반복문은 계속 돌아감, 나중에 해당 값을 빼 버림)
            if(a[left] == 1) cnt--;
        }
        if(ans==N) ans = -1;

        System.out.println(ans);
    }
    public static void main(String[] args) {
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
            while (st==null||!st.hasMoreElements()){
                try {
                    st = new StringTokenizer(br.readLine());
                }catch (IOException e){
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
