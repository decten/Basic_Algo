package graph;

import java.util.Arrays;

public class CheckingDistance_programmers {

    static int[] answer;
    static boolean visited[][];
    static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    static void solution(String[][] places) {
        answer = new int[places.length];

        for (int i = 0; i < places.length; i++) {
            answer[i] = 1;
        }

        int num = 0;
        for (String[] place : places) {
            visited = new boolean[5][5];
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if(place[i].charAt(j)=='P'){
                        visited[i][j] = true;
                        dfs(place, num, i, j, 0);
                        visited[i][j] = false;
                    }
                }
            }
            num++;
        }

        for (int ans : answer) {
            System.out.println(ans);
        }

    }
    static void dfs(String[] place, int num, int i, int j, int cnt){
        if (cnt > 2) return;
        //1, 2회에서 사람이 있는지 확인해야 함
        if (cnt >0 && cnt <=2 && place[i].charAt(j) == 'P'){
            answer[num] = 0;
            return;
        }
        for (int k = 0; k < 4; k++) {
            int nx = i + dir[k][0];
            int ny = j + dir[k][1];

            if (nx<0||ny<0||nx>=5||ny>=5) continue;
            if (place[nx].charAt(ny)=='X') continue;
            if (visited[nx][ny]) continue;

            visited[nx][ny] = true;
            dfs(place,num,nx,ny,++cnt);
            visited[nx][ny] = false;
        }
    }

    public static void main(String[] args) {
        String[][] places = {
            {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
            {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
            {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
            {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
            {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        };
        solution(places);
    }
}
