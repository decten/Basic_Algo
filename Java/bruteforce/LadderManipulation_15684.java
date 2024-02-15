package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class LadderManipulation_15684 {

    static FastReader scan = new FastReader();
    static boolean[][] visited;
    static int N,M,H, ans;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        H = scan.nextInt();
        visited = new boolean[N + 1][H + 1];
        ans = -1;


        for (int i = 0; i < M; i++) {
            int row = scan.nextInt();
            int line = scan.nextInt();

            visited[line][row] = true;
        }
    }

    static void solve() {
        int cnt = 0;

        if (M == 0 || check()) {
            ans = 0;
            return;
        }

        dfs(1, 1, cnt);

    }

    private static boolean check() {
        for (int i = 1; i <= N; i++) {
            int current = i;
            for (int j = 1; j <= H; j++) {
                if (visited[i - 1][j]) {
                    i--;
                } else if (visited[i][j]) {
                    i++;
                }
            }
            if (current != i) {
                return false;
            }
        }
        return true;
    }

    static void dfs(int i, int j, int cnt) {
        System.out.println(i + " " + j + " " + cnt);
        if (i > N || j > H || cnt == 3) {
            return;
        }

        if (visited[i][j] ||
            visited[i - 1][j] ||
            visited[i + 1][j]) {
            dfs(i + 1, j + 1, cnt);
            dfs(i, j + 1, cnt);
        }

        if (check()) {
            ans = cnt;
            return;
        }

        visited[i][j + 1] = true;
        dfs(i, j + 1, cnt + 1);
        visited[i][j + 1] = false;

    }

    public static void main(String[] args) {
        input();
        solve();

        System.out.println(ans);
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
