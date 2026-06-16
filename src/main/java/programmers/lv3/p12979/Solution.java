package programmers.lv3.p12979;

// https://school.programmers.co.kr/learn/courses/30/lessons/12979

public class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int start = 1;
        int coverage = 2 * w + 1;

        for (int station : stations) {
            int left = station - w;

            int uncoveredLength = left - start;

            if (uncoveredLength > 0) {
                answer += (uncoveredLength + coverage - 1) / coverage;
            }

            start = station + w + 1;
        }

        if (start <= n) {
            int uncoveredLength = n - start + 1;

            answer += (uncoveredLength + coverage - 1) / coverage;
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int n1 = 11;
        int[] stations1 = {4, 11};
        int w1 = 1;

        int n2 = 16;
        int[] stations2 = {9};
        int w2 = 2;

        int result1 = solution.solution(n1, stations1, w1);
        int result2 = solution.solution(n2, stations2, w2);

        System.out.println(result1); // 3
        System.out.println(result2); // 3
    }
}