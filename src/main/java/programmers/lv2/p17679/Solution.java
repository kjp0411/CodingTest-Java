package programmers.lv2.p17679;

// https://school.programmers.co.kr/learn/courses/30/lessons/17679

public class Solution {
    public int solution(int m, int n, String[] board) {
        char[][] blocks = new char[m][n];

        for (int row = 0; row < m; row++) {
            blocks[row] = board[row].toCharArray();
        }

        int answer = 0;

        while (true) {
            boolean[][] removed = new boolean[m][n];
            boolean found = false;

            // 삭제할 2×2 블록 찾기
            for (int row = 0; row < m - 1; row++) {
                for (int column = 0; column < n - 1; column++) {
                    char block = blocks[row][column];

                    if (block == ' ') {
                        continue;
                    }

                    if (block == blocks[row][column + 1]
                        && block == blocks[row + 1][column]
                        && block == blocks[row + 1][column + 1]) {

                        removed[row][column] = true;
                        removed[row][column + 1] = true;
                        removed[row + 1][column] = true;
                        removed[row + 1][column + 1] = true;

                        found = true;
                    }
                }
            }

            if (!found) {
                break;
            }

            // 표시된 블록 삭제
            for (int row = 0; row < m; row++) {
                for (int column = 0; column < n; column++) {
                    if (removed[row][column]) {
                        blocks[row][column] = ' ';
                        answer++;
                    }
                }
            }

            // 남은 블록 아래로 이동
            for (int column = 0; column < n; column++) {
                int writeRow = m - 1;

                for (int row = m - 1; row >= 0; row--) {
                    if (blocks[row][column] != ' ') {
                        blocks[writeRow][column] =
                            blocks[row][column];

                        writeRow--;
                    }
                }

                while (writeRow >= 0) {
                    blocks[writeRow][column] = ' ';
                    writeRow--;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int m1 = 4;
        int n1 = 5;
        String[] board1 = {
            "CCBDE",
            "AAADE",
            "AAABF",
            "CCBBF"
        };

        int m2 = 6;
        int n2 = 6;
        String[] board2 = {
            "TTTANT",
            "RRFACC",
            "RRRFCC",
            "TRRRAA",
            "TTMMMF",
            "TMMTTJ"
        };

        int result1 = solution.solution(m1, n1, board1);
        int result2 = solution.solution(m2, n2, board2);

        System.out.println(result1); // 14
        System.out.println(result2); // 15
    }
}