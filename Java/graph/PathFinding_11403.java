package graph;

import java.util.*;
import java.io.*;

public class PathFinding_11403 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[][] adj;
    static boolean[] visit;

    static void input(){
        N = scan.nextInt();
        adj = new int[N + 1][N + 1];
        for (int i = 1;i <= N; i++)
            for (int j = 1; j <= N; j++)
                adj[i][j] = scan.nextInt();


    }

    static void bfs(int start) {
        Queue<Integer> que = new LinkedList<>();

        for (int i = 1; i <= N; i++) visit[i] = false;

        que.add(start);
        visit[start] = false;  // [예외] 본 문제는 자기 자신을 돌아올 수 있는 지를 판단해야 하기 때문에 false로 시작한다.

        while (!que.isEmpty()) {  // 더 확인할 점이 없다면 정지
            int x = que.poll();

            for (int y = 1; y <= N; y++) {
                if (adj[x][y] == 0) continue;  // x 에서 y 로 갈 수 없다면 무시
                if (visit[y]) continue;  // x 에서 y 를 갈 수는 있지만, 이미 탐색한 점이면 무시

                // y를 갈 수 있으니까 que에 추가하고, visit 처리 하기!
                que.add(y);
                visit[y] = true;
            }
        }

        for (int i = 1; i <= N; i++) {
            sb.append(visit[i] ? 1 : 0).append(' ');
        }
        sb.append('\n');
    }

    static void pro() {
        visit = new boolean[N + 1];
        for (int i = 1; i <= N; i++)
            bfs(i);
        System.out.println(sb);
    }
    public static void main(String[] args){
        input();
        pro();
    }
    static class FastReader{
        StringTokenizer st;
        BufferedReader br;

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
