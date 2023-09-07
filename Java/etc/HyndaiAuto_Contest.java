package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class HyndaiAuto_Contest {
    static class Award implements Comparable<Award>{
        int team;
        int score;
        Award(int team, int score){
            this.team = team;
            this.score = score;
        }
        public int getTeam() {
            return team;
        }

        public int getScore() {
            return score;
        }

        @Override
        public int compareTo(Award other) {
            if (this.score == other.score) {
                return this.team - other.team; // 점수가 같으면 팀 번호가 낮은 순서대로
            }
            return other.score - this.score; // 점수가 높은 순서대로
        }
    }
    static int N,M,X;
    static int[] scores;
    static Award[] awards;

    static void input(){
        FastReader scan = new FastReader();
        N = scan.nextInt();
        M = scan.nextInt();
        X = scan.nextInt();
        scores = new int[M];
        awards = new Award[N];
        for (int i = 0; i < M; i++) {
            scores[i] = scan.nextInt();
        }
        for (int i = 0; i < N; i++) {
            int score = 0;
            for (int j = 0; j < M; j++) {
                if(scan.nextInt()==1) score+=scores[j];
            }
            awards[i] = new Award(i+1, score);
        }
        Arrays.sort(awards);
    }
    static void answer() {
        Set<Integer> winner = new HashSet<>();
        int[] rank = new int[N];

        rank[0] = 1; // 첫 번째 팀의 등수는 1로 초기화
        int cnt = 1;
        for (int i = 1; i < N; i++) {
            if (awards[i].getScore() == awards[i-1].getScore()) {
                rank[i] = rank[i-1];
                cnt++;
            } else {
                rank[i] = rank[i-1] + cnt;
                cnt=1;
            }
        }

        for (int i = 0; i < N; i++) { // 모든 팀에 대해 반복
            if (rank[i] % X == 0 || awards[i].getScore() % X == 0) { // 팀의 등수가 X의 배수이거나, 팀의 합산 점수가 X로 나누어 떨어지면
                winner.add(awards[i].getTeam()); // 수상하는 팀으로 추가
            }
        }
        for (int w : winner) {
            System.out.println(w);
        }
    }
    public static void main(String args[]){
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
                }catch(IOException e){
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
