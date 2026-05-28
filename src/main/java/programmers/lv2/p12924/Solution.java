package programmers.lv2.p12924;

// https://school.programmers.co.kr/learn/courses/30/lessons/12924

public class Solution {
    public int solution(int n) {
        int start = 1;
        int end = 1;
        int sum = 1;
        int result = 0;

        while (start <= n) {
            if (sum < n) {
                end++;
                sum += end;
            } else if (sum > n) {
                sum -= start;
                start++;
            } else {
                result++;
                sum -= start;
                start++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int s1 = 15;
        int result1 = solution.solution(s1);

        System.out.println(result1); // 4
    }
}