import java.io.*;
import java.sql.Array;
import java.util.*;

public class Password_1759 {
    static int L, C;
    static StringBuilder stringBuilder;
    static String[] strings;
    static void input(){
        FastReader scanner = new FastReader();
        L = scanner.nextInt();
        C = scanner.nextInt();
        for (int i = 0; i < C; i++) {
            strings[i] = scanner.next();
        }
    }
    static void rec_func(int k){
        if(k==L){
            if(!stringBuilder.toString().matches("^[aeiou]*$")) stringBuilder.setLength(0);
        }else{
            stringBuilder.append(strings[k]);
            rec_func(k+1);
            stringBuilder.setLength(stringBuilder.length()-1);
        }
    }

    public static void main(String[] args) {
        input();
        rec_func(0);
        if (stringBuilder.length() != 0) {
            System.out.println(stringBuilder.toString());
        }
    }

    static class FastReader{
        BufferedReader bufferedReader;
        StringTokenizer stringTokenizer;

        FastReader(){
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        }
        FastReader(String s) throws FileNotFoundException {
            bufferedReader = new BufferedReader(new FileReader(s));
        }
        String next(){
            while(!stringTokenizer.hasMoreElements() || stringTokenizer== null){
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
