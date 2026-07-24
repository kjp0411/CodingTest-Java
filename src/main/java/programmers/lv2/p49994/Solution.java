package programmers.lv2.p49994;

// https://school.programmers.co.kr/learn/courses/30/lessons/49994

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int solution(String dirs) {
        int sx = 0;
        int sy = 0;

        int answer = 0;

        Set<String> visited = new HashSet<>();

        for (int i = 0;  i < dirs.length(); i++) {
            int nx = sx;
            int ny = sy;

            char direction = dirs.charAt(i);

            if (direction == 'U') {
                ny++;
            } else if (direction == 'D') {
                ny--;
            } else if (direction == 'R') {
                nx++;
            } else if (direction == 'L') {
                nx--;
            }

            if (nx >= -5 && nx <= 5 && ny >= -5 && ny <= 5) {
                String path = sx + "," + sy + "->" + nx + "," + ny;
                String reversePath = nx + "," + ny + "->" + sx + "," + sy;

                if (!visited.contains(path)) {
                    visited.add(path);
                    visited.add(reversePath);
                    answer++;
                }

                sx = nx;
                sy = ny;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String dirs1 = "ULURRDLLU";
        String dirs2 = "LULLLLLLU";

        int result1 = solution.solution(dirs1);
        int result2 = solution.solution(dirs2);

        System.out.println(result1); // 7
        System.out.println(result2); // 7
    }
}