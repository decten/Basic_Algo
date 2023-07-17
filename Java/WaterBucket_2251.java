import java.util.*;
import java.io.*;

public class WaterBucket_2251 {
    static int A, B, C;
    static int[] water = new int[3];
    static HashSet<Integer> answer = new HashSet<>();
    static void input(){
        FastReader scan = new FastReader();
        A = scan.nextInt();
        B = scan.nextInt();
        C = scan.nextInt();
        water[2] = C;
    }
    static void ans(){

        //Hash는 정렬이 안 됨
        answer.stream().sorted().forEach(System.out::println);
    }
    public static void main(String[] args) {
        input();
        ans();
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
