import java.util.*;
import java.io.*;

public class KEM_10825 {
    static void input(){
        FastReader scan = new FastReader();
        int N = scan.nextInt();
        for (int i = 0; i < N; i++) {

        }
    }
    static class Elem implements Comparable<Elem>{
    public String name;
    public int korean, english, math;
        @Override
        public int compareTo(Elem o) {

            return 0;
        }
    }
    public static void main(String args[]){
        input();
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
