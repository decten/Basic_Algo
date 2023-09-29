package graph;

import java.util.*;
import java.io.*;
public class Sheep_3184 {
    static FastReader scan = new FastReader();
    static int N,M, sheep, wolf, s_cnt, w_cnt;
    static int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
    static String[][] a;
    static boolean[][] visit;
    static void input(){
        N = scan.nextInt();
        M = scan.nextInt();
        a = new String[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                a[i][j] = scan.next();
            }
        }

    }
    static void solve(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(!a[i][j].equals("#")&&!visit[i][j]){
                    s_cnt = 0; w_cnt = 0;
                    dfs(i,j);
                    if(s_cnt > w_cnt) sheep++;
                    else wolf++;
                }
            }
        }
        System.out.println(sheep+" "+wolf);
    }
    static void dfs(int i, int j){
        visit[i][j] = true;
        if(a[i][j].equals("o")) s_cnt++;
        else if(a[i][j].equals("v")) w_cnt++;

        for (int k = 0; k < 4; k++) {
            int nx = i + dir[k][0];
            int ny = j + dir[k][1];

            if(nx<0||ny<0||nx>=N||ny>=M) continue;
            if(visit[nx][ny]) continue;
            if(a[i][j].equals("#")) continue;

            dfs(nx,ny);
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
