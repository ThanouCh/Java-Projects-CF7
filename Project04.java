package gr.aueb.cf.solutions.projects;

import java.util.Scanner;

public class Project04 {
    public static void main(String[] args) {
        boolean playAgain = true;

        do {
            char[][] board = new char[3][3];
            for (int row = 0; row < board.length; row++) {
                for (int col = 0; col < board[row].length; col++) {
                    board[row][col] = ' ';
                }
            }

            char player = 'X';
            boolean gameOver = false;
            Scanner scanner = new Scanner(System.in);

            while (!gameOver) {
                printBoard(board);
                System.out.print("Player " + player + ", enter your move (row and column): ");
                int row = scanner.nextInt();
                int col = scanner.nextInt();
                System.out.println();

                if (row < 0 || row >= 3 || col < 0 || col >= 3) {
                    System.out.println("Invalid move. Please enter values between 0 and 2.");
                    continue;
                }

                if (board[row][col] == ' ') {
                    board[row][col] = player; // Τοποθέτηση συμβόλου
                    gameOver = haveWon(board, player);

                    if (gameOver) {
                        System.out.println("Player " + player + " has won!");
                    } else {
                        // Έλεγχος για ισοπαλία
                        if (isDraw(board)) {
                            System.out.println("The game is a draw!");
                            gameOver = true;
                        } else {
                            // Εναλλαγή παίκτη
                            player = (player == 'X') ? 'O' : 'X';
                        }
                    }
                } else {
                    System.out.println("Invalid move. This spot is already taken. Try again!");
                }

            }

            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.next().toLowerCase();
            playAgain = response.equals("yes");
            if (!playAgain) {
                System.out.println("Thanks for playing!");
            }

        } while (playAgain);
    }


    public static boolean haveWon(char[][] board, char player) {
        // check the rows
        for (int row = 0; row < board.length; row++) {
            if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
                return true;
            }
        }

        // check for col
        for (int col = 0; col < board[0].length; col++) {
            if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
                return true;
            }
        }

        // diagonal
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }

        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
        return false;
    }


    public static boolean isDraw(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }


    public static void printBoard(char[][] board) {
        System.out.print("   "); // Κενός χώρος για ευθυγράμμιση
        for (int col = 0; col < board[0].length; col++) {
            System.out.print(col + "   "); // Εμφάνιση αριθμών στηλών
        }
        System.out.println();

        for (int row = 0; row < board.length; row++) {
            System.out.print(row + " "); // Εμφάνιση αριθμού γραμμής
            for (int col = 0; col < board[row].length; col++) {
                System.out.print(" " + board[row][col] + " "); // Εμφάνιση περιεχομένου
                if (col < board[row].length - 1) {
                    System.out.print("|"); // Διαχωριστής στηλών
                }
            }
            System.out.println();

        }
    }


}
