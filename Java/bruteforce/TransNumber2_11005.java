package bruteforce;

import java.util.*;
import java.io.*;

public class TransNumber2_11005 {
    static FastReader scan = new FastReader();
    static int N, B;
    static void input(){
        N = scan.nextInt();
        B = scan.nextInt();
    }

    static void solve(){

    }

    public static void main(String[] args) {
        input();
        solve();
    }
    static class FastReader{
        StringTokenizer st;
        BufferedReader br;

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

        Integer nextInt(){
            return Integer.parseInt(next());
        }
    }
}
