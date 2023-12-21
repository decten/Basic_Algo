package graph;

import java.io.*;
import java.util.*;

public class PerfectBST_9934 {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    static int K;
    static List<Integer> L = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    static void input() {
        FastReader scan = new FastReader();
        K = (int) Math.pow(2, scan.nextInt()) - 1;
        for (int i = 0; i < K; i++) {
            L.add(scan.nextInt());
        }
    }

    //중앙 값 노드를 기준으로 왼쪽, 오른쪽 트리 나눠짐
    static Node buildTreee(int start, int end) {
        //재귀함수 종료
        if (start > end) {
            return null;
        }

        int i = (start + end) / 2;
        Node node = new Node(L.get(i));

        if (start == end) {
            return node;
        }

        node.left = buildTreee(start, i - 1);
        node.right = buildTreee(i + 1, end);
        return node;
    }

    static void answer() {
        Node root = buildTreee(0, L.size() - 1);

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                Node node = queue.poll();
                sb.append(node.data + " ");
                //전위순회라서 왼쪽 먼저
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            sb.append('\n');
        }

        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        input();
        answer();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
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

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
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
    }
}
