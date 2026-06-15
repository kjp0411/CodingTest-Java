package programmers.lv3.p42884;

// https://school.programmers.co.kr/learn/courses/30/lessons/42884

import java.util.Arrays;

public class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));

        int camera = routes[0][1];
        int cameraCount = 1;

        for (int i = 1; i < routes.length; i++) {
            if(routes[i][0] > camera) {
                cameraCount++;
                camera = routes[i][1];
            }
        }

        return cameraCount;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] routes1 = {{-20, -15}, {-14, -5}, {-18, -13}, {-5, -3}};

        int result1 = solution.solution(routes1);

        System.out.println(result1); // 2
    }
}