import java.util.*;
import java.io.*;

public class Good_1253 {
    static int N;
    static int[] a;

    static void input(){
        FastReader scan = new FastReader();
        N = scan.nextInt();
        a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = scan.nextInt();
        }
        Arrays.sort(a);
    }

    static boolean sum(int idx){
        int left=0, right = N-1, target=a[idx];
        while(right>left){
            //left, right 범위 체크를 생각 못 함
            if(left == idx) left++;
            else if (right == idx) right--;
            else{
                if(a[left]+a[right]==target) return true;
                if(a[left]+a[right]>target) right--;
                else left++;
            }
        }
        return false;
    }
    static void answer(){
        int ans = 0;
        for (int idx = 0; idx < N; idx++) {
            if(sum(idx)) ans++;
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
