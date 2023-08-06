import java.util.*;
import java.io.*;
public class SafeArea_2468 {
    static int N, height, ans;
    static int[][] a;
    static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    static boolean[][] visit;

    static void input(){
        FastReader scan = new FastReader();
        N = scan.nextInt();
        a = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                a[i][j] = scan.nextInt();
                height = Math.max(height,a[i][j]);
            }
        }

    }
    static void solve(){
        for (int limit = 1; limit <= height; limit++) {
            int cnt = 0;
            visit = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(a[i][j] > limit && !visit[i][j]){
                        cnt++;
                        bfs(i,j,limit);
                    }
                }
            }
            ans = Math.max(ans, cnt);
        }
        System.out.println(ans);
    }
    static void bfs(int i, int j, int limit){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        queue.add(j);
        visit[i][j] = true;

        while (!queue.isEmpty()){
            int x = queue.poll(), y = queue.poll();

            for (int k = 0; k < 4; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];

                if(nx<0||ny<0||nx>=N||ny>=N) continue;
                if(a[nx][ny] <= limit || visit[nx][ny]) continue;

                queue.add(nx);
                queue.add(ny);
                visit[nx][ny] = true;

            }
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
            while (st==null||!st.hasMoreElements()){
                try {
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
