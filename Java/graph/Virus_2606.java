package graph;

import java.util.*;
import java.io.*;

public class Virus_2606 {
    static FastReader scan = new FastReader();
    static int N,M,cnt;
    static List<Integer>[] adj;
    static boolean visit[];

    static void input(){
        N = scan.nextInt();
        M = scan.nextInt();
        adj = new List[N+1];
        visit = new boolean[N+1];

        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            int from = scan.nextInt(), to = scan.nextInt();
            adj[from].add(to);
            adj[to].add(from);
        }
    }

    static void solve(){
        dfs(1);
        System.out.println(cnt);
    }

    static void dfs(int x){
        visit[x] = true;
        for (int y: adj[x]) {
            if(visit[y]) continue;

            visit[y] = true;
            cnt++;
            dfs(y);
        }
    }

    public static void main(String[] args) {
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
                try{
                    st = new StringTokenizer(br.readLine());
                }catch (IOException e){
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
