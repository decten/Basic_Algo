import java.util.*;
import java.io.*;

public class Softeer01_Traffic {
    static int N;
    static int T;
    static int[][] a;
    static int[][][] signal = {
        {{}},

        {{0,-1},{1,0},{0,1}},
        {{-1,0},{0,-1},{1,0}},
        {{0,-1},{-1,0},{0,1}},
        {{-1,0},{0,1},{1,0}},

        {{0,-1},{1,0}},
        {{-1,0},{0,-1}},
        {{-1,0},{0,1}},
        {{0,1},{1,0}},

        {{1,0},{0,1}},
        {{0,-1},{1,0}},
        {{0,-1},{-1,0}},
        {{-1,0},{0,1}}
    };
    static boolean visit[][];
    static int ans;

    static void input(){
        FastReader scan = new FastReader();
        N = scan.nextInt();
        T = scan.nextInt();
        a = new int[N+1][N+1];
        visit = new boolean[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                a[i][j] = scan.nextInt();
            }
        }
    }
    static void dfs(int x, int y, int time){
        visit[x][y] = true;
        time++;
        ans++;

        for (int k = 1; k <= y; k++) {
            for (int i = 0; i < signal[x][k].length; i++) {
                int nx = x + signal[x][i][0];
                int ny = y + signal[x][i][1];

                if(time > T) return;
                if(nx > N || ny > N || nx < 1 || ny < 1) continue;
                if(visit[nx][ny]) continue;

                dfs(nx,ny,time);

            }
        }

    }
    static void ans(){
        int time = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                dfs(i, j, time);
            }
        }
    }

    public static void main(String[] args){
        input();
        ans();
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
