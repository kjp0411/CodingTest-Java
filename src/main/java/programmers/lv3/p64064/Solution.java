package programmers.lv3.p64064;

// https://school.programmers.co.kr/learn/courses/30/lessons/64064

import java.util.HashSet;
import java.util.Set;

public class Solution {
    private String[] users;
    private String[] bans;
    private Set<Integer> result = new HashSet<>();

    public int solution(String[] user_id, String[] banned_id) {
        users = user_id;
        bans = banned_id;

        dfs(0, 0);

        return result.size();
    }

    private void dfs(int banIndex, int used) {
        if (banIndex == bans.length) {
            result.add(used);
            return;
        }

        for (int i = 0; i < users.length; i++) {
            if ((used & (1 << i)) != 0) {
                continue;
            }

            if (!isMatch(users[i], bans[banIndex])) {
                continue;
            }

            dfs(banIndex + 1, used | (1 << i));
        }
    }

    private boolean isMatch(String user, String ban) {
        if (user.length() != ban.length()) {
            return false;
        }

        for (int i = 0; i < user.length(); i++) {
            if (ban.charAt(i) == '*') {
                continue;
            }

            if (user.charAt(i) != ban.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] userId1 = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] bannedId1 = {"fr*d*", "abc1**"};

        String[] userId2 = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] bannedId2 = {"*rodo", "*rodo", "******"};

        String[] userId3 = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] bannedId3 = {"fr*d*", "*rodo", "******", "******"};

        System.out.println(solution.solution(userId1, bannedId1)); // 2

        solution = new Solution();
        System.out.println(solution.solution(userId2, bannedId2)); // 2

        solution = new Solution();
        System.out.println(solution.solution(userId3, bannedId3)); // 3
    }
}