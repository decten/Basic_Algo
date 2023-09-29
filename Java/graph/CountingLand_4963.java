package graph;

import java.util.*;
import java.io.*;

public class CountingLand_4963 {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int[][] a;
    //대각선 포함
    static int dir[][] =
        {
            {0, 1}, {0, -1}, {1, 0}, {-1, 0},
            {1, 1}, {-1, -1}, {1, -1}, {-1, 1}
        };
    static boolean visited[][];
    static int W = 1, H = 1;

    static void input() {
        while (!(W == 0 && H == 0)) {
            H = scan.nextInt();
            W = scan.nextInt();
            solve();
        }
    }

    static void solve() {
        int ans = 0;
        a = new int[W][H];
        visited = new boolean[W][H];
        for (int i = 0; i < W; i++) {
            for (int j = 0; j < H; j++) {
                a[i][j] = scan.nextInt();
            }
        }
        for (int i = 0; i < W; i++) {
            for (int j = 0; j < H; j++) {
                if (a[i][j] == 1 && !visited[i][j]) {
                    ans++;
                    dfs(i, j);
                }
            }
        }
        System.out.println(ans);
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int k = 0; k < 8; k++) {
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];

            if (nx < 0 || ny < 0 || nx >= W || ny >= H) {
                continue;
            }
            if (a[nx][ny] == 0) {
                continue;
            }
            if (visited[nx][ny]) {
                continue;
            }
            dfs(nx,ny);
        }

    }

    public static void main(String[] args) {
        input();
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

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
