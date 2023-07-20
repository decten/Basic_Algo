import java.util.*;
import java.io.*;

public class Laboratory_14502 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    //wall은 벽의 개수 저장, blank는 wall를 사용해 벽이 존재하는 좌표에 접근
    static int N, M, wall, ans;
    //A는 처음 그대로 두고, 상태 저장하는 변수들을 따로 둠
    static int[][] A, blank;
    //바이러스 있는 좌표
    static boolean[][] visit;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        //인덱스를 1부터
        A = new int[N + 1][M + 1];
        blank = new int[N * M + 1][2];
        visit = new boolean[N + 1][M + 1];
        for (int i = 1; i <= N; i++)
            for (int j = 1; j <= M; j++)
                A[i][j] = scan.nextInt();
    }

    // 바이러스 퍼뜨리기!!
    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();

        // 모든 바이러스가 시작점으로 가능하니까, 전부 큐에 넣어준다.
        for(int i=1; i<=N; i++){
            for (int j = 1; j <= M; j++) {
                visit[i][j] = false;
                if(A[i][j]==2){
                    queue.add(i);
                    queue.add(j);
                    visit[i][j] = true;
                }
            }
        }

        // BFS 과정
        while(!queue.isEmpty()){
            int x = queue.poll(), y = queue.poll();
            for (int k = 0; k < 4; k++) {
                int nx = x + dir[k][0], ny = y + dir[k][1];

                if(nx < 1 || ny < 1 || nx > N || ny > M) continue;
                if(A[nx][ny] != 0) continue;
                if(visit[nx][ny]) continue;

                visit[nx][ny] = true;
                queue.add(nx);
                queue.add(ny);
            }
        }

        // 탐색이 종료된 시점이니, 안전 영역의 넓이를 계산하고, 정답을 갱신한다.
        int cnt = 0;
        for (int i = 1; i <= N ; i++) {
            for (int j = 1; j <= M; j++) {
                //빈 공간이면서 바이러스도 못 간 부분이 안전 영역
                if(A[i][j] == 0 && !visit[i][j]) cnt++;
            }
        }
        //cnt는 지역 변수(함수 안), ans는 static
        ans = Math.max(ans,cnt);
    }

    // idx 번째 빈 칸에 벽을 세울 지 말 지 결정해야 하고, 이 전까지 selected_cnt 개의 벽을 세웠다.
    static void dfs(int idx, int selected_cnt) {
        if (selected_cnt == 3) {  // 3 개의 벽을 모두 세운 상태
            bfs();
            return;
        }
        if (idx > wall) return;  // 더 이상 세울 수 있는 벽이 없는 상태

        //지금 idx에 벽을 세우는 경우와 안 세우는 경우
        A[blank[idx][0]][blank[idx][1]] = 1;
        dfs(idx+1, selected_cnt+1);

        A[blank[idx][0]][blank[idx][1]] = 0;
        dfs(idx+1, selected_cnt);

    }

    static void pro() {
        // 모든 벽의 위치
        for(int i=1; i<=N; i++){
            for (int j = 1; j <= M; j++) {
                if(A[i][j] == 0){
                    //벽의 개수
                    wall++;
                    //벽의 개수를 인덱스로 활용
                    blank[wall][0] = i;
                    blank[wall][1] = j;
                }
            }
        }

        // 벽을 3개 세우는 모든 방법을 확인
        dfs(1,0);
        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
        pro();
    }


    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
