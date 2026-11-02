package programmers.lv2.p172927;

// https://school.programmers.co.kr/learn/courses/30/lessons/172927

public class Solution {
    private static final int[][] FATIGUE = {
            {1, 1, 1},
            {5, 1, 1},
            {25, 5, 1}
    };

    public int solution(int[] picks, String[] minerals) {
        int totalPicks = picks[0] + picks[1] + picks[2];
        int mineralCount = Math.min(minerals.length, totalPicks * 5);
        int groupCount = (mineralCount + 4) / 5;

        int[][] groupCosts = new int[groupCount][3];

        for (int index = 0; index < mineralCount; index++) {
            int mineralType = getMineralType(minerals[index]);
            int groupIndex = index / 5;

            for (int pickType = 0; pickType < 3; pickType++) {
                groupCosts[groupIndex][pickType] +=
                        FATIGUE[pickType][mineralType];
            }
        }

        return findMinimumFatigue(0, picks.clone(), groupCosts);
    }

    private int findMinimumFatigue(
            int groupIndex,
            int[] remainingPicks,
            int[][] groupCosts
    ) {
        if (groupIndex == groupCosts.length) {
            return 0;
        }

        int minimumFatigue = Integer.MAX_VALUE;

        for (int pickType = 0; pickType < 3; pickType++) {
            if (remainingPicks[pickType] == 0) {
                continue;
            }

            remainingPicks[pickType]--;

            int fatigue = groupCosts[groupIndex][pickType]
                    + findMinimumFatigue(
                    groupIndex + 1,
                    remainingPicks,
                    groupCosts
            );

            minimumFatigue = Math.min(minimumFatigue, fatigue);

            remainingPicks[pickType]++;
        }

        return minimumFatigue;
    }

    private int getMineralType(String mineral) {
        switch (mineral) {
            case "diamond":
                return 0;
            case "iron":
                return 1;
            default:
                return 2;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] picks1 = {1, 3, 2};
        String[] minerals1 = {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};
        int[] picks2 = {0, 1, 1};
        String[] minerals2 = {"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond", "iron", "stone"};

        int result1 = solution.solution(picks1, minerals1);
        int result2 = solution.solution(picks2, minerals2);

        System.out.println(result1); // 12
        System.out.println(result2); // 50
    }
}