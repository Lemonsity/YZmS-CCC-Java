import java.io.*;
import java.util.ArrayList;

public class CCC02S4 {
    public static ArrayList<Integer> best = new ArrayList<Integer>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        int groupSize = Integer.parseInt(br.readLine());
        int queueSize = Integer.parseInt(br.readLine());
        String[] names = new String[queueSize];
        int[] times = new int[queueSize];
        for (int i = 0; i < queueSize; i++) {
            names[i] = br.readLine();
            times[i] = Integer.parseInt(br.readLine());
        }
    }
}

