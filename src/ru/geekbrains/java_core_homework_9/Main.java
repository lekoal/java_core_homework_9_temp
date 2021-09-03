package ru.geekbrains.java_core_homework_9;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            System.out.println("Sum of array's elements: " + arrCheck(arrEntry()));
        } catch (MyArraySizeException e) {
            System.out.print("Exception: ");
            e.message();
        } catch (MyArrayDataException e) {
            System.out.println("Program is closing");
        }

    }

    /*
        public static void arrCheck(String[][] myArray) throws MyArrayDataException {
            int sum = 0;
            try {
                if (myArray.length == 4 && myArray[0].length == 4) {
                    for (int i = 0; i < myArray[0].length; i++) {
                        for (int j = 0; j < myArray.length; j++) {
                            sum += Integer.parseInt(myArray[i][j]);
                        }
                    }
                    System.out.println(sum);
                } else throw new MyArraySizeException();

            } catch (MyArraySizeException e) {
                System.out.print("Exception: ");
                e.message();
            } catch (NumberFormatException e) {
                throw new MyArrayDataException();
            }
        }
    */
    public static int arrCheck(String[][] myArray) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;
        if (myArray.length == 4 && myArray[0].length == 4) {
            for (int i = 0; i < myArray[0].length; i++) {
                for (int j = 0; j < myArray.length; j++) {
                    if ((myArray[i][j]).matches("[-+]?\\d+")) { // Условные выражения
                        sum += Integer.parseInt(myArray[i][j]);
                    } else throw new MyArrayDataException(i, j);
                }
            }
        } else throw new MyArraySizeException();
        return sum;
    }

    public static String[][] arrEntry() {
        Scanner sc = new Scanner(System.in);
        int x = 0, y = 0;
        boolean exit = false;
        do {
            System.out.println("Enter number of lines (must be 4)");
            String input = sc.nextLine().trim();
            Scanner check = new Scanner(input);
            if (check.hasNextInt()) {
                x = check.nextInt();
                exit = true;
            }
        } while (!exit);
        exit = false;
        do {
            System.out.println("Enter number of columns (must be 4)");
            String input = sc.nextLine().trim();
            Scanner check = new Scanner(input);
            if (check.hasNextInt()) {
                y = check.nextInt();
                exit = true;
            }
        } while (!exit);

        String[][] myArray = new String[x][y];
        System.out.print("Fill the array:");
        for (int i = 0; i < myArray.length; i++) {
            for (int j = 0; j < myArray[0].length; j++) {
                System.out.printf("%nEnter %s %s element: ", i, j);
                myArray[i][j] = sc.next();
            }
        }
        return myArray;
        // return new String[][] {{"1", "3", "2", "5"}, {"6", "4", "7", "1"}, {"3", "7", "6", "2"}, {"9", "3", "4", "8"}};

    }
}

