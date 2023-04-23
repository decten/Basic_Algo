import java.util.*;
import java.io.*;

public class CuttingTree_2805 {
    static int N,M;
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
    static boolean determination(int H){
        long sum = 0;
        for (int i = 0; i < N; i++) {
            sum += a[i]-H;
        }
        return sum >= M;
    }
    static void bin_search(){
        long ans = 0;
        long left = 0;
        long right = M;
        while(right>=left){
            int mid = (int) (left+right)/2;
            if(determination(mid)){
                ans = mid;
                left = mid+1;
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
