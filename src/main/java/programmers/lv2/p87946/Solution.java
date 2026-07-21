package programmers.lv2.p87946;

// https://school.programmers.co.kr/learn/courses/30/lessons/87946

public class Solution {

    private int answer;
    private boolean[] visited;

    public int solution(int k, int[][] dungeons) {
        answer = 0;
        visited = new boolean[dungeons.length];

        dfs(k, 0, dungeons);

        return answer;
    }

    private void dfs(int fatigue, int count, int[][] dungeons) {
        answer = Math.max(answer, count);

        for (int i = 0; i < dungeons.length; i++) {
            if (fatigue >= dungeons[i][0] && !visited[i]) {

                visited[i] = true;

                dfs(fatigue - dungeons[i][1], count + 1, dungeons);

                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int k = 80;
        int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};
        int result = solution.solution(k, dungeons);

        System.out.println(result); // 3
    }
}