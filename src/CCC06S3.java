import java.io.*;

public class CCC06S3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int counter = 0;
        double[] friends = new double[4];
        String[] temp = br.readLine().split(" ");
        for (int i = 0; i < 4; i++)
            friends[i] = Double.parseDouble(temp[i]) * 1.0;
        double slope = (friends[3] - friends[1]) * 1.0 / (friends[2] - friends[0]); // the slope of telephone line
        double yInter = friends[1] - friends[0] * slope; // Y intersect of the line representing telephone
        int buildingNum = Integer.parseInt(br.readLine());
        for (int i = 0; i < buildingNum; i++) {
            temp = br.readLine().split(" ");
            double[] building = new double[temp.length];
            for (int j = 0; j < building.length; j++) {
                building[j] = Double.parseDouble(temp[j]);
            }
            if (building[1] * slope + yInter == building[2]){
                if (building[1] <= Math.max(friends[0], friends[2]) && building[1] >= Math.min(friends[0], friends[2])) {
                    System.out.print("Test1");
                    counter++;
                    continue;
                }
            }
            double firstPointX = building[1] * 1.0;
            double firstPointY = building[2] * 1.0;
            for (int j = 2; j <= building[0]; j++) {
                double secondPointX = building[j * 2 - 1] * 1.0;
                double secondPointY = building[j * 2] * 1.0;
                if (secondPointX * slope + yInter == secondPointY){
                    if (building[1] <= Math.max(friends[0], friends[2]) && building[1] >= Math.min(friends[0], friends[2])) {
                        System.out.print("Test2");
                        counter++;
                        break;
                    }
                }
                double slopeTwo = (secondPointY - firstPointY) * 1.0 / (secondPointX - firstPointX);
                double yInterTwo = firstPointY - firstPointX * slopeTwo;
                double intersectX = (yInterTwo - yInter) / (slope - slopeTwo);
                if (intersectX <= Math.max(friends[0], friends[2]) && intersectX >= Math.min(friends[0], friends[2])){
                    System.out.print("Test3");
                    counter++;
                    break;
                }
                else {
                    firstPointX = secondPointX;
                    firstPointY = secondPointY;
                }
            }
        }
        System.out.print(counter + "\n");
    }
}
