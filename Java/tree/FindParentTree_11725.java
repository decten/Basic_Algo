package tree;

import java.util.*;
import java.io.*;
public class FindParentTree_11725 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static ArrayList<Integer>[] adj;
    static int[] parent;

    static void input() {
        N = scan.nextInt();
        adj = new ArrayList[N +1];
        parent = new int[N+1];

        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            int X = scan.nextInt(), Y = scan.nextInt();
            adj[X].add(Y);
            adj[Y].add(X);
        }
    }

    // 인접 리스트는 해당 정점의 부모 또는 자식 노드만 존재 & DFS로 타고 들어가서 같은 level이랑 안 섞이도록 함
    static void dfs(int x, int par) {
        for (int y: adj[x]) {
            if(y==par) continue;
            parent[y] = x;
            dfs(y,x);
        }
    }

    static void pro() {
        dfs(1,-1);

        for (int i = 2; i <= N; i++) {
            System.out.println(parent[i]);
        }
    }

    public static void main(String[] args) {
        input();
        pro();
    }


    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
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

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
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
    }
}
