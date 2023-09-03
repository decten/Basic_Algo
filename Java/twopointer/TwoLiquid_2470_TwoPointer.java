package twopointer;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class TwoLiquid_2470_TwoPointer {
    static int N;
    static int[] a;
    static int[] b = new int[2];
    static void input(){
        FastReader scan = new FastReader();
        N = scan.nextInt();
        a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = scan.nextInt();
        }
        Arrays.sort(a);
    }

    static void answer(){
        int right = N-1, left=0, ans = Integer.MAX_VALUE, sum = 0;
        //right=left가 되는 순간 끝이 남
        while(right>left){
            sum = a[left]+a[right];
            if(Math.abs(ans) >= Math.abs(sum)){
                ans = sum;
                b[0] = a[left];
                b[1] = a[right];
            }
            if(sum > 0) right--;
            else left++;
        }
        System.out.println(b[0]+" "+b[1]);
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
