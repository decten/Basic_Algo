import java.util.*;
import java.io.*;

public class CuttingLAN_1654 {
    static int N,K;
    static long[] A;
    static void input(){
        FastReader scan = new FastReader();
        N = scan.nextInt();
        K = scan.nextInt();
        A = new long[N];
        for (int i = 0; i < N; i++) {
            A[i] = scan.nextInt();
        }
        Arrays.sort(A);
    }
    static boolean answer(long X){
        int result = 0;
        for (int i = 0; i < N; i++) {
            result += A[i]/X;
        }
        if(result>=K) return true;
        return false;
    }
    static void bin_search (long L, long R){
        long ans = 0;
        while(R>=L){
            long mid = (R+L)/2;
            if(answer(mid)) {
                ans = Math.max(mid,ans);
                L = mid+1;
            }
            else R = mid-1;
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
        bin_search(1,A[A.length-1]);
    }
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        FastReader(){
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
