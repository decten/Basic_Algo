import java.util.*;
import java.io.*;

public class NumberCard2_10816 {
    static int N,M;
    static int[] a,b;
    static List<Integer> ans = new ArrayList<>();
    static void input(){
        FastReader scan = new FastReader();
        N = scan.nextInt();
        a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i]=scan.nextInt();
        }
        M = scan.nextInt();
        b = new int[M];
        for (int i = 0; i < M; i++) {
            b[i]=scan.nextInt();
        }
    }
    static int upper_bound(int k){
        int left = 0;
        int right = M-1;
        int result = left;
        while(right>=left){
            int mid = (left+right)/2;
            if(a[mid] > k) return mid;
            else left = mid;
        }
        return result;
    }
    static int lower_bound(int k){
        int left = 0;
        int right = M-1;
        int result = right;

        while(right>=left){
            int mid = (left+right)/2;
            if(a[mid] >= k) return mid;
            else left = mid;
        }
        return result;
    }
    static void answer(){
        Arrays.sort(a);
        for (int i = 0; i < M; i++) {
            ans.add(upper_bound(b[i])-lower_bound(b[i]));
        }

        for (int answer: ans) {
            System.out.print(answer+" ");
        }
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
                    st=new StringTokenizer(br.readLine());
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
