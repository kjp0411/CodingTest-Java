package programmers.lv2.p152996;

// https://school.programmers.co.kr/learn/courses/30/lessons/152996

public class Solution {
    public long solution(int[] weights) {
        int[] weightCounts = new int[1001];

        for (int weight : weights) {
            weightCounts[weight]++;
        }

        long answer = 0;

        for (int weight = 100; weight <= 1000; weight++) {
            long count = weightCounts[weight];

            // 무게가 같은 경우
            answer += count * (count - 1) / 2;

            // 무게 비율이 1 : 2인 경우
            int doubleWeight = weight * 2;

            if (doubleWeight <= 1000) {
                answer += count * weightCounts[doubleWeight];
            }

            // 무게 비율이 2 : 3인 경우
            if ((weight * 3) % 2 == 0) {
                int threeToTwoWeight = weight * 3 / 2;

                if (threeToTwoWeight <= 1000) {
                    answer += count * weightCounts[threeToTwoWeight];
                }
            }

            // 무게 비율이 3 : 4인 경우
            if ((weight * 4) % 3 == 0) {
                int fourToThreeWeight = weight * 4 / 3;

                if (fourToThreeWeight <= 1000) {
                    answer += count * weightCounts[fourToThreeWeight];
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] weights = {100, 180, 360, 100, 270};
        long result = solution.solution(weights);

        System.out.println(result); // 4
    }
}