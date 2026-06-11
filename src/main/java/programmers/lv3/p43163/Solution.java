package programmers.lv3.p43163;

// https://school.programmers.co.kr/learn/courses/30/lessons/43163

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(begin, 0));

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.word.equals(target)) {
                return current.count;
            }

            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && canConvert(current.word, words[i])) {
                    visited[i] = true;
                    queue.offer(new Node(words[i], current.count + 1));
                }
            }
        }

        return 0;
    }

    private boolean canConvert(String word1, String word2) {
        int diffCount = 0;

        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                diffCount++;
            }

            if (diffCount > 1) {
                return false;
            }
        }

        return diffCount == 1;
    }

    private static class Node {
        String word;
        int count;

        Node(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String begin1 = "hit";
        String target1 = "cog";
        String[] words1 = {"hot", "dot", "dog", "lot", "log", "cog"};

        String begin2 = "hit";
        String target2 = "cog";
        String[] words2 = {"hot", "dot", "dog", "lot", "log"};

        int result1 = solution.solution(begin1, target1, words1);
        int result2 = solution.solution(begin2, target2, words2);

        System.out.println(result1); // 4
        System.out.println(result2); // 0
    }
}