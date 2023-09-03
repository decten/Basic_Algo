package tree;

import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public class PhoneNumberList_5052 {
    static int T;
    static ArrayList<String> numbers;
    static StringBuilder sb = new StringBuilder();
    static class Trie{
        Trie[] node;
        boolean isEnd;

        Trie(){
            //여기선 핸드폰 번호라 0~9 숫자만 가짐
            this.node = new Trie[10];
            this.isEnd = false;
        }

        public void add(String s){
            if (s.length()==0) return;

            Trie[] nodes = this.node;
            Trie curr = null;

            //번호 안에 trie가 또 존재(123이면 1안에 2안에 3 이런식)
            for (char c: s.toCharArray()){
                int num = c - '0';
                if(nodes[num]==null){
                    nodes[num] = new Trie();
                }
                curr = nodes[num];
                //번호가 가지고 있는 trie를 저장
                nodes = nodes[num].node;
            }
            //for문이 끝나고 가장 마지막 노드를 가리킴
            curr.isEnd = true;
        }

        public boolean check(String s){
            Trie[] nodes = this.node;
            Trie curr = null;

            for(int i=0; i<s.length(); i++){
                int n = s.charAt(i)-'0';
                curr = nodes[n];
                //끝까지 안 갔음에도 이미 숫자가 존재하는 경우: 일관성이 없는 경우
                if(curr.isEnd && i < s.length() -1) {
                    return false;
                }
                nodes = curr.node;
            }
            return true;
        }
    }
    static void input() {
        FastReader scan = new FastReader();
        T = scan.nextInt();

        while (T > 0) {
            int N = scan.nextInt();
            numbers = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                numbers.add(scan.next());
            }
            sb.append(solve());
            T--;
        }
        System.out.println(sb.toString());
    }

    static String solve() {
        Trie root = new Trie();
        numbers.forEach(number -> root.add(number));

        boolean check = true;
        for (String number : numbers) {
            if (!root.check(number)) {
                check = false;
                break;
            }
        }

        if (!check)
            return "NO\n";
        else
            return "YES\n";
    }

    public static void main(String[] args){
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
