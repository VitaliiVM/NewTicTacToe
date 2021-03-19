package TicTac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.valueOf;


public class Game {

    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static String firstPlayer;
    public static String secondPlayer;
    public static int row;
    public static int column;
    public static String[][] gameField;

    public static void gameStart() throws IOException {
        System.out.println("Игра: КРЕСТИКИ НОЛИКИ");

        System.out.println("Введите колличество рядов: ИГРОВОГО ПОЛЯ");
        row = parseInt(reader.readLine());

        System.out.println("Введите колличество колон: ИГРОВОГО ПОЛЯ");
        column = parseInt(reader.readLine());

        gameField = initGameField(row);

        System.out.println("Введите имя первого игрока: X");
        firstPlayer = reader.readLine();

        System.out.println("Введите имя второго игрока: O");
        secondPlayer = reader.readLine();

        System.out.println("Игра началась!!!");
        System.out.println();

        for (int win = 0; win <= 3 ; win++){
            showGameField();
            firstPlayer();
            showGameField();
            secondPlayer();
            draw();

        }

    }



    public static void firstPlayer() throws IOException {

        boolean first = false;
        do {

            System.out.println("Ход игрока: " + firstPlayer + ": ");
            var number = Integer.parseInt(reader.readLine());
            var value = findCellValueByNumber(number, gameField);
            if (value.equals("0") || value.equals("X")) {
                System.err.println("Введенное значение не верно");
            }

            for (int i = 0; i < gameField.length; i++) {
                for (int j = 0; j < column; j++) {
                    if (number -1 >= 0 && gameField[i][j] == value){
                        gameField[i][j] = "X";
                    }

                }
            }

            int riad;
            for (int i = 0; i < row; i++) {
                riad = 0;
                for (int j = 0; j < column; j++) {
                    if (gameField[i][0] == (gameField[i][j])) {
                        riad++;
                    }

                    if (riad == row){
                        System.out.println( firstPlayer + "WINNER!!!!!!!!!ROW");
                        break;
                    }
                }

            }


            int colonki;
            for (int i = 0; i < column; i++) {
                colonki = 0;
                for (int j = 0; j < row; j++) {
                    if (gameField[0][i] == (gameField[j][i])) {
                        colonki++;
                    }

                    if (colonki == column) {
                        showGameField();
                        System.out.println( firstPlayer + "WINNER!!!!!!!COLUMN");
                        break;
                    }
                }

            }

            int counterDiagonal = 1;
            for (int i = 0; i < gameField.length - 1; i++) {
                if (gameField[i][i] == gameField[i + 1][i + 1]) {
                    counterDiagonal++;
                }
                if (counterDiagonal == gameField.length) {
                    System.out.println(firstPlayer + "WINNER!!!!!!DIAGONAL");
                }
            }
            


            first = true;
        }while(!first);

    }

    public static void secondPlayer() throws IOException {

        boolean second = false;
        do {

            System.out.println("Ход игрока: " + secondPlayer + ": ");
            var numberSecond = Integer.parseInt(reader.readLine());
            var value = findCellValueByNumber(numberSecond, gameField);
            if (value.equals("0") || value.equals("X")) {
                System.err.println("Введенное значение не верно");
            }

            for (int i = 0; i < gameField.length; i++) {
                for (int j = 0; j < column; j++) {
                    if (numberSecond -1 >= 0 && gameField[i][j] == value){
                        gameField[i][j] = "O";
                    }

                }
            }

            int riad;
            for (int i = 0; i < row; i++) {
                riad = 0;
                for (int j = 0; j < column; j++) {
                    if (gameField[i][0] == (gameField[i][j])) {
                        riad++;
                    }

                    if (riad == row){
                        showGameField();
                        System.out.println( secondPlayer + " " + "WINNER!!!!!!!!!ROW");
                        break;
                    }
                }
            }

            int colonki;
            for (int i = 0; i < column; i++) {
                colonki = 0;
                for (int j = 0; j < row; j++) {
                    if (gameField[0][i] == (gameField[j][i])) {
                        colonki++;
                    }

                    if (colonki == column) {
                        showGameField();
                        System.out.println( secondPlayer + " " + "WINNER!!!!!!!COLUMN");
                        break;
                    }
                }

            }

            int counterDiagonal = 1;
            for (int i = 0; i < gameField.length - 1; i++) {
                if (gameField[i][i] == gameField[i + 1][i + 1]) {
                    counterDiagonal++;
                }
                if (counterDiagonal == gameField.length) {
                    System.out.println(secondPlayer + " " + "WINNER!!!!!!DIAGONAL");
                }
            }

            second = true;
        }while(!second);

    }

    public  static  boolean draw () throws IOException {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if ((gameField[i][j] != "")) {
                    return false;
                }
            }
            System.out.println("DRAW");
        }
            return true;


    }


    public static void showGameField() {

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {

                System.out.print(" | " + (gameField[i][j]) + " | ");
            }

            System.out.println();
            if (i != row - 1) {
                System.out.println("---------------------");
            }
        }
        System.out.println();
    }


    public static String[][] initGameField(Integer number) {
        var field = new String[number][number];
        Integer counter = 0;
        for (int k = 0; k < number; k++) {
            for (int i = 0; i < number; i++) {
                counter += 1;
                field[k][i] = counter.toString();
            }
        }

        return field;
    }


    public static String findCellValueByNumber(Integer number, String[][] gameField) {
        int counter = 0;
        for (int rowIndex = 0; rowIndex < gameField.length; rowIndex++) {
            var cellArray = gameField[rowIndex];
            for (int cellIndex = 0; cellIndex < cellArray.length; cellIndex++) {
                if (number == ++counter) {
                    return cellArray[cellIndex];
                }
            }
        }
        return "";
    }


    }



