import java.io.*;
import java.sql.Array;
import java.util.*;

public class Password_1759 {

    static void input(){
        FastReader scanner = new FastReader();
        ArrayList <String> stringArrayList= new ArrayList();

    }

    public static void main(String[] args) {
        input();
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
