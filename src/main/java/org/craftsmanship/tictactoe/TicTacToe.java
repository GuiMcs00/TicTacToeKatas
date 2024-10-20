package org.craftsmanship.tictactoe;

public class TicTacToe{
    private char[][] board;
    private char whosPlaying;

    public TicTacToe(){
        board = new char[3][3];
        whosPlaying = 'X';
    }

    public char[][] getBoard(){
        return board;
    }


    public void setBoard(int linha, int coluna) throws IllegalArgumentException{
        if(board[linha][coluna] != Character.MIN_VALUE){
            throw new IllegalArgumentException("Posição já preenchida!");
        }
        board[linha][coluna] = whosPlaying;
        whosPlaying = (whosPlaying == 'X' ? 'O' : 'X');
    }

    public boolean checkWinner(){

        for(int i=0; i < 3; i++){
            // Check horizontal
            if(board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != Character.MIN_VALUE){
                return true;
            }
            // Check vertical
            if(board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != Character.MIN_VALUE){
                return true;
            }
        }

        // Check diagonal
        if(board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[1][1] != Character.MIN_VALUE){
            return true;
        }
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[1][1] != Character.MIN_VALUE){
            return true;
        }
        return false;
    }


//    public static char[][] inserir(int linha, int coluna){
//        if (board[linha][coluna] == Character.MIN_VALUE){
////        if(board[linha][coluna] != 'X' && board[linha][coluna] != 'O'){
//            board[linha][coluna] = whosPlaying;
//            if (whosPlaying == 'X'){
//                whosPlaying = 'O';
//            }
//            else{
//                whosPlaying = 'X';
//            }
//            return board;
//
//        }
//        else{
//            return null;
//        }
//
//    }

}
