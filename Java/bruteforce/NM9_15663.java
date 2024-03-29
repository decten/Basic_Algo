package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NM9_15663 {

    static int N, M;
    static int[] input_array, selected, used;
    static StringBuilder stringBuilder = new StringBuilder();

    static void input() {
        FastReader scanner = new FastReader();
        N = scanner.nextInt();
        M = scanner.nextInt();
        input_array = new int[N];
        selected = new int[M + 1];
        used = new int[N + 1];
        for (int i = 0; i < N; i++) {
            input_array[i] = scanner.nextInt();
        }
        Arrays.sort(input_array);
    }

    static void rec_func(int k) {
        if (k == M) {
            for (int i = 0; i < M; i++) {
                stringBuilder.append(selected[i]).append(' ');
            }
            stringBuilder.append('\n');
        } else {
            int last_candi = 0;
            for (int candi = 0; candi < N; candi++) {
                if (used[candi] == 1) {
                    continue;
                }
                if (last_candi == input_array[candi]) {
                    continue;
                }

                selected[k] = input_array[candi];
                last_candi = input_array[candi];
                used[candi] = 1;
                rec_func(k + 1);
                selected[k] = 0;
                used[candi] = 0;
            }
        }
    }

    static public void main(String[] args) {
        input();
        rec_func(0);

        System.out.print(stringBuilder.toString());

    }

    static public class FastReader {

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
                    //noinspection CallToPrintStackTrace
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
