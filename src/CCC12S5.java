import java.io.*;
import java.util.StringTokenizer;
/***********************************************************************
 * Project Name: CCC12S5
 *
 * Author: YZmS Lemonsity
 *
 * Date: Feb 5, 2019
 *
 * Purpose: Solving 2012 CCC S5
 *
 ***********************************************************************
 *  Status: Completed
 *
 */
public class CCC12S5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int column = Integer.parseInt(st.nextToken());
        boolean[][] isCat = new boolean[row + 1][column + 1];

        /**
         * This key fo this question is to realize the amount of ways to reach any certain block
         * is the sum of the block above it and the block to the left of it.
         *
         * The question is a variation of Pascal's triangle:
         *      the top left corner being top left of pyramid
         *      the first column is the left side of pyramid
         *      the first row is the right side of pyramid
         */

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            isCat[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true; // mark all boxes with cat
        }

        long[][] dp = new long[row + 1][column + 1]; // the 2D array storing the equivalent of pyramid
        dp[1][1] = 1; // the top left is the top of pyramid with only 1 way reaching it
        for (int i = 1; i <= column; i++) { // going through column
            for (int j = 1; j <= row; j++) { // going through row
                if (!(i == 1 && j == 1) && !isCat[j][i]) { // if the cell isn't a cat
                    dp[j][i] = dp[j - 1][i] + dp[j][i - 1]; // the amount of ways to reach that cell = top + left
                }
            }
        }
        System.out.print(dp[row][column] + "\n"); // output the amount of ways to reach the final destination
    }
}
