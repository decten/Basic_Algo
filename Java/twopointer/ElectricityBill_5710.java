package twopointer;

import java.util.*;
import java.io.*;
public class ElectricityBill_5710 {
    static FastReader scan = new FastReader();
    static int a, b;

    public static int cal_watt(int p) {
        if (p <= 200) {
            return p / 2;
        } else if (p <= 29900) {
            return (p - 200) / 3 + 100;
        } else if (p <= 4979900) {
            return (p - 29900) / 5 + 10000;
        } else {
            return (p - 4979900) / 7 + 1000000;
        }
    }


    public static int cal_price(int watt) {
        if (watt <= 100) {
            return watt * 2;
        } else if (watt <= 10000) {
            return 200 + (watt - 100) * 3;
        } else if (watt <= 1000000) {
            return 200 + 29700 + (watt - 10000) * 5;
        } else {
            return 200 + 29700 + 4950000 + (watt - 1000000) * 7;
        }
    }
    static void input(){
        while (true) {
            a = scan.nextInt();
            b = scan.nextInt();

            if (a == 0 && b == 0) return;

            solve();

        }
    }

    static void solve() {
        int total = cal_watt(a);
        int left = 0;
        int right = total / 2;
        while (left <= right) {
            int mid = (left + right) / 2;

            int s_price = cal_price(mid);
            int n_price = cal_price(total - mid);

            int diff = Math.abs(s_price - n_price);
            if (diff < b) {
                right = mid - 1;
            } else if (diff > b) {
                left = mid + 1;
            } else {
                System.out.println(cal_price(mid));
                break;
            }
        }
    }
    public static void main(String[] args) {
        input();
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
                } catch (IOException e) {
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
