package greedy;

import java.util.*;
import java.io.*;

public class MeetingroomAssign_1931 {
    static int N;
    //배열 형태의 List
    static List<int[]> a = new ArrayList<>();

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        for (int i = 0; i < N; i++) {
            int x = scan.nextInt(), y = scan.nextInt();
            a.add(new int[]{x, y});
        }
        Collections.sort(a, (x, y) ->
        {
            return x[1] == y[1] ? x[0] - y[0] : x[1] - y[1];
        });
    }

    static void solve() {
        PriorityQueue<Integer> meeting = new PriorityQueue<>();
        meeting.add(a.get(0)[1]);

        int cnt = 1;
        for (int i = 1; i < N; i++) {
            int[] rooms = a.get(i);

            if (rooms[0] >= meeting.peek()) {
                cnt++;
                meeting.poll();
                meeting.add(rooms[1]);
            }

        }
        System.out.println(cnt);

//        int count = 0;
//        int prev_end_time = 0;
//
//        for(int i = 0; i < N; i++) {
//            if(prev_end_time <= a.get(i)[0]) {
//                prev_end_time = a.get(i)[1];
//                count++;
//            }
//        }
//
//        System.out.println(count);
    }

    public static void main(String[] args) {
        input();
        solve();
    }

    static class FastReader {
        StringTokenizer st;
        BufferedReader br;

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
