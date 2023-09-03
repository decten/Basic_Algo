package shortpath;

import java.util.*;
import java.io.*;

public class MinimumCostFinder_1916 {
    static FastReader scan = new FastReader();

    static class Edge{
        public int to, weight;

        public Edge(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
    }
    static class Info{
        public int idx, dist;

        public Info(){}

        public Info(int idx, int dist){
            this.idx = idx;
            this.dist = dist;
        }
    }
    static int N,M,start,end;
    static int[] dist;
    static ArrayList<Edge>[] edges;
    static void input(){
        N = scan.nextInt();
        M = scan.nextInt();
        dist = new int[N+1];
        edges = new ArrayList[N+1];

        //배열 안의 리스트도 할당하고 사용해야 함
        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int i = 1; i <= M ; i++) {
            int from = scan.nextInt();
            int to = scan.nextInt();
            int weight = scan.nextInt();
            edges[from].add(new Edge(to,weight));
        }

        start = scan.nextInt();
        end = scan.nextInt();
    }

    static void dijkstra(int start){
        //모든 정점에 대한 거리를 무한대로 초기화
        for (int i = 1; i <= N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        //최소 힙 생성
        PriorityQueue<Info> pq =
            new PriorityQueue<>(Comparator.comparingInt(o->o.dist));

        //처음 시작점은 0으로 최소 힙과 거리 배열 갱신
        pq.add(new Info(start,0));
        dist[start] = 0;

        //거리 갱신
        while (!pq.isEmpty()){
            Info info = pq.poll();
            //저장된 info까지의 거리가 지금의 info 거리보다 길어야 갱신(1->3 가는 방법과 2->3 가는 방법이 있다는 점)
            if(dist[info.idx] < info.dist) continue;
            //인접한 노드들 확인
            for (Edge e: edges[info.idx]){
                if(dist[info.idx]+e.weight >= dist[e.to]) continue;

                dist[e.to] = dist[info.idx]+e.weight;
                pq.add(new Info(e.to, dist[e.to]));
            }
        }

    }

    static void solve(){
        dijkstra(start);
        System.out.println(dist[end]);
    }

    public static void main(String[] args){
        input();
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
