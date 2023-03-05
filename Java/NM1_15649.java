import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NM1_15649 {
    static int N,M;
    static int[] selected, used;

    static StringBuilder sb = new StringBuilder();

    static void input(){
        FastReader scan = new FastReader();
        N = scan.nextInt();
        M = scan.nextInt();
        selected = new int[M+1];
    }

// M개를 고름
    static void rec_func(int k){
        if (k==M+1){
            //selected[1...M]
            for (int i = 1; i<=M; i++) sb.append(selected[i]).append(' ');
            sb.append('\n');
        }else{
            for(int cand = 1; cand<=N; cand++){
                if(used[cand] == 1) continue;

                //k번째에 cand가 올 수 있으면
                selected[k] = cand;
                //select에 넣은 수 마킹
                used[cand] = 1;
                //k+1번부터 M번까지 채워준다
                rec_func(k+1);
                selected[k] = 0;
                used[cand] = 0;
            }
        }
    }

    public static void main(String[] args) {
        input();
        // 1번째 원소부터 M번째 원소
        rec_func(1);

        System.out.println(sb.toString());
    }

    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        public FastReader(String s) throws FileNotFoundException{
            br = new BufferedReader(new FileReader(new File(s)));
        }
        String next(){
            while (st == null || !st.hasMoreElements()){
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
        double nextDouble(){
            return Double.parseDouble(next());
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
    }
}