package programmers.lv1.p12943;

// https://school.programmers.co.kr/learn/courses/30/lessons/12943

public class Solution {
    public int solution(int num) {
        long n = num;
        int count = 0;

        while (n != 1) {
            if (count == 500) {
                return -1;
            }

            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = n * 3 + 1;
            }

            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int result = solution.solution(626331);

        System.out.println(result);
    }
}