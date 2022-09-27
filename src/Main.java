import java.util.Scanner;
public class Main {
    public static Scanner in = new Scanner(System.in);
    static char [][] field = new char[3][3];
    public static void main(String[] args) {
        int playerToken = 1;
        int moveCounter = 0;
        fillField(field);                      // заполнить массив пустыми символами (один раз за программу)
        drawField(field);                      // вывести массив

        while (true) {
            while (true) {
                int playerInt = playersIntInput(); // Число точно будет от 1 до 9
                if (insertIntoACell(playerInt, field, playerToken))
                    break;
                else
                    continue;
            }

            drawField(field);
            if (whoWon(field, moveCounter)) {
                System.out.println("Game over!");
                break;
            }
            moveCounter++;
            if (moveCounter % 2 == 1)
                playerToken = 2;
            else if (moveCounter % 2 == 0)
                playerToken = 1;
        }

    }

    public static void drawField(char[][] field) {
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                if (j != 2)
                    System.out.print(field[i][j] + "|");
                else
                    System.out.print(field[i][j]);
            }
            System.out.println();
            if (i != 2)
                System.out.println("-+-+-");
        }
    }

    public static void fillField(char[][] field) {
        for (int i = 0; i <= 2; i++)
            for (int j = 0; j <= 2; j++) {
                field[i][j] = ' ';
            }
    }

    public static int playersIntInput() {
        while (true) {
            System.out.println("Enter the number (from 1 to 9) in which cell you want to put X/O");
            int x = in.nextInt();
            if (x < 1 || x > 9) {
                System.out.println("Error! Wrong Number.");
                continue;
            }
            return x;
        }

    }

    public static boolean insertIntoACell(int playerInt, char[][] field, int playerToken) {
        char symbol = ' ';
        int x, y;

        if (playerToken == 1)
            symbol = 'X';
        else if (playerToken == 2)
            symbol = 'O';

        if (playerInt == 1) {
            x = 0;
            y = 0;
            if (checkPosition(x, y, field)) {
                field[x][y] = symbol;
                return true;
            }
            else
                return false;
        }

        else if (playerInt == 2) {
            x = 0;
            y = 1;
            if (checkPosition(x, y, field)) {
                field[x][y] = symbol;
                return true;
            }
            else
                return false;
        }

        else if (playerInt == 3) {
            x = 0;
            y = 2;
            if (checkPosition(x, y, field)) {
                field[x][y] = symbol;
                return true;
            }
            else
                return false;
        }

        else if (playerInt == 4) {
            x = 1;
            y = 0;
            if (checkPosition(x, y, field)) {
                field[x][y] = symbol;
                return true;
            }
            else
                return false;
        }

        else if (playerInt == 5) {
            x = 1;
            y = 1;
            if (checkPosition(x, y, field)) {
                field[x][y] = symbol;
                return true;
            }
            else
                return false;

        }

        else if (playerInt == 6) {
            x = 1;
            y = 2;
            if (checkPosition(x, y, field)) {
                field[x][y] = symbol;
                return true;
            }
            else
                return false;
        }

        else if (playerInt == 7) {
            x = 2;
            y = 0;
            if (checkPosition(x, y, field)) {
                field[x][y] = symbol;
                return true;
            }
            else
                return false;
        }

        else if (playerInt == 8) {
            x = 2;
            y = 1;
            if (checkPosition(x, y, field)) {
                field[x][y] = symbol;
                return true;
            }
            else
                return false;
        }

        else if (playerInt == 9) {
            x = 2;
            y = 2;
            if (checkPosition(x, y, field)) {
                field[x][y] = symbol;
                return true;
            }
            else
                return false;
        }
        return false;
    }

    public static boolean checkPosition(int x, int y, char[][] field) {
        boolean flag = true;
        if (field[x][y] == 'X' || field[x][y] == 'O') {
            System.out.println("Error! This position in occupied.");
            flag = false;
        }
        return flag;
    }

    public static boolean whoWon(char[][] field, int moveCounter) {
        if (moveCounter == 9) {
            System.out.println("No one won!");
            return true;
        }

        else if (field[0][0] == 'X' && field[0][1] == 'X' && field[0][2] == 'X') {
            System.out.println("Player 1 win!");
            return true;
        }

        else if (field[1][0] == 'X' && field[1][1] == 'X' && field[1][2] == 'X') {
            System.out.println("Player 1 win!");
            return true;
        }

        else if (field[2][0] == 'X' && field[2][1] == 'X' && field[2][2] == 'X') {
            System.out.println("Player 1 win!");
            return true;
        }

        else if (field[0][0] == 'X' && field[1][0] == 'X' && field[2][0] == 'X') {
            System.out.println("Player 1 win!");
            return true;
        }

        else if (field[0][1] == 'X' && field[1][1] == 'X' && field[2][1] == 'X') {
            System.out.println("Player 1 win!");
            return true;
        }

        else if (field[0][2] == 'X' && field[1][2] == 'X' && field[2][2] == 'X') {
            System.out.println("Player 1 win!");
            return true;
        }

        else if (field[0][0] == 'X' && field[1][1] == 'X' && field[2][2] == 'X') {
            System.out.println("Player 1 win!");
            return true;
        }

        else if (field[2][0] == 'X' && field[1][1] == 'X' && field[0][2] == 'X') {
            System.out.println("Player 1 win!");
            return true;
        }

        else if (field[0][0] == 'O' && field[0][1] == 'O' && field[0][2] == 'O') {
            System.out.println("Player 2 win!");
            return true;
        }

        else if (field[1][0] == 'O' && field[1][1] == 'O' && field[1][2] == 'O') {
            System.out.println("Player 2 win!");
            return true;
        }

        else if (field[2][0] == 'O' && field[2][1] == 'O' && field[2][2] == 'O') {
            System.out.println("Player 2 win!");
            return true;
        }

        else if (field[0][0] == 'O' && field[1][0] == 'O' && field[2][0] == 'O') {
            System.out.println("Player 2 win!");
            return true;
        }

        else if (field[0][1] == 'O' && field[1][1] == 'O' && field[2][1] == 'O') {
            System.out.println("Player 2 win!");
            return true;
        }

        else if (field[0][2] == 'O' && field[1][2] == 'O' && field[2][2] == 'O') {
            System.out.println("Player 2 win!");
            return true;
        }

        else if (field[0][0] == 'O' && field[1][1] == 'O' && field[2][2] == 'O') {
            System.out.println("Player 2 win!");
            return true;
        }

        else if (field[2][0] == 'O' && field[1][1] == 'O' && field[0][2] == 'O') {
            System.out.println("Player 2 win!");
            return true;
        }

        return false;
    }
}