package etc;

import java.io.*;
import java.util.*;

public class BeerWalking_9205 {
    //거리는 루트 안 씌우고 딱 x 좌표의 차이 + y 좌표의 차이
    public static void main(String[] args){

    }

    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while (st==null||!st.hasMoreElements()){
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
