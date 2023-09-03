package graph;

import java.util.*;
import java.io.*;
public class ABCDE_13023 {
    static int N,M;
    static boolean found = false;
    static ArrayList<List<Integer>> nodes = new ArrayList<>();
    static boolean[] visited;

    static void input(){
        FastReader scan = new FastReader();
        N = scan.nextInt();
        M = scan.nextInt();
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            nodes.add(i, new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();

            nodes.get(a).add(b);
            nodes.get(b).add(a);
        }
    }

    static void solve(){
        //모든 노드를 시작점
        for (int i = 0; i < N; i++) {
            dfs(i,1);
            if(found) {
                System.out.println("1");
                return;
            }
        }
        System.out.println("0");
    }

    static void dfs(int idx, int depth){
        if(depth==5){
            found = true;
            return;
        }else{
            visited[idx] = true;
            for (int node :nodes.get(idx)) {
                //한 경로 안에서 같은 노드 방문 못 하게 함 (0->1 가고 1->0으로 다시 오는 걸 방지)
                if(!visited[node]) {
                    dfs(node, depth + 1);
                }
            }
            //다른 방법으로 똑같은 노드를 방문하는 걸 인정하는 문제(B-A-C와 A-B-C가 서로 다른 경우로 인정 됨)
            visited[idx] = false;
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
