package graph;

import java.util.Arrays;

public class QuadZip_programmers {
    static int[] answer = new int[2];

    static void dfs(int[][] arr, int x, int y, int size){
        if(zip(arr,x,y,size, arr[x][y])){
            if(arr[x][y] == 1)
                answer[1]++;
            else answer[0]++;
            return ;
        }
        dfs(arr,x,y, size/2);
        dfs(arr,x,y + size/2, size/2);
        dfs(arr,x+size/2,y, size/2);
        dfs(arr,x+size/2,y + size/2, size/2);
    }
    static boolean zip(int[][] arr, int x, int y, int size, int val) {
        for(int i = x; i < x + size; i++)
            for(int j = y; j < y + size; j++)
                if(arr[i][j] != val)
                    return false;
        return true;
    }
    static int[] solution(int[][] arr) {
        dfs(arr,0,0,arr.length);
        return answer;
    }
    public static void main(String[] args) {
        solution(new int[][] {{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}});
    }
}
