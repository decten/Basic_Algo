package sort;

import java.util.*;
import java.io.*;

public class WordSort_1181 {
    static int N;
    static String[] a;
    static StringBuilder sb = new StringBuilder();
    static class MyComparator implements Comparator<String>{

        @Override
        public int compare(String lhs, String rhs) {
            if(lhs.length() != rhs.length())
                return lhs.length() -rhs.length();
            return lhs.compareTo(rhs);

        }


    }
    static void input(){
        FastReader scan = new FastReader();
        N = scan.nextInt();
        a = new String[N];
        for (int i = 0; i < N; i++) {
            a[i] = scan.next();
        }
    }
    static void answer(){
        Arrays.sort(a,new MyComparator());
        for (int i = 0; i < N; i++) {
            if (i==0 || a[i].compareTo(a[i-1])!=0) sb.append(a[i]).append('\n');
        }
            System.out.println(sb.toString());
    }
    public static void main(String args[]){
        input();
        answer();
    }
    public static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while(st==null||!st.hasMoreElements()){
                try{
                    st = new StringTokenizer(br.readLine());
                }catch(IOException e){
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
