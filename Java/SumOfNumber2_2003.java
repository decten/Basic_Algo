import java.util.*;
import java.io.*;

public class SumOfNumber2_2003 {
    static int N;
    static long M;
    static int[] a;
    static void input(){
        FastReader scan = new FastReader();
        N = scan.nextInt();
        M = scan.nextLong();
        a = new int[N+1];

        for (int i = 1; i <= N; i++) {
            a[i] = scan.nextInt();
        }

    }
    static void answer(){
        int cnt = 0;
        long ans = 0;
        for (int left = 1, right=0; left <= N; left++) {
            while(right+1<=N && ans<M){
                ans += a[++right];
            }
            if(ans==M) cnt++;
            ans -= a[left];
        }
        System.out.println(cnt);
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
            while(st==null||!st.hasMoreElements()){
                try{
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

        long nextLong(){
            return Long.parseLong(next());
        }
    }
}
