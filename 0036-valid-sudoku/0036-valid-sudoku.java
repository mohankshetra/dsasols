import java.util.*;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        // 9 sets for rows, cols, and boxes
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char val = board[r][c];
                if (val == '.') continue; // skip empty cells

                // Row check
                if (rows[r].contains(val)) return false;
                rows[r].add(val);

                // Column check
                if (cols[c].contains(val)) return false;
                cols[c].add(val);

                // Box index (0 to 8)
                int boxIndex = (r / 3) * 3 + (c / 3);
                if (boxes[boxIndex].contains(val)) return false;
                boxes[boxIndex].add(val);
            }
        }
        return true;
    }
}
