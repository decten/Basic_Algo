package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class ArrowDrawing_15970 {

    static int N;
    static ArrayList<Integer>[] a;

    public static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        a = new ArrayList[N];
        for (int color = 0; color < N; color++) {
            a[color] = new ArrayList<>();
        }
        for (int i = 0; i < N; i++) {
            int coord, color;
            coord = scan.nextInt();
            color = scan.nextInt() - 1; //color는 1부터 시작함
            a[color].add(coord);
        }
    }

    public static int toLeft(int color, int idx) {
        if (idx == 0) {
            return Integer.MAX_VALUE;
        }
        return a[color].get(idx) - a[color].get(idx - 1);
    }

    public static int toRight(int color, int idx) {
        if (idx + 1 == a[color].size()) {
            return Integer.MAX_VALUE;
        }
        return a[color].get(idx + 1) - a[color].get(idx);
    }

    public static void answer() {
        int answer = 0;
        for (int color = 0; color < N; color++) {
            Collections.sort(a[color]);
        }
        for (int color = 0; color < N; color++) {
            for (int i = 0; i < a[color].size(); i++) {
                int left = toLeft(color, i);
                int right = toRight(color, i);
                answer += Math.min(left, right);
            }
        }
        System.out.println(answer);
    }

    public static void main(String args[]) {
        input();
        answer();
    }

    public static class FastReader {

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

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
