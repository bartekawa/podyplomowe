import java.util.Scanner;

public class Kolkokrzyzyk {

    public static void main(String[] args) {
        char[][] board = {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };

        char currentPlayer = 'X';

        while (true) {
            displayBoard(board);
            makeMove(board, currentPlayer);

            if (checkWin(board, currentPlayer)) {
                displayBoard(board);
                System.out.println("Gracz " + currentPlayer + " wygrywa!");
                break;
            }

            if (isBoardFull(board)) {
                displayBoard(board);
                System.out.println("Remis!");
                break;
            }

            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
    }

    private static void displayBoard(char[][] board) {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    private static void makeMove(char[][] board, char currentPlayer) {
        Scanner scanner = new Scanner(System.in);
        int row, col;

        do {
            System.out.print("Gracz " + currentPlayer + ", podaj numer wiersza (1-3): ");
            row = scanner.nextInt() - 1;
            System.out.print("Gracz " + currentPlayer + ", podaj numer kolumny (1-3): ");
            col = scanner.nextInt() - 1;
        } while (row < 0 || row >= 3 || col < 0 || col >= 3 || board[row][col] != ' ');

        board[row][col] = currentPlayer;
    }

    private static boolean checkWin(char[][] board, char currentPlayer) {
        // Sprawdzenie wierszy i kolumn
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) ||
                    (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer)) {
                return true;
            }
        }

        // Sprawdzenie przekątnych
        if ((board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) ||
                (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer)) {
            return true;
        }

        return false;
    }

    private static boolean isBoardFull(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
