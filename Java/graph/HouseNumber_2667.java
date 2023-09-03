package graph;

import java.util.*;
import java.io.*;

public class HouseNumber_2667 {
    static int N;
    static String[] a;
    static boolean[][] visit;
    //상,하,좌,우
    static int[][] dir = {{-1,0}, {1,0},{0,-1},{0,1}};
    static int cnt = 0;

    static List<Integer> answer = new ArrayList<>();
    static void input(){
        FastReader scan = new FastReader();
        N = scan.nextInt();
        a = new String[N];
        //visit는 false로 초기화 돼 있음
        visit = new boolean[N][N];

        for (int i = 0; i < N; i++) {
                a[i] = scan.next();
        }
    }
    static void dfs(int x, int y){
        cnt++;
        visit[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
            if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if(a[nx].charAt(ny) == '0') continue;
            //방문한 경우가 true 상태임
            if(visit[nx][ny]) continue;
            dfs(nx, ny);
        }
    }

    static void bfs(int x, int y){
        //queue에 현재 위치 저장
        Queue<int[]> queue = new LinkedList<>();
        cnt++;
        visit[x][y] = true;
        queue.add(new int[]{x,y});

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dir[i][0];
                int ny = cur[1] + dir[i][1];
                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if(a[nx].charAt(ny) == '0') continue;
                if(visit[nx][ny]) continue;
                queue.add(new int[] {nx,ny});
                visit[nx][ny] = true;
                cnt++;
            }
        }
    }

    static void ans(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                //!false -> true, 방문 하지 않은 경우가 false임
                if(!visit[i][j]&&a[i].charAt(j)=='1'){
                    cnt = 0;
                    //dfs(i,j);
                    bfs(i,j);
                    answer.add(cnt);
                }
            }
        }

        Collections.sort(answer);
        System.out.println(answer.size());
        for (int house_cnt: answer) {
            System.out.println(house_cnt);
        }
    }

    public static void main(String[] args) {
        input();
        ans();
        System.out.println();
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
