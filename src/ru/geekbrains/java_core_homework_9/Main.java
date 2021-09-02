package ru.geekbrains.java_core_homework_9;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        arrCheck(arrEntry());
    }

    public static void arrCheck(String[][] myArray) {
        int sum = 0;
        try {
            if (myArray.length == 4 && myArray[0].length == 4) {
                for (int i = 0; i < myArray[0].length; i++) {
                    for (int j = 0; j < myArray.length; j++) {
                        if ((myArray[i][j]).matches("[-+]?\\d+")) {
                            sum += Integer.parseInt(myArray[i][j]);
                        } else throw new MyArrayDataException();
                    }
                }
                System.out.println(sum);
            } else throw new MyArraySizeException();
        } catch (MyArraySizeException e) {
            System.out.print("Exception: ");
            e.message();
        } catch (MyArrayDataException e) {
            System.out.print("Exception: ");
            e.message();
            e.printStackTrace();
        }
    }

    public static String[][] arrEntry() {
        Scanner sc = new Scanner(System.in);
        int x = 0, y = 0;
        System.out.println("Enter number of lines (must be 4)");
        if (sc.hasNextInt()) {
            x = sc.nextInt();
        } else System.out.println("Must be an integer type");
        System.out.println("Enter number of columns (must be 4)");
        if (sc.hasNextInt()) {
            y = sc.nextInt();
        } else System.out.println("Must be an integer type");
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

