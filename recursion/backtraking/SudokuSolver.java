package recursion.backtraking;

public class SudokuSolver {
    public static void main(String[] args) {
        
    }

    static boolean solve(int[][] board) {
        int n = board.length;
        int row = -1;
        int col = -1;

        boolean emptyLeft = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    row = i;
                    col = j;
                    emptyLeft = false;
                    break;
                }
            }
            // if we found some empty element in row, then break
            if (emptyLeft == false) {
                break;
            }
        }

        if (emptyLeft == true) {
            return true;
            // sudoku is solved
        }

        // backtrack
        for (int number = 0; number < board.length; number++) {
            if (isSafe(board, row, col, number)) {
                board[row][col] = number;
                if (solve(board)) {
                    // found the answer
                    display(board);
                    return true;
                } else {
                    // backtrack
                    board[row][col] = 0;
                }
            }
        }

        return false;
    }

    static boolean isSafe(int[][] board, int row, int col, int num) {
        // check the row
        for (int i = 0; i < board.length; i++) {
            // check if the number is in the row
            if (board[row][col] == num) {
                return false;
            }
        }

        // check the col
        for (int[] nums : board) {
            // check if the number is in the row
            if (nums[col] == num) {
                return false;
            }
        }

        int sqrt = (int)(Math.sqrt(board.length));
        int rowStart = row - row % sqrt;
        int colStart = col - col % sqrt;

        for (int i = rowStart; i < rowStart + sqrt; i++) {
            for (int j = 0; colStart < colStart + sqrt; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    static void display(int[][] board) {
        for (int[] row : board) {
            for (int num : row) {
                System.out.println(num + " ");
            }
            System.out.println();
        }
    }
}
