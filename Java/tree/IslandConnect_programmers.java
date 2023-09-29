package tree;

public class IslandConnect_programmers {

    static int[] parent;
    static void solution(int n, int[][] costs) {
        int answer = 0;
        //악 유니온 파인드 왜 생각 못 했지
        parent = new int[costs.length];
        System.out.println(answer);
    }

    static int find(int a){
        if(parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }
    static void union(int x, int y){
        if(find(x)!=find(y)){
            parent[y] = x;
        }
    }

    public static void main(String[] args) {
        solution(4, new int[][] {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}});
    }
}
