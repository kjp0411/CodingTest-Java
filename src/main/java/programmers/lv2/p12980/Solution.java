package programmers.lv2.p12980;

// https://school.programmers.co.kr/learn/courses/30/lessons/12980

public class Solution {
    public int solution(int n) {
        int battery = 0;

        while (n > 0) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n--;
                battery++;
            }
        }

        return battery;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int n1 = 5;
        int n2 = 6;
        int n3 = 5000;

        int result1 = solution.solution(n1);
        int result2 = solution.solution(n2);
        int result3 = solution.solution(n3);

        System.out.println(result1); // 2
        System.out.println(result2); // 2
        System.out.println(result3); // 5
    }
}