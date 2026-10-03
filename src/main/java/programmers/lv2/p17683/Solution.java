package programmers.lv2.p17683;

// https://school.programmers.co.kr/learn/courses/30/lessons/17683

public class Solution {
    public String solution(String m, String[] musicinfos) {
        String rememberedMelody = normalizeMelody(m);

        String answer = "(None)";
        int longestPlayTime = 0;

        for (String musicInfo : musicinfos) {
            String[] information = musicInfo.split(",");

            String startTime = information[0];
            String endTime = information[1];
            String title = information[2];
            String sheetMusic = normalizeMelody(information[3]);

            int playTime = calculatePlayTime(startTime, endTime);
            String playedMelody = createPlayedMelody(sheetMusic, playTime);

            if (playedMelody.contains(rememberedMelody)
                    && playTime > longestPlayTime) {
                answer = title;
                longestPlayTime = playTime;
            }
        }

        return answer;
    }

    private String normalizeMelody(String melody) {
        StringBuilder normalizedMelody = new StringBuilder();

        for (int i = 0; i < melody.length(); i++) {
            char note = melody.charAt(i);

            if (i + 1 < melody.length() && melody.charAt(i + 1) == '#') {
                normalizedMelody.append(Character.toLowerCase(note));
                i++;
            } else {
                normalizedMelody.append(note);
            }
        }

        return normalizedMelody.toString();
    }

    private int calculatePlayTime(String startTime, String endTime) {
        return convertToMinutes(endTime) - convertToMinutes(startTime);
    }

    private int convertToMinutes(String time) {
        String[] hourAndMinute = time.split(":");

        int hour = Integer.parseInt(hourAndMinute[0]);
        int minute = Integer.parseInt(hourAndMinute[1]);

        return hour * 60 + minute;
    }

    private String createPlayedMelody(String sheetMusic, int playTime) {
        StringBuilder playedMelody = new StringBuilder();

        for (int minute = 0; minute < playTime; minute++) {
            int noteIndex = minute % sheetMusic.length();
            playedMelody.append(sheetMusic.charAt(noteIndex));
        }

        return playedMelody.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String m1 = "ABCDEFG";
        String[] musicinfos1 = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        String m2 = "CC#BCC#BCC#BCC#B";
        String[] musicinfos2 = {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};
        String m3 = "ABC";
        String[] musicinfos3 = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};

        String result1 = solution.solution(m1, musicinfos1);
        String result2 = solution.solution(m2, musicinfos2);
        String result3 = solution.solution(m3, musicinfos3);

        System.out.println(result1); // HELLO
        System.out.println(result2); // FOO
        System.out.println(result3); // WORLD
    }
}