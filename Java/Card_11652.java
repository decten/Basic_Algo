import java.util.*;
import java.io.*;

public class Card_11652 {
    static int N;
    static long[] A;
    static void answer(){
        Arrays.sort(A);
        //mode: 최빈값, modeCnt: 최빈값의 등장 횟수, curCnt: 현재 값의 등장 횟수
        long mode = A[0];
        int modeCnt = 1, curCnt = 1;

        for (int i = 1; i < N; i++) {
            if(A[i] == A[i-1]){
                curCnt++;
            }else{
                curCnt = 1;
            }
            // 최빈값이 같다면 앞에 있는 걸 최빈값으로 써야 해서 최대한 갱신이 안 일어나도록 큰 경우에만 한다
            if(curCnt > modeCnt){
                modeCnt = curCnt;
                mode = A[i];
            }
        }
        System.out.println(mode);
    }
    static void input(){
        FastReader scan = new FastReader();
        N = scan.nextInt();
        A = new long[N];
        for (int i = 0; i < N; i++) {
            A[i] = scan.nextLong();
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

        long nextLong(){
            return Long.parseLong(next());
        }
    }
}
