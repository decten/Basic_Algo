package dynamicprogramming;

import java.io.*;
import java.util.*;

public class Add123_9095 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    //n은 11보다 작음
    static int[] Dy = new int[15];
    static void pro(){
        int T = scan.nextInt();
        for (int i = 0; i < T; i++) {
            int N = scan.nextInt();
            sb.append(Dy[N]).append('\n');
        }
        System.out.println(sb.toString());
    }
    static void solve(){
        Dy[1] = 1;
        Dy[2] = 2;
        Dy[3] = 4;

        for (int i = 4; i <= 11; i++) {
            Dy[i] = Dy[i-1]+Dy[i-2]+Dy[i-3];
        }

    }

    public static void main(String[] args){
        solve();
        pro();
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
