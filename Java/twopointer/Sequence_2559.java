package twopointer;

import java.util.*;
import java.io.*;

public class Sequence_2559 {
    static int N, K;
    static int[] a;

    static void input(){
        FastReader scan = new FastReader();
        N = scan.nextInt();
        K = scan.nextInt();
        a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = scan.nextInt();
        }
    }
    static void answer(){
        int ans = Integer.MIN_VALUE, day = 0, sum = 0;
        for (int left = 0, right=0; left+K-1 < N; left++) {
            while (right+1 <= left+K) {
                sum += a[right++];
            }
            ans = Math.max(ans,sum);
            sum -= a[left];
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

        FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
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

        int nextInt(){
            return Integer.parseInt(next());
        }
    }
}
