package tree;

import java.util.*;
import java.io.*;

public class Tree_1068 {
    static FastReader scan = new FastReader();
    static int N, root, erased;
    static ArrayList<Integer>[] child;
    static int[] leaf;

    static void input(){
        N = scan.nextInt();
        //이번 문제는 인덱스가 0부터 주어짐
        child = new ArrayList[N];
        leaf = new int[N];

        for (int i = 0; i < N; i++) child[i] = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int par = scan.nextInt();
            //루트는 subtree 안 만듦
            if (par==-1){
                root = i;
                continue;
            }
            child[par].add(i);
        }
        erased = scan.nextInt();

    }
    static void dfs(int x){
        if(child[x].isEmpty()){
           leaf[x] = 1;
        }
        for (int y:child[x]) {
            dfs(y);
            leaf[x] += leaf[y];
        }
    }
    static void solve(){
        for (int i = 0; i < N; i++) {
            if(child[i].contains(erased)){
                child[i].remove(child[i].indexOf(erased));
            }
        }
        if (root!=erased) dfs(root);
        System.out.println(leaf[root]);
    }
    public static void main(String[] args) {
        input();
        solve();
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
