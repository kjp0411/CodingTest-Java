package programmers.lv2.p155651;

// https://school.programmers.co.kr/learn/courses/30/lessons/155651

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public int solution(String[][] bookTime) {
        int[][] reservations = new int[bookTime.length][2];

        for (int i = 0; i < bookTime.length; i++) {
            reservations[i][0] = convertToMinutes(bookTime[i][0]);
            reservations[i][1] = convertToMinutes(bookTime[i][1]) + 10;
        }

        Arrays.sort(
                reservations,
                (first, second) -> Integer.compare(first[0], second[0])
        );

        Queue<Integer> roomEndTimes = new PriorityQueue<>();
        int answer = 0;

        for (int[] reservation : reservations) {
            int startTime = reservation[0];
            int endTime = reservation[1];

            while (!roomEndTimes.isEmpty()
                    && roomEndTimes.peek() <= startTime) {

                roomEndTimes.poll();
            }

            roomEndTimes.offer(endTime);
            answer = Math.max(answer, roomEndTimes.size());
        }

        return answer;
    }

    private int convertToMinutes(String time) {
        int hour = Integer.parseInt(time.substring(0, 2));
        int minute = Integer.parseInt(time.substring(3, 5));

        return hour * 60 + minute;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String[][] bookTime1 = {
                {"15:00", "17:00"},
                {"16:40", "18:20"},
                {"14:20", "15:20"},
                {"14:10", "19:20"},
                {"18:20", "21:20"}
        };
        String[][] bookTime2 = {
                {"09:10", "10:10"},
                {"10:20", "12:20"}
        };
        String[][] bookTime3 = {
                {"10:20", "12:30"},
                {"10:20", "12:30"},
                {"10:20", "12:30"}
        };

        int result1 = solution.solution(bookTime1);
        int result2 = solution.solution(bookTime2);
        int result3 = solution.solution(bookTime3);

        System.out.println(result1); // 3
        System.out.println(result2); // 1
        System.out.println(result3); // 3
    }
}