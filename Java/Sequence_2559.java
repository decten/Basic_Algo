import java.util.*;
import java.io.*;

public class Sequence_2559 {
    static int N, K;
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
        int ans = 0, day = 0, current = 0;
        for (int left = 0, right=0; left < N; left++) {
            while (right+1 < N) {
                day = right-left+1;
                if(day==K) break;
                right++;
            }
            ans = Math.max(ans,Arrays.stream(a,left,right+1).sum());
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
        answer();
    }

    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next(){
            while (st==null||!st.hasMoreElements()){
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
