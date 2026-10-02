package Recursion.Backtracking;

public class Knights {
    static void knights(boolean[][] board, int row, int col, int kn) {
        if(kn==0){
            display(board);
            System.out.println();
            return;
        }
        if (row == board.length) {
            return;
        }

        if (col == board[0].length) {
            knights(board, row + 1, 0, kn);
            return;
        }
        if(safe(board,row,col)){
            board[row][col]=true;
            knights(board,row,col+1,kn-1);
            board[row][col]=false;
        }
        knights(board,row,col+1,kn);
    }
    static boolean safe(boolean[][] board, int row, int col) {

        if (valid(board, row - 2, col - 1) && board[row - 2][col - 1]) {
            return false;
        }

        if (valid(board, row - 2, col + 1) && board[row - 2][col + 1]) {
            return false;
        }

        if (valid(board, row - 1, col - 2) && board[row - 1][col - 2]) {
            return false;
        }

        if (valid(board, row - 1, col + 2) && board[row - 1][col + 2]) {
            return false;
        }

        return true;
    }
    static boolean valid(boolean[][] board, int row, int col){
        if(row>=0&&row<=board.length-1&&col>=0&&col<=board[0].length-1) return true;
        return false;
    }
    public static void display(boolean[][] board) {
        for(boolean[] row : board){
            for(boolean cell : row){
                if(cell){
                    System.out.print("K");
                }
                else {
                    System.out.print("X");
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int n=4;
        boolean[][] board = new boolean[n][n];
        knights(board,0,0,n);
    }
}
