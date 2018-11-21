import java.io.*;
/***********************************************************************
 * Project Name: CCC12S3
 *
 * Author: YZmS Lemonsity
 *
 * Date: Nov 20, 2018
 *
 * Purpose: Solving 2013 CCC S3
 *
 ***********************************************************************
 *  Status: On Hold
 *
 *  - Figuring out logic
 */
public class CCC13S3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] score = new int[4];
        int[][] table = new int[4][4];
        int team = Integer.parseInt(br.readLine());
        int gamesDone = Integer.parseInt(br.readLine());
        for (int i = 0; i < gamesDone; i++){
            String[] temp = br.readLine().split(" ");
            int[] input = new int[4];
            for (int j = 0; j < 4; j++) { // Transfer String input into integer input for comparison.
                input[j] = Integer.parseInt(temp[j]);
            }
            if (input[2] > input[3]){
                table[input[0] - 1][input[1] - 1] = 1;
                table[input[1] - 1][input[0] - 1] = -1;
            } else if (input[3] > input[2]){
                table[input[1] - 1][input[0] - 1] = 1;
                table[input[0] - 1][input[1] - 1] = -1;
            } else {
                table[input[0] - 1][input[1] - 1] = 2;
                table[input[1] - 1][input[0] - 1] = 2;
            }
        } // end of taking in input for game already finished
        int counter = 0;

    }
}
