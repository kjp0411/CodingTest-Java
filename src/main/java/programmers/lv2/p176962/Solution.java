
package programmers.lv2.p176962;

// https://school.programmers.co.kr/learn/courses/30/lessons/176962

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution {

    public String[] solution(String[][] plans) {

        Arrays.sort(plans, (a, b) ->
                toMinutes(a[1]) - toMinutes(b[1])
        );

        Deque<String[]> stack = new ArrayDeque<>();

        String[] answer = new String[plans.length];

        int answerIndex = 0;

        int currentTime = 0;

        for (int i = 0; i < plans.length; i++) {

            String name = plans[i][0];
            int start = toMinutes(plans[i][1]);
            int playTime = Integer.parseInt(plans[i][2]);

            if (i > 0) {

                int availableTime = start - currentTime;

                while (!stack.isEmpty() && availableTime > 0) {

                    String[] pausedPlan = stack.pop();

                    int remainingTime =
                            Integer.parseInt(pausedPlan[1]);

                    if (remainingTime <= availableTime) {

                        availableTime -= remainingTime;

                        answer[answerIndex++] = pausedPlan[0];

                    } else {

                        pausedPlan[1] =
                                String.valueOf(remainingTime - availableTime);

                        stack.push(pausedPlan);

                        availableTime = 0;
                    }
                }
            }

            currentTime = start + playTime;

            if (i < plans.length - 1) {

                int nextStart = toMinutes(plans[i + 1][1]);

                if (currentTime > nextStart) {

                    stack.push(new String[]{
                            name,
                            String.valueOf(playTime - (nextStart - start))
                    });

                } else {

                    answer[answerIndex++] = name;
                }

            } else {

                answer[answerIndex++] = name;
            }
        }

        while (!stack.isEmpty()) {
            answer[answerIndex++] = stack.pop()[0];
        }

        return answer;
    }

    private int toMinutes(String time) {

        String[] parts = time.split(":");

        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);

        return hour * 60 + minute;
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        String[][] plans1 = {
                {"korean", "11:40", "30"},
                {"english", "12:10", "20"},
                {"math", "12:30", "40"}
        };

        String[][] plans2 = {
                {"science", "12:40", "50"},
                {"music", "12:20", "40"},
                {"history", "14:00", "30"},
                {"computer", "12:30", "100"}
        };

        String[][] plans3 = {
                {"aaa", "12:00", "20"},
                {"bbb", "12:10", "30"},
                {"ccc", "12:40", "10"}
        };

        String[] result1 = solution.solution(plans1);
        String[] result2 = solution.solution(plans2);
        String[] result3 = solution.solution(plans3);

        System.out.println(Arrays.toString(result1));
        // [korean, english, math]

        System.out.println(Arrays.toString(result2));
        // [science, history, computer, music]

        System.out.println(Arrays.toString(result3));
        // [bbb, ccc, aaa]
    }
}
