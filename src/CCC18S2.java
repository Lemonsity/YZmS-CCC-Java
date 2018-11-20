import  java.io.*;
import java.util.Scanner;

public class CCC18S2 {
    public static int[][] table;
    public static void main(String[] args) throws  IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        table = new int[size][size];
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                table[i][j] = sc.nextInt();
            }
        }
        while (table[0][0] > table[0][1] || table[0][0] > table[1][0]){
            rotate(size);
        }
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                System.out.print(j < size ? table[i][j] + " ": table[i][j]);
            }
            System.out.print("\n");
        }
    }
    public static void rotate(int size){
        if (size % 2 == 0){
            for (int row = 0; row < size / 2; row++){
                for (int column = 0; column < size / 2; column++){
                    int temp = table[row][column];
                    table[row][column] = table[size - 1 - column][row];
                    table[size - 1 - column][row] = table[size - 1 - row][size - 1 - column];
                    table[size - 1 - row][size - 1 - column] = table[column][size - 1 - row];
                    table[column][size - 1 - row] = temp;
                }
            }
        }
        else if (size % 2 == 1){
            for (int row = 0; row <= size / 2 - 1; row++){
                for (int column = 0; column <= size / 2; column++){
                    int temp = table[row][column];
                    table[row][column] = table[size - 1 - column][row];
                    table[size - 1 - column][row] = table[size - 1 - row][size - 1 - column];
                    table[size - 1 - row][size - 1 - column] = table[column][size - 1 - row];
                    table[column][size - 1 - row] = temp;
                }
            }
        }
    }
}
