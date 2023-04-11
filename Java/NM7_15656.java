import java.util.*;
import java.io.*;

public class NM7_15656 {
    static int N,M;
    static int[] A,selected;
    static StringBuilder sb = new StringBuilder();
    static void input(){
        FastReader scan = new FastReader();
        N = scan.nextInt();
        M = scan.nextInt();
        A = new int[N];
        selected = new int[M];
        for (int i = 0; i < N; i++) {
            A[i] = scan.nextInt();
        }
        Arrays.sort(A);
    }
    static void rec_func(int k){
        if(k==M){
            for (int i = 0; i < k; i++) {
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
        }else {
            for (int candi = 0; candi < N; candi++) {
                selected[k] = A[candi];
                rec_func(k+1);
                selected[k] = 0;
            }
        }
    }
    public static void main(String args[]){
        input();
        rec_func(0);

        System.out.println(sb.toString());
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
