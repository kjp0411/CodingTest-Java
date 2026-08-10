package programmers.lv2.p92341;

// https://school.programmers.co.kr/learn/courses/30/lessons/92341

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> entryTimes = new HashMap<>();
        Map<String, Integer> totalTimes = new TreeMap<>();

        for (String record : records) {
            String[] values = record.split(" ");

            int time = convertToMinutes(values[0]);
            String carNumber = values[1];
            String status = values[2];

            totalTimes.putIfAbsent(carNumber, 0);

            if (status.equals("IN")) {
                entryTimes.put(carNumber, time);
            } else {
                int entryTime = entryTimes.remove(carNumber);
                int parkingTime = time - entryTime;

                totalTimes.put(
                    carNumber,
                    totalTimes.get(carNumber) + parkingTime
                );
            }
        }

        int endOfDay = convertToMinutes("23:59");

        for (Map.Entry<String, Integer> entry : entryTimes.entrySet()) {
            String carNumber = entry.getKey();
            int entryTime = entry.getValue();
            int parkingTime = endOfDay - entryTime;

            totalTimes.put(
                carNumber,
                totalTimes.get(carNumber) + parkingTime
            );
        }

        int[] answer = new int[totalTimes.size()];
        int index = 0;

        for (int totalTime : totalTimes.values()) {
            answer[index++] = calculateFee(totalTime, fees);
        }

        return answer;
    }

    private int convertToMinutes(String time) {
        String[] values = time.split(":");

        int hour = Integer.parseInt(values[0]);
        int minute = Integer.parseInt(values[1]);

        return hour * 60 + minute;
    }

    private int calculateFee(int totalTime, int[] fees) {
        int basicTime = fees[0];
        int basicFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];

        if (totalTime <= basicTime) {
            return basicFee;
        }

        int extraTime = totalTime - basicTime;
        int unitCount = (extraTime + unitTime - 1) / unitTime;

        return basicFee + unitCount * unitFee;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] fees = {180, 5000, 10, 600};
        String[] records = {
            "05:34 5961 IN",
            "06:00 0000 IN",
            "06:34 0000 OUT",
            "07:59 5961 OUT",
            "07:59 0148 IN",
            "18:59 0000 IN",
            "19:09 0148 OUT",
            "22:59 5961 IN",
            "23:00 5961 OUT"
        };

        int[] result = solution.solution(fees, records);

        System.out.println(Arrays.toString(result));// [14600, 34400, 5000]
    }
}