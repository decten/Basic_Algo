import java.io.*;
import java.util.*;

public class HideNSeek_1697 {
    static int N,K;
    static int[] dist;
    static boolean[] visit;
    static void input(){
        FastReader scan = new FastReader();
        N = scan.nextInt();
        K = scan.nextInt();
        //N이 큰지 K가 큰지 모르기 때문에 '최대 규모+a'로 할당
        dist = new int[100005];
        visit = new boolean[100005];

    }
    static void solve(){
        bfs();
        System.out.println(dist[K]);
    }
    static void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        visit[N] = true;
        dist[N] = 0;

        while (!queue.isEmpty()){
            int x = queue.poll();
            if (0<=x - 1 && x - 1<=100000 && !visit[x - 1]){
                visit[x - 1] = true;
                dist[x - 1] = dist[x]+1;
                queue.add(x - 1);
            }
            if (0<=x + 1 && x + 1<=100000 && !visit[x + 1]){
                visit[x + 1] = true;
                dist[x + 1] = dist[x]+1;
                queue.add(x + 1);
            }
            if (0<=x * 2 && x * 2<=100000 && !visit[x * 2]){
                visit[x * 2] = true;
                dist[x * 2] = dist[x]+1;
                queue.add(x * 2);
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
