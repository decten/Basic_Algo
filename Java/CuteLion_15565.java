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
        int ans = N;
        for (int left = 0, right = 0; left < N; left++) {
            int cnt = 0;
            if(a[left]==2) continue;
            else cnt++;
            while(right+1<N && a[right]==2){
                if(a[++right]==1) cnt++;
                if(cnt==3){
                    ans = Math.min(ans, right-left+1);
                    break;
                }
            }
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
