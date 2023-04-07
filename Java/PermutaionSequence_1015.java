import java.util.*;
import java.io.*;

public class PermutaionSequence_1015 {
    static int N;
    static int[] P;
    static Elem[] A;
    static class Elem implements Comparable<Elem>{
        public int num, idx;
        //num과 idx의 오름차순
        @Override
        public int compareTo(Elem other) {
            if(num!=other.num) return num-other.num;
            return idx-other.idx;
        }

    }
    static void answer(){
        Arrays.sort(A);
        for (int i = 0; i < N; i++) {
            P[A[i].idx] = i;
        }
        for (int i = 0; i < N; i++) {
            System.out.print(P[i]+" ");
        }

    }
    static void input(){
        FastReader scan = new FastReader();
        N = scan.nextInt();
        A = new Elem[N];
        P = new int[N];
        for (int i = 0; i < N ; i++) {
            A[i] = new Elem();
            A[i].num = scan.nextInt();
            A[i].idx = i;
        }
    }

    public static void main(String args[]){
        input();
        answer();
    }
    public static class FastReader{
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
