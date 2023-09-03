package binarysearch;

import java.io.*;
import java.util.*;

public class RouterInstall_2110 {
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
        Arrays.sort(a);
    }
    static boolean determination(int k){
        int cnt = 1, last = a[0];
        for (int i = 1; i < N; i++) {
            if(a[i]-last>=k) {
                cnt++;
                last = a[i];
            }
        }
        return cnt>=M;
    }
    static void answer(){
        int left=0, right=1000000000, ans=0;
        while (right>=left){
            int mid = (left+right)/2;
            if(determination(mid)){
                ans = mid;
                left = mid+1;
            }else{
                right = mid-1;
            }
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
