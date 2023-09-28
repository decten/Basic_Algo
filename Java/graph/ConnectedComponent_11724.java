package graph;

import java.io.*;
import java.util.*;

public class ConnectedComponent_11724 {
    static FastReader scan = new FastReader();

    static int N,M;
    static List<Integer>[] a;
    static void input(){
        N = scan.nextInt();
        M = scan.nextInt();
        a = new List[N+1];

        for (int i = 0; i < M; i++) {
            int from = scan.nextInt(), to = scan.nextInt();
            a[from].add(to);
        }

    }
    static void solve(){
        BFS();
    }
    public static void main(String[] args){
        input();
        solve();
    }
    static void BFS(){

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
