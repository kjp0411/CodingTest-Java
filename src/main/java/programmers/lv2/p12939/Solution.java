package programmers.lv2.p12939;

// https://school.programmers.co.kr/learn/courses/30/lessons/12939

import java.util.*;

public class Solution {
    public String solution1(String s) {
        String[] arr = s.split(" ");

        List<Integer> list = new ArrayList<>();

        for (String num : arr) {
            list.add(Integer.parseInt(num));
        }

        int min = Collections.min(list);
        int max = Collections.max(list);


        return min + " " + max;
    }

    public String solution2(String s) {
        String[] arr = s.split(" ");

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (String num : arr) {
            int n = Integer.parseInt(num);
            min = Math.min(min, n);
            max = Math.max(max, n);
        }

        return min + " " + max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String s1 = solution.solution1("1 2 3 4");
        String s2 = solution.solution1("-1 -2 -3 -4");
        String s3 = solution.solution1("-1 -1");
        System.out.println(s1); // "1 4"
        System.out.println(s2); // "-4 -1"
        System.out.println(s3); // "-1 -1"

        String s4 = solution.solution2("1 2 3 4");
        String s5 = solution.solution2("-1 -2 -3 -4");
        String s6 = solution.solution2("-1 -1");
        System.out.println(s4); // "1 4"
        System.out.println(s5); // "-4 -1"
        System.out.println(s6); // "-1 -1"
    }
}