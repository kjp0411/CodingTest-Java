package programmers.lv2.p389479;

// https://school.programmers.co.kr/learn/courses/30/lessons/389479

public class Solution {
    public int solution(int[] players, int m, int k) {
        int[] addedServers = new int[players.length];

        int runningServers = 0;
        int answer = 0;

        for (int hour = 0; hour < players.length; hour++) {
            // k시간 전에 증설한 서버 반납
            int expirationHour = hour - k;

            if (expirationHour >= 0) {
                runningServers -= addedServers[expirationHour];
            }

            int requiredServers = players[hour] / m;

            if (runningServers < requiredServers) {
                int serversToAdd = requiredServers - runningServers;

                addedServers[hour] = serversToAdd;
                runningServers += serversToAdd;
                answer += serversToAdd;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] players1 = {
                0, 2, 3, 3, 1, 2, 0, 0, 0, 0, 4, 2,
                0, 6, 0, 4, 2, 13, 3, 5, 10, 0, 1, 5
        };
        int result1 = solution.solution(players1, 3, 5);

        int[] players2 = {
                0, 0, 0, 10, 0, 12, 0, 15, 0, 1, 0, 1,
                0, 0, 0, 5, 0, 0, 11, 0, 8, 0, 0, 0
        };
        int result2 = solution.solution(players2, 5, 1);

        int[] players3 = {
                0, 0, 0, 0, 0, 2, 0, 0, 0, 1, 0, 5,
                0, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1
        };
        int result3 = solution.solution(players3, 1, 1);

        System.out.println(result1); // 7
        System.out.println(result2); // 11
        System.out.println(result3); // 12
    }
}