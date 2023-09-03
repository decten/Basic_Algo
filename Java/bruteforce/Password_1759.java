package bruteforce;

import java.io.*;
import java.sql.Array;
import java.util.*;

public class Password_1759 {
    static int N, M;
    static StringBuilder stringBuilder;
    static char[] chars;
    static int[] selected;
    static void input(){
        FastReader scanner = new FastReader();
        stringBuilder = new StringBuilder();
        N = scanner.nextInt();
        M = scanner.nextInt();
        chars = new char[M+1];
        selected = new int[N+1];
        //반복문 안 쓰고 이런 식으로!
        String[] tokens = scanner.nextLine().split(" ");
        //입력 받은 string을 다시 char로 변환
        for (int i = 0; i < M; i++) {
            chars[i] = tokens[i].charAt(0);
        }
        //정렬 해줘야 함
        Arrays.sort(chars,0,M);
    }

    static void rec_func(int k){
        if(k==N){
            int vowel = 0;
            int consonant = 0;
            for (int i = 0; i < N; i++) {
                if(String.valueOf(chars[selected[i]]).matches("^[aeiou]*$")) vowel++;
                else consonant++;
            }
            if(vowel>=1 && consonant>=2){
                for (int i = 0; i < N; i++) stringBuilder.append(chars[selected[i]]);
                stringBuilder.append('\n');
            }
        }else{
            int candi = 0;
            if(k!=0) candi = selected[k-1]+1;
            for (;  candi < M; candi++) {
                selected[k]=candi;
                rec_func(k+1);
                selected[k]=0;
            }

        }
    }

    public static void main(String[] args) {
        input();
        rec_func(0);
        System.out.print(stringBuilder.toString());
    }

    static class FastReader{
        BufferedReader bufferedReader;
        StringTokenizer stringTokenizer;

        FastReader(){
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        }
        FastReader(String s) throws FileNotFoundException {
            bufferedReader = new BufferedReader(new FileReader(new File(s)));
        }
        String next(){
            //순서 바뀌면 에러 발생
            while(stringTokenizer== null||!stringTokenizer.hasMoreElements() ){
                try{
                    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return stringTokenizer.nextToken();
        }
        String nextLine(){
            String str = "";
            try{
                str = bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
        int nextInt(){
            return Integer.parseInt(next());
        }

    }
}
