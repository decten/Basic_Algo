import java.util.*;
import java.io.*;
public class Operand_14888 {
    static StringBuilder sb = new StringBuilder();
    static int N,max_value,min_value;
    static int[] numbers, operand, order;
    static void input(){
        FastReader scan = new FastReader();
        N = scan.nextInt();
        numbers = new int[N+1];
        //연산자는 N-1이 아닌 4개로 고정됨
        operand = new int[5];
        for (int i = 0; i < N; i++) {
            numbers[i] = scan.nextInt();
        }
        for (int i = 0; i < 4; i++) {
            operand[i] = scan.nextInt();
        }
        //order에는 N-1개의 배열 생성
        order = new int[N];
        //Max, Min 초기화 방법 몰랐음
        max_value = Integer.MIN_VALUE;
        min_value = Integer.MAX_VALUE;
    }
    static int calculate(int operand1, int operator, int operand2){
        if(operator == 1){
            return operand1 + operand2;
        }
        if(operator == 2){
            return operand1 - operand2;
        }
        if(operator == 3){
            return operand1 * operand2;
        }
        if(operator == 4){
            return operand1 / operand2;
        }
        return 0;
    }
    //개수별로 받은 연산자를 1-더하기/2-뺄셈/3-곱셈/4-나눗셈 이런식으로 인덱싱 해서 순열을 만든다
    //만든 순열을 order에 저장, order는 1-더하기/2-뺄셈/3-곱셈/4-나눗셈으로 주르륵 들어가 있음
    //order=[1,4,2...]->N-1개
    static void rec_func(int k, int value){
        if(k==N-1){
            max_value = Math.max(max_value, value);
            min_value = Math.min(min_value, value);
        }
        else{
            //k번째 연산자는 무엇을 선택할것인가
            for (int candi = 0; candi < 4 ; candi++) {
                if (operand[candi] >= 1){
                    operand[candi]--;
                    rec_func(k+1, calculate(value, candi+1, numbers[k+1]));
                    operand[candi]++;
                }
            }
        }
    }
    public static void main(String[] args) {
        input();
        /*calculate();calculate와 recursive 함수를 따로 둬야 함*/
        rec_func(0,numbers[0]);

        sb.append(max_value).append('\n').append(min_value);
        System.out.println(sb.toString());
    }
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        FastReader(String s) throws FileNotFoundException{
            br = new BufferedReader(new FileReader(s));
        }
        String next(){
            while (st==null||!st.hasMoreElements()){
                try {
                    st = new StringTokenizer(br.readLine());
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        String nextLine(){
            String str = "";
            try {
            str = br.readLine();
        }catch (IOException e){
            e.printStackTrace();
            }
            return str;
        }
        int nextInt(){
            return Integer.parseInt(next());
        }
    }
}
