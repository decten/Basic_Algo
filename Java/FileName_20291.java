import java.util.*;
import java.io.*;

public class FileName_20291 {
    static int N;
    static String[] a;
    static StringBuilder sb = new StringBuilder();
    static void input(){
        FastReader scan = new FastReader();
        N = scan.nextInt();
        a = new String[N];
        for (int i = 0; i < N; i++) {
            a[i] = scan.nextLine().split("\\.")[1];
        }
    }
    static void answer(){
        Arrays.sort(a);
        for (int i = 0; i < N; i++) {
            int cnt = 1, j=i+1;
            for (;j < N; j++) {
                if(a[j].compareTo(a[i])==0) cnt++;
                else break;
            }
            sb.append(a[i]).append(' ').append(cnt).append('\n');
            i=j;
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
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        String nextLine(){
            String str = "";
                try{
                    str = br.readLine();
                }catch (IOException e){
                    e.printStackTrace();
                }

            return str;
        }
        int nextInt(){
            return Integer.parseInt(next());
        }
    }
}
