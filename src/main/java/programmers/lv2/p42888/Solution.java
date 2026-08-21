package programmers.lv2.p42888;

// https://school.programmers.co.kr/learn/courses/30/lessons/42888

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public String[] solution(String[] record) {
        Map<String, String> nicknames = new HashMap<>();
        List<String> messages = new ArrayList<>();

        for (String value : record) {
            String[] information = value.split(" ");

            String command = information[0];
            String userId = information[1];

            if (command.equals("Enter")
                || command.equals("Change")) {

                String nickname = information[2];
                nicknames.put(userId, nickname);
            }
        }

        for (String value : record) {
            String[] information = value.split(" ");

            String command = information[0];
            String userId = information[1];
            String nickname = nicknames.get(userId);

            if (command.equals("Enter")) {
                messages.add(nickname + "님이 들어왔습니다.");
            } else if (command.equals("Leave")) {
                messages.add(nickname + "님이 나갔습니다.");
            }
        }

        return messages.toArray(new String[0]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] record = {
            "Enter uid1234 Muzi",
            "Enter uid4567 Prodo",
            "Leave uid1234",
            "Enter uid1234 Prodo",
            "Change uid4567 Ryan"
        };

        String[] result = solution.solution(record);

        System.out.println(Arrays.toString(result));
    }
}