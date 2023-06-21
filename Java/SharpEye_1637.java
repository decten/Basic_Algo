import java.util.*;
import java.io.*;

public class SharpEye_1637 {
    static int N;
    static int[][] a;
    static void input(){
        FastReader scan = new FastReader();
        N = scan.nextInt();
        a = new int[N][3];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                a[i][j] = scan.nextInt();
            }
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
