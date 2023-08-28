import java.util.*;
import java.io.*;

public class Escape_3055 {
    static int R, C;
    static String[] a;
    static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

    //물이 있는 곳은 visit 배열(도치 bfs랑 같이 사용)로 체크
    static boolean[][] visit;
    static int[][] dist_water, dist_dochi;
    static void input(){
        FastReader scan = new FastReader();
        R = scan.nextInt();
        C = scan.nextInt();
        a = new String[R];

        for (int i = 0; i < R; i++) {
            a[i] = scan.next();
        }

        //개수만큼만 할당
        visit = new boolean[R][C];
        dist_water = new int[R][C];
        dist_dochi = new int[R][C];

    }


    static void bfs_water(){
        Queue<Integer> queue = new LinkedList<>();

        //물이 여러 곳에 있을 수 있음
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                visit[i][j] = false;
                dist_water[i][j] = -1;
                if(a[i].charAt(j)=='*'){
                    //물이 있는 곳을 0으로 초기화
                    queue.add(i);
                    queue.add(j);
                    visit[i][j] = true;
                    dist_water[i][j] = 0;
                }
            }
        }

        //bfs 시작
        while (!queue.isEmpty()){
            int x = queue.poll();
            int y = queue.poll();

            for (int k = 0; k < 4; k++) {
                int nx = x+dir[k][0], ny = y+dir[k][1];
                //등호 포함!
                if(nx<0||ny<0||nx>=R||ny>=C) continue;
                //빈칸이 아니면 무조건 패스
                if(a[nx].charAt(ny) != '.' || visit[nx][ny]) continue;
                queue.add(nx);
                queue.add(ny);
                visit[nx][ny] = true;
                dist_water[nx][ny] = dist_water[x][y]+1;
            }
        }

    }
    static void bfs_dochi(){
        Queue<Integer> queue = new LinkedList<>();

        //도치는 멀티 소스가 아니지만 인자 안 받는 bfs로 통일해서 여기서 처음 좌표 찾음
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                visit[i][j] = false;
                dist_dochi[i][j] = -1;
                if (a[i].charAt(j)=='S'){
                    queue.add(i);
                    queue.add(j);
                    visit[i][j] = true;
                    dist_dochi[i][j] = 0;
                }
            }
        }

        while (!queue.isEmpty()){
            int x = queue.poll(), y = queue.poll();
            for (int k = 0; k < 4; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];

                if(nx <0 || ny < 0 || nx >= R || ny >= C) continue;
                if(a[nx].charAt(ny) != '.' && a[nx].charAt(ny) != 'D')  continue;
                //갈 칸의 도치 이동 시간이 물 이동 시간 보다 길거나 같으면 못 가는 칸 -> 이 문제의 핵심
                if(dist_water[nx][ny] != -1 && dist_water[nx][ny] <= dist_dochi[x][y]+1) continue;
                if(visit[nx][ny]) continue;

                queue.add(nx);
                queue.add(ny);
                visit[nx][ny] = true;
                dist_dochi[nx][ny] = dist_dochi[x][y]+1;

            }
        }

    }
    static void solve(){
        bfs_water();
        bfs_dochi();
        //정답 출력 기준은 'D' 지점에서 도치의 이동 시간
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (a[i].charAt(j)=='D'){
                    if (dist_dochi[i][j] == -1) System.out.println("KAKTUS");
                    else System.out.println(dist_dochi[i][j]);
                }
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
