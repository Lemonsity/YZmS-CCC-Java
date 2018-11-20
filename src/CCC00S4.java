import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;

public class CCC00S4 {
    public static TreeSet<Integer> possibilities = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] clubs;
        int distance = Integer.parseInt(br.readLine());
        int amount = Integer.parseInt(br.readLine());
        clubs = new int[amount];
        for (int i = 0; i < amount; i++) {
            clubs[i] = Integer.parseInt(br.readLine());
        }
        int least = ways(distance, clubs);
        if (least == 0)
            System.out.print("Roberta acknowledges defeat.");
        else
            System.out.printf("Roberta wins in %d strokes.", least);
    }
    public static int ways(int distance, int[] clubs) {
        if (distance == 0) return 0;
        int[] possibilities = new int[distance + 1];
        for (int temp : clubs) {
            possibilities[temp] = 1;
        }
        ArrayList<Integer> array = new ArrayList<>();
        for (int i = 1; i <= distance; i++) {
            for (int club : clubs) {
                if ((i - club >= 0 && possibilities[i - club] > 0) || i - club == 0) {
                    array.add(possibilities[i - club]);
                }
            }
            if (array.size() == 0)
                possibilities[i] = 0;
            else {
                possibilities[i] = Collections.min(array) + 1;
            }
            array.clear();
        }
        return possibilities[distance];
    }
}