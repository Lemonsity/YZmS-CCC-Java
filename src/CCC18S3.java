import java.io.*;
/**********************************************************************
 * Project Name: CCC18S3
 *
 * Author: YZmS Lemonsity
 *
 * Date: Nov 25, 2018
 *
 * Purpose: Solving 2018 CCC S3
 *
 ***********************************************************************
 *  Status: On hold
 *
 *  -Need better algorithm
 */
public class CCC18S3 {
    public static String[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        int rows = Integer.parseInt(temp[0]);
        int columns = Integer.parseInt(temp[1]);
        map = new String[rows][columns];
        for (int i = 0; i < rows; i++) {
            map[i] = br.readLine().split("");
        }
        //******************* Mark all location that are in view of the camera *************************
        for (int rowIndex = 0; rowIndex < rows; rowIndex++) {
            for (int columnIndex = 0; columnIndex < columns; columnIndex++) {
                if (map[rowIndex][columnIndex].equals("C")) {
                    // check top
                    for (int i = rowIndex; i >= 0; i--) {
                        if (map[i][columnIndex].equals("."))
                            map[i][columnIndex] = "-1";
                        if (map[i][columnIndex].equals("W"))
                            break;
                    }
                    //check bot
                    for (int i = rowIndex; i <= rows; i++) {
                        if (map[i][columnIndex].equals("."))
                            map[i][columnIndex] = "-1";
                        if (map[i][columnIndex].equals("W"))
                            break;
                    }
                    //check left
                    for (int i = columnIndex; i >= 0; i--) {
                        if (map[rowIndex][i].equals("."))
                            map[rowIndex][i] = "-1";
                        if (map[rowIndex][i].equals("W"))
                            break;
                    }
                    //check right
                    for (int i = columnIndex; i <= columns; i++) {
                        if (map[rowIndex][i].equals("."))
                            map[rowIndex][i] = "-1";
                        if (map[rowIndex][i].equals("W"))
                            break;
                    }
                }
            }
        }
        //**********************************************************************************************
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                if (map[i][j].equals("S")) {
                    r(i + 1, j, 1);
                    r(i - 1, j, 1);
                    r(i, j + 1, 1);
                    r(i, j - 1, 1);
                }
            }
        }
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                if (map[i][j].equals("."))
                    map[i][j] = "-1";
                if (isInteger(map[i][j]))
                    System.out.print(map[i][j] + "\n");
            }
        }
    }
    public static void r(int row, int column, int counter){
        if (map[row][column].equals("L"))
            column -= 1;
        else if (map[row][column].equals("R"))
            column += 1;
        else if (map[row][column].equals("U"))
            row -= 1;
        else if (map[row][column].equals("D"))
            row += 1;
        if (map[row][column].equals("W") || map[row][column].equals("-1")) {
            return;
        }
        if (isInteger(map[row][column]) && Integer.parseInt(map[row][column]) > counter) {
            map[row][column] = String.valueOf(counter);
            r(row + 1, column, counter + 1);
            r(row - 1, column, counter + 1);
            r(row, column + 1, counter + 1);
            r(row, column - 1, counter + 1);
        }
        else if (map[row][column].equals(".")){
            map[row][column] = String.valueOf(counter);
            r(row + 1, column, counter + 1);
            r(row - 1, column, counter + 1);
            r(row, column + 1, counter + 1);
            r(row, column - 1, counter + 1);
        }
        //https://dmoj.ca/problem/ccc18s3
    }
    public static boolean isInteger(String potential){
        boolean check = false;
        try{
            Integer.parseInt(potential);
            check = true;
        } catch (Exception e){

        }
        return check;
    }
}
