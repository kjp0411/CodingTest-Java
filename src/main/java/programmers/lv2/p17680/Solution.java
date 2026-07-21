package programmers.lv2.p17680;

// https://school.programmers.co.kr/learn/courses/30/lessons/17680

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int solution(int cacheSize, String[] cities) {
        List<String> cache = new ArrayList<>();
        int runTime = 0;

        if (cacheSize == 0) {
            runTime = cities.length * 5;
            return runTime;
        }

        String[] upperCities = new String[cities.length];
        for (int i = 0; i < cities.length; i++) {
            upperCities[i] = cities[i].toUpperCase();
        }

        for (String city : upperCities) {
            if (cache.contains(city)) {
                cache.remove(city);
                cache.add(city);
                runTime++;
            } else {
                if (cache.size() == cacheSize) {
                    cache.remove(0);
                }
                cache.add(city);
                runTime += 5;
            }
        }

        return runTime;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int cacheSize1 = 3;
        String[] cities1 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        int result1 = solution.solution(cacheSize1, cities1);

        int cacheSize2 = 3;
        String[] cities2 = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
        int result2 = solution.solution(cacheSize2, cities2);

        int cacheSize3 = 2;
        String[] cities3 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
        int result3 = solution.solution(cacheSize3, cities3);

        int cacheSize4 = 5;
        String[] cities4 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
        int result4 = solution.solution(cacheSize4, cities4);

        int cacheSize5 = 2;
        String[] cities5 = {"Jeju", "Pangyo", "NewYork", "newyork"};
        int result5 = solution.solution(cacheSize5, cities5);

        int cacheSize6 = 0;
        String[] cities6 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        int result6 = solution.solution(cacheSize6, cities6);

        System.out.println(result1); // 50
        System.out.println(result2); // 21
        System.out.println(result3); // 60
        System.out.println(result4); // 52
        System.out.println(result5); // 16
        System.out.println(result6); // 25
    }
}