package sort;

import java.util.*;
import java.io.*;

public class KEM_10825 {
    static int N;
    static Elem[] a;
    static StringBuilder sb = new StringBuilder();
    static void input(){
        FastReader scan = new FastReader();
        N = scan.nextInt();
        a = new Elem[N];
        for (int i = 0; i < N; i++) {
            a[i] = new Elem();
            a[i].name = scan.next();
            a[i].korean = scan.nextInt();
            a[i].english = scan.nextInt();
            a[i].math = scan.nextInt();
        }
    }
    static void answer(){
        Arrays.sort(a);
        for (int i = 0; i < N; i++) {
            sb.append(a[i].name).append('\n');
        }
        System.out.println(sb.toString());
    }
    static class Elem implements Comparable<Elem>{
    public String name;
    public int korean, english, math;
        @Override
        public int compareTo(Elem other) {
            if(korean != other.korean) return other.korean - korean;
            if(english != other.english) return english - other.english;
            if(math != other.math) return other.math - math;
            return name.compareTo(other.name);
        }
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
        FastReader(String s) throws IOException{
            br = new BufferedReader(new FileReader(new File(s)));
        }
        String next(){
            while(st==null || !st.hasMoreElements()){
                try{
                st = new StringTokenizer(br.readLine());
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        String nextLine(){
            String str = "";
            try{
                str = br.readLine();
            }catch(IOException e){
                e.printStackTrace();
            }
            return str;
        }
        int nextInt(){
            return Integer.parseInt(next());
        }
    }
}
