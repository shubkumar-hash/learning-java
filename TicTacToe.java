import java.util.*;
public class TicTacToe {
    static char[][] board = {
        {' ', ' ', ' '},
        {' ', ' ', ' '},
        {' ', ' ', ' '}
    };

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("1. Human vs Human");
        System.out.println("2. Human vs AI");
        System.out.println("3. AI vs AI");
        System.out.print("Choose mode: ");

        int choice = sc.nextInt();
        play(choice<3 , choice<2);
    }

    static void play(boolean humanX, boolean humanO){
        char currPlayer = 'X';

        while (true) {
            printBoard();
            if(currPlayer=='X'){
                if(humanX) playHuman(currPlayer);
                else playAi(currPlayer);
            } else{
                if(humanO) playHuman(currPlayer);
                else playAi(currPlayer);
            }

            if (checkWin(currPlayer)) {
                printBoard();
                System.out.println(currPlayer + " wins!");
                break;
            }

            if (isBoardFull()) {
                printBoard();
                System.out.println("It's a draw!");
                break;
            }


            if(currPlayer == 'X') currPlayer = 'O';
            else currPlayer = 'X';
        }
    }

    static void playHuman(char currPlayer){
        while(true){
            System.out.println("Enter a valid between 1 to 9");
            int choice = sc.nextInt() - 1;
            int row = choice/3;
            int col = choice%3;
            if(isValidMove(row, col)){
                board[row][col] = currPlayer;
                break;
            } 
            else{
                System.out.println("Enter a valid move");
            }
        }
    }

    static void playAi(char currPlayer){
        int bestScore = Integer.MIN_VALUE;
        int bestRow = -1, bestCol = -1;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    board[i][j] = currPlayer;
                    int score = minimax(false, currPlayer);
                    board[i][j] = ' ';

                    if (score > bestScore) {
                        bestScore = score;
                        bestRow = i;
                        bestCol = j;
                    }
                }
            }
        }

        board[bestRow][bestCol] = currPlayer;
    }

    static int minimax(boolean isMaximizing, char aiPlayer) {
        char opponent = (aiPlayer == 'X') ? 'O' : 'X';

        if (checkWin(aiPlayer)) return 1;
        if (checkWin(opponent)) return -1;
        if (isBoardFull()) return 0;

        if (isMaximizing) {
            int bestScore = Integer.MIN_VALUE;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == ' ') {
                        board[i][j] = aiPlayer;
                        int score = minimax(false, aiPlayer);
                        board[i][j] = ' ';
                        bestScore = Math.max(bestScore, score);
                    }
                }
            }
            return bestScore;
        } 
        else {
            int bestScore = Integer.MAX_VALUE;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == ' ') {
                        board[i][j] = opponent;
                        int score = minimax(true, aiPlayer);
                        board[i][j] = ' ';
                        bestScore = Math.min(bestScore, score);
                    }
                }
            }
            return bestScore;
        }
    }

    static boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ';
    }

    static boolean isBoardFull() {
        for (char[] row : board)
            for (char c : row)
                if (c == ' ') return false;
        return true;
    }

    static boolean checkWin(char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player)
                return true;
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player)
                return true;
        }

        return (board[0][0] == player && board[1][1] == player && board[2][2] == player)
                || (board[0][2] == player && board[1][1] == player && board[2][0] == player);
    }

    static void printBoard() {
        System.out.println();
        for (int i = 0; i < 3; i++) {
            System.out.println(" " + board[i][0] + " | " + board[i][1] + " | " + board[i][2]);
            if (i < 2) System.out.println("---+---+---");
        }
        System.out.println();
    }
}
