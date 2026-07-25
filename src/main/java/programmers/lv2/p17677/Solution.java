package programmers.lv2.p17677;

// https://school.programmers.co.kr/learn/courses/30/lessons/17677

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int solution(String str1, String str2) {
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();

        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        for (int i = 0; i < str1.length() - 1; i++) {
            String pair = str1.substring(i, i + 2);

            if (isAlphabetPair(pair)) {
                list1.add(pair);
            }
        }

        for (int i = 0; i < str2.length() - 1; i++) {
            String pair = str2.substring(i, i + 2);

            if (isAlphabetPair(pair)) {
                list2.add(pair);
            }
        }

        List<String> temp = new ArrayList<>(list2);
        int intersection = 0;

        for (String pair : list1) {
            if (temp.contains(pair)) {
                intersection++;
                temp.remove(pair);
            }
        }

        int union = list1.size() + list2.size() - intersection;

        if (union == 0) {
            return 65536;
        }

        return (int) ((double) intersection / union * 65536);
    }

    private boolean isAlphabetPair(String pair) {
        return pair.charAt(0) >= 'A' && pair.charAt(0) <= 'Z'
            && pair.charAt(1) >= 'A' && pair.charAt(1) <= 'Z';
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String str1 = "FRANCE";
        String str2 = "french";
        int result1 = solution.solution(str1, str2);
        System.out.println(result1); // 16384

        str1 = "handshake";
        str2 = "shake hands";
        int result2 = solution.solution(str1, str2);
        System.out.println(result2); // 65536

        str1 = "aa1+aa2";
        str2 = "AAAA12";
        int result3 = solution.solution(str1, str2);
        System.out.println(result3); // 43690

        str1 = "E=M*C^2";
        str2 = "e=m*c^2";
        int result4 = solution.solution(str1, str2);
        System.out.println(result4); // 65536
    }
}