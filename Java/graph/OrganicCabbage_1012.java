package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class OrganicCabbage_1012 {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N, M, K;
    static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static boolean[][] cabbage;
    static boolean[][] visit;

    static void input() {

        M = scan.nextInt();
        N = scan.nextInt();
        K = scan.nextInt();

        cabbage = new boolean[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < K; i++) {
            //행 값 먼저 주어짐
            int col = scan.nextInt();
            int row = scan.nextInt();
            //배추 있는 곳으로 체크
            cabbage[row][col] = true;
        }

    }

    static void solve() {
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visit[i][j] && cabbage[i][j]) {
                    cnt++;
                    bfs(i, j);
                }
            }
        }
        sb.append(cnt + "\n");

    }

    static void bfs(int i, int j) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        queue.add(j);
        visit[i][j] = true;

        while (!queue.isEmpty()) {
            int x = queue.poll(), y = queue.poll();
            for (int k = 0; k < 4; k++) {
                int nx = dir[k][0] + x, ny = dir[k][1] + y;

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }
                if (!cabbage[nx][ny]) {
                    continue;
                }
                if (visit[nx][ny]) {
                    continue;
                }

                queue.add(nx);
                queue.add(ny);
                visit[nx][ny] = true;
            }
        }

    }

    public static void main(String[] args) {
        int T = scan.nextInt();
        while (T-- > 0) {
            input();
            solve();
        }
        System.out.println(sb.toString());
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
