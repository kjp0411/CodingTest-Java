package programmers.lv2.p148653;

// https://school.programmers.co.kr/learn/courses/30/lessons/148653

public class Solution {
    public int solution(int storey) {
        int answer = 0;

        while (storey > 0) {
            int currentDigit = storey % 10;
            int nextDigit = (storey / 10) % 10;

            if (currentDigit > 5) {
                answer += 10 - currentDigit;
                storey = storey / 10 + 1;
            } else if (currentDigit < 5) {
                answer += currentDigit;
                storey /= 10;
            } else {
                answer += 5;

                if (nextDigit >= 5) {
                    storey = storey / 10 + 1;
                } else {
                    storey /= 10;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int storey1 = 16;
        int result1 = solution.solution(storey1);

        int storey2 = 2554;
        int result2 = solution.solution(storey2);

        System.out.println(result1); // 6
        System.out.println(result2); // 16
    }
}