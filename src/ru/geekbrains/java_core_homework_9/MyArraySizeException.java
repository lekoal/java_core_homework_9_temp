package ru.geekbrains.java_core_homework_9;

public class MyArraySizeException extends Exception {
    @Override
    public String toString() {
        return "Array's size must be 4x4!";
    }
}
