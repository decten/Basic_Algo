package bruteforce;

import java.util.ArrayList;

public class MockExam_programmers {

    static int[] supo1 = {1,2,3,4,5};
    static int[] supo2 = {2,1,2,3,2,4,2,5};
    static int[] supo3 = {3,3,1,1,2,2,4,4,5,5};
    static int[] score= {0,0,0};

    static int[] solution(int[] answers) {
        for (int i = 0; i < answers.length; i++) {
            if(supo1[i%5]==answers[i]) score[0]++;
            if(supo2[i%10]==answers[i]) score[1]++;
            if(supo3[i%8]==answers[i]) score[2]++;
        }

        int maxScore = Math.max(score[0], Math.max(score[1], score[2]));
        ArrayList<Integer> list = new ArrayList<>();

        if(maxScore == score[0]) list.add(1);
        if(maxScore == score[1]) list.add(2);
        if(maxScore == score[2]) list.add(3);

        return list.stream().mapToInt(i -> i.intValue()).toArray() ;
    }
    public static void main(String[] args) {
        solution(new int[] {1,2,3,4,5});
    }
}
