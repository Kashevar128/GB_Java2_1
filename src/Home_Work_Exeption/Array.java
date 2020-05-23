package Home_Work_Exeption;

import com.geekbrains.java2.lesson2.hw.MyArrayDataException;
import com.geekbrains.java2.lesson2.hw.MyArraySizeException;

import java.util.Arrays;

public class Array {
    public static int methodArr(int x, int y) throws MyArrayDataException, MyArraySizeException {

        String arr[][] = new String[x][y];
        if (x != 4 || y != 4) {
            throw new MyArraySizeException("Размер массива может быть только 4Х4");
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println();
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = "7";
                arr[1][3] = "5";
                System.out.print(arr[i][j] + "  ");
            }
        }


        System.out.println();
        int arr2[][] = new int[x][y];
        int a = 0;
        int b = 0;
        int sum = 0;
        try {
            for (int i = 0; i < arr.length; i++) {
                System.out.println();
                for (int j = 0; j < arr.length; j++) {
                    arr2[i][j] = Integer.parseInt(arr[i][j]);
                    sum += arr2[i][j];
                    a = i;
                    b = j+1;
                    System.out.print(arr2[i][j] + "  ");
                }
            }
        }
        catch (NumberFormatException e) {
            System.out.println();
            throw new MyArrayDataException(" Невозможно преобразовать ячейку ["+ a +"] и ["+ b +"]" );
        }
        System.out.println();
        return sum;

    }

    public static void main(String[] args) {
        try {
            System.out.println(methodArr(4, 4));
        }
        catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }
    }
}
