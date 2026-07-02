package programmers.lv3.p17678;

// https://school.programmers.co.kr/learn/courses/30/lessons/17678

import java.util.Arrays;

public class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        int[] times = new int[timetable.length];

        for (int i = 0; i < timetable.length; i++) {
            String[] split = timetable[i].split(":");

            int hour = Integer.parseInt(split[0]);
            int minute = Integer.parseInt(split[1]);

            times[i] = hour * 60 + minute;
        }

        Arrays.sort(times);

        int busTime = 9 * 60; // 09:00 = 540
        int index = 0;
        int answer = 0;

        for (int bus = 0; bus < n; bus++) {
            int currentBusTime = busTime + bus * t;
            int count = 0;

            while (index < times.length && times[index] <= currentBusTime && count < m) {
                index++;
                count++;
            }

            if (bus == n - 1) {
                if (count < m) {
                    answer = currentBusTime;
                } else {
                    answer = times[index - 1] - 1;
                }
            }
        }

        return String.format("%02d:%02d", answer / 60, answer % 60);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int n1 = 1;
        int t1 = 1;
        int m1 = 5;

        int n2 = 2;
        int t2 = 10;
        int m2 = 2;

        int n3 = 2;
        int t3 = 1;
        int m3 = 2;

        int n4 = 1;
        int t4 = 1;
        int m4 = 5;

        int n5 = 1;
        int t5 = 1;
        int m5 = 1;

        int n6 = 10;
        int t6 = 60;
        int m6 = 45;

        String[] timetable1 = {"08:00", "08:01", "08:02", "08:03"};
        String[] timetable2 = {"09:10", "09:09", "08:00"};
        String[] timetable3 = {"09:00", "09:00", "09:00", "09:00"};
        String[] timetable4 = {"00:01", "00:01", "00:01", "00:01", "00:01"};
        String[] timetable5 = {"23:59"};
        String[] timetable6 = {"23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"};

        String result1 = solution.solution(n1, t1, m1, timetable1);
        String result2 = solution.solution(n2, t2, m2, timetable2);
        String result3 = solution.solution(n3, t3, m3, timetable3);
        String result4 = solution.solution(n4, t4, m4, timetable4);
        String result5 = solution.solution(n5, t5, m5, timetable5);
        String result6 = solution.solution(n6, t6, m6, timetable6);

        System.out.println(result1); // 09:00
        System.out.println(result2); // 09:09
        System.out.println(result3); // 08:59
        System.out.println(result4); // 00:00
        System.out.println(result5); // 09:00
        System.out.println(result6); // 18:00
    }
}