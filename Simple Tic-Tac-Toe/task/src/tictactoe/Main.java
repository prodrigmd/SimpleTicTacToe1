package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] matrix = createMatrix();
        printMatrix(matrix);

        boolean stopIt = false;
        char player = 'X';
        while (!stopIt) {
            System.out.println("Enter the coordinates: ");
            String coordI = scanner.next();
            if (isNumeric(coordI)) {
                String coordJ = scanner.next();
                if (isNumeric(coordJ)) {
                    int x = Integer.parseInt(coordI);
                    int y = Integer.parseInt(coordJ);
                    if (x > 0 && x < 4 && y > 0 && y < 4) {
                        player = play(matrix, x, y, player);
                        stopIt = result(matrix);
                    } else {
                        System.out.println("Coordinates should be from 1 to 3!");
                    }

                } else {
                    System.out.println("You should enter 1 numbers!");
                }
            } else {
                System.out.println("You should enter 2 numbers!");
                scanner.next();
            }
        }

    }
    public static char[][] createMatrix() {;
        char[][] matrix = new char[3][3];
        for (int i = 0, k = 0; i < 3; i++, k += 3) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = ' ';
            }
        }
        return matrix;
    }
    public static void printMatrix(char[][] matrix) {
        System.out.println("---------");
        System.out.println("| " + matrix[0][0] + " " + matrix[0][1] + " " + matrix[0][2] + " |");
        System.out.println("| " + matrix[1][0] + " " + matrix[1][1] + " " + matrix[1][2] + " |");
        System.out.println("| " + matrix[2][0] + " " + matrix[2][1] + " " + matrix[2][2] + " |");
        System.out.println("---------");
    }
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            int d = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static char play(char[][] matrix, int i, int j, char player) {
        char newPlayer;
        if (matrix[i - 1][j - 1] == ' ') {
            matrix[i - 1][j - 1] = player;
            newPlayer = player == 'X' ? 'O': 'X';
            printMatrix(matrix);
        } else {
            System.out.println("This cell is occupied! Choose another one!");
            newPlayer = player;
        }
        return newPlayer;
    }
    public static boolean result(char[][] matrix) {
        boolean stopIt1 = false;
        boolean stopIt2 = false;
        for (int i = 0; i < 3; i++) {
            if (matrix[i][0] + matrix[i][1] + matrix[i][2] == 264) {
                System.out.println("X wins");
                stopIt1 = true;
            } else if (matrix[i][0] + matrix[i][1] + matrix[i][2] == 237) {
                System.out.println("O wins");
                stopIt1 = true;
            } else if (matrix[0][i] + matrix[1][i] + matrix[2][i] == 264) {
                System.out.println("X wins");
                stopIt1 = true;
            } else if (matrix[0][i] + matrix[1][i] + matrix[2][i] == 237) {
                System.out.println("O wins");
                stopIt1 = true;
            }
        }
        if (matrix[0][0] + matrix[1][1] + matrix[2][2] == 264) {
            System.out.println("X wins");
            stopIt2 = true;
        } else if (matrix[0][0] + matrix[1][1] + matrix[2][2] == 237) {
            System.out.println("O wins");
            stopIt2 = true;
        } else if (matrix[0][2] + matrix[1][1] + matrix[2][0] == 264) {
            System.out.println("X wins");
            stopIt2 = true;
        } else if (matrix[0][2] + matrix[1][1] + matrix[2][0] == 237) {
            System.out.println("O wins");
            stopIt2 = true;
        }
        return stopIt1 || stopIt2;
    }
}
