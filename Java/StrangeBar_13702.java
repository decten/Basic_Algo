import java.io.*;
import java.util.*;

public class StrangeBar_13702 {
    static int N, M;
    static int[] a;
    static void input(){
        FastReader scan = new FastReader();
        N = scan.nextInt();
        M = scan.nextInt();
        a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = scan.nextInt();
        }
        Arrays.sort(a);
    }
    static boolean deter(int k){
        int ans = 0;
        for (int i = 0; i < N; i++) {
            ans += a[i]/k;
        }
        return ans >= M;
    }
    static void bin_search(){
        int ans = 0;
        int right = a[N-1];
        int left = 0;

        while(right>=left){
            int mid = (right+left)/2;
            if(deter(mid)){
                left = mid+1;
                ans = mid;
            }else{
                right = mid-1;
            }
        }

        System.out.println(ans);
    }
    public static void main(String[] args) {
        input();
        bin_search();
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
        int nextInt(){
            return Integer.parseInt(next());
        }
    }
}
