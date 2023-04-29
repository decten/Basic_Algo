import java.util.*;
import java.io.*;

//문제에서 인덱스를 1부터 사용함!
public class KthNumber_1300 {
    static int N,M;
    static int[] B;
    static void input(){
        FastReader scan = new FastReader();
        N = scan.nextInt();
        M = scan.nextInt();
        B = new int[N*N+1];
    }
    static void answer(){
        for (int i = 1 ; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                B[i]=i*j;
            }
        }
        Arrays.sort(B);
        System.out.println(B[M]);
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
    }
}
