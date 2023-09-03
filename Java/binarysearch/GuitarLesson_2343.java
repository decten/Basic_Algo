package binarysearch;

import java.util.*;
import java.io.*;

public class GuitarLesson_2343 {
    static int N,M;
    static int[] a;
    static void input(){
        FastReader scan = new FastReader();
        N = scan.nextInt();
        M = scan.nextInt();
        a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = scan.nextInt();
        }
    }
    static boolean determination(long k){
        int cnt=1;
        int sum=0;
        for (int i = 0; i < N; i++) {
            sum+=a[i];
            if(sum>=k){
                cnt++;
                sum=a[i];
            }
        }
        return cnt<=M;
    }
    static void answer(){
        Arrays.sort(a);
        long left=a[0], right=1000000000,ans=0;
        for (int i = 0; i < N; i++) left = Math.max(left, a[i]);  // 적어도 제일 긴 녹화본의 길이 만큼은 필요하다!
        while(right>=left){
            long mid = (right+left)/2;
            if(determination(mid)){
                right = mid-1;
                ans = mid;
            }else{
                left = mid+1;
            }
        }
        System.out.println(ans-1);
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
