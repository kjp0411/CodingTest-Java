package programmers.lv2.p12946;

// https://school.programmers.co.kr/learn/courses/30/lessons/12946

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[][] solution(int n) {
        List<int[]> moves = new ArrayList<>();

        moveDisks(n, 1, 3, 2, moves);

        return moves.toArray(new int[moves.size()][]);
    }

    private void moveDisks(
            int count,
            int from,
            int to,
            int auxiliary,
            List<int[]> moves
    ) {
        if (count == 0) {
            return;
        }

        moveDisks(count - 1, from, auxiliary, to, moves);
        moves.add(new int[]{from, to});
        moveDisks(count - 1, auxiliary, to, from, moves);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int n = 2;

        int[][] result = solution.solution(n);

        System.out.println(Arrays.deepToString(result));
    }
}