import java.util.*;
import java.io.*;

public class HyndaiAuto_Tracing {
    static char[][] array;
    static int N,K;

    static void input(){
        FastReader scan = new FastReader();
        N = scan.nextInt();
        K = scan.nextInt();
        array = new char[N][N];
        for(int i=0; i<N; i++){
            String row = scan.next();
            for(int j=0; j<N;j++){
                array[i][j] = row.charAt(j);
            }
        }
    }

    static void answer(){
        int ans = 0;

        for(int track=0; track<N; track++){
            int cnt = 1;
            int a_cnt = 0;
            int b_cnt = 0;

            for(int date=0; date<=K;date++){
                if(cnt==K+1) {
                    ans = Math.max(ans,Math.abs(a_cnt-b_cnt));
                    break;
                }
                if(array[date][track]=='a') a_cnt++;
                else b_cnt++;
                cnt++;

            }
        }

        System.out.println(ans);
    }

    public static void main(String args[]){
        input();
        answer();
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
