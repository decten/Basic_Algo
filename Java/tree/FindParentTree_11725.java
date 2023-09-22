package tree;

import java.util.*;
import java.io.*;

public class FindParentTree_11725 {
    static FastReader scan = new FastReader();
    static int N;
    static List<ArrayList<Integer>> a;

    static void input(){
        N = scan.nextInt();

        for (int i = 1; i <= N; i++) {
            a = new ArrayList<>();
            a.add(i, new ArrayList<>());
        }

        for (int i = 1; i <= N; i++) {
            int first = scan.nextInt();
            int second = scan.nextInt();

            a.get(first).add(second);

        }
    }
    public static void main(String[] args) {
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
