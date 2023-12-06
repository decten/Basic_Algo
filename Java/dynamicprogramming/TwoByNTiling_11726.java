package dynamicprogramming;

import java.io.*;
import java.util.*;

public class TwoByNTiling_11726 {

    static FastReader scan = new FastReader();

    static int N;
    static int[] Dy;

    static void solve() {
        Dy[1] = 1;
        Dy[2] = 2;

        for (int i = 3; i <= N; i++) {
            Dy[i] = (Dy[i - 2] + Dy[i - 1]) % 10007;
        }

        System.out.println(Dy[N]);

    }

    static void pro() {
        N = scan.nextInt();
        Dy = new int[1005];
        solve();

    }

    public static void main(String[] args) {
        pro();
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
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
