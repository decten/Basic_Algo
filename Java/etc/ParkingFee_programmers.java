package etc;

import java.util.*;
public class ParkingFee_programmers {

    static int[] solution(int[] fees, String[] records) {
        int[] answer;
        Map<Integer, Integer> carMap = new TreeMap<>();
        Map<Integer, Integer> feeMap = new TreeMap<>();
        boolean[] carOut = new boolean[10000];

        for (String record : records) {
            int time = Integer.parseInt(record.split(" ")[0].split(":")[0]) * 60 +
                Integer.parseInt(record.split(" ")[0].split(":")[1]);
            int carNumber = Integer.parseInt(record.split(" ")[1]);
            String flag = record.split(" ")[2];

            if (flag.equals("OUT")) {
                feeMap.put(carNumber,
                    feeMap.getOrDefault(carNumber, 0) + time - carMap.get(carNumber));
                carOut[carNumber] = true;
            }else{
                carMap.put(carNumber, time);
                carOut[carNumber] = false;
            }
        }

        int i = 0;
        answer = new int[feeMap.size()];

        for (int key : feeMap.keySet()) {
            answer[i] = fees[1];
            if (!carOut[key]) {
                feeMap.put(key, feeMap.getOrDefault(key, 0) + (23 * 60 + 59) - carMap.get(key));
            }
            if ((int) Math.ceil((feeMap.get(key) - fees[0]) / (float) fees[2]) * fees[3] > 0) {
                answer[i] = fees[1] + (int) Math.ceil((feeMap.get(key) - fees[0]) / (float) fees[2]) * fees[3];
            }
            i++;
        }


        return answer;
    }

    public static void main(String[] args) {
        solution(new int[]{180, 5000, 10, 600}, new String[]
            {
                "05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT",
                "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN",
                "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"
            }
        );

    }
}
