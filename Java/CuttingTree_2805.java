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
    }
    static int bin_search(int k){
        int left = 0;
        int right = N-1;
        while(right>=left){

        }
        return right;
    }
    static void answer(){
        int result = 0;
        Arrays.sort(a);
        int ans = a[N-1];

        while(result != M){
            result = 0;
            for (int i = 0; i < N; i++) {
                if(a[i]< ans) continue;
                result+=a[i]-ans;
            }
            ans--;
        }
        ans++;
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
