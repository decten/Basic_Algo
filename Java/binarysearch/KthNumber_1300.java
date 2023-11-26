package binarysearch;

import java.util.*;
import java.io.*;

//문제에서 인덱스를 1부터 사용함!
public class KthNumber_1300 {
    static int N;
    static long M;
    static void input(){
        FastReader scan = new FastReader();
        N = scan.nextInt();
        M = scan.nextLong();
    }
    static boolean multiple_check(long k){
        long ans = 0;
        for (int i = 1; i <= N; i++) {
            ans += Math.min(k/i,N);
        }
        return ans >= M;
    }
    static long bin_search(){
        long ans = 0;
        long left = 1;
        long right = (long) N*N;

        while(right>=left){
            long mid = (left+right)/2;
            if(multiple_check(mid)){
                right = mid-1;
                ans = mid;
            }else{
                left = mid+1;
            }
        }
        return ans;
    }

    static void answer(){
        System.out.println(bin_search());
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
