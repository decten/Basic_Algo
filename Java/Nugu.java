import java.util.*;
import java.io.*;

public class Nugu {
    static int N,M;
    static String[] A, B;
    static StringBuilder sb = new StringBuilder();

    static void input(){
        FastReader scan = new FastReader();
        N = scan.nextInt();
        M = scan.nextInt();
        A = new String[N];
        B = new String[M];

        for (int i = 0; i < N; i++) {
            A[i] = scan.next();
        }
        for (int i = 0; i < M; i++) {
            B[i] = scan.next();
        }
    }
    static void answer(){
        Arrays.sort(A);
        Arrays.sort(B);
        int count = 0;
        for (int i = 0; i < N; i++) {
            if(bin_search(B,0,M-1,A[i])) {
                count++;
                sb.append(A[i]).append('\n');
            }
        }
        System.out.printf("%d\n%s",count,sb);
    }
    // array[mid].compareTo(X) == 0 -> 왜 equals를 생각 못 했을까
    static boolean bin_search(String[] array, int L, int R, String X){
        while(R>=L){
            int mid = (L+R)/2;
            if(array[mid].equals(X)) return true;
            if(array[mid].compareTo(X) > 0){
                R = mid-1;
            }else{
                L=mid+1;
            }
        }
        return false;
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
