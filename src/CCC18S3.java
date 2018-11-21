import java.io.*;

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
        for (int rowIndex = 0; rowIndex < rows; rowIndex++) {
            for (int columnIndex = 0; columnIndex < columns; columnIndex++) {
                if (map[rowIndex][columnIndex].equals("C")) {
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
    }
}
