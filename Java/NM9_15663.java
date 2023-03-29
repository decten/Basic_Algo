import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class NM9_15663 {
    static int N, M;
    static int[] input_array,selected;
    static StringBuilder stringBuilder = new StringBuilder();
    static void input(){
        FastReader scanner = new FastReader();
        N = scanner.nextInt();
        M = scanner.nextInt();
        input_array = new int[N+1];
        selected = new int[M+1];
        for (int i = 0; i < N; i++) {
            input_array[i] = scanner.nextInt();
        }
        Arrays.sort(input_array);
    }
    static void rec_func(int k){
        int[] answer = new int[M+1];
        if(k==M){
            for (int i = 0; i < M; i++) stringBuilder.append(answer[i]).append(' ');
            stringBuilder.append('\n');
        }else{
            for (int candi = 0; candi < N; candi++) {

                selected[k] = candi;
                rec_func(k+1);
                selected[k] = 0;
            }
        }
    }

    static public void main(String[] args){
        input();
        rec_func(0);

        System.out.print(stringBuilder.toString());

    }
    static public class FastReader{
        BufferedReader br;
        StringTokenizer st;

        FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        FastReader(String s) throws IOException{
            br = new BufferedReader(new FileReader(new File(s)));
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
        String nextLine(){
            String str = "";
            try {
                str = br.readLine();
            }catch (IOException e){
                e.printStackTrace();
            }
            return str;
        }
        int nextInt(){
            return Integer.parseInt(next());
        }
    }
}
