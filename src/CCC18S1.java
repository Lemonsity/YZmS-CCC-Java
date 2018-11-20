import java.io.*;
import java.util.Arrays;

public class CCC18S1 {
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int villageNum = Integer.parseInt(br.readLine());
        double[] data = new double[villageNum];
        for (int i = 0; i < villageNum; i++){
            data[i] = Double.parseDouble(br.readLine());
        }
        Arrays.sort(data);
        double[] distance = new double[villageNum];
        double shortest = Integer.MAX_VALUE;
        for (int i = 0; i < villageNum; i++){
            if (!(i == 0 || i == villageNum - 1)){
                distance[i] = (data[i] - data[i - 1]) / 2.0 + (data[i + 1] - data[i]) / 2.0;
                if (distance[i] == 1)
                    shortest = distance[i];
                else{
                    if (distance[i] < shortest)
                        shortest = distance[i];
                }
            }
        }
        System.out.printf("%.1f\n", shortest);;
    }
}
