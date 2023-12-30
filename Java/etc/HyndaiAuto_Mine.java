package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HyndaiAuto_Mine {

    static int N, M;
    static int[][] array;
    static int[][] H_shape =
        {
            {1, 0, 1},
            {1, 1, 1},
            {1, 0, 1}
        };
    static int[][] I_shape =
        {
            {1, 1, 1},
            {0, 1, 0},
            {1, 1, 1}
        };

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        M = scan.nextInt();
        array = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                array[i][j] = scan.nextInt();
            }
        }
    }

    static void answer() {
        int max_resource = 0;

        // 0~N-3까지
        for (int i = 0; i < N - 2; i++) {
            for (int j = 0; j < M - 2; j++) {
                int H_sum = 0;
                int I_sum = 0;

                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        H_sum += array[i + k][j + l] * H_shape[k][l];
                    }
                }
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        I_sum += array[i + k][j + l] * I_shape[k][l];
                    }
                }
                max_resource = Math.max(max_resource, Math.max(H_sum, I_sum));
            }
        }

        System.out.println(max_resource);
    }

    public static void main(String args[]) {
        input();
        answer();
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
