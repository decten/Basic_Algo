package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LadderManipulation_15684 {

    static FastReader scan = new FastReader();
    static int N,M,H, ans;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        H = scan.nextInt();

    }

    static void dfs(){
        if(ans==3){
            System.out.println(-1);
            return;
        }
    }

    public static void main(String[] args) {
        input();
        dfs();
    }

    static class FastReader {

        BufferedReader br;
        StringTokenizer st;

        FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

}
