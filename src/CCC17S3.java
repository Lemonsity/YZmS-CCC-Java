import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class CCC17S3 {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int[] numBoard = new int[2001];
        int[] longestLength = new int[4001];
        int boardNum = sc.nextInt();
        for (int i = 0; i < boardNum; i++){
            numBoard[sc.nextInt()] += 1;
        }
        for (int i = 2; i <= 4000; i++){
            for(int j = 1; j <= 2000; j++){
                if (j >= i)
                    break;
                if (j < i && i - j <= 2000 && j < i - j){
                    longestLength[i] += Math.min(numBoard[j], numBoard[i - j]);
                }
                if (j == i - j){
                    longestLength[i] += numBoard[j] / 2;
                }
            }
        }
        Arrays.sort(longestLength);
        int counter = 0;
        int longest = longestLength[4000];
        for (int i = 4000; i >= 2; i--){
            if (longestLength[i] == longest)
                counter++;
            else
                break;
        }
        System.out.printf("%d %d\n", longestLength[4000], counter);
    }
}
