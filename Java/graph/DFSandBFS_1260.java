package graph;

import java.util.*;
import java.io.*;

public class DFSandBFS_1260 {
    static int N, M, V;
    static ArrayList<Integer>[] graph;
    static boolean visited[];

    static void input(){
        FastReader scan = new FastReader();
        N = scan.nextInt();
        M = scan.nextInt();
        V = scan.nextInt();
        visited = new boolean[N+1];
        //노드 개수만큼 배열 생성
        graph = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        //입력 받은대로 저장이 아니라 그래프에 맞춰 저장
        for (int i = 0; i < M; i++) {
            int x = scan.nextInt(), y = scan.nextInt();
            graph[x].add(y);
            graph[y].add(x);
        }
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }
    }

    static void DFS(int x){
        visited[x] = true;
        System.out.print(x+" ");
        for (int i: graph[x]) {
            if(visited[i]) continue;
            DFS(i);
        }
    }
    static void BFS(int start){
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            int x = queue.poll();
            System.out.print(x+" ");

            for (int i: graph[x]) {
                if(visited[i]) continue;

                queue.add(i);
                visited[i] = true;
            }
        }
    }

    public static void main(String[] args) {
        input();
        DFS(V);
        for (int i = 0; i <= N; i++) {
            visited[i] = false;
        }
        System.out.println();
        BFS(V);
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
