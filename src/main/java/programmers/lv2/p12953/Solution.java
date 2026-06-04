package programmers.lv2.p12953;

// https://school.programmers.co.kr/learn/courses/30/lessons/12953

public class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];

        for (int i = 1; i < arr.length; i++) {
            answer = lcm(answer, arr[i]);
        }

        return answer;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }

    private int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] arr1 = {2, 6, 8, 14};
        int[] arr2 = {1, 2, 3};

        int result1 = solution.solution(arr1);
        int result2 = solution.solution(arr2);

        System.out.println(result1); // 168
        System.out.println(result2); // 6
    }
}