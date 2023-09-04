package shortpath;

import java.util.*;
import java.io.*;

public class ShortPath_1753 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static class Edge{
        int to;
        int weight;

        public Edge(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
    }
    static class Info{
        int idx;
        int dist;

        Info(){};
        Info(int idx, int dist){
            this.idx = idx;
            this.dist = dist;
        }
    }

    static int V,E,start;
    static ArrayList<Edge>[] edges;
    static int[] dist;
    static void input(){
        V = scan.nextInt();
        E = scan.nextInt();
        start = scan.nextInt();

        //전체 배열의 개수 할당하고 그 안에 또 해야 함
        edges = new ArrayList[V+1];
        for (int i = 1; i <= V; i++) {
            //List 배열이라 배열의 요소 안에 List를 할당해야 함
            edges[i] = new ArrayList<>();
        }

        for (int i = 1; i <= E; i++) {

            int from = scan.nextInt();
            int to = scan.nextInt();
            int weight = scan.nextInt();

            edges[from].add(new Edge(to, weight));
        }

        dist = new int[V+1];
    }

    static void solve(){
        dijkstra(start);

        for (int i = 1; i <= V; i++) {
            if (dist[i] != Integer.MAX_VALUE) {
                System.out.println(dist[i]);
            }else{
                System.out.println("INF");
            }
        }
    }

    static void dijkstra(int start){
        //최단거리 초기화
        for (int i = 1; i <= V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        //정렬 기준 넣기
        PriorityQueue<Info> pq =
            new PriorityQueue<>(Comparator.comparingInt(o->o.dist));

        pq.add(new Info(start,0));
        dist[start] = 0;

        while (!pq.isEmpty()){
            Info info = pq.poll();

            if(dist[info.idx] < info.dist) continue;

            for(Edge e: edges[info.idx]){
                if(dist[info.idx]+e.weight >= dist[e.to]) continue;

                dist[e.to] = dist[info.idx]+e.weight;
                pq.add(new Info(e.to, dist[e.to]));
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
