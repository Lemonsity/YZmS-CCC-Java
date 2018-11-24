import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/***********************************************************************
 * Project Name: CCC05S1
 *
 * Author: YZmS Lemonsity
 *
 * Date: Nov 24, 2018
 *
 * Purpose: Solving 2005 CCC S1
 *
 ***********************************************************************
 *  Status: Completed
 *
 */
public class CCC05S1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int amount = Integer.parseInt(br.readLine()); // amount of inputs
        for (int i = 0; i < amount; i++) {
            String input = br.readLine(); // take in value as a string
            int[] finalOutput = new int[10]; // set an array which holds the value after process
            int counter = 0; // amount of number found
            int index = 0; // index of string checking
            while (counter < 10) { // when found less than 10 numbers
                if (input.charAt(index) != '-') { // check if the string index at is a -, if not, then turn it into a number
                    int temp = (int) input.charAt(index);
                    if (temp >= 48 && temp <= 57) { // if the char is already number
                        finalOutput[counter] = temp - 48;
                    } else {
                        finalOutput[counter] = letter(temp); // if the char is not number but an uppercase
                    }
                    counter++; // add to to amount of number found
                }
                index++; // move onto next char
            }
            for (int j = 0; j < 10; j++){ //output
                System.out.print(finalOutput[j]);
                if (j == 2 || j == 5)
                    System.out.print('-');
            }
            System.out.print("\n");
        }
    }
    private static int letter(int value) { // for each char, return different integer
        if (value >= 65 && value <= 67)
            return 2;
        else if (value >= 68 && value <= 70)
            return 3;
        else if (value >= 71 && value <= 73)
            return 4;
        else if (value >= 74 && value <= 76)
            return 5;
        else if (value >= 77 && value <= 79)
            return 6;
        else if (value >= 80 && value <= 83)
            return 7;
        else if (value >= 84 && value <= 86)
            return 8;
        return 9;
    }
}
