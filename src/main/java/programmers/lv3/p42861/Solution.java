package programmers.lv3.p42861;

// https://school.programmers.co.kr/learn/courses/30/lessons/42861

import java.util.Arrays;

public class Solution {
    private int[] parent;

    public int solution(int n, int[][] costs) {
        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        Arrays.sort(costs, (a, b) -> Integer.compare(a[2], b[2]));

        int answer = 0;
        int count = 0;

        for (int[] cost : costs) {
            int a = cost[0];
            int b = cost[1];
            int price = cost[2];

            if (find(a) != find(b)) {
                union(a, b);
                answer += price;
                count++;

                if (count == n - 1) {
                    break;
                }
            }
        }

        return answer;
    }

    private int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    private void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) {
            parent[rootB] = rootA;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int n1 = 4;

        int[][] costs1 = {
            {0, 1, 1},
            {0, 2, 2},
            {1, 2, 5},
            {1, 3, 1},
            {2, 3, 8}
        };

        int result1 = solution.solution(n1, costs1);

        System.out.println(result1); // 4
    }
}