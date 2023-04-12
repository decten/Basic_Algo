import java.util.*;
import java.io.*;

public class TwoLiquid_2470 {
    static int N;
    static int[] A;
    static void input(){
        FastReader scan = new FastReader();
        N = scan.nextInt();
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = scan.nextInt();
        }
    }
    static int lower_bound(int[] array, int L, int R, int X){
        int res = R;
        while (R>=L){
            int mid = (R+L)/2;
            if(array[mid] >= X){
                res = mid;
                R= mid-1;
            }else{
                L = mid +1;
            }
        }
        return res+1;
    }
    static void answer(){
        Arrays.sort(A);

        int best_sum = Integer.MAX_VALUE;
        int v1 = 0, v2 = 0;
        for (int left = 0; left < N-1; left++) {
            int res = lower_bound(A, left+1, N-1, -A[left]);

            if(left<=res-1 && Math.abs(A[res-1]+A[left])<best_sum){
                best_sum = Math.abs(A[res-1]+A[left]);
                v1 = A[left];
                v2 = A[res-1];

            }
            if(res<N-1 && Math.abs(A[res]+A[left])<best_sum){
                best_sum = Math.abs(A[res]+A[left]);
                v1 = A[left];
                v2 = A[res];
            }
        }
        System.out.printf("%d %d",v1,v2);
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
