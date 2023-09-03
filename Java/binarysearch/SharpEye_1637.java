package binarysearch;

import java.util.*;
import java.io.*;

public class SharpEye_1637 {
    static int N;
    static int[][] a;
    static void input(){
        FastReader scan = new FastReader();
        N = scan.nextInt();
        a = new int[N][3];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                a[i][j] = scan.nextInt();
            }
        }
    }

    static boolean deter(int k){
        long sum = 0;
        for (int i = 0; i < N; i++) {
            sum += count(a[i][0], a[i][1], a[i][2],k);
        }
        return sum % 2 == 1;
    }

    private static int count(int a, int c, int b, int k) {
        if(k < a) return 0;
        if(k > c) return (c-a)/b+1;
        return (k-a) / b + 1;
    }

    static void answer(){
        long left =1 , right = Integer.MAX_VALUE, ans = 0, ansCnt = 0;
        while(right>=left){
            long mid = (left+right)/2;
            if(deter((int)mid)){
                ans = mid;
                right = mid -1;
            }else{
                left = mid + 1;
            }
        }
        if (ans == 0) {
            System.out.println("NOTHING");
        }else{
            for (int i = 0; i < N; i++) {
                //마지막은 공차가 맞는지 확인
                if (a[i][0] <= ans && ans <= a[i][1] && (ans-a[i][0]) % a[i][2] == 0) ansCnt++;
            }
        }
        System.out.println(ans+" "+ansCnt);
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
        String nextLine(){
           String str = "";
           try{
               str = br.readLine();
           }catch (IOException e){
               e.printStackTrace();
           }
           return str;
        }
        int nextInt(){
            return Integer.parseInt(next());
        }
    }
}
