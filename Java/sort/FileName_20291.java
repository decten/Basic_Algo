package sort;

import java.io.*;
import java.util.*;

public class FileName_20291 {
    static FastReader scan = new FastReader();

    static int N;
    static String[] A;

    static void input() {
        N = scan.nextInt();
        A = new String[N];
        for (int i = 0; i < N; i++) {
            A[i] = scan.next().split("\\.")[1];
        }

    }

    static void answer(){
        Arrays.sort(A);
        Map <String, Integer> hashMap = new LinkedHashMap<>();
        hashMap.put(A[0],1);
        for (int i = 1; i < N; i++) {
            if(hashMap.containsKey(A[i])){
                hashMap.put(A[i],hashMap.get(A[i])+1);
                continue;
            }
            hashMap.put(A[i],1);
        }
        hashMap.forEach((key,value)->{
            System.out.println(key+" "+value);
        });
    }
    public static void main(String[] args) {
        input();
        answer();

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