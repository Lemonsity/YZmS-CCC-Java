import java.io.*;
import java.util.StringTokenizer;
/***********************************************************************
 * Project Name: CCC05S3
 *
 * Author: YZmS Lemonsity
 *
 * Date: Jan 16, 2019
 *
 * Purpose: Solving 2005 CCC S3
 *
 ***********************************************************************
 *  Status: Completed
 *
 */
public class CCC05S3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // this is the matrix that we want to build upon, initialize it as a 1x1 array of 1
        int[][] array = new int[1][1];
        array[0][0] = 1;
        // this 2d array will store the new, bigger matrix after every quantum operator
        int[][] resultArray = new int[1][1];
        int numMatrix = Integer.parseInt(br.readLine());
        for (int i = 0; i < numMatrix; i++) {

            // the size of the matrix B
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int column = Integer.parseInt(st.nextToken());

            // the size of the resulting matrix is [# rows of A * # of rows of B][# columns of A * # columns of B]
            resultArray = new int[array.length * row][array[0].length * column];

            for (int bR = 0; bR < row; bR++) {
                StringTokenizer inputRow = new StringTokenizer(br.readLine());
                for (int bC = 0; bC < column; bC++) {
                    // for each element of matrix B from top left to bottom right
                    int bElement = Integer.parseInt(inputRow.nextToken());

                    // replace the number in Matrix B with Matrix A x element of Matrix B
                    for (int aR = 0; aR < array.length; aR++) {
                        for (int aC = 0; aC < array[0].length; aC++) {
                            // so give A is 2 x 2 : 1, 2
                            //                      3, 4
                            // B is 2 * 3
                            // A x B would end up being
                            /* 12 12 12  12 12 12  12 12 12
                               34 34 34  34 34 34  34 34 34
                               12 12 12  12 12 12  12 12 12
                               34 34 34  34 34 34  34 34 34
                             */
                            // this require some formatting, as the top left corner of each Matrix A always start at
                            // row: integer * the amount of rows of Matrix B
                            // column: integer * the amount of column of Matrix B
                            resultArray[aR * row + bR][aC * column + bC] = bElement * array[aR][aC];
                        }
                    }
                }
            }
            // Now the resulting matrix is produced, copy it to another matrix that we can build upon
            array = new int[resultArray.length][];
            for (int j = 0; j < resultArray.length; j++) {
                array[j] = resultArray[j].clone();
            }
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int maxColumn = Integer.MIN_VALUE;
        int minColumn = Integer.MAX_VALUE;
        int maxRow = Integer.MIN_VALUE;
        int minRow = Integer.MAX_VALUE;

        // Some simple 2d array navigation, adding rows, columns, and finding largest / smallest value
        for (int i = 0; i < resultArray.length; i++) {
            int sumRow = 0;
            for (int j = 0; j < resultArray[0].length; j++) {
                if (resultArray[i][j] > max)
                    max = resultArray[i][j];
                if (resultArray[i][j] < min)
                    min = resultArray[i][j];
                sumRow += resultArray[i][j];
            }
            if (sumRow > maxRow)
                maxRow = sumRow;
            if (sumRow < minRow)
                minRow = sumRow;
        }
        for (int i = 0; i < resultArray[0].length; i++) {
            int sumColumn = 0;
            for (int j = 0; j < resultArray.length; j++) {
                sumColumn += resultArray[j][i];
            }
            if (sumColumn > maxColumn)
                maxColumn= sumColumn;
            if (sumColumn < minColumn)
                minColumn = sumColumn;
        }
        // output
        System.out.print(max + "\n");
        System.out.print(min + "\n");
        System.out.print(maxRow + "\n");
        System.out.print(minRow + "\n");
        System.out.print(maxColumn + "\n");
        System.out.print(minColumn + "\n");
    }
}
