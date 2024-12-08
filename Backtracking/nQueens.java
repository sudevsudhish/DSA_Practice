package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class nQueens {

    public static void savBoard(char[][] board,List<List<String>> allBords){
        String row ="";
        List<String> newBoard = new ArrayList<String>();

        for(int i=0;i<board.length;i++){
            row="";
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] == 'Q') row += 'Q';
                else row += '.';
            }
            newBoard.add(row);
        }
        allBords.add(newBoard);
    }
    public static boolean isSafe(int row, int col, char[][] board){
        //horizontal
        for(int j=0;j<board.length;j++){
            if(board[row][j] == 'Q')
                return false;
        }
        //vertical
        for(int i=0;i<board.length;i++){
            if(board[i][col] == 'Q')
                return false;
        }
        //upper left
        int r = row;
        for(int c=col; c>=0 && r>=0;c--,r++){
            if(board[r][c] == 'Q')
                return false;
        }
        //upper right
        r = row;
        for(int c=col; c<board.length && r>=0;c++,r--){
            if(board[r][c] == 'Q')
                return false;
        }

        //lower left
        r = row;
        for(int c=col; c>=0 && r<board.length;c--,r++){
            if(board[r][c] == 'Q')
                return false;
        }

        //lower right
        r = row;
        for(int c=col;  c<board.length && r<board.length;c++,r++){
            if(board[r][c] == 'Q')
                return false;
        }

        return true;
    }
    
    public static void helper(char[][] board,List<List<String>> allBords, int col ){
        if(col == board.length){
            savBoard(board,allBords);
            return;
        }
        for(int row=0;row<board.length;row++){
            if(isSafe(row,col, board)){
                board[row][col] = 'Q';
                helper(board, allBords, col+1);
                board[row][col] = '.'; // backtrack
            }
        }
    }

    public static void solveNqueens(int n){
        List<List<String>> allBords = new ArrayList<List<String>>();
        char[][] board = new char[n][n];

        helper(board, allBords,0);

    }

    public static void main(String[] args) {
        solveNqueens(3);
    }
}
