package binarysearch;

import java.util.*;
import java.io.*;

public class AllowanceManagement_6236 {
    static int N,M;
    static int[] a;
    static void input(){
        FastReader scan = new FastReader();
        N = scan.nextInteger();
        M = scan.nextInteger();
        a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = scan.nextInteger();
        }
    }
    static boolean determination(int k){
        int cnt = 1, sum=0;
        for (int i = 0; i < N; i++) {
            if(sum+a[i] > k){
                cnt++;
                sum = a[i];
            }else{
                sum += a[i];
            }
        }
        return cnt<=M;
    }

    static void answer(){
        Arrays.sort(a);
        int left=a[0], right=1000000000, ans=0;
        for (int i = 0; i < N; i++) {
            left = Math.max(left,a[i]);
        }
        while (right>=left){
            int mid = (right+left)/2;
            if(determination(mid)){
                right = mid-1;
                ans = mid;
            }else{
                left = mid+1;
            }
        }
        System.out.println(ans);
    }
    static public void main(String args[]){
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
        int nextInteger(){
            return Integer.parseInt(next());
        }
    }
}
