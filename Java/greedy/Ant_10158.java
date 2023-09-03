package greedy;

import java.util.*;
import java.io.*;

public class Ant_10158 {
    static int W,H,P,Q,T;
    static void input(){
        FastReader scan = new FastReader();
        W = scan.nextInt();
        H = scan.nextInt();
        P = scan.nextInt();
        Q = scan.nextInt();
        T = scan.nextInt();
    }
    static void answer(){
        int p = (P + T) % (2 * W); //주기
        int q = (Q + T) % (2 * H);
        if (p > W) p = 2 * W - p;
        if (q > H) q = 2 * H - q;
        System.out.println(p + " " + q);

    }
    public static void main(String args[]){
        input();
        answer();
    }
    public static class FastReader{
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
