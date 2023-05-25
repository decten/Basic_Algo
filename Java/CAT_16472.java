import java.util.*;
import java.io.*;

public class CAT_16472 {
    static int N, kind;
    static String a;
    static int[] alpha = new int[26];

    static void input(){
        FastReader scan = new FastReader();
        N = scan.nextInt();
        a = scan.next();
    }
    //kind 처리 때문에 함수로 따로 빼는게 깔끔하다
    static void add(char x) {
        alpha[x - 'a']++;
        if (alpha[x - 'a'] == 1)
            kind++;
    }

    static void erase(char x) {
        alpha[x - 'a']--;
        if (alpha[x - 'a'] == 0)
            kind--;
    }
    static void answer(){
        int len = a.length(), ans = 0;
        //Right이 기준이 됨
        for (int left = 0, right=0; right < len; right++) {
            add(a.charAt(right));

            //가능할 때까지 Left 이동
            while(kind>N){
                erase(a.charAt(left++));
            }

            ans = Math.max(ans,right-left+1);
        }
        System.out.println(ans);
    }
    public static void main(String[] args) {
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
