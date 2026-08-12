package programmers.lv2.p49993;

// https://school.programmers.co.kr/learn/courses/30/lessons/49993

public class Solution {
    public int solution(String skill, String[] skillTrees) {
        int answer = 0;

        for (String skillTree : skillTrees) {
            int skillIndex = 0;
            boolean possible = true;

            for (char currentSkill : skillTree.toCharArray()) {
                if (skill.indexOf(currentSkill) == -1) {
                    continue;
                }

                if (currentSkill != skill.charAt(skillIndex)) {
                    possible = false;
                    break;
                }

                skillIndex++;
            }

            if (possible) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String skill = "CBD";
        String[] skillTrees = {"BACDE", "CBADF", "AECB", "BDA"};

        int result = solution.solution(skill, skillTrees);

        System.out.println(result); // 2
    }
}