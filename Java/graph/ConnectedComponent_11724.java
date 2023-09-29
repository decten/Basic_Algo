package graph;

import java.io.*;
import java.util.*;

public class ConnectedComponent_11724 {
    static FastReader scan = new FastReader();

    static int N,M, ans;
    static List<Integer>[] adj;
    static boolean[] visited;
    static void input(){
        N = scan.nextInt();
        M = scan.nextInt();
        adj = new List[N+1];
        visited = new boolean[N+1];

        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            int from = scan.nextInt(), to = scan.nextInt();
            adj[from].add(to);
        }

    }
    static void solve(){
        for (int i = 1; i <= N; i++) {
            if(visited[i]) continue;
            dfs(i);
            ans++;
        }
        System.out.println(ans);
    }
    static void dfs(int x){
        visited[x] = true;
        for (int y : adj[x]) {
            if(visited[y]) continue;
            dfs(y);
        }
    }
    public static void main(String[] args){
        input();
        solve();
    }
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next(){
            while(st==null||!st.hasMoreElements()){
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt(){
            return Integer.parseInt(next());
        }
    }
}
