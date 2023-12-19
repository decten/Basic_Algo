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
            } else {
                carMap.put(carNumber, time);
                carOut[carNumber] = false;
            }
        }

        int i = 0;
        answer = new int[carMap.size()];

        for (int key : carMap.keySet()) {
            answer[i] = fees[1];
            if (!carOut[key]) {
                feeMap.put(key, feeMap.getOrDefault(key, 0) + (23 * 60 + 59) - carMap.get(key));
            }
            if ((int) Math.ceil((feeMap.get(key) - fees[0]) / (float) fees[2]) * fees[3] > 0) {
                answer[i] = fees[1]
                    + (int) Math.ceil((feeMap.get(key) - fees[0]) / (float) fees[2]) * fees[3];
            }
            i++;
        }

        return answer;
    }

    public static void main(String[] args) {
    }
}
