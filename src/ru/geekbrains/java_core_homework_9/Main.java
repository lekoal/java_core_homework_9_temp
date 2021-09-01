package ru.geekbrains.java_core_homework_9;

public class Main {

    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {
        String[][] myArray = {{"j", "3", "2", "5"}, {"6", "4", "7", "1"}, {"3", "7", "6", "2"}, {"9", "3", "4", "8"}};

        arrCheck(myArray);
    }


    public static void arrCheck(String[][] myArray) {
        int sum = 0;
        try {
            if (myArray.length == 4 || myArray[0].length == 4) {
                for (int i = 0; i < myArray[0].length; i++) {
                    for (int j = 0; j < myArray.length; j++) {
                        sum += Integer.parseInt(myArray[i][j]);
                    }
                }
            } else throw new MyArraySizeException();

        } catch (MyArraySizeException e) {
            System.out.printf("Exception: %s%n", e.toString());
        } catch (NumberFormatException e) {
            e.printStackTrace();
            new MyArrayDataException("Cant convert symbol to int!");
        }
    }
}
