import java.util.*;
import java.io.*;

public class GuitarLesson_2343 {
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
    }
    static boolean determination(long k){
        int cnt=1;
        int sum=0;
        for (int i = 0; i < N; i++) {
            sum+=a[i];
            if(sum>=k){
                cnt++;
                sum=a[i];
            }
        }
        return cnt==M;
    }
    static void answer(){
        Arrays.sort(a);
        long left=0, right=1000000000,ans=0;
        while(right>=left){
            long mid = (right+left)/2;
            if(determination(mid)){
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
                try {
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
