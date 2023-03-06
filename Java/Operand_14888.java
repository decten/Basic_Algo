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
        //Max, Min 초기화 방법 몰랐음
        max_value = Integer.MIN_VALUE;
        min_value = Integer.MAX_VALUE;
    }
    static int calculate(){
        int answer = numbers[0];
        //order는 연산자의 총 개수인 N-1개가 들어가 있다
        for (int i = 0; i < N-1; i++) {
            //answer = numbers[i],operator[i],numbers[i+1]
            if(order[i] == 1){
                answer += numbers[i+1];
            }
            if(order[i] == 2){
                answer -= numbers[i+1];
            }
            if(order[i] == 3){
                answer *= numbers[i+1];
            }
            if(order[i] == 4){
//                if(answer==0) answer = 0;
//                if(answer < 0){
//                    int result = Math.abs(answer) / numbers[i+1];
//                    answer = -result;
//                } else{
//                    int result = answer / numbers[i+1];
//                    answer = result;
//                }
                //그냥 나눗셈 쓰면 되는거였음
                answer /= numbers[i+1];
            }

        }
        return answer;
    }
    //개수별로 받은 연산자를 1-더하기/2-뺄셈/3-곱셈/4-나눗셈 이런식으로 인덱싱 해서 순열을 만든다
    //만든 순열을 order에 저장, order는 1-더하기/2-뺄셈/3-곱셈/4-나눗셈으로 주르륵 들어가 있음
    //order=[1,4,2...]->N-1개
    static void rec_func(int k){
        if(k==N-1){
            int value = calculate();
            max_value = Math.max(max_value, value);
            min_value = Math.min(min_value, value);
        }
        else{
            //k번째 연산자는 무엇을 선택할것인가
            for (int candi = 0; candi < 4 ; candi++) {
                if (operand[candi] >= 1){
                    operand[candi]--;
                    order[k] = candi+1;//order에는 1부터 집어넣음
                    rec_func(k+1);
                    operand[candi]++;
                    order[k] = 0;
                }
            }
        }
    }
    public static void main(String[] args) {
        input();
        /*calculate();calculate와 recursive 함수를 따로 둬야 함*/
        rec_func(0);

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
