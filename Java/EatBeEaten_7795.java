import java.io.*;
import java.util.*;
public class EatBeEaten_7795 {
    static int N, M;
    static int[] A,B;
    static int lower_bound(int[] array, int L, int R, int X){
        int result = L;
        while (L<=R){
            int mid = (L+R)/2;
            if(array[mid]< X){
                result = mid+1;
                L = mid+1;
            }
            else{
                R = mid -1;
            }
        }
        return result;
    }
    static void answer(){
        int ans = 0;
        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = 0; i < N; i++) {
            ans+= lower_bound(B, 0, M-1, A[i]);
        }

        System.out.println(ans);
    }
    static void input(){
        FastReader scan = new FastReader();
        int T = scan.nextInt();
        while (T>0){
            N = scan.nextInt();
            M = scan.nextInt();
            A = new int[N];
            B = new int[M];

            for (int i = 0; i < N; i++) {
                A[i] = scan.nextInt();
            }

            for (int i = 0; i < M; i++) {
                B[i] = scan.nextInt();
            }

            answer();

            T--;
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

        int nextInt(){
            return Integer.parseInt(next());
        }
    }
}
