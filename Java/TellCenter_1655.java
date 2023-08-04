import java.util.*;
import java.io.*;
public class TellCenter_1655{
    static int N;
    static PriorityQueue<Integer> min = new PriorityQueue<>();
    static PriorityQueue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args){
        FastReader scan = new FastReader();
        N = scan.nextInt();

        for (int i = 0; i < N; i++) {
            int x = scan.nextInt();

            //번갈아가면서 저장
            if(max.size()== min.size()){
                max.offer(x);
            }else{
                min.offer(x);
            }
            //max는 min 보다 작거나 같은 값들로 -> max의 루트가 중간 값
            if(!min.isEmpty() && max.peek() > min.peek()){
                min.offer(max.poll());
                max.offer(min.poll());
            }
            sb.append(max.peek()+"\n");
        }
        System.out.println(sb.toString());
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
                }catch(IOException e){
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
