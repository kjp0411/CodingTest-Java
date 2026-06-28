package programmers.lv3.p77486;

// https://school.programmers.co.kr/learn/courses/30/lessons/77486

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int n = enroll.length;

        int[] answer = new int[n];
        int[] parent = new int[n];

        Map<String, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            indexMap.put(enroll[i], i);
        }

        for (int i = 0; i < n; i++) {
            if (referral[i].equals("-")) {
                parent[i] = -1;
            } else {
                parent[i] = indexMap.get(referral[i]);
            }
        }

        for (int i = 0; i < seller.length; i++) {
            int current = indexMap.get(seller[i]);
            int money = amount[i] * 100;

            while (current != -1 && money > 0) {
                int commission = money / 10;
                int profit = money - commission;

                answer[current] += profit;

                current = parent[current];
                money = commission;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] enroll1 = {
            "john", "mary", "edward", "sam",
            "emily", "jaimie", "tod", "young"
        };

        String[] referral1 = {
            "-", "-", "mary", "edward",
            "mary", "mary", "jaimie", "edward"
        };

        String[] seller1 = {
            "young", "john", "tod", "emily", "mary"
        };

        int[] amount1 = {
            12, 4, 2, 5, 10
        };

        int[] result1 = solution.solution(enroll1, referral1, seller1, amount1);

        System.out.println(Arrays.toString(result1));
        // [360, 958, 108, 0, 450, 18, 180, 1080]


        String[] enroll2 = {
            "john", "mary", "edward", "sam",
            "emily", "jaimie", "tod", "young"
        };

        String[] referral2 = {
            "-", "-", "mary", "edward",
            "mary", "mary", "jaimie", "edward"
        };

        String[] seller2 = {
            "sam", "emily", "jaimie", "edward"
        };

        int[] amount2 = {
            2, 3, 5, 4
        };

        int[] result2 = solution.solution(enroll2, referral2, seller2, amount2);

        System.out.println(Arrays.toString(result2));
        // [0, 110, 378, 180, 270, 450, 0, 0]
    }
}