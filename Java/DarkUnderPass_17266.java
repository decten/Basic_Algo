import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class DarkUnderPass_17266 {
    static int N, M;
    static List<Integer> array = new ArrayList<>();
    static void input(){
        FastReader scan = new FastReader();
        N = scan.nextInt();
        M = scan.nextInt();
        while(scan != null){
            array.add(scan.nextInt());
        }
    }

    static boolean deter(int k){
        return true;
    }

    static void bin_search(){
        int left=0, right=100000, ans=0;
        while(right>=left){
            int mid = (right+left)/2;
            if(deter(mid)){
                right = mid-1;
                ans = Math.min(ans,mid);
            }else{
                left = mid+1;
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
        bin_search();
    }
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next(){
            while (st==null||!st.hasMoreElements()){
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
