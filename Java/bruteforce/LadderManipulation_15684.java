package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LadderManipulation_15684 {

    static FastReader scan = new FastReader();
    static boolean[][] visited;
    static int N,M,H, ans;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        H = scan.nextInt();
        visited = new boolean[H + 1][N + 1];
        ans = Integer.MAX_VALUE;


        for (int i = 0; i < M; i++) {
            int row = scan.nextInt();
            int col = scan.nextInt();

            visited[row][col] = true;
        }
    }

    static void solve() {

        if (M == 0 || check()) {
            ans = 0;
            return;
        }

        dfs(1, 0);

    }

    private static boolean check() {
        for (int col = 1; col <= N; col++) {
            int current = col;
            for (int row = 1; row <= H; row++) {
                if (visited[row][current - 1]) {
                    current--;
                } else if (visited[row][current]) {
                    current++;
                }
            }
            if (current != col) {
                return false;
            }
        }
        return true;
    }

    static void dfs(int current, int cnt) {
        //문제처럼 왼->오만 그릴 수 있도록 함
        if (cnt > 3) {
            return;
        }

        if (check()) {
            ans = Math.min(cnt, ans);
            return;
        }

        for (int row = current; row <= H; row++) {
            for (int col = 1; col < N; col++) {
                if (visited[row][col] || visited[row][col - 1] || visited[row][col + 1]) {
                    continue;
                }

                visited[row][col] = true;
                dfs(row, cnt + 1);
                visited[row][col] = false;

            }
        }

    }

    public static void main(String[] args) {
        input();
        solve();

        if (ans > 3) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }

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
