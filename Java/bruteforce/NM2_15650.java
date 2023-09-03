package bruteforce;

import java.util.*;
import java.io.*;

public class NM2_15650 {
    static StringBuilder sb = new StringBuilder();
    static int N,M;
    static int[] selected;
    static void input(){
        FastReader scan = new FastReader();
        N = scan.nextInt();
        M = scan.nextInt();
        selected = new int[M+1];
    }
    static void rec_func(int k){
        if(k==M+1){
            for (int i = 1; i <= M; i++) sb.append(selected[i]).append(' ');
            sb.append('\n');
        }else{
            //이전에 쓰인 숫자보다 1크게
            for (int present = selected[k-1]+1; present <= N ; present++) {
                selected[k] = present;
                rec_func(k+1);
                selected[k] = 0;
            }
        }
    }

    public static void main(String[] args) {
        input();
        rec_func(1);

        System.out.println(sb.toString());
    }

    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        FastReader(String s) throws FileNotFoundException{
            br = new BufferedReader(new FileReader(s));
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
