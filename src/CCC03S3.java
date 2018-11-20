import java.io.*;
import java.util.Arrays;

public class CCC03S3 {
    public static char[][] floorPlan;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tile = Integer.parseInt(br.readLine());
        int row = Integer.parseInt(br.readLine());
        int column = Integer.parseInt(br.readLine());
        floorPlan = new char[row][column];
        for (int i = 0; i < row; i++){
            floorPlan[i] = br.readLine().toCharArray();
        }
        int roomNumber = 0;
        for (int i = 0; i < row; i++){
            for (int j = 0; j < column; j++){
                if (floorPlan[i][j] == '.'){
                    roomNumber++;
                    roomIdentify(i, j, roomNumber);
                }
            }
        }
        int[] sizes = new int[roomNumber];
        for (char[] value : floorPlan){
            for (char v : value){
                for (int i = 1; i <= roomNumber; i++){
                    if (v == (char)(i + '0'))
                        sizes[i - 1]++;
                }
            }//column
        }// row
        Arrays.sort(sizes);
        int roomCovered = 0;
        int indexChecking = sizes.length - 1;
        while (indexChecking >= 0 && tile >= sizes[indexChecking]){
            roomCovered++;
            tile -= sizes[indexChecking];
            indexChecking--;
        }
        if (roomCovered == 1)
            System.out.printf("%d room, %d square metre(s) left over", roomCovered, tile);
        else
            System.out.printf("%d rooms, %d square metre(s) left over", roomCovered, tile);
    }
    public static void roomIdentify(int row, int column, int currentRoomNum){
        floorPlan[row][column] = (String.valueOf(currentRoomNum) + "").charAt(0);
        boolean up, right, down, left;
        up = right = down = left = true;
        if (row - 1 < 0 || floorPlan[row - 1][column] != '.')
            up = false;
        if (row + 1 == floorPlan.length || floorPlan[row + 1][column] != '.')
            down = false;
        if (column - 1 < 0 || floorPlan[row][column - 1] != '.')
            left = false;
        if (column + 1 == floorPlan[0].length || floorPlan[row][column + 1] != '.')
            right = false;
        if (!up && !down && !left && !right)
            return;
        if (up) {
            roomIdentify(row - 1, column, currentRoomNum);
        }
        if (down) {
            roomIdentify(row + 1, column, currentRoomNum);
        }
        if (left) {
            roomIdentify(row, column - 1, currentRoomNum);
        }
        if (right) {
            roomIdentify(row, column + 1, currentRoomNum);
        }
    }
}
