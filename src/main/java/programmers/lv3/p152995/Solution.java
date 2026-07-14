package programmers.lv3.p152995;

// https://school.programmers.co.kr/learn/courses/30/lessons/152995

import java.util.Arrays;

public class Solution {
    public int solution(int[][] scores) {
        int wanhoAttitude = scores[0][0];
        int wanhoPeer = scores[0][1];
        int wanhoSum = wanhoAttitude + wanhoPeer;

        Arrays.sort(scores, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }

            return Integer.compare(b[0], a[0]);
        });

        int maxPeerScore = 0;
        int rank = 1;

        for (int[] score : scores) {
            int attitude = score[0];
            int peer = score[1];

            if (peer < maxPeerScore) {
                if (attitude == wanhoAttitude && peer == wanhoPeer) {
                    return -1;
                }

                continue;
            }

            maxPeerScore = peer;

            if (attitude + peer > wanhoSum) {
                rank++;
            }
        }

        return rank;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] scores = {
            {2, 2},
            {1, 4},
            {3, 2},
            {3, 2},
            {2, 1}
        };

        int result = solution.solution(scores);

        System.out.println(result); // 4
    }
}