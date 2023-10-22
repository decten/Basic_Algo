package etc;

import java.util.*;
public class ParkingFee_programmers {

    static int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        Map<Integer, Integer> carMap = new TreeMap<>();

        for (String record : records) {
            int time = Integer.parseInt(record.split(" ")[0].split(":")[0]) * 60 +
                Integer.parseInt(record.split(" ")[0].split(":")[1]);
            int number = Integer.parseInt(record.split(" ")[1]);
            String flag = record.split(" ")[2];

            if(flag=="OUT"){
                int fee = (time - carMap.get(number) - fees[0])/fees[3] * fees[4] + fees[1];
                carMap.put(number,fee);
            }else{
                carMap.put(number,time);
            }
        }

        return carMap.values().stream().mapToInt(Integer::intValue).toArray();
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
