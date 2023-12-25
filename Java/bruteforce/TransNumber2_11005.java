package bruteforce;

import java.util.*;
import java.io.*;

public class TransNumber2_11005 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N, B;

    static void input() {
        N = scan.nextInt();
        B = scan.nextInt();
    }

    static void solve() {
        int k = 0;
        while (Math.pow(B, k) <= N) {
            k++;
        }
        if (Math.pow(B, k) > N) k--;

        for (; k >= 0; k--) {
            if (Math.pow(B, k) > N) {
                sb.append(0);
                continue;
            }
            int mod = (int) (N / Math.pow(B, k));
            if (mod > 9) sb.append((char) ((mod - 10) + 'A'));
            else sb.append(mod);
            N = N % (int) Math.pow(B, k);
        }

        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        input();
        solve();
    }

    static class FastReader {
        StringTokenizer st;
        BufferedReader br;

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

        Integer nextInt() {
            return Integer.parseInt(next());
        }
    }
}
