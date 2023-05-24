import java.io.*;
import java.util.*;

public class TwoLiquid_2470_TwoPointer {
    static int N;
    static long[] a;

    static void input(){
        FastReader scan = new FastReader();
        N = scan.nextInt();
        a = new long[N];
        for (int i = 0; i < N; i++) {
            a[i] = scan.nextLong();
        }
    }

    static void answer(){

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
