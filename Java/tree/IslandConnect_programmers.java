package tree;

import java.util.Arrays;
import java.util.Comparator;

public class IslandConnect_programmers {

    static int[] parent;
    static void solution(int n, int[][] costs) {
        int answer = 0;
        //악 유니온 파인드 왜 생각 못 했지
        parent = new int[costs.length];
        for (int i = 0; i < costs.length; i++) {
            parent[i] = i;
        }
        //다익스트라 안 가고 정렬 선에서 끝남
        Arrays.sort(costs, (a, b) -> Integer.compare(a[2], b[2]));

        for (int i = 0; i < costs.length ; i++) {
            int x = find(costs[i][0]);
            int y = find(costs[i][1]);

            if(find(x)!=find(y)){
                parent[y] = x;
                answer += costs[i][2];
            }
        }
        System.out.println(answer);
    }

    static int find(int a){
        if(parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }

    public static void main(String[] args) {
        solution(4, new int[][] {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}});
    }
}
