package programmers.lv2.p17686;

// https://school.programmers.co.kr/learn/courses/30/lessons/17686

import java.util.Arrays;

public class Solution {
    public String[] solution(String[] files) {
        Arrays.sort(files, (file1, file2) -> {
            FileInfo first = splitFileName(file1);
            FileInfo second = splitFileName(file2);

            int headComparison =
                first.head.compareToIgnoreCase(second.head);

            if (headComparison != 0) {
                return headComparison;
            }

            return Integer.compare(first.number, second.number);
        });

        return files;
    }

    private FileInfo splitFileName(String fileName) {
        int numberStart = 0;

        while (!Character.isDigit(fileName.charAt(numberStart))) {
            numberStart++;
        }

        int numberEnd = numberStart;

        while (numberEnd < fileName.length()
            && Character.isDigit(fileName.charAt(numberEnd))
            && numberEnd - numberStart < 5) {

            numberEnd++;
        }

        String head = fileName.substring(0, numberStart);
        int number = Integer.parseInt(
            fileName.substring(numberStart, numberEnd)
        );

        return new FileInfo(head, number);
    }

    private static class FileInfo {
        private final String head;
        private final int number;

        private FileInfo(String head, int number) {
            this.head = head;
            this.number = number;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] files = {
            "img12.png",
            "img10.png",
            "img02.png",
            "img1.png",
            "IMG01.GIF",
            "img2.JPG"
        };

        String[] result = solution.solution(files);

        System.out.println(Arrays.toString(result)); // [img1.png, IMG01.GIF, img02.png, img2.JPG, img10.png, img12.png]
    }
}