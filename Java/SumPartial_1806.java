import java.util.*;
import java.io.*;

public class SumPartial_1806 {
    static int N, M;
    static int[] a;

    static void input(){
        FastReader scan = new FastReader();
        N = scan.nextInt();
        M = scan.nextInt();
        a = new int[N+1];
        for (int i = 1; i <= N; i++) {
            a[i] = scan.nextInt();
        }
    }

    static void answer(){
        int R = 0, ans = N+1, sum = 0;
        for (int L = 1; L <= N; L++) {
            sum -= a[L-1];
            //R을 증가하기 때문에 R이 아닌 R+1이 범위의 기준
            while(R+1<=N && sum < M) sum += a[++R];
            if(sum >= M) ans = Math.min(ans, R-L+1);
        }
        if(ans==N+1) ans = 0;
        System.out.println(ans);
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
