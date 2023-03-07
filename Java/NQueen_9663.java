import java.util.*;
import java.io.*;

public class NQueen_9663 {
    static int N,answer;
    static int[] col;
    static boolean attackable(int r1, int c1, int r2, int c2){
        if(c1==c2) return true;
        if(r1-c1 == r2-c2) return true;
        if(r1+c1 == r2+c2) return true;
        return false;
    }
    static int rec_func(int row){

        //N+1이 되면 멈춤
        if(row==N+1){
            answer++;
        }
        else{
            //col[현재행] = c(이전 열)
            for (int c = 1; c <= N; c++) {
                boolean possible = true;
                for (int i = 1; i <= row; i++) {
                    //i,col[i]
                    if(attackable(row, c, i, col[i])){
                        possible = false;
                        break;
                    }
                }
                if(possible){
                    col[row] = c;
                    rec_func(row+1);
                    col[row] = 0;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        //N만 입력 받는거라 FastReader 안 만들었다
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        col = new int[N+1];

        System.out.println(rec_func(1));
    }

}
