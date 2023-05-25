import java.util.*;
import java.io.*;

public class LUN_13144 {
    static int N;
    static int[] a;
    static void input(){
        FastReader scan = new FastReader();
        N = scan.nextInt();
        a = new int[N+1];
        for (int i = 1; i <= N; i++) {
            a[i] = scan.nextInt();
        }
    }
    static void answer(){
        int right=0, count=0, tmp = 0;
        for (int left = 1; left < N; left++) {

        }
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
