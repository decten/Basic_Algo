package graph;

import java.util.*;
import java.io.*;
public class WaterBucket_2251 {
    static class State{
        int[] x;
        State(int[] _x){
            x = new int[3];
            for (int i = 0; i < 3; i++) {
                x[i] = _x[i];
            }
        }
        //물통은 총 3개이나, 물을 옮기는 행위는 B->A, C->B 이런 식으로 2개의 물통을 대상으로 이뤄짐
        State move(int from, int to, int[] Limit){
            int[] nX = new int[]{x[0],x[1],x[2]};
            //from의 물을 옮기면, 담는(to) 통이 꽉 차는 경우
            if(x[from] + x[to] >= Limit[to]){
                // 원래 통은 물을 다 옮기지 않고, 채울 수 있는 만큼만 넣음
                nX[from] -= Limit[to] - x[to];
                // 담는 통은 꽉 채움
                nX[to] = Limit[to];
            }else//from이 먼저 바닥나는 경우
            {
                nX[to] += nX[from];
                nX[from] = 0;
            }
            return new State(nX);
        }
    };
    static int[] Limit;
    //마지막 통의 용량만 체크
    static boolean[] possible;
    //전체 통의 방문 여부 체크
    static boolean[][][] visit;
    static StringBuilder sb = new StringBuilder();
    static void input(){
        FastReader scan = new FastReader();
        Limit = new int[3];
        for (int i = 0; i < 3; i++) {
            Limit[i] = scan.nextInt();
        }
        visit = new boolean[205][205][205];
        possible = new boolean[205];
    }
    static void bfs(int x1, int x2, int x3){
        Queue<State> queue = new LinkedList<>();
        visit[x1][x2][x3] = true;
        queue.add(new State(new int[] {x1,x2,x3}));

        while(!queue.isEmpty()){
            State st = queue.poll();
            //첫 번째 물통이 비어 있을 때, 세 번째 물통에 담겨 있을 수 있는 물의 양
            if(st.x[0] == 0) possible[st.x[2]] = true;
            for (int from = 0; from < 3; from++) {
                for (int to = 0; to < 3; to++) {
                    //같은 물통끼리는 교환 X
                    if(from==to) continue;
                    State next = st.move(from, to, Limit);

                    if(!visit[next.x[0]][next.x[1]][next.x[2]]){
                        visit[next.x[0]][next.x[1]][next.x[2]] = true;
                        queue.add(next);
                    }
                }
            }
        }
    }
    static void ans(){
        bfs(0,0,Limit[2]);
        //possible과 Limit의 크기를 동일하게 설정해서 마지막 요소까지 접근 가능
        for (int i = 0; i <= Limit[2]; i++) {
            if(possible[i]) sb.append(i).append(' ');
        }
        System.out.println(sb.toString());
    }
    public static void main(String[] args) {
        input();
        ans();
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

        int nextInt(){
            return Integer.parseInt(next());
        }
    }
}
