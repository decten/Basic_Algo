package dynamicprogramming;

import java.io.*;
import java.util.*;

public class StairClimbing_2579 {

    static FastReader scan = new FastReader();

    static int N;
    static int[] score;
    static int[][] Dy;

    static void input() {
        N = scan.nextInt();
        score = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            score[i] = scan.nextInt();
        }
        Dy = new int[N + 1][2];
    }

    static void solve() {
        Dy[1][0] = 0;
        Dy[1][1] = score[1];

        if (N >= 2) {
            Dy[2][0] = score[2];
            Dy[2][1] = score[1] + score[2];
        }

        for (int i = 3; i <= N; i++) {
            Dy[i][0] = Math.max(
                Dy[i - 2][0] + score[i],
                Dy[i - 2][1] + score[i]
            );
            Dy[i][1] = Dy[i - 1][0] + score[i];
        }

        System.out.println(Math.max
            (
                Dy[N][0], Dy[N][1]
            )
        );

    }

    public static void main(String[] args) {
        input();
        solve();
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
