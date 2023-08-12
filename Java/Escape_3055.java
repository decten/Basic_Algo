import java.util.*;
import java.io.*;

public class Escape_3055 {
    static int R, C;
    static String[] a;
    static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    static boolean[][] visit = new boolean[51][51];
    static int[][] dist = new int[51][51];
    static void input(){
        FastReader scan = new FastReader();
        R = scan.nextInt();
        C = scan.nextInt();
        a = new String[R];

        for (int i = 0; i < R; i++) {
            a[i] = scan.next();
        }

    }
    //물이 있는 곳은 visit 배열(도치 bfs랑 같이 사용)로 체크
    static void water_BFS(int i, int j){

    }
    static void bfs(int i, int j){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        queue.add(j);
        visit[i][j] = true;

        while (!queue.isEmpty()){
            int x = queue.poll(), y = queue.poll();
            for (int k = 0; k < 4; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];

                if(nx<0||ny<0||nx>R||ny>C) continue;
                //돌은 문자로 체크
                if(a[nx].charAt(ny)=='X' || visit[nx][ny]) continue;
                if(a[nx].charAt(ny)=='D') break;

                queue.add(nx);
                queue.add(ny);
                visit[nx][ny] = true;
                dist[nx][ny] = dist[x][y]+1;

            }
        }

    }
    static void solve(){
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(a[i].charAt(j) == '*') water_BFS(i,j);
                if(a[i].charAt(j) == 'S') bfs(i,j);
            }
        }
        //dist의 어딜 참조해야 할지 모르겠네
//        System.out.println(dist[][]);
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
