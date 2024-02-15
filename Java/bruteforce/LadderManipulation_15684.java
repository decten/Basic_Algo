package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class LadderManipulation_15684 {

    static FastReader scan = new FastReader();
    static List<ArrayList<Integer>> array = new ArrayList<>();
    static boolean[][] visited;
    static int N,M,H, ans;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        H = scan.nextInt();

        visited = new boolean[N+1][M+1];

        for (int i = 1; i <= N; i++) {
            array.add(i, new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int row = scan.nextInt();
            int line = scan.nextInt();

            array.get(row).add(line);
        }
    }

    static void solve() {
        int cnt = 0;
        dfs(cnt);

    }

    static void dfs(int cnt){
        if(cnt==3){
            return;
        }


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
