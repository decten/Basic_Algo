import java.io.*;
import java.util.*;

public class PartialSum_1182 {
    static int N,S, answer;
    static int[] numbers;

    static void input(){
        FastReader scan = new FastReader();
        N = scan.nextInt();
        S = scan.nextInt();
        numbers = new int[N+1];
        for (int i = 0; i < N; i++) {
            numbers[i] = scan.nextInt();
        }
    }

    private static void rec_func(int k, int value) {
        if(k==N){//부분 수열을 완성
            if (value == S) answer++;
        }
        else{
            //k번째 원소를 포함시킬지 결정하고 재귀호출하기
            // Include
            rec_func(k+1, value+numbers[k]);
            // Exclude
            rec_func(k+1, value);
        }

    }

    public static void main(String[] args) {
        input();
        //왜 k=0, numbers[k+1]은 안 될까
        rec_func(1, 0);

        //진부분집합만
        if(S==0){
            answer--;
        }

        System.out.println(answer);
    }

    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(s));
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
        String nextLine(){
            String str = "";
            try{
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