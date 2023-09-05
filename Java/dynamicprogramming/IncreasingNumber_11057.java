package dynamicprogramming;

import java.util.*;
import java.io.*;

public class IncreasingNumber_11057 {
    static FastReader scan = new FastReader();

    static int N;
    static int[][] Dy;

    static void solve(){
        N = scan.nextInt();
        Dy = new int[N+1][10];

        for (int num = 0; num <= 9; num++) {
            Dy[1][num] = 1; //길이가 1이고 num으로 끝나는 수
        }

        //테이블 채우기(2부터 점화식 사용 가능)
        for (int len = 2; len <= N; len++) {
            for (int num = 0; num <= 9; num++) {
                //last가 9보다 작은 경우를 고려해야 했음
                for (int prev = 0; prev <= num; prev++) {
                    Dy[len][num] += Dy[len-1][prev];
                    Dy[len][num] %= 10007;
                }
            }
        }

        //N줄에 있는 개수 구하기
        int ans = 0;
        for (int num = 0; num <= 9; num++) {
            ans += Dy[N][num];
            ans %= 10007;
        }

        System.out.println(ans);
    }

    public static void main(String[] args) {
        solve();
    }

    static class FastReader {

        BufferedReader br;
        StringTokenizer st;

        FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
