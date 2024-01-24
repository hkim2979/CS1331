import java.util.*;

public class Battleship {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to Battleship!\n");

        char [][][] playerNum = new char [2][5][5];
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                playerNum[0][row][col] = '-';
                playerNum[1][row][col] = '-';
            }
        }

        for(int boxNum = 0; boxNum < 2; boxNum++) {
            System.out.println("PLAYER "+ (boxNum + 1) +", ENTER YOUR SHIPS' COORDINATES.");

            int shipLoc = 1;
            do {
                System.out.println("Enter ship "+ shipLoc +" location:");

                int row = input.nextInt();
                int col = input.nextInt();

                if ((row < 0) || (row > 4) || (col < 0) || (col > 4)) {
                    System.out.println("Invalid coordinates. Choose different coordinates.");
                    shipLoc--;
                }
                else if ((playerNum[boxNum][row][col] == '@')) {
                    System.out.println("0 1");
                    shipLoc--;
                }
                else{
                    playerNum[boxNum][row][col] = '@';
                }
                shipLoc++;
            } while (shipLoc <= 5);

            printBattleShip(playerNum[boxNum]);

            for (int i = 0; i < 100; i++) {
                System.out.print("\n");
            }
        }

        int[] target = new int[2];
        target[0] = 5;
        target[1] = 5;

        char[][][] hit = new char [2][5][5];
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {

                hit[0][row][col] = '-';
                hit[1][row][col] = '-';
            }
        }

        int finish = 0;

        while (target[0] > 0 || target[1] > 0) {

            for (int i = 0; i < 2; i++) {

                int [] intInput = userInput(i, hit[i]);

                if (playerNum[zeroOne(i)][intInput[0]][intInput[1]] == '@') {
                    target[i]--;

                    hit[i][intInput[0]][intInput[1]] = 'X';
                    System.out.println("PLAYER " + (i + 1) + " HIT PLAYER " + (zeroOne(i) + 1) + "'s SHIP!");
                }
                else {
                    hit[i][intInput[0]][intInput[1]] = 'O';
                    System.out.println("PLAYER " + (i + 1) + " MISSED!");
                }

                printBattleShip(hit[i]);

                if (target[i] == 0) {
                    finish = 1;
                    System.out.println("PLAYER " + (i + 1) + " WINS! YOU SUNK ALL OF YOUR OPPONENT’S SHIPS!\n");
                    break;
                }
            }

            if (finish == 1) {
                break;
            }
        }

        char[][][] gameResult = new char[2][5][5];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if (hit[zeroOne(i)][j][k] == 'X') {
                        gameResult[i][j][k] = 'X';
                    }
                    else if (hit[zeroOne(i)][j][k] == 'O') {
                        gameResult[i][j][k] = 'O';
                    }
                    else if (playerNum[i][j][k] == '@') {
                        gameResult[i][j][k] = '@';
                    }
                    else {
                        gameResult[i][j][k] = '-';
                    }
                }
            }
        }
        System.out.println("Final boards:\n");
        printBattleShip(gameResult[0]);
        System.out.println("\n");
        printBattleShip(gameResult[1]);
    }

    public static int zeroOne(int a) {
        if (a == 0) {
            return 1;
        }
        return 0;
    }

    public static int[] userInput(int i, char[][] hit) {
        Scanner input = new Scanner(System.in);
        System.out.println("\nPlayer " + (i + 1) + ", enter hit row/column:");

        int hitPointRow = input.nextInt();
        int hitPointCol = input.nextInt();

        if ((hitPointRow < 0) || (hitPointRow > 4) || (hitPointCol < 0) || (hitPointCol > 4)) {
            System.out.println("Invalid coordinates. Choose different coordinates.");
            return userInput(i, hit);
        }

        else if (hit[hitPointRow][hitPointCol] == 'X' || hit[hitPointRow][hitPointCol] == 'O') {
            System.out.println("You already fired on this spot. Choose different coordinates.");
            return userInput(i, hit);
        }

        else {
            int [] x = new int[2];
            x[0] = hitPointRow;
            x[1] = hitPointCol;
            return x;
        }
    }

    // Use this method to print game boards to the console.
    private static void printBattleShip(char[][] player) {
        System.out.print("  ");
        for (int row = -1; row < 5; row++) {
            if (row > -1) {
                System.out.print(row + " ");
            }
            for (int column = 0; column < 5; column++) {
                if (row == -1) {
                    System.out.print(column + " ");
                } else {
                    System.out.print(player[row][column] + " ");
                }
            }
            System.out.println("");
        }
    }

}