import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class OrganicCabbage_1012 {
    static int T,N,M,K;
    //멀티소스 bfs로 여러 시작점의 큐 시도
    static Queue<Integer> queue = new LinkedList<>();
    static void input(){
        FastReader scan = new FastReader();
        T = scan.nextInt();
        while (T>0){
            //M이 먼저 입력 됨
            M = scan.nextInt();
            N = scan.nextInt();
            K = scan.nextInt();

            for (int i = 0; i < K; i++) {
                //x, y 값을 넣음
                queue.add(scan.nextInt());
                queue.add(scan.nextInt());
            }
            bfs();
            T--;
        }
    }
    public static void bfs(){

    }

    public static void main(String[] args){
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
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
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
