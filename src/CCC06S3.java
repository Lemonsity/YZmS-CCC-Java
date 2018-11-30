import java.io.*;
public class CCC06S3 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        int counter = 0;
        double[] friends = new double[4];
        String[] temp = br.readLine().split(" ");
        for (int i = 0; i < 4; i++)
            friends[i] = Double.parseDouble(temp[i]);
        if (friends[2] != friends[0]) {
            double slope = (friends[3] - friends[1]) / (friends[2] - friends[0]);
            double yInter = friends[1] - friends[0] * slope;
            int numBuilding = Integer.parseInt(br.readLine());
            int[][] buildings = new int[numBuilding][];
            for (int i = 0; i < numBuilding; i++) {
                temp = br.readLine().split(" ");
                buildings[i] = new int[temp.length];
                for (int j = 0; j < temp.length; j++) {
                    buildings[i][j] = Integer.parseInt(temp[j]);
                }
                if (slope * buildings[i][1] + yInter == buildings[i][2]) { // if first corner land on the telephone line
                    counter++;
                    continue;
                }
                boolean firstCorner;
                if (slope * buildings[i][1] + yInter > buildings[i][2]) // If the first corner lands above the telephone line
                    firstCorner = true;
                else // if the first corner lands below the telephone line
                    firstCorner = false;
                for (int j = 2; j <= buildings[i][0]; j++) {
                    if (slope * buildings[i][j * 2 - 1] + yInter == buildings[i][j * 2]) { // if a corner is on the telephone line
                        counter++;
                        break;
                    } else if ((slope * buildings[i][j * 2 - 1] + yInter > buildings[i][j * 2]) != firstCorner) { // if a corner is on the opposite side as the first corner
                        counter++;
                        break;
                    }
                }
            }
        }
        else {
            int numBuilding = Integer.parseInt(br.readLine());
            int[][] buildings = new int[numBuilding][];
            for (int i = 0; i < numBuilding; i++) {
                temp = br.readLine().split(" ");
                buildings[i] = new int[temp.length];
                for (int j = 0; j < temp.length; j++) {
                    buildings[i][j] = Integer.parseInt(temp[j]);
                }
                if (buildings[i][1] == friends[0]){
                    counter++;
                    continue;
                }
                boolean first;
                if (buildings[i][1] < friends[0])
                    first = true;
                else
                    first = false;
                for (int j = 2; j <= buildings[i][0]; j++) {
                    if (buildings[i][j * 2 - 1] == friends[0]){
                        counter++;
                        break;
                    }
                    else if ((buildings[i][1] < friends[0]) != first){
                        counter++;
                        break;
                    }
                }
            }
        }
        System.out.print(counter + "\n");
    }
}
