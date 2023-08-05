import java.util.*;
import java.io.*;
public class MazeExplorer_2178 {
    static int N,M,ans;
    static int[][] a;
    static boolean[][] visit;
    static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    static void input(){
        FastReader scan = new FastReader();
        N = scan.nextInt();
        M = scan.nextInt();
        a = new int[N+1][M+1];
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
        System.out.println(ans);
    }
    static void bfs(int row, int col){
       Queue<Integer> queue = new LinkedList<>();
       queue.add(row);
       queue.add(col);
       visit[row][col] = true;

       while(!queue.isEmpty()){
           int x = queue.poll(), y = queue.poll();
           for (int k = 0; k < 4; k++) {
               int nx = x + dir[k][0];
               int ny = y + dir[k][1];

               if(nx<0 || ny<0 || nx>N || ny>M) continue;
               if(a[nx][ny] == 0 || visit[nx][ny]) continue;
               if(nx==N && ny==M) return;

               queue.add(nx);
               queue.add(ny);
               visit[nx][ny] = true;
               ans++;
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
