import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class CCC02S1 {
    public static ArrayList<Integer> amount = new ArrayList<Integer>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        int[] prices = new int[4];
        int total;
        for (int i = 0; i < 4; i++)
            prices[i] = Integer.parseInt(br.readLine());
        total = Integer.parseInt(br.readLine());
        for (int pinkCounter = 0; pinkCounter * prices[0] <= total; pinkCounter++){
            int leftAfterPink = total - pinkCounter * prices[0];
            for (int greenCounter = 0; greenCounter * prices[1] <= leftAfterPink; greenCounter++){
                int leftAfterGreen = leftAfterPink - greenCounter * prices[1];
                for (int redCounter = 0; redCounter * prices[2] <= leftAfterGreen; redCounter++){
                    int leftAfterRed = leftAfterGreen - redCounter * prices[2];
                    if (leftAfterRed % prices[3] == 0){
                        System.out.printf("# of PINK is %d # of GREEN is %d # of RED is %d # of ORANGE is %d\n",
                                            pinkCounter, greenCounter, redCounter, leftAfterRed / prices[3]);
                        amount.add(pinkCounter + greenCounter + redCounter + (leftAfterRed / prices[3]));
                    }//end of calculate the amount of orange
                }//end of red ticket
            }// end of green ticket
        }// end of pink ticket
        Collections.sort(amount);
        System.out.printf("Total combinations is %d.\n", amount.size());
        System.out.printf("Minimum number of tickets to print is %d.", amount.get(0));
    }
}
