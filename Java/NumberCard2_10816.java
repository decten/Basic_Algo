import java.util.*;
import java.io.*;

public class NumberCard2_10816 {
    static int N,M;
    static int[] ans,b;
    static List<Integer> a = new ArrayList<>();
    static void input(){
        FastReader scan = new FastReader();
        N = scan.nextInt();
        for (int i = 0; i < N; i++) {
            a.add(scan.nextInt());
        }
        M = scan.nextInt();
        b = new int[M];
        ans = new int[M];
        for (int i = 0; i < M; i++) {
            b[i]=scan.nextInt();
        }
    }
    static void answer(){
            for (int j = 0; j < M; j++) {
                ans[j] = Collections.frequency(a,b[j]);
            }

        for (int answer: ans) {
            System.out.print(answer+" ");
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
            while(st==null||!st.hasMoreElements()){
                try{
                    st=new StringTokenizer(br.readLine());
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
