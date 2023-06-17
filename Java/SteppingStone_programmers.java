import java.util.*;
import java.util.stream.Collectors;

public class SteppingStone_programmers {
    static int bin_search(ArrayList<Integer> rocks){
        int left=0, right=rocks.get(rocks.size()-1), mid = 0;
        while(right>=left){
            mid = (right+left)/2;
            if(deter(mid,rocks)){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return mid;
    }
    static boolean deter(int ans, ArrayList<Integer> rocks){
        int sum = 0;
        int tmp = rocks.get(0);
        for (int i = 1; i < rocks.size(); i++) {
                if(ans>tmp){
                    sum++;
                    continue;
                }
                tmp = rocks.get(i)-rocks.get(i-1);
        }
        return sum>=tmp;
    }

    static int solution(int distance, int[] rocks, int n) {
        ArrayList<Integer> arrayList = (ArrayList<Integer>) Arrays.stream(rocks).boxed().collect(
            Collectors.toList());
        arrayList.add(distance);
        Collections.sort(arrayList);
        int answer = bin_search(arrayList);
        return answer;
    }

    public static void main(String[] args) {
        int ans = solution(25, new int[]{2,14,11,21,17},2);
        System.out.println(ans);
    }
}
