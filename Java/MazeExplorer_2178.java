import java.util.*;
import java.io.*;
public class MazeExplorer_2178 {
    static int N,M;
    static int[][] a;
    static int[][] dist;
    static boolean[][] visit;
    static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    static void input(){
        FastReader scan = new FastReader();
        N = scan.nextInt();
        M = scan.nextInt();
        a = new int[N+1][M+1];
        dist = new int[N+1][M+1];
        visit = new boolean[N+1][M+1];

        for (int i = 1; i <= N; i++) {
            String row = scan.next();
            //j인덱스가 1부터 시작이라 빼줘야 함
            for (int j = 1; j <= M; j++) {
                a[i][j] = row.charAt(j-1)-'0';
            }
        }
    }
    static void solve(){
        bfs(1,1);
        System.out.println(dist[N][M]);
    }
    static void bfs(int row, int col){
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M ; j++) {
                dist[i][j] = -1;
            }
        }

       Queue<Integer> queue = new LinkedList<>();
       queue.add(row);
       queue.add(col);
       visit[row][col] = true;
       dist[row][col] = 1;

       while(!queue.isEmpty()){
           int x = queue.poll(), y = queue.poll();
           for (int k = 0; k < 4; k++) {
               int nx = x + dir[k][0];
               int ny = y + dir[k][1];

               if(nx<0 || ny<0 || nx>N || ny>M) continue;
               if(a[nx][ny] == 0 || visit[nx][ny]) continue;

               queue.add(nx);
               queue.add(ny);
               visit[nx][ny] = true;
               //경로가 없는 노드는 방향에서 제외해야 하는데 그 처리가 안 돼 있음 -> 방문하는 경우에만 값 누적
               dist[nx][ny] = dist[x][y]+1;
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
            while(st==null||!st.hasMoreElements()){
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
